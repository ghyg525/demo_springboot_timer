package org.yangjie.timer.config.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解, 标记为一个定时任务
 * 使用aop对任务方法进行统一日志异常处理
 * @author YangJie [2016年10月17日 下午1:28:19]
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyTask{

	// 任务标识(描述)
	String value() default "";
	
}
