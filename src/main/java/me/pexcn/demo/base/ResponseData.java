package me.pexcn.demo.base;

import lombok.Data;
import me.pexcn.demo.config.ErrorCode;

import java.util.Objects;

/**
 * @author pexcn
 * @date 2018-09-18
 */
@Data
public class ResponseData<T> {
    private T data;
    private Error error;
    private boolean success;

    public static <T> ResponseData<T> succeed() {
        return succeed(null);
    }

    public static <T> ResponseData<T> succeed(T data) {
        ResponseData<T> response = new ResponseData<>();

        if (Objects.nonNull(data)) {
            response.setData(data);
        }
        response.setError(null);
        response.setSuccess(true);

        return response;
    }

    public static <T> ResponseData<T> fail() {
        return fail(ErrorCode.ERROR_UNDEFINED, ErrorCode.ERROR_UNDEFINED.name());
    }

    public static <T> ResponseData<T> fail(ErrorCode code) {
        if (Objects.nonNull(code)) {
            return fail(code, code.name());
        }
        return fail();
    }

    public static <T> ResponseData<T> fail(String message) {
        if (Objects.nonNull(message)) {
            return fail(ErrorCode.ERROR_UNDEFINED, message);
        }
        return fail();
    }

    public static <T> ResponseData<T> fail(ErrorCode code, String message) {
        ResponseData<T> response = new ResponseData<>();

        response.setData(null);
        response.setSuccess(false);

        Error error = new Error();
        if (Objects.isNull(code)) {
            code = ErrorCode.ERROR_UNDEFINED;
        }
        error.setCode(code.getCode());
        error.setStatus(code);
        if (Objects.isNull(message)) {
            message = ErrorCode.ERROR_UNDEFINED.name();
        }
        error.setMessage(message);
        response.setError(error);

        return response;
    }

    @Data
    private static class Error {
        private String code;
        private ErrorCode status;
        private String message;
    }
}
