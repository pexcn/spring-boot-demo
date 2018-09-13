package me.pexcn.demo.entity.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.pexcn.demo.entity.model.User;

/**
 * @author pexcn
 * @date 2018-09-25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginResponse {
    private String token;
    private User user;
}
