package com.giczi.david.commissioncalculator.test;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import com.giczi.david.commissioncalculator.io.SalesPersonCommissionXMLFileCreator;
import com.giczi.david.commissioncalculator.model.SalesPerson;

public class SalesPersonCommissionXMLFileCreatorTest {

	@Test
	public void testCreateXMLFile() {

		List<String> soldProducts = new ArrayList<>();
		soldProducts.add("A|Ü1|12000000");
		soldProducts.add("B|Ü1|10000000");
		soldProducts.add("C|Ü1|15000000");
		SalesPerson person = new SalesPerson(soldProducts);
		person.setNameOfSalesPerson("Noname");
		person.calcSummaCommission();
		SalesPersonCommissionXMLFileCreator creator = new SalesPersonCommissionXMLFileCreator(Arrays.asList(person));
		creator.setFilePath("./XML/test.xml");
		creator.createXMLFile();
		File xml = new File(creator.getFilePath());
		assertTrue(xml.exists());
	}

}
