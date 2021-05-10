package serealAndDeserializer;

import domain.Vehicle;

import java.io.File;
import java.util.LinkedList;

/**
 * Интерфейс сериализации
 */
public interface Serializer {
     /**
      *
      * @param LinkedList коллекция, которую необходимо записать в файл
      * @param file куда будет происходить запись
      */
     void serialize(LinkedList<Vehicle> LinkedList, File file) ;
}
