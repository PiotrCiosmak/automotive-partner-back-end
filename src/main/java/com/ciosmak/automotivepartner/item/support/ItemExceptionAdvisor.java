package com.ciosmak.automotivepartner.item.support;

import com.ciosmak.automotivepartner.item.support.exception.ItemNotFoundException;
import com.ciosmak.automotivepartner.shared.api.response.ErrorMessageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ItemExceptionAdvisor
{
    private static final Logger LOG = LoggerFactory.getLogger(ItemExceptionAdvisor.class);

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorMessageResponse itemNotFound(ItemNotFoundException exception)
    {
        LOG.error(exception.getMessage(), exception);
        return new ErrorMessageResponse(exception.getLocalizedMessage());
    }
}
