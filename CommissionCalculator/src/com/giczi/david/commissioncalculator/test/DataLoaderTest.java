package com.giczi.david.commissioncalculator.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.giczi.david.commissioncalculator.io.DataLoader;

public class DataLoaderTest {

	@Test
	void testLoadDataFromFile1() {

		List<String> dataStore = DataLoader.loadDataFromFile("./task/Feladat_fejlesztőknek_1_jutalékadatok.txt");
		assertTrue(!dataStore.isEmpty());
		// for (String row : dataStore) {
		// System.out.println(row);}
	}

	@Test
	void testLoadDataFromFile2() {

		DataLoader.loadDataFromFile("./task/Feladat_fejlesztőknek_1_jutalékadatok");
		assertTrue(true);
	}

	@Test
	void testGetÜ1SalesPersonData() {

		List<String> dataStore = DataLoader.loadDataFromFile("./task/Feladat_fejlesztőknek_1_jutalékadatok.txt");
		List<String> ü1SalesPersonData = DataLoader.getSalesPersonData("Ü1", dataStore);
		assertTrue(!ü1SalesPersonData.isEmpty());
		// for (String ü1Data : ü1SalesPersonData) {
		// System.out.println(ü1Data);}
	}

	@Test
	void testGetÜ2SalesPersonData() {

		List<String> dataStore = DataLoader.loadDataFromFile("./task/Feladat_fejlesztőknek_1_jutalékadatok.txt");
		List<String> ü2SalesPersonData = DataLoader.getSalesPersonData("Ü2", dataStore);
		assertTrue(!ü2SalesPersonData.isEmpty());
		// for (String ü2Data : ü2SalesPersonData) {
		// System.out.println(ü2Data);}
	}

	@Test
	void testGetÜ3SalesPersonData() {

		List<String> dataStore = DataLoader.loadDataFromFile("./task/Feladat_fejlesztőknek_1_jutalékadatok.txt");
		List<String> ü3SalesPersonData = DataLoader.getSalesPersonData("Ü3", dataStore);
		assertTrue(!ü3SalesPersonData.isEmpty());
		// for (String ü3Data : ü3SalesPersonData) {
		// System.out.println(ü3Data);}
	}

	@Test
	void testGetNotExistSalesPersonData() {

		List<String> dataStore = DataLoader.loadDataFromFile("./task/Feladat_fejlesztőknek_1_jutalékadatok.txt");
		List<String> notExistSalesPersonData = DataLoader.getSalesPersonData("Ü4", dataStore);
		assertTrue(notExistSalesPersonData.isEmpty());

	}

}
