package com.langidentify.model;

/**
 * Content represents user input from the UI
 */
public class Content {
	private String text;
	private int numWords;

	/**
	 * 
	 */
	public Content() {
	}

	/**
	 * @return the numWords
	 */
	public int getNumWords() {
		return numWords;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param numWords
	 *            the numWords to set
	 */
	public void setNumWords(int numWords) {
		this.numWords = numWords;
	}

	/**
	 * @param text
	 *            the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

}
