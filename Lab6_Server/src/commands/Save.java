package commands;

import domain.Vehicle;
import serealAndDeserializer.*;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * класс, реализующий сохранение коллекции(дальнейшую сериализацию)
 * */
public class Save extends AbstractCommand {
    /**
     * реализация сохранения с отсылкой на сериализацию
     * @param LinkedList
     */
    public void execute(LinkedList<Vehicle> LinkedList) {
        SerializerImpl writer = new SerializerImpl();
        writer.serialize(LinkedList, Vehicle.file );
        System.out.println("Сохранение прошло успешно");
    }
}
