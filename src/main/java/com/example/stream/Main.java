package com.example.stream;

import static com.example.stream.process.util.StreamProcessUtil.isStandardInputAvailable;
import static com.example.stream.process.util.StreamProcessUtil.parseArgs;

import com.example.stream.process.enums.InputStrategyType;

/**
 * @author <a href="mailto:sthallapalli@outlook.com">sthallapalli</a>
 * @since 1.0
 */

/**
 * Passing any invalid/novalue/zero as input, defaults to 5. 
 *
 */
public class Main {

	public static void main(String[] args) {
		int n = parseArgs(args);
		InputStrategyType.get(isStandardInputAvailable()).getStrategy().process(n);
	}
}
