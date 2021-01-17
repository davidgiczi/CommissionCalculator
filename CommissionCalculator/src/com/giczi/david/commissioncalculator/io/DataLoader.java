package com.giczi.david.commissioncalculator.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class DataLoader {

	public static List<String> loadDataFromFile(String filePath) {

		List<String> rawData = new ArrayList<>();

		try (FileInputStream fis = new FileInputStream(new File(filePath));
				InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
				BufferedReader reader = new BufferedReader(isr)) {

			String row;

			while ((row = reader.readLine()) != null) {

				rawData.add(row);
			}

		} catch (IOException e) {
			System.out.println("Incorrect path and/or file name: " + filePath);
			e.printStackTrace();
		}

		return rawData;
	}

	public static List<String> getSalesPersonData(String salesPersonName, List<String> rowDataStore) {

		List<String> dataStore = new ArrayList<>();

		for (String row : rowDataStore) {

			if (row.contains(salesPersonName)) {
				dataStore.add(row);
			}
		}

		return dataStore;
	}

}
