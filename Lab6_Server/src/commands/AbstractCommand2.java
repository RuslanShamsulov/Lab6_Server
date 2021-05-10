package commands;

import domain.Vehicle;

import java.util.LinkedList;
import java.util.Scanner;

public class AbstractCommand2 {
    public void execute(LinkedList<Vehicle> LinkedList){};
    public void execute(LinkedList<Vehicle> LinkedList, Scanner scanner){};
    public void execute(String textFromScanner,LinkedList<Vehicle> LinkedList){};
    public void execute(){};
    public void execute(LinkedList<Vehicle> LinkedList, String textFromScanner, Scanner scanner){};

}
