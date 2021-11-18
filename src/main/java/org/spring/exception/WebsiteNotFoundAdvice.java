package org.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class WebsiteNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(value = {WebsiteNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String employeeNotFoundHandler(WebsiteNotFoundException e) {
        return e.getMessage();
    }
}
