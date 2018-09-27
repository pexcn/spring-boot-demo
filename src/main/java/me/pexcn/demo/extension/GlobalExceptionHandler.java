package me.pexcn.demo.extension;

import lombok.extern.slf4j.Slf4j;
import me.pexcn.demo.base.ResponseData;
import me.pexcn.demo.config.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author pexcn
 * @date 2018-09-26
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseData onBadRequest(Exception e) {
        log.error(e.getMessage());
        return ResponseData.fail(ErrorCode.BAD_REQUEST);
    }
}
