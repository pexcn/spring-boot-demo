package me.pexcn.demo.config;

/**
 * @author pexcn
 * @date 2018-09-18
 */
public enum ErrorCode {
    ERROR_UNDEFINED("0x000000", "未定义错误"),

    BAD_REQUEST("0x000001", "请求失败"),

    USER_NOT_EXIST("0x100000", "用户名不存在"),

    USER_NOT_MATCH("0x100001", "用户名和密码不匹配"),

    USERNAME_NOT_BE_NULL("0x100002", "用户名不能为空"),

    PASSWORD_NOT_BE_NULL("0x100003", "密码不能为空"),

    ;

    private String code;
    private String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
