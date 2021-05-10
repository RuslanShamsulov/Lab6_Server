package commands;

import domain.Vehicle;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * класс, реализуюший вывод элементов
 */
public class Show extends AbstractCommand {



    public String execute2(LinkedList<Vehicle> LinkedList) {
        String result = "Получены объекты : \n";
        Iterator iterator = LinkedList.iterator();
        while (iterator.hasNext()) {
            result = result+iterator.next();
            // System.out.println(iterator.next());
        }
        return result;
    }


}
   // /**
   //  * вывод элементов
   //   * @param LinkedList
   //  */
   // @Override
   // public void execute(LinkedList<Vehicle> LinkedList) {
   //     Iterator iterator = LinkedList.iterator();
   //     while (iterator.hasNext()) {
   //         System.out.println(iterator.next());
   //     }
//
   // }


