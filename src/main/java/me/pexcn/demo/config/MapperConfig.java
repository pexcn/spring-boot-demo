package me.pexcn.demo.config;

import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author pexcn
 * @date 2018-09-19
 */
@Configuration
@MapperScan(basePackages = "me.pexcn.demo.mapper")
public class MapperConfig {
}
