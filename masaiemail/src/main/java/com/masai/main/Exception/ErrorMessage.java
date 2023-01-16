package com.masai.main.Exception;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data


public class ErrorMessage {
    private String error_message;
    private LocalDateTime error_time;
    private String uri_details;
}
