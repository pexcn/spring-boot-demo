package me.pexcn.demo.entity.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pexcn
 * @date 2018-09-25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginInfo {
    private String username;
    private String password;
}
