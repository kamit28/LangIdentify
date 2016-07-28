package com.langidentify.service;

import com.langidentify.model.Content;

public interface LangIdentifierService {
	/**
	 * Identifies the language based on number of matching words from a
	 * particular language dictionary. The algorithm matches each word from the
	 * input with all language dictionaries and creates a word matching
	 * frequency map where it records how many words of input matched with words
	 * in different dictionaries. Then the language with highest match is
	 * selected as "identified" input language. If there is a tie, or, frequency
	 * is zero or less than 30 % of the number of input words, result is set to
	 * "unidentified".
	 * 
	 * @param content
	 * @return
	 */
	public String identify(Content content);
}
