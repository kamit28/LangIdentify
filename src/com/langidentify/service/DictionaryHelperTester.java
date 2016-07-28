package com.langidentify.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.langidentify.model.Dictionary;

public class DictionaryHelperTester {
	DictionaryHelper dict;

	@Before
	public void setUp() throws Exception {
		DictionaryHelper.init();
		dict = new DictionaryHelper();
	}

	@Test
	public final void testInit() {
		Dictionary german = dict.getDictionary("GERMAN");
		assertNotNull(german);
		assertEquals("Testing number of words in German dictionary", 125,
				german.size());
		Dictionary french = dict.getDictionary("FRENCH");
		assertEquals("French dictionary should be null", null, french);
	}

	@Test
	public final void testIsWord() {
		assertTrue("GERMAN".equals(dict.isWord("zytotoxisch")));
		assertTrue("ENGLISH".equals(dict.isWord("AOL")));
		assertFalse("GERMAN".equals(dict.isWord("detective")));
		assertFalse("ENGLISH".equals(dict.isWord("bestinformiertes")));
		assertNull(dict.isWord("AAAAAAAA"));
	}

	@Test
	public final void testGetDictionary() {
		assertNotNull("The german should not be null",
				dict.getDictionary("GERMAN"));
		assertNull("The french should be null", dict.getDictionary("FRENCH"));
	}

}
