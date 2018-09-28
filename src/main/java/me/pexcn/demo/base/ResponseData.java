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
        return fail(null, null);
    }

    public static <T> ResponseData<T> fail(ErrorCode code) {
        return fail(code, null);
    }

    public static <T> ResponseData<T> fail(String message) {
        return fail(null, message);
    }

    public static <T> ResponseData<T> fail(ErrorCode code, String message) {
        ResponseData<T> response = new ResponseData<>();

        response.setData(null);
        response.setSuccess(false);

        Error error = new Error();
        if (Objects.isNull(code)) {
            code = ErrorCode.UNDEFINED;
        }
        if (Objects.isNull(message)) {
            message = code.getMessage();
        }
        error.setCode(code.getCode());
        error.setStatus(code.name());
        error.setMessage(message);
        response.setError(error);

        return response;
    }

    @Data
    private static class Error {
        private String code;
        private String status;
        private String message;
    }
}
