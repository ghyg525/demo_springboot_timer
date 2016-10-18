package org.yangjie.timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 程序入口, 启动器
 * @author YangJie [2016年10月11日 上午11:51:20]
 */
@SpringBootApplication
@EnableAsync  // 启用异步任务执行
@EnableScheduling // 启动定时任务
@EnableAspectJAutoProxy // 启动aop自动代理
public class Application {

	private static Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		logger.info("timer is running...");
	}
	
}
