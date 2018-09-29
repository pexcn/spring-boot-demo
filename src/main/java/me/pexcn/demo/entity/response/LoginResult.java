package me.pexcn.demo.entity.response;

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
public class LoginResult {
    private Long userId;
    private String token;
}
