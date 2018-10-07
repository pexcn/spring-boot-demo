package me.pexcn.demo.extension;

import lombok.extern.slf4j.Slf4j;
import me.pexcn.demo.config.ErrorCode;
import me.pexcn.demo.exception.CommonException;
import me.pexcn.demo.utils.ResponseData;
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
    public ResponseData onCommonException(RuntimeException e) {
        if (e instanceof CommonException) {
            CommonException ee = (CommonException) e;

            // TODO: write log to file.
            log.warn(ee.getMessage());

            if (Objects.nonNull(ee.getCode())) {
                return ResponseData.fail(ee.getCode(), ee.getMessage());
            }
        }
        return ResponseData.fail(ErrorCode.SYSTEM_ERROR, e.getMessage());
    }
}
