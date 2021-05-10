package commands;

import domain.Vehicle;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Optional;

/**
 * класс, удаляющий элемент с введенным EnginePower
 */
public class RemoveEnginePower extends AbstractCommand {

    /**
     *
     * @param LinkedList
     * @param input
     */
    public void execute(LinkedList<Vehicle> LinkedList, String input) {
        FinderNumbers finder = new FinderNumbers();
        int power = finder.find(input);
        Iterator<Vehicle> iterator = LinkedList.iterator();
        while (iterator.hasNext()) {
            Vehicle currentVehicle = iterator.next();
            if (currentVehicle.getEnginePower() == power) {
                LinkedList.remove(currentVehicle);
                System.out.println("Элемент"+currentVehicle.toString()+ "был успешно удален" );
                break;
            }
        }
    }

    public String execute2(LinkedList<Vehicle> LinkedList, String input) {
        FinderNumbers finder = new FinderNumbers();
        int power = finder.find(input);
        Iterator<Vehicle> iterator = LinkedList.iterator();
        String result = null;
        while (iterator.hasNext()) {
            Vehicle currentVehicle = iterator.next();
            if (currentVehicle.getEnginePower() == power) {
                LinkedList.remove(currentVehicle);
                result = ("Элемент"+currentVehicle.toString()+ "был успешно удален" );
                break;
            } else result= ("Элементов с введенным EnginePower не найдено");
        }
        return result;
    }




}

