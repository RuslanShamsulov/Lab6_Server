package commands;

import domain.Vehicle;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * основной класс, работающий с пользовательским вводом
 */
public class CommandDefiner {
    /**
     * @param LinkedList коллекция с Vehicle
     */
    public void define(LinkedList<Vehicle> LinkedList) {
        Scanner in2 = new Scanner(System.in);
        try {
            System.out.println("Введите команду");
            String userInput = in2.nextLine();
            while (!userInput.contains("exit")) {

                if(userInput.contains("help")) {
                    Help help = new Help();
                    help.execute();
                } else if (userInput.contains("info")) {
                    Info info = new Info();
                    info.execute(LinkedList);
                } else if (userInput.contains("show")) {
                    Show show = new Show();
                    show.execute(LinkedList);

                } else if (userInput.contains("save")) {
                    Save save = new Save();
                    save.execute(LinkedList);
                } else if (userInput.contains("add") && (!userInput.contains("max"))) {

                    Add add = new Add();
                    add.execute(LinkedList,in2);
                } else if (userInput.contains("update id")) {
                    UpdateId updateId = new UpdateId();
                    updateId.execute(LinkedList, userInput,in2);

                } else if (userInput.contains("remove_by_id")) {
                    RemoveById removeById = new RemoveById();
                    removeById.execute(userInput, LinkedList);

                } else if (userInput.contains("add_if_max")) {
                    AddIfMax addIfMax = new AddIfMax();
                    addIfMax.execute(LinkedList,in2);
                } else if (userInput.contains("remove_greater")) {
                    RemoveGreator removeGreator = new RemoveGreator();
                    removeGreator.execute(LinkedList);
                } else if (userInput.contains("remove_lower")) {
                    RemoveLower removeLower = new RemoveLower();
                    removeLower.execute(LinkedList);
                } else if (userInput.contains("remove_any_by_engine_power")) {
                    RemoveEnginePower removeEnginePower = new RemoveEnginePower();
                    removeEnginePower.execute(LinkedList, userInput);
                } else if (userInput.contains("min_by_creation_date")) {
                    MinData minData = new MinData();
                    minData.execute(LinkedList);
                } else if (userInput.contains("clear")) {
                    Clear clear = new Clear();
                    clear.execute(LinkedList);
                } else System.out.println("В пользовательском вводе не обнаружено команд\n" +
                        "Чтобы отобразить список возможных команд, введите help " +
                        "\nчтобы завершить действие программы, нажмите exit");

                System.out.println("Введите команду");
                userInput = in2.nextLine();

            }


        }catch (Exception e) {
            System.out.println("Произошла ошибка при обнаружении команды пользователя");
            e.printStackTrace();
        } finally {
            in2.close();

        }
    }

}
