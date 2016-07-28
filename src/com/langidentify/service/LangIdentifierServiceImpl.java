package com.langidentify.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.langidentify.model.Content;

public class LangIdentifierServiceImpl implements LangIdentifierService {
	@Autowired
	private DictionaryHelper dictionaryHelper;

	public void setDictionaryHelper(DictionaryHelper dictionaryHelper) {
		this.dictionaryHelper = dictionaryHelper;
	}

	@Override
	public String identify(Content content) {
		Map<String, Integer> frequencies = new HashMap<>();
		createWordLangMatchingMap(frequencies, content);
		String nearestMatch = findNearestMatchingLang(frequencies, content);
		return nearestMatch;
	}

	/**
	 * Returns the language which gets maximum matches with the input. If there
	 * is a tie, "unidentified" is returned.
	 * 
	 * @param frequencies
	 * @return
	 */
	private String findNearestMatchingLang(Map<String, Integer> frequencies,
			Content content) {
		Iterator<String> iter = frequencies.keySet().iterator();
		int highest = 0;
		int secongHighest = 0;
		String lang = "unidentified";
		while (iter.hasNext()) {
			String key = iter.next();
			if (highest <= frequencies.get(key)) {
				lang = key;
				secongHighest = highest;
				highest = frequencies.get(key);
			}
		}
		if (highest == secongHighest || highest == 0
				|| highest < .3 * content.getNumWords())
			lang = "unidentified";
		return lang;
	}

	/**
	 * Creates a map of word match counts with dictionaries of different
	 * languages.
	 * 
	 * @param frequencies
	 * @param content
	 */
	private void createWordLangMatchingMap(Map<String, Integer> frequencies,
			Content content) {
		String[] words = content.getText().split("\\.|,|;|:| ");
		int wordCount = 0;
		for (String word : words) {
			if (!(word.trim().length() > 0))
				continue;
			else {
				wordCount++;
				String lang = dictionaryHelper.isWord(word.trim());
				if (null != lang) {
					if (frequencies.containsKey(lang)) {
						frequencies.put(lang, frequencies.get(lang) + 1);
						frequencies.get(lang);
					} else {
						frequencies.put(lang, 1);
					}
				}
			}
		}
		content.setNumWords(wordCount);
	}
}
