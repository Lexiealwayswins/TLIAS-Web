package com.itheima.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME) // 当前注解在runtime时间生效
@Target(ElementType.METHOD) // 当前注解是作用到method上
public @interface Log {
}
