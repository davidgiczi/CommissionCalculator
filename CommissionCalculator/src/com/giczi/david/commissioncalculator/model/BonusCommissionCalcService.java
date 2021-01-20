package com.giczi.david.commissioncalculator.model;

public interface BonusCommissionCalcService {

	
	double COMMISSION_PERCENT = 1.0;
	
	double calcCommissionBySoldProducts();

	int calcBonusCommissionForProductA();

	int calcBonusCommissionForProductB();

	int calcBonusCommissionForProductC();
}
