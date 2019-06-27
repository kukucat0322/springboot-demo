package com.example.demo;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dojo.Result;

@RestController
@PropertySource({"classpath:application.properties"})
public class FileUploadController {
	
	@Value("${web.upload-path}")
	String filepath;
	
	@RequestMapping("/upload")
	public Result upload(MultipartFile file, @RequestParam(value="name") String name) {
		System.out.println(name);
		System.out.println(file.getSize());
		try {
			
			file.transferTo(new File(filepath+UUID.randomUUID()+".png"));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Result(0,"success");
	}
	
}
