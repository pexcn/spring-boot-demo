package me.pexcn.demo.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.pexcn.demo.base.BaseException;
import me.pexcn.demo.config.ErrorCode;

/**
 * @author pexcn
 * @date 2018-09-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ServiceException extends BaseException {
    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(ErrorCode code) {
        super(code);
    }

    public ServiceException(ErrorCode code, String message) {
        super(code, message);
    }
}
