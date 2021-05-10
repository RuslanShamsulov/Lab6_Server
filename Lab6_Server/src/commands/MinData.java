package commands;

import domain.Vehicle;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.LinkedList;


/**
 * класс, реализующий поиск элемента с минимальной датой
 */
public class MinData extends AbstractCommand{
    static Vehicle minDataVehicle = null;
    static LocalDate minDate = null;




    public String execute3(LinkedList<Vehicle> LinkedList) {
        return "Элемент Vehicle с самой ранней датой создания это\n" + LinkedList.stream().min((p1, p2) -> p1.getCreationDate().compareTo(p2.getCreationDate())).get();
    }
}

















   // /**
   //  * нахождение самой ранней даты
   //   * @param LinkedList
   //  */
   // @Override
   // public void execute(LinkedList<Vehicle> LinkedList) {
   //     Iterator<Vehicle> iterator = LinkedList.iterator();
   //     minDate = LinkedList.get(0).getCreationDate();
   //     minDataVehicle =LinkedList.get(0);
   //     while (iterator.hasNext()) {
   //         Vehicle currentVehicle = iterator.next();
//
//
   //         if (currentVehicle.getCreationDate().isBefore(minDate)) {
   //             minDate = currentVehicle.getCreationDate();
   //             minDataVehicle = currentVehicle;
   //         }
//
   //     }
   //     System.out.println("Элемент с самой ранней датой создания это\n" + minDataVehicle.toString());
   // }
//
   // public String execute2(LinkedList<Vehicle> LinkedList) {
   //     Iterator<Vehicle> iterator = LinkedList.iterator();
   //     minDate = LinkedList.get(0).getCreationDate();
   //     minDataVehicle =LinkedList.get(0);
   //     while (iterator.hasNext()) {
   //         Vehicle currentVehicle = iterator.next();
//
//
   //         if (currentVehicle.getCreationDate().isBefore(minDate)) {
   //             minDate = currentVehicle.getCreationDate();
   //             minDataVehicle = currentVehicle;
   //         }
//
   //     }
   //     return "Элемент с самой ранней датой создания это\n" + minDataVehicle.toString();
   // }

