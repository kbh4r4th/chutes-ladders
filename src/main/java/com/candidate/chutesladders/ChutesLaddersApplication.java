package com.candidate.chutesladders;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

import com.candidate.chutesladders.runner.GameRunner;
import com.candidate.chutesladders.spring.ChutesLaddersProperties;
import static com.candidate.chutesladders.constant.ChutesLaddersConstants.*;

/**
 * @author Bharath
 *
 */
@SpringBootApplication
@EnableConfigurationProperties(ChutesLaddersProperties.class)
public class ChutesLaddersApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(ChutesLaddersApplication.class);

	private static ChutesLaddersApplication application;

	@Autowired
	private GameRunner gameRunner;

	public static void main(String[] args) {
		LOGGER.info(MSG_ENTERED);

		ConfigurableApplicationContext applicationContext = SpringApplication.run(ChutesLaddersApplication.class, args);

		application = applicationContext.getBean(ChutesLaddersApplication.class);

		application.gameRunner.play();

		LOGGER.info(MSG_EXITED);
	}

}
