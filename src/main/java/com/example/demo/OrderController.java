package com.example.demo;

import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.JsonData;
import com.example.demo.service.ProducerService;

/**
 * 功能描述：模拟微信支付回调
 *
 * <p> 创建时间：May 3, 2018 9:53:14 PM </p> 
 *
 *@作者 小D课堂  小D
 */
@RestController
@RequestMapping("/api/v1")
public class OrderController {
	
	@Autowired
	private ProducerService producerService;
	/**
	 * 功能描述：微信支付回调接口
	 * @param msg 支付信息
	 * @return
	 */
	@GetMapping("order")
	public Object order(String msg){
		
		Destination destination = new ActiveMQQueue("order.queue");
		
		producerService.sendMessage(destination, msg);
	
       return JsonData.buildSuccess();
	}
	
	
	
	@GetMapping("common")
	public Object common(String msg){
		producerService.sendMessage(msg);	
       return JsonData.buildSuccess();
	}
	
	@GetMapping("publish")
	public Object publish(String msg){
		producerService.publish(msg);	
       return JsonData.buildSuccess();
	}
	
}
