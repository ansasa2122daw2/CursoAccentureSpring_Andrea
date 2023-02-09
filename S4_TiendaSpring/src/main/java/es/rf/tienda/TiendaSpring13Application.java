package es.rf.tienda;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@SpringBootApplication(scanBasePackages= {"es.rf.tienda"},exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication(scanBasePackages= ("es.rf.tienda"))
public class TiendaSpring13Application {

	public static void main(String[] args) {
		SpringApplication.run(TiendaSpring13Application.class, args);
	}

}
