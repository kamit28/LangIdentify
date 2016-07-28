package com.langidentify.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.langidentify.model.Dictionary;
import com.langidentify.model.DictionaryImpl;

public final class DictionaryHelper {
	private static final Map<String, Dictionary> dictionaries = new HashMap<>();
	private static volatile boolean isEnabled;

	public static void init() {
		isEnabled = false;
		Path dir = Paths.get("/Users/Anshu/Desktop/langfiles");
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
			for (Path file : stream) {
				System.out.println(file.toString());
				System.out.println(file.getFileName());
				String[] fileParts = file.getFileName().toString().split("\\.");
				Dictionary dict;
				if (dictionaries.containsKey(fileParts[0])) {
					dict = dictionaries.get(fileParts[0]);
				} else {
					dict = new DictionaryImpl();
					dictionaries.put(fileParts[0], dict);
				}
				loadDictionary(dict, file.toString());
				isEnabled = true;
			}
		} catch (IOException | DirectoryIteratorException x) {
			System.err.println(x);
		}
	}

	/**
	 * Load the words from the dictionary file into the dictionary
	 * 
	 * @param d
	 *            The dictionary to load
	 * @param filename
	 *            The file containing the words to load.
	 */
	private static void loadDictionary(Dictionary d, String filename) {
		BufferedReader reader = null;

		try {
			String nextLine;
			reader = new BufferedReader(new FileReader(filename));
			while ((nextLine = reader.readLine()) != null) {
				String[] words = nextLine.split("\\.|,|;|:| ");
				for (String nextWord : words) {
					if (nextWord.trim().length() > 0)
						d.addWord(nextWord.trim().toLowerCase());
				}
			}
		} catch (IOException e) {
			System.err.println("Problem loading dictionary file: " + filename);
			e.printStackTrace();
		}
	}

	public String isWord(String word) {
		if (DictionaryHelper.isEnabled) {
			Iterator<String> iter = dictionaries.keySet().iterator();
			while (iter.hasNext()) {
				String lang = iter.next();
				if (dictionaries.get(lang).isWord(word.toLowerCase()))
					return lang;
			}
			return null;
		} else {
			return null;
		}
	}
	
	public Dictionary getDictionary(String lang) {
		return dictionaries.get(lang);
	}
}
