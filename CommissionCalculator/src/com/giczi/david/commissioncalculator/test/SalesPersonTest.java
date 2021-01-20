package com.giczi.david.commissioncalculator.test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.giczi.david.commissioncalculator.model.SalesPerson;

public class SalesPersonTest {

	@Test
	public void testCalcSummaCommission() {

		List<String> soldProducts = new ArrayList<>();
		soldProducts.add("A|Ü1|12000000");
		soldProducts.add("B|Ü1|10000000");
		soldProducts.add("C|Ü1|15000000");
		SalesPerson salesPerson = new SalesPerson(soldProducts);
		salesPerson.calcSummaCommission();
		assertTrue(465000.0 == salesPerson.getSummaCommission());
	}

}
