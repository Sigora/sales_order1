package com.sales.controllers;

import com.sales.exceptions.CustomerHaveNotEnoughtCredit;
import com.sales.exceptions.NotEnoughItemsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by starnakin on 09.04.2016.
 */
@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler({ NotEnoughItemsException.class })
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Not enough items")
    public void notEnoughQuantity(HttpServletRequest req, Exception exception) {
    }

    @ExceptionHandler({ CustomerHaveNotEnoughtCredit.class })
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Not enough credit")
    public void notEnoughCredit(HttpServletRequest req, Exception exception) {
    }

}
