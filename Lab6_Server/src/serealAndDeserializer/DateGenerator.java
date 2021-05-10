package serealAndDeserializer;

import java.time.LocalDate;

/**
 * интерфейс для дальнейшей реализации автоматической генерации даты
 */
public interface DateGenerator {
     /**
      *
      * @return
      */
     LocalDate generateDate();
}
