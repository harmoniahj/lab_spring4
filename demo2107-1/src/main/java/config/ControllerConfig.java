package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kosmo.spring3.HomeController;

@Configuration
public class ControllerConfig {
	@Bean
	public HomeController helloController() {
		return new HomeController();
	}
	
//	@Bean
//	public class BoardController boardController() {
//		return new BoardController();
//	}
}