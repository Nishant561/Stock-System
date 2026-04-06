package stock.app.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class EndUserResponse {

    private String message;

    private int statusCode;

    private LocalDateTime timeStamp;

}
