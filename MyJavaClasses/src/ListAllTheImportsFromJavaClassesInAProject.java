// import com.thoughtworks.qdox.JavaDocBuilder;
// import com.thoughtworks.qdox.model.JavaSource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ListAllTheImportsFromJavaClassesInAProject
{

	/* public static void main(String[] args)
	{
		// String fileFullPath = "Your\\java\\ file \\full\\path";

		String projectLocation = "D:/dev/workspaces/workspace1/PiThirdPartyExchangeImplLibrary";

		System.out.println("Trying to print the imports from the project : " + projectLocation);

		readFolders(projectLocation);
	}

	private static String getExtension(String fullPath, char extensionSeparator)
	{
		int dot = fullPath.lastIndexOf(extensionSeparator);
		return fullPath.substring(dot + 1);
	}

	private static void printImportListFromFile(String fileFullPath)
	{

		JavaDocBuilder builder = new JavaDocBuilder();
		try
		{
			builder.addSource(new FileReader(fileFullPath));
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}

		JavaSource src = builder.getSources()[0];
		String[] imports = src.getImports();

		System.out.println("The imports from the class " + fileFullPath + " are : ");
		for (int i = 1; i <= imports.length; i++)
		{
			System.out.println("        " + i + ". " + imports[i - 1]);
		}
	}

	private static void readFiles(String projectLocation)
	{
		// System.out.println(">>readFiles");
		// System.out.println("location : " + location);
		File folder = new File(projectLocation);
		File[] listOfFiles = folder.listFiles();
		if (null != listOfFiles)
		{
			for (int i = 0; i < listOfFiles.length; i++)
			{
				if (listOfFiles[i].isFile())
				{
					// System.out.println("isFile");

					String fileName = listOfFiles[i].getName();
					// System.out.println("fileName : " + fileName);
					String fileFullPath = projectLocation + "/" + listOfFiles[i].getName();
					// System.out.println("fileFullPath : " + fileFullPath);

					// Filename myHomePage = new Filename(fileFullPath, '/', '.');
					// System.out.println("Extension = " + myHomePage.extension());
					// System.out.println("Filename = " + myHomePage.filename());
					// System.out.println("Path = " + myHomePage.path());

					if ("java".equals(getExtension(fileFullPath, '.')))
					{
						printImportListFromFile(fileFullPath);
					}
				}
				else if (listOfFiles[i].isDirectory())
				{
					// System.out.println("isDirectory");
					readFiles(projectLocation + "/" + listOfFiles[i].getName());
				}
			}
		}
		else
		{
			return;
		}
	}

	private static void readFolders(String projectLocation)
	{
		// System.out.println(">>readFolders");
		File folder = new File(projectLocation);
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++)
		{
			// System.out.println("listOfFiles[i].getName() : " + listOfFiles[i].getName());
			if (listOfFiles[i].isFile())
			{
				// System.out.println("File " + listOfFiles[i].getName());
			}
			else if (listOfFiles[i].isDirectory())
			{
				// System.out.println("Author : "+listOfFiles[i].getName());
				readFiles(projectLocation + "/" + listOfFiles[i].getName());
			}
		}
	}*/
}
