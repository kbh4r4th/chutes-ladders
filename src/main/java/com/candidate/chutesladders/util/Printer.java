/**
 * 
 */
package com.candidate.chutesladders.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import static com.candidate.chutesladders.constant.ChutesLaddersConstants.*;

/**
 * @author Bharath
 *
 */
@Component
public class Printer {
	private static final Logger LOGGER = LoggerFactory.getLogger(Printer.class);

	public void stat(int moveId, String name, int oldPos, int newPos, int modifiedPos, int cause) {
		LOGGER.debug(MSG_ENTERED);
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(moveId);
		stringBuilder.append(": ");
		stringBuilder.append(name);
		stringBuilder.append(": ");
		stringBuilder.append(oldPos);
		stringBuilder.append(" --> ");
		stringBuilder.append(newPos);
		if (modifiedPos > 0) {
			stringBuilder.append(" --");
			if (cause == 1)
				stringBuilder.append("LADDER");
			if (cause == 2)
				stringBuilder.append("CHUTE");
			stringBuilder.append("--> ");
			stringBuilder.append(modifiedPos);
		}
		LOGGER.info(stringBuilder.toString());
		LOGGER.debug(MSG_EXITED);
	}

}
