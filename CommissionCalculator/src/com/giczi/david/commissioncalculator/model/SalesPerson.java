package com.giczi.david.commissioncalculator.model;

import java.util.List;

public class SalesPerson extends AbstractSalesPerson {

	private String nameOfSalesPerson;
	private Double summaCommision;
	
	public SalesPerson(List<String> personData) {
		super(personData);
		
	}
	
	public String getNameOfSalesPerson() {
		return nameOfSalesPerson;
	}

	public void setNameOfSalesPerson(String nameOfSalesPerson) {
		this.nameOfSalesPerson = nameOfSalesPerson;
	}

	public Double getSummaCommision() {
		return summaCommision;
	}

	@Override
	public void calcSummaCommission() {
		
		summaCommision = super.calcCommissionBySoldProducts() +
						 super.calcBonusCommissionForProductA() +
						 super.calcBonusCommissionForProductB() +
						 super.calcBonusCommissionForProductC();
	}
	
}
