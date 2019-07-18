package com.example.demo;

import java.util.Date;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;
import javax.servlet.MultipartConfigElement;
import javax.servlet.http.HttpServletRequest;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.util.unit.DataSize;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dojo.ServerSettings;
import com.example.demo.dojo.User;

@RestController
@SpringBootApplication
@ServletComponentScan
@EnableJms
public class DemoApplication {

	@Autowired
	ServerSettings settings;

	@RequestMapping("/")
	String home() {
		return "Hello World!!!!!!";
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping("/test")
	String test(HttpServletRequest request) {
		return request.getParameter("name");
	}

	@RequestMapping("/testHeader")
	String testHeader(@RequestHeader("access_token") String accessToken,
			@RequestParam(value = "name", required = true) String name) {
		return accessToken + ":name=" + name;
	}

	@RequestMapping("/testJson")
	User testJson() {
		return new User("zs", "13916654422", new Date(), "shanghai");
	}

	@RequestMapping("/testPro")
	String testProperties() {
		return settings.filepath;
	}

	@RequestMapping("/login")
	String login() {
		return "login success";
	}

	@RequestMapping("/Handles")
	String handle() {
		return "handle success";
	}

	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		// 单个文件最大
		factory.setMaxFileSize(DataSize.ofKilobytes(10240));
		/// 设置总上传数据总大小
		factory.setMaxRequestSize(DataSize.ofMegabytes(10));
		return factory.createMultipartConfig();
	}

	@Bean
	public Topic topic() {
		return new ActiveMQTopic("video.topic");
	}

	@Bean
	public Queue queue() {
		return new ActiveMQQueue("common.queue");
	}

	@Bean
	public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ConnectionFactory activeMQConnectionFactory) {
		DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
		bean.setPubSubDomain(true);
		bean.setConnectionFactory(activeMQConnectionFactory);
		return bean;
	}

}
