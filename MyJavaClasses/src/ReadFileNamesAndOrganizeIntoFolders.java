import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ReadFileNamesAndOrganizeIntoFolders
{

	private static final String directory = "C:\\Users\\n0281526\\Downloads\\TryTomorrow\\TryTomorrow";

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		readBooks(directory);
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

				// System.out.println("book : " + getBookName(listOfFiles[i].getName()));

				// System.out.println(getAuthorName(listOfFiles[i].getName()) + " } " +
				// getBookName(listOfFiles[i].getName()));

				if (null != getAuthorName(listOfFiles[i].getName()))
				{
					createAuthorFolder(getAuthorName(listOfFiles[i].getName()));

					// move book into the folder
					moveFile(listOfFiles[i].getName(), getBookName(listOfFiles[i].getName()),
							getAuthorName(listOfFiles[i].getName()));
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
		File folder = new File(directory + "\\" + authorName);

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

	private static void moveFile(String source, String target, String authorName)
	{
		InputStream inStream = null;
		OutputStream outStream = null;

		try
		{

			File afile = new File(directory + "\\" + source);

			System.out.println("book : " + getBookName(source));

			File bfile = new File(directory + "\\" + authorName + "\\" + getBookName(source));

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
			afile.delete();

			System.out.println("File is copied successful!");

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}

}
