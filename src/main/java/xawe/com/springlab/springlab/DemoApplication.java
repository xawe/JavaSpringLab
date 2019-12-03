package xawe.com.springlab.springlab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@RestController
public class DemoApplication {

@Autowired
	RestTemplate restTemplate;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping(value ="/")
	public String hello()
	{
		return "Hello Spring Boot";
	}

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

}
