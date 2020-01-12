
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.NoSuchAlgorithmException;

import org.artofsolving.jodconverter.office.DefaultOfficeManagerConfiguration;
import org.artofsolving.jodconverter.OfficeDocumentConverter;
import org.artofsolving.jodconverter.office.OfficeManager;*/

/**
 *
 * @author harshavardhane
 */
public class RtfToPdf
{

	/* public static void main(String[] args) throws FileNotFoundException, IOException, NoSuchAlgorithmException
	{
		readFileNames("/Users/harshavardhane/Desktop/rtffiles");
	}

	private static void readFileNames(String folderLocation)
			throws FileNotFoundException, IOException, NoSuchAlgorithmException
	{
		File folder = new File(folderLocation);
		File[] listOfFiles = folder.listFiles();
		System.out.println("listOfFiles.length : " + listOfFiles.length);
		for (int i = 0; i < listOfFiles.length; i++)
		{
			System.out.println("start of for loop for file " + i);
			if (listOfFiles[i].isFile())
			{
				// to make sure that the file is a rtf file
				if (listOfFiles[i].getName()
						.substring(listOfFiles[i].getName().length() - 4, listOfFiles[i].getName().length())
						.equals(".rtf"))
				{
					String fileName = folderLocation + "/" + listOfFiles[i].getName();
					System.out.println("rtf fileName : " + fileName);
					String pdfFN = fileName.substring(0, fileName.length() - 4) + ".pdf";
					System.out.println("pdf fileName : " + pdfFN);
					// dumbTest(fileName);
					// readBytes(fileName);
					convert(fileName, pdfFN);
				}
			}
			else if (listOfFiles[i].isDirectory())
			{
				// do nothing
			}
			System.out.println("end of for loop for file " + i);
		}
	}

	private static void convert(String rtfFileName, String pdfFileName)
	{
		DefaultOfficeManagerConfiguration configuration = new DefaultOfficeManagerConfiguration();
		configuration.setOfficeHome("/Applications/OpenOffice.app/Contents");
		OfficeManager officeManager = configuration.buildOfficeManager();
		OfficeDocumentConverter documentConverter = new OfficeDocumentConverter(officeManager);
		officeManager.start();

		OfficeDocumentConverter converter = new OfficeDocumentConverter(officeManager);
		converter.convert(new File(rtfFileName), new File(pdfFileName));

		officeManager.stop();
	}

	private static void readBytes(String fn) throws IOException, FileNotFoundException, NoSuchAlgorithmException
	{
		byte[] bts = loadFile(fn);
		System.out.println("byteArray : " + bts);
		writeBytesToFile(bts, fn);
	}

	private static void writeBytesToFile2(byte[] b, String fn)
			throws FileNotFoundException, IOException, NoSuchAlgorithmException
	{
		String filename = fn.substring(0, fn.length() - 4) + ".pdf";

		// create an object of FileOutputStream
		FileOutputStream fos = new FileOutputStream(new File(filename));
		fos.write(b);
		fos.close();
		//
		// //create an object of BufferedOutputStream
		// BufferedOutputStream bos = new BufferedOutputStream(fos);
		//
		// KeyGenerator kgen = KeyGenerator.getInstance("AES");
		// kgen.init(128);
		// SecretKey key = kgen.generateKey();
		// byte[] encoded = key.getEncoded();
		//
		// bos.write(encoded);

		// KeyGenerator kgen = KeyGenerator.getInstance("AES");
		// kgen.init(128);
		// SecretKey key = kgen.generateKey();
		// byte[] encoded = key.getEncoded();
		// FileOutputStream fos = new FileOutputStream(new File(filename));
		// BufferedOutputStream bos = new BufferedOutputStream(fos);
		// FileUtils.writeByteArrayToFile(new File(filename), b);
		// Files.write(b, new File(filename));

	}

	// private static void writeBytesToFile(byte[] b, String fn) throws
	// FileNotFoundException, IOException{
	// FileOutputStream fos = new FileOutputStream(fn.substring(0,
	// fn.length()-4)+".pdf");
	// BufferedOutputStream bos = new BufferedOutputStream(fos);
	// bos.write(b);
	// bos.flush();
	// bos.close();
	// }

	// private static void readBytes(String fn) throws FileNotFoundException,
	// IOException{
	// File file = new File(fn);
	// FileInputStream fileInputStream = new FileInputStream(file);
	// byte[] byteArray = new byte[(int) file.length()];
	// //System.out.println("length : "+file.length());
	// fileInputStream.read(byteArray);
	// System.out.println("read the bytes from the file : "+fn);
	// //System.out.println("byteArray : "+byteArray);
	// writeBytesToFile(byteArray, fn);
	// }

	private static void writeBytesToFile(byte[] bArray, String fn) throws FileNotFoundException, IOException
	{
		// always use this to write bytes to file
		// do not use FileWriter. It is for writing characters
		OutputStream out = new FileOutputStream(fn.substring(0, fn.length() - 4) + ".pdf");
		out.write(bArray);
		out.close();
	}

	// private static void convertRtfToPdf(String inputFile, String outputFile){
	// // create a new document
	// Document document = new Document();
	//
	// try {
	// // create a PDF writer to save the new document to disk
	// PdfWriter writer = PdfWriter.getInstance(document, new
	// FileOutputStream(outputFile));
	// // open the document for modifications
	// document.open();
	//
	// // create a new parser to load the RTF file
	// RtfParser parser = new RtfParser(null);
	// // read the rtf file into a compatible document
	// parser.convertRtfDocument(new FileInputStream(inputFile), document);
	//
	// // save the pdf to disk
	// document.close();
	//
	// System.out.println("Finished");
	//
	// } catch (DocumentException e) {
	// e.printStackTrace();
	// } catch (FileNotFoundException e) {
	// e.printStackTrace();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }

	public static byte[] loadFile(String sourcePath) throws IOException
	{
		InputStream inputStream = null;
		try
		{
			inputStream = new FileInputStream(sourcePath);
			return readFully(inputStream);
		}
		finally
		{
			if (inputStream != null)
			{
				inputStream.close();
			}
		}
	}

	public static byte[] readFully(InputStream stream) throws IOException
	{
		byte[] buffer = new byte[8192];
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		int bytesRead;
		while ((bytesRead = stream.read(buffer)) != -1)
		{
			baos.write(buffer, 0, bytesRead);
		}
		return baos.toByteArray();
	}*/

}
