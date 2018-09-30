package me.pexcn.demo.extension;

import lombok.extern.slf4j.Slf4j;
import me.pexcn.demo.base.BaseException;
import me.pexcn.demo.base.ResponseData;
import me.pexcn.demo.config.ErrorCode;
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
    /**
     * TODO: workaround only, I want to wrap the spring exception response via ResponseData.fail().
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseData onHandle(RuntimeException e) {
        e.printStackTrace();

        if (e instanceof BaseException) {
            BaseException error = (BaseException) e;

            // TODO: write log to file.
            log.error(error.getMessage());

            if (Objects.nonNull(error.getCode())) {
                return ResponseData.fail(error.getCode(), error.getMessage());
            }
        }
        return ResponseData.fail(ErrorCode.SYSTEM_ERROR, e.getMessage());
    }
}
