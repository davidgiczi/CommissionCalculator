package com.giczi.david.commissioncalculator.model;

import java.util.List;

public class SalesPerson extends AbstractSalesPerson {

	private String nameOfSalesPerson;
	private Double summaCommission;

	public SalesPerson(List<String> personData) {
		super(personData);

	}

	public String getNameOfSalesPerson() {
		return nameOfSalesPerson;
	}

	public void setNameOfSalesPerson(String nameOfSalesPerson) {
		this.nameOfSalesPerson = nameOfSalesPerson;
	}

	public Double getSummaCommission() {
		return summaCommission;
	}

	@Override
	public void calcSummaCommission() {

		summaCommission = super.calcCommissionBySoldProducts() + super.calcBonusCommissionForProductA()
				+ super.calcBonusCommissionForProductB() + super.calcBonusCommissionForProductC();
	}

}
