package com.example.stream.process.enums;

import static com.example.stream.process.util.StreamProcessUtil.defaultProcess;
import static com.example.stream.process.util.StreamProcessUtil.standardInputProcess;

import com.example.stream.process.strategy.IProcessStrategy;

/**
 * @author <a href="mailto:sthallapalli@outlook.com">sthallapalli</a>
 * @since 1.0
 */

/**
 * 
 * An enumeration of data input types.
 * Other enums types can be, HTTP, KAFKA etc.
 *
 * <b>Note: In case of more than two enums, get() can take an enum associated label and return corresponding
 * enum type<b>.
 *
 */

public enum InputStrategyType {

	STANDARD_INPUT {

		@Override
		public IProcessStrategy getStrategy() {
			return STANDARD_INPUT_STRATEGY;
		}
	},

	DEFAULT {

		@Override
		public IProcessStrategy getStrategy() {
			return DEFAULT_STRATEGY;
		}
	};

	public static InputStrategyType get(boolean isStandardInput) {
		return isStandardInput ? STANDARD_INPUT : DEFAULT;
	}

	public abstract IProcessStrategy getStrategy();

	// To make the code concise,lambdas are used as follows, alternate way is to have two strategy classes.	
	private static final IProcessStrategy DEFAULT_STRATEGY = n -> defaultProcess(n);
	private static final IProcessStrategy STANDARD_INPUT_STRATEGY = n -> standardInputProcess(n);
}
