package com.theproeshop.restt.api.eshop.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetail {
    private Date timestamp;
    private String message;
    private String details;
}
