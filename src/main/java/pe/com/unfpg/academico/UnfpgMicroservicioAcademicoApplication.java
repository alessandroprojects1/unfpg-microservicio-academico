package pe.com.unfpg.academico;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class UnfpgMicroservicioAcademicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnfpgMicroservicioAcademicoApplication.class, args);
	}

}
