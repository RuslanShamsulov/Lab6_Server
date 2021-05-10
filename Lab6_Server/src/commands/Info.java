package commands;

import domain.Vehicle;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * реализация команды Info
 */
public class Info extends AbstractCommand {

    /**
     * вывод информации о коллекции
     * @param LinkedList
     *
     */
    @Override
    public void execute(LinkedList<Vehicle> LinkedList) {
        try {
            System.out.println("Тип коллекции: " + LinkedList.getClass() +
                    "\nДата инициализации коллекции:" + LinkedList.get(0).getCreationDate() // дата создания коллекции совпадает с внесением первого элемента в коллекцию
                    + "\nКоличество элементов: " + (LinkedList.size() - 1));

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Коллекция пуста");
        }
    }

    public String execute2(LinkedList<Vehicle> LinkedList) {

            return("Тип коллекции: " + LinkedList.getClass() +
                    "\nДата инициализации коллекции:" + LinkedList.get(0).getCreationDate() // дата создания коллекции совпадает с внесением первого элемента в коллекцию
                    + "\nКоличество элементов: " + (LinkedList.size() - 1));


    }
}
