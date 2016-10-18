package org.yangjie.timer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.yangjie.timer.config.annotation.MyTask;

/**
 * 定时器任务配置
 * @author YangJie [2016年10月11日 下午3:13:56]
 */
@Configuration
public class TaskTimerConfig {
	
	/**
	 * 启动后3秒开始执行, 下次执行在100天后 (仅用于执行一次性任务)
	 */
	@MyTask("一次性任务")
	@Scheduled(initialDelay=3*1000, fixedDelay=100*24*60*60*1000)
	public void taskOnce(){}

	/**
	 * 每分钟执行
	 */
	@MyTask("每分钟任务")
//	@Scheduled(cron="0 * * * * ?")
	public void taskPerMinute(){}
	
	/**
	 * 每小时执行
	 */
	@MyTask("每小时任务")
//	@Scheduled(cron="0 0 * * * ?")
	public void taskPerHour(){}
	
	/**
	 * 每天执行 (4点)
	 */
	@MyTask("每天任务")
//	@Scheduled(cron="0 0 4 * * ?")
	public void taskPerDay(){}

}
