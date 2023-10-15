package com.ciosmak.automotivepartner.token.support;

import com.ciosmak.automotivepartner.shared.api.response.ErrorMessageResponse;
import com.ciosmak.automotivepartner.token.support.exception.InvalidTokenException;
import com.ciosmak.automotivepartner.token.support.exception.NotExpiredTokenException;
import com.ciosmak.automotivepartner.user.support.UserExceptionAdvisor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice

public class TokenExceptionAdvisor
{
    private static final Logger LOG = LoggerFactory.getLogger(UserExceptionAdvisor.class);

    @ExceptionHandler(InvalidTokenException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessageResponse invalidToken(InvalidTokenException exception)
    {
        LOG.error(exception.getMessage(), exception);
        return new ErrorMessageResponse(exception.getMessage());
    }

    @ExceptionHandler(NotExpiredTokenException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessageResponse notExpiredToken(NotExpiredTokenException exception)
    {
        LOG.error(exception.getMessage(), exception);
        return new ErrorMessageResponse(exception.getMessage());
    }
}
