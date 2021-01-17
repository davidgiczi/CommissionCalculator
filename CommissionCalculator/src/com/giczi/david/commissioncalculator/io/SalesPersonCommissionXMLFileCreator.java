package com.giczi.david.commissioncalculator.io;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import com.giczi.david.commissioncalculator.model.SalesPerson;

public class SalesPersonCommissionXMLFileCreator {

	private List<SalesPerson> salesPersonStore;
	private String filePath;

	public SalesPersonCommissionXMLFileCreator(List<SalesPerson> salesPersonStore) {

		this.salesPersonStore = salesPersonStore;

	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public void createXMLFile() {

		try {
			Element salesPersons = new Element("salespersons");
			Document doc = new Document(salesPersons);

			for (SalesPerson salesPerson : salesPersonStore) {
				
				Element personData = new Element("salesperson");
				personData.addContent(new Element("name").setText(salesPerson.getNameOfSalesPerson()));
				personData.addContent(new Element("commission").setText(String.valueOf(salesPerson.getSummaCommision())));
				doc.getRootElement().addContent(personData);
			}
			
			XMLOutputter xmlOutput = new XMLOutputter();
			xmlOutput.setFormat(Format.getPrettyFormat());

			xmlOutput.output(doc, new FileWriter(filePath));
			System.out.println("File Saved!");
		} catch (IOException e) {
			System.out.println("The file cannot be created: " + filePath);
			e.printStackTrace();
		}

	}

}
