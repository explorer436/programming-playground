
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 *
 * @author harshavardhane
 */
public class PrintFileNamesInAFolder
{
	/*private final static String folderLocation = "/Users/harshavardhanedupuganti/Google Drive/eBooks/Kindle Library (Final)/K";
	private final static String catalogLocation = "/Users/harshavardhanedupuganti/Google Drive/eBooks/Kindle Library (Final)";*/
	
	private final static String folderLocation = "/Users/harshavardhanedupuganti/Google Drive/OCD Pirate's Library - Java Books";
	private final static String catalogLocation = "/Users/harshavardhanedupuganti/Google Drive/OCD Pirate's Library - Java Books";

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args)
	{
		// String folderLocation = "/Users/harshavardhane/Desktop/eBooks/Kindle Library
		// (Final)/K";

		readAuthors(folderLocation);
		System.out.println("--finished--");
	}

	private static void readAuthors(String folderLocation)
	{
		Writer writer = null;
		try
		{
			writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(
							catalogLocation + "/0000Catalog.txt"),
					"utf-8"));
			
			File folder = new File(folderLocation);
			File[] listOfFiles = folder.listFiles();
			for (int i = 0; i < listOfFiles.length; i++)
			{
				if (listOfFiles[i].isFile())
				{
					try
					{
						System.out.println("File " + listOfFiles[i].getName());
						System.out.println("File name length : " + listOfFiles[i].getName().substring(22, listOfFiles[i].getName().length()));
					}
					catch (Exception e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					//String str = "8776815013 {7CB886F5} ";
					//System.out.println(str.length());
					writer.write(listOfFiles[i].getName() + "\n");
				}
				else if (listOfFiles[i].isDirectory())
				{
					// System.out.println("Author : "+listOfFiles[i].getName());
					readBooks(listOfFiles[i].getName(), folderLocation + "/" + listOfFiles[i].getName(), writer);
				}
			}
			
		}
		catch (IOException ex)
		{
			// Report
			System.out.println("IO exception : " + ex.toString());
		}
		finally
		{
			try
			{
				writer.close();
			}
			catch (Exception ex)
			{
				/* ignore */}
		}
	}

	private static void readBooks(String authorName, String location, Writer writer) throws IOException
	{
		File folder = new File(location);
		File[] listOfFiles = folder.listFiles();
		
		for (int i = 0; i < listOfFiles.length; i++)
		{
			if (listOfFiles[i].isFile())
			{
				// System.out.println("File " + listOfFiles[i].getName());
			}
			else if (listOfFiles[i].isDirectory())
			{
				// System.out.println(location.substring(62) + " } " +
				// listOfFiles[i].getName());
				//System.out.println(authorName + "\t } \t" + listOfFiles[i].getName());
				writer.write(authorName + "\t } \t" + listOfFiles[i].getName() + "\n");
			}
		}
	}
}
