
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
// import com.itextpdf.text.Document;
// import com.itextpdf.text.Element;
// import com.itextpdf.text.PageSize;
// import com.itextpdf.text.Paragraph;
// import com.itextpdf.text.pdf.PdfWriter;
// import java.io.BufferedReader;
// import java.io.File;
// import java.io.FileOutputStream;
// import java.io.FileReader;

/**
 *
 * @author harshavardhane
 */
public class ConvertTextfilesInAFolderToPDF
{

	/**
	 * @param args
	 *            the command line arguments
	 */
	/* public static void main(String[] args)
	{
		readFileNames("/Users/harshavardhane/Desktop/textfiles");
	}

	private static void readFileNames(String folderLocation)
	{
		File folder = new File(folderLocation);
		File[] listOfFiles = folder.listFiles();
		System.out.println("listOfFiles.length : " + listOfFiles.length);
		for (int i = 0; i < listOfFiles.length; i++)
		{
			System.out.println("start of for loop for file " + i);
			if (listOfFiles[i].isFile())
			{
				// to make sure that the file is a text file
				if (listOfFiles[i].getName()
						.substring(listOfFiles[i].getName().length() - 4, listOfFiles[i].getName().length())
						.equals(".txt"))
				{
					System.out.println(listOfFiles[i].getName().substring(listOfFiles[i].getName().length() - 4,
							listOfFiles[i].getName().length()));
					System.out.println("processing the file " + listOfFiles[i].getName());
					String textFN = folderLocation + "/" + listOfFiles[i].getName();
					System.out.println("Text File Name " + textFN);
					String pdfFN = folderLocation + "/"
							+ listOfFiles[i].getName().substring(0, listOfFiles[i].getName().length() - 4) + ".pdf";
					System.out.println("PDF File Name " + pdfFN);
					convertTextfileToPDFfile(textFN, pdfFN);
				}
			}
			else if (listOfFiles[i].isDirectory())
			{
				// do nothing
			}
			System.out.println("end of for loop for file " + i);
		}
	}

	public static void convertTextfileToPDFfile(String txtFileName, String pdfFileName)
	{
		BufferedReader input = null;
		Document output = null;
		System.out.println("Convert text file to pdf");
		System.out.println("input  : " + txtFileName);
		System.out.println("output : " + pdfFileName);
		try
		{
			input = new BufferedReader(new FileReader(txtFileName));
			// letter 8.5x11
			// see com.lowagie.text.PageSize for a complete list of page-size constants.
			output = new Document(PageSize.LETTER, 40, 40, 40, 40);

			PdfWriter.getInstance(output, new FileOutputStream(pdfFileName));

			output.open();
			output.addAuthor("YourName");
			output.addSubject(txtFileName);
			output.addTitle(txtFileName);

			String line = "";
			while (null != (line = input.readLine()))
			{
				System.out.println(line);
				Paragraph p = new Paragraph(line);
				p.setAlignment(Element.ALIGN_JUSTIFIED);
				output.add(p);
			}
			System.out.println("Done.");
			output.close();
			input.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}*/
}
