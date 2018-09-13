package me.pexcn.demo.config;

/**
 * @author pexcn
 * @date 2018-09-18
 */
public enum ErrorCode {
    // 错误未定义
    ERROR_UNDEFINED("0xffffff"),

    // 用户名不存在
    USER_NOT_EXIST("0x100000"),

    // 用户名和密码不匹配
    USER_NOT_MATCH("0x100001"),

    // 用户名不能为空
    USERNAME_NOT_BE_NULL("0x100002"),

    // 密码不能为空
    PASSWORD_NOT_BE_NULL("0x100003"),

    ;

    private String code;

    ErrorCode(String code) {
        this.code = code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
