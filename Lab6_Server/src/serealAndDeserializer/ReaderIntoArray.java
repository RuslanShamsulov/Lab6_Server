package serealAndDeserializer;

import java.io.File;
import java.util.List;


/**
 * интерфейс чтения из файла в список
 * param file json
 */
public interface ReaderIntoArray {
     /**
      *
      * @param file
      * @return
      */
     List<String> readIntoArray(File file);
}
