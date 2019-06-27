package com.example.demo.dojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource({"classpath:application.properties"})
@ConfigurationProperties
public class ServerSettings {
	
	@Value("${web.upload-path}")
	public String filepath;

}
