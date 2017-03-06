package org.yangjie.timer.util;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 邮件发送工具类
 * @author YangJie [2016年10月12日 下午3:45:45]
 */
@Component
public class MailUtil {
	
	private Logger logger = LoggerFactory.getLogger(MailUtil.class);
	
	@Autowired
	private JavaMailSenderImpl javaMailSender;
	

	@Value("${mail.tos}") // 管理员邮件地址
	private String[] admins;

	/**
	 * 发送系统邮件 (收件地址在配置文件)
	 * @author YangJie [2016年8月5日 下午3:52:34]
	 * @param subject 主题 	
	 * @param text 邮件内容
	 * 注意主线程结束后线程池中任务不会继续执行
	 */
	@Async // 此注解表示方法异步执行, 在同一个类中调用无效, 因为spring会生成动态代理类完成异步调用
	public void sendMail(String subject, String text){
		SimpleMailMessage mailMessage = new SimpleMailMessage(); 
		mailMessage.setFrom(javaMailSender.getUsername());
		mailMessage.setTo(admins);
		mailMessage.setSubject(subject);
		mailMessage.setText(text);
		javaMailSender.send(mailMessage);
		logger.info("已向管理员[{}]发送了主题为[{}]的邮件", Arrays.asList(admins), subject);
	}
	
}
