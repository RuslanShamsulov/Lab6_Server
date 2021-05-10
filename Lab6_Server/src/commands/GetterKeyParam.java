package commands;

import java.util.Scanner;

/**
 * класс реализация поиска ключевого параметра(EnginePower)
 */
public class GetterKeyParam {
    /**
     *
     * @return EnginePower
     */
    public int get(){
        Scanner in = new Scanner(System.in);
        String textFromScanner = in.nextLine();
        FinderNumbers finder = new FinderNumbers();
        int InputEnginePower = finder.find(textFromScanner);
        return InputEnginePower;
           }

}
