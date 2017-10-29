package com.example.stream.process.strategy;

/**
 * @author <a href="mailto:sthallapalli@outlook.com">sthallapalli</a>
 * @since 1.0
 */

@FunctionalInterface
public interface IProcessStrategy {

	/**
	 * Process the character stream and prints random characters of specified length.
	 * @param n, Random characters length
	 */
	void process(int n);
	
}
