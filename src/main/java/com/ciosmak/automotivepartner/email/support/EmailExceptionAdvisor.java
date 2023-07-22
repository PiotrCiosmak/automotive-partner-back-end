package com.ciosmak.automotivepartner.email.support;

import com.ciosmak.automotivepartner.email.support.exception.EmailNotFoundException;
import com.ciosmak.automotivepartner.email.support.exception.EmailTakenException;
import com.ciosmak.automotivepartner.email.support.exception.InCorrectEmailException;
import com.ciosmak.automotivepartner.shared.api.response.ErrorMessageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class EmailExceptionAdvisor
{
    private static final Logger LOG = LoggerFactory.getLogger(EmailExceptionAdvisor.class);

    @ExceptionHandler(EmailTakenException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public ErrorMessageResponse emailTaken(EmailTakenException exception)
    {
        LOG.error(exception.getMessage(), exception);
        return new ErrorMessageResponse(exception.getMessage());
    }

    @ExceptionHandler(InCorrectEmailException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessageResponse inCorrectEmail(InCorrectEmailException exception)
    {
        LOG.error(exception.getMessage(), exception);
        return new ErrorMessageResponse(exception.getMessage());
    }

    @ExceptionHandler(EmailNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessageResponse emailNotFound(EmailNotFoundException exception)
    {
        LOG.error(exception.getMessage(), exception);
        return new ErrorMessageResponse(exception.getMessage());
    }
}
