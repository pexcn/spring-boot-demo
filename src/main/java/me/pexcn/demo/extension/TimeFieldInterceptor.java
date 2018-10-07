package me.pexcn.demo.extension;

import me.pexcn.demo.annotation.CreateTime;
import me.pexcn.demo.annotation.UpdateTime;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.Objects;
import java.util.Properties;

/**
 * @author pexcn
 * @date 2018-10-07
 */
@Component
@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})
})
public class TimeFieldInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        MappedStatement statement = (MappedStatement) invocation.getArgs()[0];
        SqlCommandType type = statement.getSqlCommandType();
        Object parameter = invocation.getArgs()[1];

        Field[] fields = parameter.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (Objects.nonNull(field.getAnnotation(CreateTime.class))) {
                if (SqlCommandType.INSERT.equals(type)) {
                    field.setAccessible(true);
                    field.set(parameter, new Date());
                    field.setAccessible(false);
                }
            }

            if (Objects.nonNull(field.getAnnotation(UpdateTime.class))) {
                if (SqlCommandType.UPDATE.equals(type)) {
                    field.setAccessible(true);
                    field.set(parameter, new Date());
                    field.setAccessible(false);
                }
            }
        }

        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
    }
}
