import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SearchTextInFile2
{
	public static void main(String[] args) throws IOException
	{
		String fileLocation = "/Users/harshavardhanedupuganti/Desktop/temp/ToRead.txt";
		
		BufferedReader b = null;
		try
		{

			File f = new File(fileLocation);

			b = new BufferedReader(new FileReader(f));

			String readLine = "";

			System.out.println("Reading file using Buffered Reader");

			while ((readLine = b.readLine()) != null)
			{
				//System.out.println(readLine);
				searchUsingBufferedReader(readLine);
			}

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			b.close();
		}
		
		System.out.println("-- finished --");

	}

	public static String searchUsingBufferedReader(String searchQuery) throws IOException
	{
		//System.out.println("trying to find - " + searchQuery);
		String filePath = "/Users/harshavardhanedupuganti/Google Drive/eBooks/Kindle Library (Final)/Catalog.txt";

		searchQuery = searchQuery.trim();
		BufferedReader br = null;

		try
		{
			br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
			String line;
			while ((line = br.readLine()) != null)
			{
				if (line.contains(searchQuery))
				{
					System.out.println("found - " + searchQuery);
					return line;
				}
			}
		}
		finally
		{
			try
			{
				if (br != null)
					br.close();
			}
			catch (Exception e)
			{
				System.err.println("Exception while closing bufferedreader " + e.toString());
			}
		}

		return null;
	}

}
