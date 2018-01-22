package com.mo.prep.interview.amzon;

import org.junit.Assert;
import org.junit.Test;

public class TestDetermineShape {

	@Test
	public void testFindShape() {

		int[][] array = { { 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 1, 1, 1, 1, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 1, 1, 1, 1, 1, 1, 1, 0 }, { 0, 0, 0, 1, 1, 1, 0, 0, 0 } };

		Assert.assertEquals("Pretty cicular", DetermineShape.findShape(array));

		array = new int[][] { { 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 }, { 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0 },
				{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0 }, { 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0 } };

		Assert.assertEquals("Not very circular", DetermineShape.findShape(array));

	}

}