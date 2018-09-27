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
        return fail(ErrorCode.ERROR_UNDEFINED);
    }

    public static <T> ResponseData<T> fail(ErrorCode code) {
        if (Objects.isNull(code)) {
            return fail();
        }
        return fail(code, code.getMessage());
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
        error.setStatus(code.name());
        if (Objects.isNull(message)) {
            message = code.getMessage();
        }
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
