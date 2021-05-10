package commands;

import domain.Vehicle;

import java.util.LinkedList;


/**
 * класс, реализующий очистку коллекцию
 */
public class Clear extends AbstractCommand {


    @Override
    public void execute(LinkedList<Vehicle> LinkedList) {
        LinkedList.clear();
    }

    public String execute2(LinkedList<Vehicle> LinkedList) {
        LinkedList.clear();
        return "Коллекция очищена";
    }
}
