package academydevdojo.springboot22essentials.handler;

import academydevdojo.springboot22essentials.exception.BadRequestException;
import academydevdojo.springboot22essentials.exception.BadRequestExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BadRequestExceptionDetails> handleBadRequestException(BadRequestException bre){
      return  new ResponseEntity<>(BadRequestExceptionDetails.builder()
              .timeStamp(LocalDateTime.now())
              .status(HttpStatus.BAD_REQUEST.value())
              .title("BAD REQUEST EXCEPTION")
              .details(bre.getMessage())
              .developerMessage(bre.getClass().getName())
              .build(), HttpStatus.BAD_REQUEST);
    }

}
