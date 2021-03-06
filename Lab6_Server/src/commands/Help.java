package commands;


import domain.Vehicle;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * класс с выводом доступных команд
 */
public class Help {
    /**
     * вывод доступных команд
     */
    public String execute(){
        return("Вам доступны следующие команды:\n"+
                "info : вывод информации о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                "show : вывод элементов коллекции в строковом представлении\n" +
                "add {element} : добавить новый элемент в коллекцию\n" +
                "remove_by_id id : удалить элемент из коллекции по его id\n" +
                "clear : очистить коллекцию\n" +
                "exit : завершить программу (без сохранения в файл)\n" +
                "add_if_max {element} : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции\n" +
                "remove_greater enginePower : удалить из коллекции все элементы, превышающие заданный\n" +
                "remove_lower enginePower : удалить из коллекции все элементы, меньшие, чем заданный\n" +
                "remove_any_by_engine_power enginePower : удалить из коллекции один элемент, значение поля enginePower которого эквивалентно заданному\n" +
                "min_by_creation_date : вывести любой объект из коллекции, значение поля creationDate которого является минимальным\n" +
                "filter_greater_than_type type : вывести элементы, значение поля type которых больше заданного");
    }

}
