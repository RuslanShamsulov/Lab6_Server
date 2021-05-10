package commands;

import domain.Vehicle;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Optional;

/**
 * класс для реализации замены по ID
 */
public class RemoveById extends AbstractCommand{


    public String execute3(String textFromScanner,LinkedList<Vehicle> LinkedList) {
        FinderNumbers finder = new FinderNumbers();
        int id = finder.find(textFromScanner);

        Optional<Vehicle> vehicle =LinkedList.stream()
                .filter(s -> s.getId()==id)
                .findAny();
        LinkedList.remove(vehicle.get());


        return "Элемент " + vehicle + " был удален";
    }








  //  /**
  //   *
  //   * @param textFromScanner
  //   * @param LinkedList
  //   */
  //public void execute(String textFromScanner,LinkedList<Vehicle> LinkedList) {
  //    FinderNumbers finder = new FinderNumbers();
  //    int id = finder.find(textFromScanner);
  //    Iterator<Vehicle> iterator =  LinkedList.iterator();
  //    while (iterator.hasNext()){
  //        Vehicle currentVehicle =iterator.next();
  //        if (currentVehicle.getId()==id){
  //            LinkedList.remove(currentVehicle);
  //            break;
  //        }
  //    }
  //}


  //public String execute2(String textFromScanner,LinkedList<Vehicle> LinkedList) {
  //    FinderNumbers finder = new FinderNumbers();
  //    int id = finder.find(textFromScanner);
  //    Iterator<Vehicle> iterator =  LinkedList.iterator();
  //    Vehicle currentVehicle=null;
  //    while (iterator.hasNext()){
  //         currentVehicle =iterator.next();
  //        if (currentVehicle.getId()==id){
  //            LinkedList.remove(currentVehicle);
  //            break;
  //        }
  //    }
  //    return "Элемент " + currentVehicle.getName()+ " был удален";
  //}





}
