package me.pexcn.demo.entity.request;

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
public class RegisterBody {
    private String username;
    private String password;
}
