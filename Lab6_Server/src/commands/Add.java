package commands;

import domain.Coordinates;
import domain.FuelType;
import domain.Vehicle;
import domain.VehicleType;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * класс реализация команды Add
 */
public class Add  {
    /**
     *
     * @param LinkedList принимаемая коллекция
     */

    public void execute(LinkedList<Vehicle> LinkedList, Scanner scanner) {
        System.out.println("Была вызвана команда добавления нового элемента");
        Vehicle vehicle = new Vehicle();
        vehicle.setId(vehicle.generateID());
        LocalDate date = LocalDate.now();
        vehicle.setCreationDate(date);


        System.out.println("Name");

        vehicle.setName(scanner.nextLine().replace("\"", ""));


        System.out.println("EnginePower");
        try {
            vehicle.setEnginePower(Long.valueOf(scanner.nextLine()));
        } catch (NumberFormatException e) {
            System.out.println("неправильный ввод, необходимы цифры");
        }

        System.out.println("Coordinates");

        try {
            System.out.println("Введите координату x");
            Double x = Double.parseDouble(scanner.nextLine());
            System.out.println("Введите координату y");
            Float y = Float.parseFloat(scanner.nextLine());
            Coordinates cooordinates = new Coordinates(x, y);
            vehicle.setCoordinates(cooordinates);
        } catch (NumberFormatException e) {
            System.out.println("неправильный ввод, необходимы цифры");
        }


        System.out.println("VehicleType");
        recommendVehicleType();
        vehicle.setType(defineVehicleType(scanner.nextLine()));


        System.out.println("FuelType");
        recommendFuelType();
        vehicle.setFuelType(defineFuelType(scanner.nextLine()));


        LinkedList.add(vehicle);
        System.out.println("Добавление элемента завершено");


    }


    public String execute2(LinkedList<Vehicle> LinkedList, Vehicle vehicle) {

        LinkedList.add(vehicle);
        return "Успешно добавлен элемент";
    }

    public String execute3(LinkedList<Vehicle> LinkedList, Vehicle vehicle) {
         Long engPower = vehicle.getEnginePower();

        if ((LinkedList.get(LinkedList.size() - 1).getEnginePower()) < engPower) {
            LinkedList.add(vehicle);
            return ("Введенное значение EnginePower больше, чем у максимального элемента коллекции. элемент добавлен");
        } else return("Введенное значение EnginePower меньше, добавление элемента запрещено");

    }






    /**
     * метод, предлагаюший пользователю возможные Enum VehicleType
     */
    private void recommendVehicleType() {
        System.out.println("Выберите один из представленных VehicleType:\n" +
                "HELICOPTER\n" +
                "SUBMARINE\n" +
                "BICYCLE\n" +
                "MOTORCYCLE\n");
    }

    /**
     * метод, предлагаюший пользователю возможные Enum FuelType
     */
    private void recommendFuelType() {
        System.out.println("Выберите один из представленных FuelType:\n" +
                "GASOLINE\n" +
                "KEROSENE\n" +
                "ELECTRICITY\n" +
                "PLASMA\n");
    }

    /**
     *
     * @param inputText введенная строка пользователем
     * @return тип VehicleType
     */
    private VehicleType defineVehicleType(String inputText) {

        VehicleType type = null;
        if (inputText.contains("HELICOPTER")) {
            type = VehicleType.HELICOPTER;

        } else if (inputText.contains("SUBMARINE")) {
            type = VehicleType.SUBMARINE;
        } else if (inputText.contains("BICYCLE")) {
            type = VehicleType.BICYCLE;
        } else if (inputText.contains("MOTORCYCLE")) {
            type = VehicleType.MOTORCYCLE;
        } else {
            System.out.println("Введен отсутствующий VehicleType" +
                    "\n Возможно, вы используете нижний регистр");
            type = null;

        }
        return type;
    }

    /**
     *
     * @param inputText введенная строка пользователем
     * @return FuelType
     */
    private FuelType defineFuelType(String inputText) {

        FuelType type = null;

        if (inputText.contains("GASOLINE")) {
            type = FuelType.GASOLINE;


        } else if (inputText.contains("PLASMA")) {
            type = FuelType.PLASMA;

        } else if (inputText.contains("KEROSENE")) {
            type = FuelType.KEROSENE;

        } else if (inputText.contains("ELECTRICITY")) {
            type = FuelType.ELECTRICITY;

        } else {
            System.out.println("Введен отсутствующий VehicleType" +
                    "\n Возможно, вы используете нижний регистр");

        }

        return type;
    }
}





