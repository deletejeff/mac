package com.mac.manager;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 功能：在请求具有此注解的方法时自己插入日志
 * 作者： yangyan
 * 时间： 2014/9/5 .
 */
@Target(ElementType.METHOD)//这个标注应用于类
@Retention(RetentionPolicy.RUNTIME)//标注会一直保留到运行时
public @interface AdminLog {
    /**
     * 模块的名称
     *
     * @return
     */
    String module();

    /**
     * 操作
     *
     * @return
     */
    String action();
}
