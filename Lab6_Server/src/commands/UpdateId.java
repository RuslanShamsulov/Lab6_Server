package commands;

import domain.Vehicle;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *класс, задающий реализацию замены элемента по ID
 */
public class UpdateId extends AbstractCommand {
    static int nesessaryID = 0;

    /**
     * @param LinkedList
     * @param textFromScanner
     */
    public void execute(LinkedList<Vehicle> LinkedList, String textFromScanner, Scanner scanner) {
        Iterator<Vehicle> iterator = LinkedList.iterator();
        FinderNumbers finder = new FinderNumbers();
        int id = finder.find(textFromScanner);

        while (iterator.hasNext()) {
            Vehicle currentVehicle = iterator.next();
            if (currentVehicle.getId() == id) {
                nesessaryID = id;
                LinkedList.remove(currentVehicle);
                break;
            }
        }
        Add add = new Add();
        add.execute(LinkedList, scanner);

    }


    public String execute2(LinkedList<Vehicle> LinkedList, String textFromScanner, Vehicle vehicle) {
        Iterator<Vehicle> iterator = LinkedList.iterator();
        FinderNumbers finder = new FinderNumbers();
        int id = finder.find(textFromScanner);
        Boolean flag = false;
        while (iterator.hasNext()) {
            Vehicle currentVehicle = iterator.next();
            if (currentVehicle.getId() == id) {
                nesessaryID = id;
                LinkedList.remove(currentVehicle);
                flag = true;
                break;
            }
        }
        if (flag = true) {
            Add add = new Add();
            add.execute2(LinkedList, vehicle);
            flag = false;
            return "Элемент с таким ID найден и успешно заменен";
        } else
        {
            flag = false;
            return "Не существует элемента с таким ID";
        }


    }
}

