
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author harshavardhanedupuganti
 */
public class ArrangeBooks_Mac
{
	private static final String sourceDirectory = "/Volumes/SIGNATURE/eBooks/KindleLibrary2012/Library";

	private static final String targetDirectory = "/Volumes/SIGNATURE/eBooks/Kindle Library (Final)/K/";

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		readBooks(sourceDirectory);
	}

	private static void readBooks(String location)
	{
		File folder = new File(location);
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++)
		{
			if (listOfFiles[i].isFile())
			{
				// System.out.println("File : " + listOfFiles[i].getName());

				// System.out.println("author : " + getAuthorName(listOfFiles[i].getName()));

				String bookName = getBookName(listOfFiles[i].getName());

				bookName = bookName.substring(0, bookName.lastIndexOf("."));

				System.out.println("book : " + bookName);

				// System.out.println(getAuthorName(listOfFiles[i].getName()) + " } " +
				// getBookName(listOfFiles[i].getName()));

				if (null != getAuthorName(listOfFiles[i].getName()))
				{
					createAuthorFolder(getAuthorName(listOfFiles[i].getName()));

					createBookFolder(getAuthorName(listOfFiles[i].getName()), bookName);

					// move book into the folder
					moveFile(listOfFiles[i].getName(), getBookName(listOfFiles[i].getName()),
							getAuthorName(listOfFiles[i].getName()), bookName);
				}
			}
			else if (listOfFiles[i].isDirectory())
			{
				// System.out.println(location.substring(62) + " } " +
				// listOfFiles[i].getName());
				// System.out.println("Book : " + listOfFiles[i].getName());
			}
		}
	}

	// split author & book name
	private static String getAuthorName(String str)
	{
		String bookName = null;
		try
		{
			bookName = str.substring(0, str.indexOf("-")).trim();
		}
		catch (Exception e)
		{
			// e.printStackTrace();
		}
		return bookName;
	}

	private static String getBookName(String str)
	{
		String authorName = null;
		try
		{
			authorName = str.substring(str.indexOf("-") + 1, str.length()).trim();
		}
		catch (Exception e)
		{
			// e.printStackTrace();
		}
		return authorName;
	}

	private static void createAuthorFolder(String authorName)
	{
		File folder = new File(targetDirectory + authorName);

		if (!folder.exists())
		{
			if (folder.mkdir())
			{
				System.out.println("author directory is created!");
			}
			else
			{
				System.out.println("Failed to create directory!");
			}
		}
	}

	private static void createBookFolder(String authorName, String bookName)
	{
		File folder = new File(targetDirectory + authorName + "/" + bookName);

		if (!folder.exists())
		{
			if (folder.mkdir())
			{
				System.out.println("book directory is created!");
			}
			else
			{
				System.out.println("Failed to book directory!");
			}
		}
	}

	private static void moveFile(String source, String target, String authorName, String bookName)
	{
		InputStream inStream = null;
		OutputStream outStream = null;

		try
		{

			File afile = new File(sourceDirectory + "/" + source);

			System.out.println("book : " + getBookName(source));

			File bfile = new File(targetDirectory + authorName + "/" + bookName + "/" + bookName + "(lib2).mobi");

			inStream = new FileInputStream(afile);
			outStream = new FileOutputStream(bfile);

			byte[] buffer = new byte[1024];

			int length;
			// copy the file content in bytes
			while ((length = inStream.read(buffer)) > 0)
			{

				outStream.write(buffer, 0, length);

			}

			inStream.close();
			outStream.close();

			// delete the original file
			// afile.delete();

			System.out.println("File is copied successful!");

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}
}
