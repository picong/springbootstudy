package com.zanfq;

import com.zanfq.kafka.Sender;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class KafkaApplication {
	public static void main(String[] args) throws InterruptedException {
		ApplicationContext app = SpringApplication.run(KafkaApplication.class, args);

		while(true){
			Sender sender = app.getBean(Sender.class);
			sender.senMessage();
			Thread.sleep(500);
		}

	}
}
