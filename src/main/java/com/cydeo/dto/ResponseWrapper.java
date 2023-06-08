package com.cydeo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseWrapper {
    private boolean success;
    private String message;
    private Integer statusCode;
    private Object data;

    public ResponseWrapper( String message,Object data) {
        this.success =true;
        this.message = message;
        this.statusCode = HttpStatus.OK.value();
        this.data = data;
    }

    public ResponseWrapper(String message) {
        this.success = true;
        this.message = message;
        this.statusCode = HttpStatus.OK.value();
    }
}
