
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * @author
 */

public class XMLDOMCreator
{

	public static void main(String[] args)
	{
		DocumentBuilderFactory icFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder icBuilder;
		try
		{
			icBuilder = icFactory.newDocumentBuilder();
			Document doc = icBuilder.newDocument();
			Element mainRootElement = doc.createElement("nvps");
			doc.appendChild(mainRootElement);

			// append child elements to root element
			mainRootElement.appendChild(getNVP(doc, "Paypal", "Payment"));
			mainRootElement.appendChild(getNVP(doc, "eBay", "Shopping"));
			mainRootElement.appendChild(getNVP(doc, "Google", "Search"));

			// output DOM XML to console
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			StringWriter writer = new StringWriter();
			StreamResult result = new StreamResult(writer);
			transformer.transform(source, result);
			System.out.println(writer.toString());

			System.out.println("\nXML DOM Created Successfully..");

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private static Node getNVP(Document doc, String name, String age)
	{
		Element nvp = doc.createElement("nvp");

		nvp.appendChild(getNVPElements(doc, nvp, "tag", name));
		nvp.appendChild(getNVPElements(doc, nvp, "value", age));

		return nvp;
	}

	// utility method to create text node
	private static Node getNVPElements(Document doc, Element element, String name, String value)
	{
		Element node = doc.createElement(name);
		node.appendChild(doc.createTextNode(value));
		return node;
	}
}
