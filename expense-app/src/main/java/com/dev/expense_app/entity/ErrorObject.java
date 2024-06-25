package com.dev.expense_app.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ErrorObject {

    private Integer statusCode;

    private String errorMessage;

    private Date timestamp;
}
