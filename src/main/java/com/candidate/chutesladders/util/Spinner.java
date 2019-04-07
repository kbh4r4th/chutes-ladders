package com.candidate.chutesladders.util;

import static com.candidate.chutesladders.constant.ChutesLaddersConstants.MSG_ENTERED;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.candidate.chutesladders.spring.ChutesLaddersProperties;

/**
 * @author Bharath
 *
 */
@Component
public class Spinner {
	private static final Logger LOGGER = LoggerFactory.getLogger(Printer.class);

	private Random random = new Random();

	@Autowired
	private ChutesLaddersProperties properties;

	public int spin() {
		LOGGER.debug(MSG_ENTERED);
		return random.nextInt(properties.getSpinnerSize()) + 1;
	}

}
