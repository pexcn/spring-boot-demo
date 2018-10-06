package me.pexcn.demo.entity.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pexcn
 * @date 2018-10-06
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterResult {
    private Long userId;
    private String token;
}
