package com.giczi.david.commissioncalculator.model;

import java.util.List;

public class SalesPerson extends AbstractSalesPerson {

	private Double summaCommission;

	public SalesPerson(List<String> personData) {
		super(personData);

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
