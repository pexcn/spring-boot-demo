package me.pexcn.demo.base;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author pexcn
 * @date 2018-09-18
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
