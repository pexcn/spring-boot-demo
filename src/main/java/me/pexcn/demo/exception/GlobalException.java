package me.pexcn.demo.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.pexcn.demo.config.ErrorCode;

/**
 * @author pexcn
 * @date 2018-09-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class GlobalException extends Exception {
    private static final long serialVersionUID = -2884711401322100667L;

    private ErrorCode code;

    public GlobalException() {
        super();
    }

    public GlobalException(ErrorCode code) {
        super(code.getMessage());
        this.code = code;
    }
}
