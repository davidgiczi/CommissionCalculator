package com.giczi.david.commissioncalculator.model;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSalesPerson implements BonusCommissionCalcService {

	private double commissionPercent = 1.0;
	protected List<Integer> incomeItemsForAProduct;
	protected List<Integer> incomeItemsForBProduct;
	protected List<Integer> incomeItemsForCProduct;

	public AbstractSalesPerson(List<String> personData) {
		incomeItemsForAProduct = new ArrayList<>();
		incomeItemsForBProduct = new ArrayList<>();
		incomeItemsForCProduct = new ArrayList<>();
		setIncomeItemsListsForProducts(personData);
	}

	public abstract void calcSummaCommission();

	private void setIncomeItemsListsForProducts(List<String> salesPersonData) {

		for (String data : salesPersonData) {

			String[] dataStore = data.split("\\|");

			switch (dataStore[0]) {
			case "A":
				incomeItemsForAProduct.add(Integer.parseInt(dataStore[2]));
				break;
			case "B":
				incomeItemsForBProduct.add(Integer.parseInt(dataStore[2]));
				break;
			case "C":
				incomeItemsForCProduct.add(Integer.parseInt(dataStore[2]));

			}
		}

	}

	public List<Integer> getIncomeItemsForAProduct() {
		return incomeItemsForAProduct;
	}

	public List<Integer> getIncomeItemsForBProduct() {
		return incomeItemsForBProduct;
	}

	public List<Integer> getIncomeItemsForCProduct() {
		return incomeItemsForCProduct;
	}

	public double getCommissionPercent() {
		return commissionPercent;
	}

	public void setCommissionPercent(double commissionPercent) {
		this.commissionPercent = commissionPercent;
	}

	@Override
	public double calcCommissionBySoldProducts() {

		double summaIncome = 0.0;

		for (Integer incomeItemA : incomeItemsForAProduct) {
			summaIncome += incomeItemA;
		}
		for (Integer incomeItemB : incomeItemsForBProduct) {
			summaIncome += incomeItemB;
		}
		for (Integer incomeItemC : incomeItemsForCProduct) {
			summaIncome += incomeItemC;
		}

		return summaIncome * commissionPercent / 100;
	}

	@Override
	public int calcBonusCommissionForProductA() {

		double summaIncomeForProductA = 0;

		for (Integer incomeItemA : incomeItemsForAProduct) {
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

		double summaIncomeForProductB = 0;

		for (Integer incomeItemB : incomeItemsForBProduct) {
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

		double summaIncomeForProductC = 0;

		for (Integer incomeItemC : incomeItemsForCProduct) {
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
