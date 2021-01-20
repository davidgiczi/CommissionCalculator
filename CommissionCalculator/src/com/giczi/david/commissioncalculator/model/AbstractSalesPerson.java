package com.giczi.david.commissioncalculator.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class AbstractSalesPerson implements BonusCommissionCalcService {

	private String nameOfSalesPerson;
	private HashMap<String, List<Integer>> incomeItems;

	public AbstractSalesPerson(List<String> personData) {

		incomeItems = new HashMap<>();
		setIncomeItemsForProducts(personData);
		nameOfSalesPerson = getSalesPersonName(personData);
	}

	public abstract void calcSummaCommission();

	private void setIncomeItemsForProducts(List<String> salesPersonData) {

		for (String productType : ProductType.PRODUCT_STORE) {
			List<Integer> productList = getProductListByProductType(productType, salesPersonData);
			incomeItems.put(productType, productList);
		}

	}

	private List<Integer> getProductListByProductType(String productType, List<String> salesPersonData) {

		List<Integer> productList = new ArrayList<>();

		for (String personData : salesPersonData) {

			String[] data = personData.split("\\|");

			if (productType.equals(data[0])) {
				productList.add(Integer.parseInt(data[2]));
			}
		}

		return productList;
	}

	private String getSalesPersonName(List<String> personData) {
		return personData.get(0).split("\\|")[1];
	}

	public List<Integer> getProductListByType(String productType) {
		return incomeItems.get(productType);
	}

	public String getNameOfSalesPerson() {
		return nameOfSalesPerson;
	}

	public void setNameOfSalesPerson(String nameOfSalesPerson) {
		this.nameOfSalesPerson = nameOfSalesPerson;
	}

	@Override
	public double calcCommissionBySoldProducts() {

		double summaIncome = 0.0;

		for (String productType : ProductType.PRODUCT_STORE) {

			List<Integer> productItems = incomeItems.get(productType);

			for (Integer productItem : productItems) {
				summaIncome += productItem;
			}

		}

		return summaIncome * COMMISSION_PERCENT / 100;
	}

	@Override
	public int calcBonusCommissionForProductA() {

		int summaIncomeForProductA = 0;

		for (Integer incomeItemA : incomeItems.get(ProductType.PRODUCT_STORE[0])) {
			summaIncomeForProductA += incomeItemA;
		}

		if (summaIncomeForProductA >= 10000000 && summaIncomeForProductA < 20000000) {
			return 25000;
		} else if (summaIncomeForProductA >= 20000000) {
			return 40000;
		}

		return 0;
	}

	@Override
	public int calcBonusCommissionForProductB() {

		int summaIncomeForProductB = 0;

		for (Integer incomeItemB : incomeItems.get(ProductType.PRODUCT_STORE[1])) {
			summaIncomeForProductB += incomeItemB;
		}

		if (summaIncomeForProductB >= 8000000 && summaIncomeForProductB < 16000000) {
			return 30000;
		} else if (summaIncomeForProductB >= 16000000) {
			return 50000;
		}

		return 0;
	}

	@Override
	public int calcBonusCommissionForProductC() {

		int summaIncomeForProductC = 0;

		for (Integer incomeItemC : incomeItems.get(ProductType.PRODUCT_STORE[2])) {
			summaIncomeForProductC += incomeItemC;
		}

		if (summaIncomeForProductC >= 5000000 && summaIncomeForProductC < 10000000) {
			return 20000;
		} else if (summaIncomeForProductC >= 10000000) {
			return 40000;
		}

		return 0;
	}

}
