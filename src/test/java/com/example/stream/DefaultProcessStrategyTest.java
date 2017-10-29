package com.example.stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.example.stream.process.enums.InputStrategyType;
import com.example.stream.process.strategy.IProcessStrategy;

/**
 * @author <a href="mailto:sthallapalli@outlook.com">sthallapalli</a>
 * @since 1.0
 */

public class DefaultProcessStrategyTest extends AbstractInputProcessStrategyTest {

	private final IProcessStrategy strategy = InputStrategyType.DEFAULT.getStrategy();

	@Test
	public void test1() {
		strategy.process(10);
		// assert stdout's content value
		assertNotNull(outContent.toString());
		assertEquals(10, outContent.toString().trim().length());
	}

	@Test
	public void test2() {
		strategy.process(10);
		// assert stdout's content value
		assertNotNull(outContent.toString());
		assertNotEquals(0, outContent.toString().trim().length());
	}
}