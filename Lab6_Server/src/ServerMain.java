import commands.*;
import domain.Vehicle;
import serealAndDeserializer.DeserializerImpl;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class ServerMain {
    private static ServerSocketChannel serverSocketChannel;
    private static ByteBuffer byteBuffer;


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        LinkedList<Vehicle> mylist = new LinkedList<>(); // создание linkedList для хранения объектов
        String path = Arrays.toString(args).replaceAll("]", "").replaceAll("\\[", ""); // обработка аргументов командной строки
        System.out.println("Задан путь к файлу  " + path);

        File file = new File(path);
        if (file.exists()) {
            System.out.println("путь к файлу найден");
        } else {
            System.out.println("Путь к файлу неверный, измените аргументы командной строки и запустите программу снова");
            System.exit(0); // выход из программы
        }

        Vehicle.file = file;

        DeserializerImpl reader = new DeserializerImpl();
        reader.deserialize(Vehicle.file, mylist);


        // Подключение

        while (true) {

            serverSocketChannel = ServerSocketChannel.open();
            SocketAddress socketAddress = new InetSocketAddress(55555);
            serverSocketChannel.bind(socketAddress);
            byteBuffer = ByteBuffer.allocate(65536);


            byteBuffer.clear();
            accept(byteBuffer);
            MessageForClient message = new MessageForClient();
            AbstractCommand<?> command = read(byteBuffer);

            try {
                String name = command.getCommandName();
                System.out.println("От клиента пришел запрос на команду "+ name);
                switch (name) {
                    case "help":
                        Help help = new Help();
                        message.setMessage(help.execute());
                        break;
                    case "info":
                        Info info = new Info();
                        message.setMessage(info.execute2(mylist));
                        break;
                    case "show":
                        Show show = new Show();
                        message.setMessage(show.execute2(mylist));
                        break;
                    case "add":
                        Add add = new Add();
                        message.setMessage(add.execute2(mylist, (Vehicle) command.getArgument()));
                        break;
                    case "min_by_creation_date":
                        MinData minData = new MinData();
                        message.setMessage(minData.execute3(mylist));
                        break;
                    case "exit":
                        message.setMessage("Сервер закрыл соединение");
                        break;
                    case "remove_by_id":
                        RemoveById removeById = new RemoveById();
                        message.setMessage(removeById.execute3((String) command.getArgument(), mylist));
                        break;
                    case "clear":
                        Clear clear = new Clear();
                        message.setMessage(clear.execute2(mylist));
                        break;
                    case "add_if_max":
                        Add add_if_max = new Add();
                        message.setMessage(add_if_max.execute3(mylist, (Vehicle) command.getArgument()));
                        break;
                    case "remove_greater":
                        RemoveGreator remove_greater = new RemoveGreator();
                        message.setMessage(remove_greater.execute2(mylist, (String) command.getArgument()));
                        break;
                    case "remove_lower":
                        RemoveLower remove_lower = new RemoveLower();
                        message.setMessage(remove_lower.execute2(mylist, (String) command.getArgument()));
                        break;
                    case "remove_any_by_engine_power":
                        RemoveEnginePower removeEnginePower = new RemoveEnginePower();
                        message.setMessage(removeEnginePower.execute2(mylist, (String) command.getArgument()));
                        break;

                }


            } catch (NullPointerException e) {
                System.out.println("Client went out");
            }
            System.out.println("Отсылаем сообщение клиенту");
            write(message);
            System.out.println("успешно послано");
            if (command.getCommandName().equals("exit")) {
                checkForSaving(mylist);
            }
            message = null;
            command = null;

        }
    }

    //установка соединения
    private static void accept(ByteBuffer byteBuffer) {

        try {


            SocketChannel socketChannel = serverSocketChannel.accept();

            socketChannel.read(byteBuffer);
            serverSocketChannel.close();
            socketChannel.close();

            System.out.println("Client connected");

        } catch (IOException ignored) {
            ignored.printStackTrace();
        }
    }


    private static <T> T deserialize(ByteBuffer byteBuffer) throws IOException {

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteBuffer.array());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        try {
            return (T) objectInputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();

            return null;
        } finally {
            byteArrayInputStream.close();
            objectInputStream.close();

        }
    }


    //метод для отправки сообщения клиенту
    private static void write(MessageForClient message) throws IOException, ClassNotFoundException {

        ServerSocket serverSocket = new ServerSocket(55554);
        Socket socket = serverSocket.accept();
        ObjectInputStream serverInputStream = new
                ObjectInputStream(socket.getInputStream());
        ObjectOutputStream serverOutputStream = new
                ObjectOutputStream(socket.getOutputStream());
        MessageForClient messageForClient = (MessageForClient) serverInputStream.readObject(); //нн
        serverOutputStream.writeObject(message);
        serverSocket.close();
        serverInputStream.close();
        serverOutputStream.close();

    }

    // это для распаковки команды из клиента
    private static AbstractCommand<?> read(ByteBuffer buffer) {

        try {

            AbstractCommand<?> command = deserialize(buffer);
            return command;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Problem while reading");
            return null;
        }

    }

    private static String checkForSaving(LinkedList list) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("От клиента пришел запрос exit. Хотите ли вы сохранить все изменения, введенные пользователем?");
        System.out.println("Введите да или нет");
        String userInput = scanner.nextLine();
        if (userInput.contains("да")) {
            Save save = new Save();
            save.execute(list);

            return ("Успешно сохранено");
        } else {
            System.out.println("Изменения не сохранены");
            return ("Изменения не сохранены");
        }

    }


}

