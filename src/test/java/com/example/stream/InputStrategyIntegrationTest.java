package com.example.stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayInputStream;

import org.junit.Test;

import com.example.stream.process.enums.InputStrategyType;
import com.example.stream.process.util.StreamProcessUtil;

/**
 * @author <a href="mailto:sthallapalli@outlook.com">sthallapalli</a>
 * @since 1.0
 */

public class InputStrategyIntegrationTest extends AbstractInputProcessStrategyTest {

	@Test
	public void standardInputTest() {
		String input = "THEQUICKBROWNFOXJUMPSOVERLAZYDOG";
		System.setIn(new ByteArrayInputStream(input.getBytes()));

		InputStrategyType.get(StreamProcessUtil.isStandardInputAvailable()).getStrategy().process(5);

		assertNotNull(outContent.toString());
		assertEquals(5, outContent.toString().trim().length());
	}

	@Test
	public void defaultInputTest() {

		InputStrategyType.get(StreamProcessUtil.isStandardInputAvailable()).getStrategy().process(5);

		assertNotNull(outContent.toString());
		assertEquals(5, outContent.toString().trim().length());
	}

}
