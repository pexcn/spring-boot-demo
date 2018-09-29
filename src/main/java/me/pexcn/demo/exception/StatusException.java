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
public class StatusException extends RuntimeException {
    private static final long serialVersionUID = -2884711401322100667L;

    private ErrorCode code;

    public StatusException(String message) {
        super(message);
    }

    public StatusException(ErrorCode code) {
        super(code.getMessage());
        this.code = code;
    }

    public StatusException(ErrorCode code, String message) {
        super(message);
        this.code = code;
    }
}
