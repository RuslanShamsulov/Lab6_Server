package commands;

import domain.Vehicle;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * класс, задающий реализацию удаления элементов с полем EnginePower больше чем введенный
 */
public class RemoveGreator extends AbstractCommand {
    /**
     *
     * @param LinkedList
     */
        public void execute(LinkedList<Vehicle> LinkedList) {
        GetterKeyParam getterKeyParam = new GetterKeyParam();
        System.out.println("Введите величину EnginePower, используемой в качестве сравнения");
        int engPower=getterKeyParam.get();
        Iterator<Vehicle> iterator = LinkedList.iterator();
        while (iterator.hasNext()) {
          Vehicle currentVehicle = iterator.next();
            if(currentVehicle.getEnginePower()> engPower) {
                iterator.remove();
                }
          }
        System.out.println("Все значения Vehicle, имеющие EnginePower >"+engPower+ "были успешно удалены");
      }


    public String execute2(LinkedList<Vehicle> LinkedList,String textFromServer) {
        FinderNumbers finder = new FinderNumbers();
        int EnginePower = finder.find(textFromServer);
        int engPower=EnginePower;
        Iterator<Vehicle> iterator = LinkedList.iterator();
        while (iterator.hasNext()) {
            Vehicle currentVehicle = iterator.next();
            if(currentVehicle.getEnginePower()> engPower) {
                iterator.remove();
            }
        }
         return ("Все значения Vehicle, имеющие EnginePower >"+engPower+ "были успешно удалены");
    }



}