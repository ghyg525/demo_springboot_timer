package org.yangjie.timer.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.yangjie.timer.config.annotation.MyTask;
import org.yangjie.timer.util.MailUtil;

/**
 * 任务aop切面配置
 * 扩展任务方法, 记录日志, 异常处理等
 * @author YangJie [2016年10月12日 下午3:27:12]
 */
@Aspect
@Configuration
public class TaskAspectConfig{
	
	Logger Logger = LoggerFactory.getLogger(TaskAspectConfig.class);
	
	@Autowired
	private MailUtil mailUtil;
	

	/**
	 * 配置切入点(标记有{@link MyTask}注解)
	 */
	@Pointcut("@annotation(cc.moko.timer.framework.annotation.myTask)")
	public void pointcut(){}
	
    /**
     * 目标执行前执行
     * @param joinPoint
     * @param myTask
     */
	@Before("@annotation(myTask)")
	public void befor(JoinPoint joinPoint, MyTask myTask){
		String task = myTask.value(); // 任务名称, @MyTask注解的value内容
		Logger.info(task+"开始执行..."); // 日志信息写入数据库
	}
	
	/**
	 * 目标执行后执行
     * @param joinPoint
     * @param myTask
	 */
	@After("@annotation(myTask)")
	public void after(JoinPoint joinPoint, MyTask myTask){
		String task = myTask.value(); // 任务名称, @MyTask注解的value内容
		Logger.info(task+"执行结束.");
	}
	
	/**
	 * 目标抛出异常后执行
     * @param joinPoint
     * @param myTask
	 * @param e
	 */
	@AfterThrowing(pointcut="@annotation(myTask)", throwing="e")
	public void afterThrowing(JoinPoint joinPoint, MyTask myTask, Throwable e){
		String task = myTask.value(); // 任务名称, @MyTask注解的value内容
		mailUtil.sendMail(task+"出现异常!", e.getMessage()); // 异常信息发送邮件给管理员
		Logger.error(task+"出现异常!"+e.getMessage(), e);
	}
    
}
