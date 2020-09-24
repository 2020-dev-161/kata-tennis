package com.example.katatennis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class KataTennisApplicationTests {

	@Autowired
	private KataTennisApplication kataTennisApplication;

	@Test
	void testKataTennisApplication() {
		assertNotNull(kataTennisApplication);
	}

}
