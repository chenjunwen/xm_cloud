package com.xm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@EnableEurekaClient
@SpringBootApplication
@RestController
public class EurekaClientApplication {

	private final static Logger logger = LoggerFactory.getLogger(EurekaClientApplication.class);

	@Value("${server.port}")
	String port;

	private AtomicInteger value = new AtomicInteger();

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}

	@GetMapping("hello")
	public String hello(String name){

		String str = "hello "+name+",我的端口号="+port;
		return str;
	}

	@GetMapping("/")
	public String index(String name) throws InterruptedException {
		String str = "eureka——client我的端口号="+port;
		int i = value.incrementAndGet();
		logger.info("当前请求次数----"+i);
		TimeUnit.MILLISECONDS.sleep(100);
		return str;
	}
}
