package org.yangjie.timer.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * 邮件发送配置
 * @author YangJie [2016年10月12日 下午3:27:12]
 */
@Configuration
public class MailSenderConfig {

	@Bean // 初始化邮件发送器
	@ConfigurationProperties(prefix = "mail.from")
	public JavaMailSenderImpl javaMailSender() {
		return new JavaMailSenderImpl();
	}
	
}
