package com.theproeshop.restt.api.eshop.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
public class EShopException extends RuntimeException{
    private HttpStatus status;
    private String message;
    public EShopException(HttpStatus status, String message){
        this.status = status;
        this.message = message;
    }
}
