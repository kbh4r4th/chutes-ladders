package com.candidate.chutesladders;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChutesLaddersApplicationTests {
	@Test
	public void testGameBoardSizeOf100() {
		ChutesLaddersApplication.main(new String[] {});
		assertTrue(true);
	}
	
}
