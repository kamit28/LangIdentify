package com.langidentify.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DictionaryTester {

	Dictionary dict = new DictionaryImpl();
	Dictionary emptyDict;

	@Before
	public void setUp() throws Exception {
		emptyDict = new DictionaryImpl();
		dict.addWord("Hello");
		dict.addWord("HElLo");
		dict.addWord("help");
		dict.addWord("a");
		dict.addWord("subsequent");
	}

	@Test
	public final void testSize() {
		assertEquals("Testing size for empty dict", 0, emptyDict.size());
		assertEquals("Testing size for dict", 4, dict.size());
		dict.addWord("major");
		assertEquals(5, dict.size());
	}

	@Test
	public final void testIsWord() {
		assertEquals("Testing isWord on empty: Hello", false,
				emptyDict.isWord("Hello"));
		assertEquals("Testing isWord on dict: Hello", true,
				dict.isWord("Hello"));

		assertEquals("Testing isWord on dict: hello", true,
				dict.isWord("hello"));

		assertEquals("Testing isWord on dict: hellow", false,
				dict.isWord("hellow"));

		assertEquals("Testing isWord on empty: empty string", false,
				emptyDict.isWord(""));
		assertEquals("Testing isWord on dict: empty string", false,
				dict.isWord(""));

		assertEquals("Testing isWord on dict: no", false, dict.isWord("no"));

		assertEquals("Testing isWord on dict: subsequent", true,
				dict.isWord("subsequent"));
	}

	@Test
	public void addWord() {
		assertEquals("Asserting hellow is not in empty dict", false,
				emptyDict.isWord("hellow"));
		assertEquals("Asserting hellow is not in dict", false,
				dict.isWord("hellow"));

		emptyDict.addWord("hellow");
		dict.addWord("hellow");

		assertEquals("Asserting hellow is in empty dict", true,
				emptyDict.isWord("hellow"));
		assertEquals("Asserting hellow is in dict", true, dict.isWord("hellow"));

		assertEquals("Asserting xyzabc is not in empty dict", false,
				emptyDict.isWord("xyzabc"));
		assertEquals("Asserting xyzabc is not in dict", false,
				dict.isWord("xyzabc"));

		emptyDict.addWord("XYZAbC");
		dict.addWord("XYZAbC");

		assertEquals("Asserting xyzabc is in empty dict", true,
				emptyDict.isWord("xyzabc"));
		assertEquals("Asserting xyzabc is in dict", true, dict.isWord("xyzabc"));

		assertEquals("Testing isWord on empty: empty string", false,
				emptyDict.isWord(""));
		assertEquals("Testing isWord on dict: empty string", false,
				dict.isWord(""));

		assertEquals("Testing isWord on dict: no", false, dict.isWord("no"));

		assertEquals("Testing isWord on dict: subsequent", true,
				dict.isWord("subsequent"));
	}
}
