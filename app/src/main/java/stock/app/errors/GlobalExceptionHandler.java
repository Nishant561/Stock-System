package stock.app.errors;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handelGlobalRuntimeException(RuntimeException ex){
        return new ResponseEntity<>(
                new ErrorResponse(
                        ex.getMessage(),
                        HttpStatus.BAD_REQUEST.value(),
                        LocalDateTime.now()
                ), HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handelMethodArgumentNotValid(MethodArgumentNotValidException ex){
        Map<String ,String> errors= new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put("message",error.getDefaultMessage());
        });

        errors.put("statusCode", String.valueOf(HttpStatus.BAD_REQUEST.value()));
        errors.put("timeStamp",LocalDateTime.now().toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }




    @ExceptionHandler(FailedUserCreation.class)
    public ResponseEntity<ErrorResponse> handleFailedUserCreationException(FailedUserCreation ex){
        return new ResponseEntity<>(
                new ErrorResponse(
                        ex.getMessage(),
                        HttpStatus.BAD_REQUEST.value(),
                        LocalDateTime.now()
                ), HttpStatus.BAD_REQUEST
        );
    }






}
