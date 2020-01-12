
/**
 * Copyright (c) 2017, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLValidationAgainstWSDL
{

	public static void main(String args[]) throws SAXException, IOException
	{

		String wsdlLocation = "C:\\Users\\n0281526\\Desktop\\QuoteIntegrationService_v1_0_1.wsdl";
		String xmlLocation = "Normalised.xml";

		// First create a document from the WSDL-source
		DocumentBuilder db = null;
		try
		{
			db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		}
		catch (ParserConfigurationException e1)
		{
			e1.printStackTrace();
		}

		Document wsdlDoc = db.newDocument();

		TransformerFactory.newInstance();

		File wsdlFile = new File(wsdlLocation);
		FileInputStream wsdlFileInputStream = null;
		try
		{
			wsdlFileInputStream = new FileInputStream(wsdlFile);
		}
		catch (IOException e)
		{
			System.out.println("exception : " + e.toString());

		}

		Document wsdlDocument = null;
		try
		{
			wsdlDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(wsdlFileInputStream);
		}
		catch (ParserConfigurationException e)
		{
			System.out.println("exception : " + e.toString());
		}

		Transformer transformer = null;
		try
		{
			transformer = TransformerFactory.newInstance().newTransformer();
		}
		catch (TransformerConfigurationException | TransformerFactoryConfigurationError e)
		{
			System.out.println("exception : " + e.toString());
		}
		try
		{
			transformer.transform(new DOMSource(wsdlDocument), new DOMResult(wsdlDoc));
		}
		catch (TransformerException e)
		{
			System.out.println("exception : " + e.toString());
		}

		// Now get the schemas from the WSDL
		NodeList schemaNodes = wsdlDoc.getElementsByTagNameNS(XMLConstants.W3C_XML_SCHEMA_NS_URI, "schema");

		int nrSchemas = schemaNodes.getLength();

		Source[] schemas = new Source[nrSchemas];

		for (

				int i = 0; i < nrSchemas; i++)

		{
			schemas[i] = new DOMSource(schemaNodes.item(i));
		}

		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

		// Now we have a schema that can validate the payload
		Schema schema = schemaFactory.newSchema(schemas);

		Validator validator = schema.newValidator();

		Source xmlFile = null;
		try
		{
			xmlFile = new StreamSource(new File(xmlLocation));

			validator.validate(xmlFile);
			System.out.println(xmlFile.getSystemId() + " is valid");
		}
		catch (SAXException e)
		{
			System.out.println(xmlFile.getSystemId() + " is NOT valid");
			System.out.println("Reason: " + e.getLocalizedMessage());
			e.printStackTrace();
		}

		System.out.println("success");
	}

}