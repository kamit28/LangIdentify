package com.langidentify.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.langidentify.model.Content;

public class LangIdentifierTester {
	
	LangIdentifierService service;

	@Before
	public void setUp() throws Exception {
		service = new LangIdentifierServiceImpl();
	}

	@Test
	public final void testIdentify() {
		Content content = new Content();
		content.setText("Aachenerin, Aal, deklarierte; deklarierender, AOL, AIDS, zzgl apple april atlantic : detecting, detective misbehavior");
		assertEquals("ENGLISH", service.identify(content));
		content.setText("Aachenerin, Aal, deklarierte; deklarierender,");
		assertEquals("GERMAN", service.identify(content));
		content.setText("Aachenerin, AOL, april; deklarierender,");
		assertEquals("unidentified", service.identify(content));
	}

}
