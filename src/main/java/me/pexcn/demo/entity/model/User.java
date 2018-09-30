package me.pexcn.demo.entity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author pexcn
 * @date 2018-09-18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
@NameStyle(Style.camelhumpAndLowercase)
public class User {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long uid;
    private String username;
    private String password;
}
