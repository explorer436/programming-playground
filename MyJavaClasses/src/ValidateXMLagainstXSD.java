import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;
import javax.xml.transform.stream.StreamSource;

public class ValidateXMLagainstXSD
{

	public static void main(String args[]) throws SAXException, IOException
	{
		Source schemaFile = new StreamSource(new File(
				"D:/Workspaces/LifeServices/ILAnnuityNetJavaBatch/resources/DTCC-NSCC_2014_03_APP_Records.xsd"));
		Source xmlFile = new StreamSource(
				new File("D:/lifeBatch/batch/ILAppsubBatch/input/appsub_20150421_020508.xml"));
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(schemaFile);
		Validator validator = schema.newValidator();

		try
		{
			validator.validate(xmlFile);
			System.out.println(xmlFile.getSystemId() + " is valid");
		}
		catch (Exception e)
		{
			System.out.println(xmlFile.getSystemId() + " is NOT valid");
			System.out.println("Reason: " + e.getLocalizedMessage());
			e.printStackTrace();
		}
	}

}
