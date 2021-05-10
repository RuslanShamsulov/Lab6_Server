package commands;

import domain.Vehicle;
import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * класс реализация добавления элемента,
 */
public class AddIfMax extends Add {
    /**
     * метод реализация занесения максимального элемента
     * @param LinkedList
     */
    @Override
    public void execute(LinkedList<Vehicle> LinkedList, Scanner scanner) {
        System.out.println("Введите величину EnginePower, используемой в качестве сравнения");
        GetterKeyParam getterKeyParam = new GetterKeyParam();

        if ((LinkedList.get(LinkedList.size() - 1).getEnginePower()) < getterKeyParam.get()) {
            System.out.println("Введенное значение EnginePower больше, чем у максимального элемента коллекции");
            System.out.println("Добавление элемента разрешено");
            super.execute(LinkedList,scanner);
        } else {
            System.out.println("Введенное значение EnginePower меньше, добавление элемента запрещено");

        }


    }



    public String execute2(LinkedList<Vehicle> LinkedList, Vehicle vehicle) {
        System.out.println("Введите величину EnginePower, используемой в качестве сравнения");
        Long engPower = vehicle.getEnginePower();

        if ((LinkedList.get(LinkedList.size() - 1).getEnginePower()) < engPower) {
            LinkedList.add(vehicle);
            return ("Введенное значение EnginePower больше, чем у максимального элемента коллекции. элемент добавлен");
        } else return("Введенное значение EnginePower меньше, добавление элемента запрещено");

    }

}
