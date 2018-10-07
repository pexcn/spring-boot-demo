package me.pexcn.demo.entity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class User {
    @Id
    @GeneratedValue(generator = "JDBC")

    private Long uid;

    private String username;

    private String password;
}
