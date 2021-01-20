package com.giczi.david.commissioncalculator.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import com.giczi.david.commissioncalculator.io.DataLoader;
import com.giczi.david.commissioncalculator.model.AbstractSalesPerson;
import com.giczi.david.commissioncalculator.model.SalesPerson;

public class AbstractSalesPersonTest {

	@Test
	public void testCreateListOfIncomeItemsOfProductA() {

		List<String> dataStore = DataLoader.loadDataFromFile("./task/Feladat_fejlesztőknek_1_jutalékadatok.txt");
		List<String> salesPersonData = DataLoader.getSalesPersonData("Ü1", dataStore);
		AbstractSalesPerson salesPerson = new SalesPerson(salesPersonData);
		assertTrue(!salesPerson.getProductListByType("A").isEmpty());
		// for (Integer incomeItemA : salesPerson.getIncomeItemsForAProduct()) {
		// System.out.println(incomeItemA);}
	}

	@Test
	public void testCreateListOfIncomeItemsOfProductB() {

		List<String> dataStore = DataLoader.loadDataFromFile("./task/Feladat_fejlesztőknek_1_jutalékadatok.txt");
		List<String> salesPersonData = DataLoader.getSalesPersonData("Ü1", dataStore);
		AbstractSalesPerson salesPerson = new SalesPerson(salesPersonData);
		assertTrue(!salesPerson.getProductListByType("B").isEmpty());
		// for (Integer incomeItemB : salesPerson.getIncomeItemsForBProduct()) {
		 //System.out.println(incomeItemB);}
	}

	@Test
	public void testCreateListOfIncomeItemsOfProductC() {

		List<String> dataStore = DataLoader.loadDataFromFile("./task/Feladat_fejlesztőknek_1_jutalékadatok.txt");
		List<String> salesPersonData = DataLoader.getSalesPersonData("Ü1", dataStore);
		AbstractSalesPerson salesPerson = new SalesPerson(salesPersonData);
		assertTrue(!salesPerson.getProductListByType("C").isEmpty());
		// for (Integer incomeItemC : salesPerson.getIncomeItemsForBProduct()) {
		 //System.out.println(incomeItemC);}
	}

	@Test
	public void testCalcCommissionBySoldProducts() {

		List<String> soldProducts = new ArrayList<>();
		soldProducts.add("A|Ü1|20");
		soldProducts.add("B|Ü1|30");
		soldProducts.add("C|Ü1|50");
		AbstractSalesPerson salesPerson = new SalesPerson(soldProducts);
		assertTrue(1.0 == salesPerson.calcCommissionBySoldProducts());
	}

	@Test
	public void test1CalcBonusCommissionForProductA() {

		List<String> soldProductA = new ArrayList<>();
		soldProductA.add("A|Ü1|2000000");
		soldProductA.add("A|Ü1|3000000");
		soldProductA.add("A|Ü1|4000000");
		AbstractSalesPerson salesPerson = new SalesPerson(soldProductA);
		assertEquals(0, salesPerson.calcBonusCommissionForProductA());
	}

	@Test
	public void test2CalcBonusCommissionForProductA() {

		List<String> soldProductA = new ArrayList<>();
		soldProductA.add("A|Ü1|2000000");
		soldProductA.add("A|Ü1|8000000");
		soldProductA.add("A|Ü1|5000000");
		AbstractSalesPerson salesPerson = new SalesPerson(soldProductA);
		assertEquals(25000, salesPerson.calcBonusCommissionForProductA());
	}

	@Test
	public void test3CalcBonusCommissionForProductA() {

		List<String> soldProductA = new ArrayList<>();
		soldProductA.add("A|Ü1|1000000");
		soldProductA.add("A|Ü1|2000000");
		soldProductA.add("A|Ü1|20000000");
		AbstractSalesPerson salesPerson = new SalesPerson(soldProductA);
		assertEquals(40000, salesPerson.calcBonusCommissionForProductA());
	}

	@Test
	public void test1CalcBonusCommissionForProductB() {

		List<String> soldProductB = new ArrayList<>();
		soldProductB.add("B|Ü1|1000000");
		soldProductB.add("B|Ü1|2000000");
		soldProductB.add("B|Ü1|4000000");
		AbstractSalesPerson salesPerson = new SalesPerson(soldProductB);
		assertEquals(0, salesPerson.calcBonusCommissionForProductB());
	}

	@Test
	public void test2CalcBonusCommissionForProductB() {

		List<String> soldProductB = new ArrayList<>();
		soldProductB.add("B|Ü1|1000000");
		soldProductB.add("B|Ü1|8000000");
		soldProductB.add("B|Ü1|3000000");
		AbstractSalesPerson salesPerson = new SalesPerson(soldProductB);
		assertEquals(30000, salesPerson.calcBonusCommissionForProductB());
	}

	@Test
	public void test3CalcBonusCommissionForProductB() {

		List<String> soldProductB = new ArrayList<>();
		soldProductB.add("B|Ü1|7000000");
		soldProductB.add("B|Ü1|8000000");
		soldProductB.add("B|Ü1|3000000");
		AbstractSalesPerson salesPerson = new SalesPerson(soldProductB);
		assertEquals(50000, salesPerson.calcBonusCommissionForProductB());
	}

	@Test
	public void test1CalcBonusCommissionForProductC() {

		List<String> soldProductC = new ArrayList<>();
		soldProductC.add("C|Ü1|1000000");
		soldProductC.add("C|Ü1|1000000");
		soldProductC.add("C|Ü1|2000000");
		AbstractSalesPerson salesPerson = new SalesPerson(soldProductC);
		assertEquals(0, salesPerson.calcBonusCommissionForProductC());
	}

	@Test
	public void test2CalcBonusCommissionForProductC() {

		List<String> soldProductC = new ArrayList<>();
		soldProductC.add("C|Ü1|3000000");
		soldProductC.add("C|Ü1|4000000");
		soldProductC.add("C|Ü1|1000000");
		AbstractSalesPerson salesPerson = new SalesPerson(soldProductC);
		assertEquals(20000, salesPerson.calcBonusCommissionForProductC());
	}

	@Test
	public void test3CalcBonusCommissionForProductC() {

		List<String> soldProductC = new ArrayList<>();
		soldProductC.add("C|Ü1|6000000");
		soldProductC.add("C|Ü1|5000000");
		soldProductC.add("C|Ü1|2000000");
		AbstractSalesPerson salesPerson = new SalesPerson(soldProductC);
		assertEquals(40000, salesPerson.calcBonusCommissionForProductC());
	}
}
