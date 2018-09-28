package me.pexcn.demo.extension;

import lombok.extern.slf4j.Slf4j;
import me.pexcn.demo.base.ResponseData;
import me.pexcn.demo.config.ErrorCode;
import me.pexcn.demo.exception.GlobalException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

/**
 * @author pexcn
 * @date 2018-09-26
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseData onHandle(RuntimeException e) {
        if (e instanceof GlobalException) {
            GlobalException error = (GlobalException) e;

            // TODO: write log to file.
            log.error(error.getMessage());

            if (Objects.nonNull(error.getCode())) {
                return ResponseData.fail(error.getCode(), error.getMessage());
            }
        }
        return ResponseData.fail(ErrorCode.SYSTEM_ERROR, e.getMessage());
    }
}
