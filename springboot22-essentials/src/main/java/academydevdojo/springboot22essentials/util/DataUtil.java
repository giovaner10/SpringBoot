package academydevdojo.springboot22essentials.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

@Component
public class DataUtil {
    //data no formato
    public String formatLocalDateTimeToDatabaseStyle(LocalDateTime localDateTime) {
        return DateTimeFormatter.ofPattern("dd-MM-yyyy  HH:mm:ss").format(localDateTime);

    }

}

