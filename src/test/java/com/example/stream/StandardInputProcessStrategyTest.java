package com.example.stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.junit.Test;

import com.example.stream.process.enums.InputStrategyType;
import com.example.stream.process.strategy.IProcessStrategy;

/**
 * @author <a href="mailto:sthallapalli@outlook.com">sthallapalli</a>
 * @since 1.0
 */

public class StandardInputProcessStrategyTest extends AbstractInputProcessStrategyTest {

	private final IProcessStrategy strategy = InputStrategyType.STANDARD_INPUT.getStrategy();

	@Test
	public void test1() throws IOException {

		String input = "THEQUICKBROWNFOXJUMPSOVERLAZYDOG";
		System.setIn(new ByteArrayInputStream(input.getBytes()));

		strategy.process(5);

		// assert stdout's content value
		assertNotNull(outContent.toString());
		assertEquals(5, outContent.toString().trim().length());
	}

	@Test
	public void test2() throws IOException {

		String input = "THEQUICKBROWNFOXJUMPSOVERLAZYDOG";
		System.setIn(new ByteArrayInputStream(input.getBytes()));

		strategy.process(5);

		// assert stdout's content value
		assertNotNull(outContent.toString());
		assertNotEquals(-1, outContent.toString().trim().length());

	}
}
