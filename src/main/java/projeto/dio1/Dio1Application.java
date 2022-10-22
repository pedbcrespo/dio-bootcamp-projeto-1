package projeto.dio1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class Dio1Application {

	public static void main(String[] args) {
		SpringApplication.run(Dio1Application.class, args);
	}

}
