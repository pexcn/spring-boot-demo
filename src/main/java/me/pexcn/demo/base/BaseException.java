package me.pexcn.demo.base;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.pexcn.demo.config.ErrorCode;

/**
 * @author pexcn
 * @date 2018-09-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class BaseException extends RuntimeException {
    private static final long serialVersionUID = -2884711401322100667L;

    private ErrorCode code;

    public BaseException(String message) {
        super(message);
    }

    public BaseException(ErrorCode code) {
        super(code.getMessage());
        this.code = code;
    }

    public BaseException(ErrorCode code, String message) {
        super(message);
        this.code = code;
    }
}
