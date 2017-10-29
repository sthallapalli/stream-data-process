package com.example.stream.process.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:sthallapalli@outlook.com">sthallapalli</a>
 * @since 1.0
 */

public class StreamProcessUtil {

	private static final Logger LOG = Logger.getLogger(StreamProcessUtil.class.getName());

	private static final Pattern NUMBER_PATTERN = Pattern.compile("[0-9]+");

	private static final String DEFAULT_NUM_CHARS_SYS_PROP = "com.example.stream.process.defaultNumChars";

	private static final int RANDOM_SOURCE_STR_LENGTH = 1000;
	
	 /*
     * Only allow numbers less than 57 (the digits 0-9) or greater than 65 and 
     * less than 90 (letters A-Z) or great than 97 (the letters a-z)
     */
    public static String generateRandomString(int length){
        return new Random().ints(48, 122)
                .filter(i-> (i < 57 || i > 65) && (i < 90 || i > 97))
                .mapToObj(i -> (char) i)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

    public static void printRandom(String str, int limit) {
    	List<Character> chars = str.chars().mapToObj(e -> (char)e).collect(Collectors.toList());
    	Collections.shuffle(chars);
    	chars.stream().limit(limit).forEach(System.out::print);
    	System.out.println();
    }

	public static void defaultProcess(int n) {
		String randomStr = generateRandomString(RANDOM_SOURCE_STR_LENGTH);
		printRandom(randomStr, n);
	}	
	
	public static void standardInputProcess(int n) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String line;
			while ((line = br.readLine()) != null) {
				// If entered line contains only spaces, log a debug message and skip the line.
				if (line.trim().isEmpty()) {
					LOG.log(Level.INFO, "The input value [{0}] is blank.", line);
					continue;
				}
				printRandom(line, n);
			}
		} catch (IOException ex) {
			LOG.log(Level.SEVERE, "Exception while reading the standard input.", ex);
			throw new RuntimeException("Exception while reading the standard input.", ex);
		}
	}

	public static boolean isStandardInputAvailable() {
		try {
			return System.in.available() > 0;
		} catch (IOException ex) {
			LOG.log(Level.WARNING, "Exception while checking the standard input available", ex);
		}
		return false;
	}
	
	public static int parseArgs(String[] args) {

		if (args.length != 1 || (args[0] == null || args[0].isEmpty())) {
			System.out.println("Please input a single positive number argument.");
			System.exit(0);
		}

		String defaultNumCharsStr = System.getProperty(DEFAULT_NUM_CHARS_SYS_PROP, "5");

		int defaultNumChars = 5;
		try {
			defaultNumChars = Integer.parseInt(defaultNumCharsStr);
		} catch (NumberFormatException ex) {
			LOG.log(Level.WARNING, "Invalid value passed for VM arg [com.example.stream.process.defaultNumChars]", ex);
		}

		return (NUMBER_PATTERN.matcher(args[0]).matches() && Integer.parseInt(args[0]) > 0) ? 
								Integer.parseInt(args[0]) : defaultNumChars;
	}
}
