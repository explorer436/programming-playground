import java.io.File;

public class RenameFiles
{
	private final static String folderLocation = "/Users/harshavardhanedupuganti/Desktop/OCD Pirate's Library - Java Books";
	//private final static String folderLocation = "/Users/harshavardhanedupuganti/Google Drive/OCD Pirate's Library - Java Books";
	
	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args)
	{
		readAuthors(folderLocation);
		System.out.println("--finished--");
	}

	private static void readAuthors(String folderLocation)
	{
		try
		{
			File folder = new File(folderLocation);
			File[] listOfFiles = folder.listFiles();
			for (int i = 0; i < listOfFiles.length; i++)
			{
				if (listOfFiles[i].isFile() && listOfFiles[i].getName().length() > 22)
				{
					try
					{
						String oldName = listOfFiles[i].getAbsoluteFile().getPath();
						
						System.out.println("Absolute Old File Name : " + oldName);
						
						String s = "/Users/harshavardhanedupuganti/Desktop/OCD Pirate's Library - Java Books/";
						System.out.println(s.length());

						int indexOfExtension = oldName.lastIndexOf('.');
						System.out.println("indexOfExtension : " + indexOfExtension);

						String suffix = oldName.substring(0, 73);
						String firstPart = oldName.substring(73, 73 + 21);
						String lastPart = oldName.substring(73 + 22, indexOfExtension);
						String ext = oldName.substring(indexOfExtension,
								oldName.length());

						System.out.println("suffix : " + suffix);
						System.out.println("firstPart : " + firstPart);
						System.out.println("lastPart : " + lastPart);
						System.out.println("ext : " + ext);

						String newFileName = suffix + lastPart + " - " + firstPart + ext;

						System.out.println("new absolute FileName : " + newFileName);

						if (listOfFiles[i].renameTo(new File(newFileName)))
						{
							System.out.println("Rename succesful");
						}
						else
						{
							System.out.println("Rename failed");
						}
					}
					catch (Exception e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				/*
				 * else if (listOfFiles[i].isDirectory()) { //
				 * System.out.println("Author : "+listOfFiles[i].getName());
				 * readBooks(listOfFiles[i].getName(), folderLocation + "/" +
				 * listOfFiles[i].getName(), writer); }
				 */
			}

		}
		catch (Exception ex)
		{
			// Report
			System.out.println("Exception : " + ex.toString());
		}
	}
}
