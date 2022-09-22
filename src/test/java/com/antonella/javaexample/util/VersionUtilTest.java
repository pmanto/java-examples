package com.antonella.javaexample.util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VersionUtilTest {

	@Test
	void whenVersion2IsShorterAndSmallerThanVersion1_thenReturn1() {
		int result = VersionUtil.compareVersions("3.2", "3");
		assertEquals(1, result);
	}

	@Test
	void whenVersion2AndVersion1AreSameSize_thenReturnRightValue() {
		int result = VersionUtil.compareVersions("1.2.3.5.8", "1.2.3.5.7");
		assertEquals(1, result);
	}

	@Test
	void whenVersion2IsShorterAndBiggerThanVersion1_thenReturnMinus1() {
		int result = VersionUtil.compareVersions("2.2", "3");
		assertEquals(-1, result);
	}

	@Test
	void whenVersion1IsShorterAndSmallerThanVersion2_thenReturnMinus1() {
		int result = VersionUtil.compareVersions("3.2", "3.2.5");
		assertEquals(-1, result);
	}

	@Test
	void whenVersion2EqualToVersion1_thenReturn0() {
		int result = VersionUtil.compareVersions("0.5", "0.5");
		assertEquals(0, result);
	}

}
