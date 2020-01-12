
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 *
 * @author harshavardhane
 */
public class Unzip
{

	private static Properties propertiesConfig = new Properties();

	public void loadProperties()
	{
		try
		{
			propertiesConfig.load(Unzip.class.getResourceAsStream("/PropertiesConfig.properties"));
		}
		catch (IOException e)
		{
			System.out.println("problem reading the properties file : " + e);
		}
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException, NoSuchAlgorithmException
	{

		// String sourceFileServerLocation = "/Users/harshavardhane/Desktop/rtffiles";
		String sourceFileServerLocation = propertiesConfig.getProperty("sourceFileServerLocation");
		// String destFolderName = "/Users/harshavardhane/Desktop/dest";
		String destFolderName = propertiesConfig.getProperty("destFolderName");
		readZipFileNames(sourceFileServerLocation, destFolderName);
	}

	private static void readZipFileNames(String folderLocation, String destination)
			throws FileNotFoundException, IOException, NoSuchAlgorithmException
	{
		File folder = new File(folderLocation);
		File[] listOfFiles = folder.listFiles();
		System.out.println("listOfFiles.length : " + listOfFiles.length);
		for (int i = 0; i < listOfFiles.length; i++)
		{
			System.out.println("start of for loop for file " + i);
			if (listOfFiles[i].getName()
					.substring(listOfFiles[i].getName().length() - 4, listOfFiles[i].getName().length()).equals(".zip"))
			{
				String inputZipName = folderLocation + "/" + listOfFiles[i].getName();
				// String outputFolderName =
				// folderLocation+"/"+listOfFiles[i].getName().substring(0,
				// listOfFiles[i].getName().length()-4);
				// String outputFolderName = destination;

				System.out.println("inputZipName : " + inputZipName);
				System.out.println("outputFolderName : " + destination);
				unZipIt(inputZipName, destination);
			}
			System.out.println("end of for loop for file " + i);
		}
	}

	/**
	 * Unzip it
	 * 
	 * @param zipFile
	 *            input zip file
	 * @param output
	 *            zip file output folder
	 */
	public static void unZipIt(String zipFile, String outputFolder)
	{

		byte[] buffer = new byte[1024];

		try
		{

			// create output directory is not exists
			File folder = new File(outputFolder);
			if (!folder.exists())
			{
				folder.mkdir();
			}

			// get the zip file content
			ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile));
			// get the zipped file list entry
			ZipEntry ze = zis.getNextEntry();

			while (ze != null
					&& (ze.getName().substring(ze.getName().length() - 4, ze.getName().length()).equals("rtf")))
			{

				String fileName = ze.getName();
				File newFile = new File(outputFolder + File.separator + fileName);

				System.out.println("file unzip : " + newFile.getAbsoluteFile());

				// create all non exists folders
				// else you will hit FileNotFoundException for compressed folder
				new File(newFile.getParent()).mkdirs();

				FileOutputStream fos = new FileOutputStream(newFile);

				int len;
				while ((len = zis.read(buffer)) > 0)
				{
					fos.write(buffer, 0, len);
				}

				fos.close();
				ze = zis.getNextEntry();
			}

			zis.closeEntry();
			zis.close();

			System.out.println("Done");

		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
	}
}
