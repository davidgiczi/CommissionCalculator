package com.giczi.david.commissioncalculator.app;

import java.util.Arrays;
import java.util.List;

import com.giczi.david.commissioncalculator.io.DataLoader;
import com.giczi.david.commissioncalculator.io.SalesPersonCommissionXMLFileCreator;
import com.giczi.david.commissioncalculator.model.SalesPerson;

public class ComissionCalculatorApp {

	public static void main(String[] args) {
		
		List<String> dataStore = DataLoader.loadDataFromFile("./task/Feladat_fejlesztőknek_1_jutalékadatok.txt");
		List<String> ü1SalesPersonData = DataLoader.getSalesPersonData("Ü1", dataStore);
		List<String> ü2SalesPersonData = DataLoader.getSalesPersonData("Ü2", dataStore);
		List<String> ü3SalesPersonData = DataLoader.getSalesPersonData("Ü3", dataStore);
		
		SalesPerson ü1SalesPerson = new SalesPerson(ü1SalesPersonData);
		ü1SalesPerson.setNameOfSalesPerson("Ü1");
		ü1SalesPerson.calcSummaCommission();
		
		SalesPerson ü2SalesPerson = new SalesPerson(ü2SalesPersonData);
		ü2SalesPerson.setNameOfSalesPerson("Ü2");
		ü2SalesPerson.calcSummaCommission();
		
		SalesPerson ü3SalesPerson = new SalesPerson(ü3SalesPersonData);
		ü3SalesPerson.setNameOfSalesPerson("Ü3");
		ü3SalesPerson.calcSummaCommission();
		
		SalesPersonCommissionXMLFileCreator fileXMLCreator = 
				new SalesPersonCommissionXMLFileCreator(Arrays.asList(ü1SalesPerson, ü2SalesPerson, ü3SalesPerson));
		fileXMLCreator.setFilePath("./XML/commission.xml");
		fileXMLCreator.createXMLFile();
	}

}
