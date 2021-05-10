package serealAndDeserializer;


import domain.Coordinates;
import domain.FuelType;
import domain.Vehicle;
import domain.VehicleType;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * реализация интерфейса десериализации
 */
public class DeserializerImpl implements Deserializer, ReaderIntoArray,DateGenerator{


    /**
     * метод, с помощью которого текст из файла json будет построчно записан в arrayList
     *
     * @param file файл, откуда берем json
     * @return список с элементами, состоящий из считанных из файла строк
     */
    public List<String> readIntoArray(File file) {

        List<String> list = new ArrayList<>(); // Сюда построчно будем складывать всю информацию из файла
        FileReader fr = null;

        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            System.out.println("File json has not been found");
        }

        //создаем BufferedReader с существующего FileReader для построчного считывания
        BufferedReader reader = new BufferedReader(fr);
        // считаем сначала первую строку

        String line = null;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            System.out.println("Error while reading a line");
        }

        list.add(line); // засунем первый элемент в коллекцию

        while (line != null) {
            try {
                line = reader.readLine();
            } catch (IOException e) {
                System.out.println("Error while reading a line");
            }
            list.add(line); //добавляем элементы в список по одной строке
        }
        try {
            fr.close();
        } catch (IOException e) {
            System.out.println("Error while closing the file");

        }
        return list;
    }


    /**
     * метод, реализующий добавление определенного vehicle в linkedList
     *
     * @param linkedList куда добавляем
     * @param vehicle    конкретный vehicle для добавления
     */
    private void addToLinkedList(LinkedList<Vehicle> linkedList, Vehicle vehicle) {

        linkedList.add(vehicle);
    }

    /**
     * @return возвращает новый vehicle и генерирует Id для него
     */
    private Vehicle createVehicle() {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(vehicle.generateID());
        vehicle.setCreationDate(generateDate());
        return vehicle;
    }




    /**
     * метод, выполняющий основную работу десериализатора с использованием regex
     *
     * @param listOfLinesJson список с элементами(построчно считанный файл)
     * @param linkedList      (куда происходит добавление)
     */
    private void findArgsInFile(List<String> listOfLinesJson, LinkedList<Vehicle> linkedList) {


        String regex = "\"(.*)\": (.*),"; // регулярное выражение для выделения параметра и значения в json
        Pattern pattern = Pattern.compile(regex);


        for (int i = 0; i < (listOfLinesJson.size() - 1); i++) { // сделал минус один потому что последняя строка null  и вылетает исключение
            if (listOfLinesJson.get(i).contains("{")) {
                Vehicle vehicle = createVehicle(); // это по моему какая то ерунда, но не понял как по другому

                for (int k = ++i; k < (listOfLinesJson.size() - 1); k++) {

                    if ((listOfLinesJson.get(k).contains("}"))) {
                        addToLinkedList(linkedList, vehicle);
                        break;
                    }
                    Matcher matcher = pattern.matcher(listOfLinesJson.get(k));
                    while (matcher.find()) {
                        switch (matcher.group(1)) {
                            case ("Name"):

                                vehicle.setName((matcher.group(2).replace("\"", "")));
                                break;

                            case ("VehicleType"):
                                vehicle.setType(VehicleType.valueOf((matcher.group(2).replace("\"", ""))));
                                break;

                            case ("FuelType"):
                                vehicle.setFuelType(FuelType.valueOf((matcher.group(2).replace("\"", ""))));
                                break;
                            case ("EnginePower"):

                                vehicle.setEnginePower(Long.valueOf(matcher.group(2)));
                                break;


                            case ("Coordinates"):

                                // Ниже новая регулярка для корректной записи координат
                                String regex4ID = "\\[(.*), (.*)\\]";
                                Pattern pattern2 = Pattern.compile(regex4ID);
                                Matcher matcher2 = pattern2.matcher(matcher.group(2));
                                while (matcher2.find()) {
                                    Coordinates currCooordinates = new Coordinates(Double.parseDouble(matcher2.group(1)), Float.parseFloat(matcher2.group(2)));
                                    vehicle.setCoordinates(currCooordinates);
                                }

                            default:

                                break;

                        }
                        Collections.sort(linkedList); // после добавления в коллекцию отсортируем ее
                    }

                }

            }

        }

    }

    /**
     * публичный метод, выполняющий десериазилацию
     *
     * @param file
     * @param linkedList
     */
    @Override
    public void deserialize(File file, LinkedList<Vehicle> linkedList) {

        findArgsInFile(readIntoArray(file), linkedList);

    }

    @Override
    public LocalDate generateDate() {
        LocalDate date = LocalDate.now();

        return date;

    }
}


