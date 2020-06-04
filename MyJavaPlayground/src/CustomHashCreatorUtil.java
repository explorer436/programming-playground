/**
 * Utility class that accepts a number and generates a HashID for it
 * 
 * @author n0281526 (Harsha Edupuganti)
 */
public final class CustomHashCreatorUtil
{
	private static final String DEFAULT_SALT = "";

	// private static final String DEFAULT_ALPHABET =
	// "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	private static final String DEFAULT_ALPHABET = "abcdefghijklmnopqrstuvwxyz1234567890";

	private static final int DEFAULT_MIN_HASH_LENGTH = 0;

	private static final int MIN_ALPHABET_LENGTH = 16;

	// private static final String DEFAULT_SEPS = "geicopipeGEICOPIPE";
	private static final String DEFAULT_SEPS = "geicopipe";

	private static final double SEP_DIV = 3.5;

	private static final int GUARD_DIV = 12;

	private static String salt;

	private static int minHashLength;

	private static String alphabet;

	private static String seps;

	private static String guards;

	/**
	 * public Constructor
	 */
	public CustomHashCreatorUtil()
	{
		super();
	}

	private static void init()
	{
		salt = DEFAULT_SALT;
		minHashLength = DEFAULT_MIN_HASH_LENGTH;
		alphabet = DEFAULT_ALPHABET;

		StringBuilder uniqueAlphabet = new StringBuilder();
		for (int i = 0; i < alphabet.length(); i++)
		{
			if (uniqueAlphabet.indexOf(String.valueOf(alphabet.charAt(i))) == -1)
			{
				uniqueAlphabet.append(alphabet.charAt(i));
			}
		}

		alphabet = uniqueAlphabet.toString();

		if (alphabet.length() < MIN_ALPHABET_LENGTH)
		{
			throw new IllegalArgumentException(
					"alphabet must contain at least " + MIN_ALPHABET_LENGTH + " unique characters");
		}

		if (alphabet.contains(" "))
		{
			throw new IllegalArgumentException("alphabet cannot contains spaces");
		}

		// seps should contain only characters present in alphabet;
		// alphabet should not contains seps
		// String seps = DEFAULT_SEPS;
		seps = DEFAULT_SEPS;
		for (int i = 0; i < seps.length(); i++)
		{
			int j = alphabet.indexOf(seps.charAt(i));
			if (j == -1)
			{
				seps = seps.substring(0, i) + " " + seps.substring(i + 1);
			}
			else
			{
				alphabet = alphabet.substring(0, j) + " " + alphabet.substring(j + 1);
			}
		}

		alphabet = alphabet.replaceAll("\\s+", "");
		seps = seps.replaceAll("\\s+", "");
		seps = consistentShuffle(seps, salt);

		if ((seps.isEmpty()) || (((float) alphabet.length() / seps.length()) > SEP_DIV))
		{
			int seps_len = (int) Math.ceil(alphabet.length() / SEP_DIV);

			if (seps_len == 1)
			{
				seps_len++;
			}

			if (seps_len > seps.length())
			{
				int diff = seps_len - seps.length();
				seps += alphabet.substring(0, diff);
				alphabet = alphabet.substring(diff);
			}
			else
			{
				seps = seps.substring(0, seps_len);
			}
		}

		alphabet = consistentShuffle(alphabet, salt);
		// use double to round up
		int guardCount = (int) Math.ceil((double) alphabet.length() / GUARD_DIV);

		// String guards;
		if (alphabet.length() < 3)
		{
			guards = seps.substring(0, guardCount);
			seps = seps.substring(guardCount);
		}
		else
		{
			guards = alphabet.substring(0, guardCount);
			alphabet = alphabet.substring(guardCount);
		}

	}

	private static String consistentShuffle(String alphabet, String salt)
	{
		if (salt.length() <= 0)
			return alphabet;

		int asc_val, j;
		char tmp;
		for (int i = alphabet.length() - 1, v = 0, p = 0; i > 0; i--, v++)
		{
			v %= salt.length();
			asc_val = (int) salt.charAt(v);
			p += asc_val;
			j = (asc_val + v + p) % i;

			tmp = alphabet.charAt(j);
			alphabet = alphabet.substring(0, j) + alphabet.charAt(i) + alphabet.substring(j + 1);
			alphabet = alphabet.substring(0, i) + tmp + alphabet.substring(i + 1);
		}

		return alphabet;
	}

	public static String encode(long... numbers)
	{
		init();

		int numberHashInt = 0;
		for (int i = 0; i < numbers.length; i++)
		{
			numberHashInt += (numbers[i] % (i + 100));
		}

		char ret = alphabet.charAt(numberHashInt % numbers.length);
		// char lottery = ret;
		long num;
		int sepsIndex, guardIndex;
		String buffer;
		StringBuilder ret_strB = new StringBuilder(minHashLength);
		ret_strB.append(ret);
		char guard;

		for (int i = 0; i < numbers.length; i++)
		{
			num = numbers[i];
			buffer = ret + salt + alphabet;

			alphabet = consistentShuffle(alphabet, buffer.substring(0, alphabet.length()));
			String last = hash(num, alphabet);

			ret_strB.append(last);

			if (i + 1 < numbers.length)
			{
				num %= ((int) last.charAt(0) + i);
				sepsIndex = (int) (num % seps.length());
				ret_strB.append(seps.charAt(sepsIndex));
			}
		}

		String ret_str = ret_strB.toString();
		if (ret_str.length() < minHashLength)
		{
			guardIndex = (numberHashInt + (int) (ret_str.charAt(0))) % guards.length();
			guard = guards.charAt(guardIndex);

			ret_str = guard + ret_str;

			if (ret_str.length() < minHashLength)
			{
				guardIndex = (numberHashInt + (int) (ret_str.charAt(2))) % guards.length();
				guard = guards.charAt(guardIndex);

				ret_str += guard;
			}
		}

		int halfLen = alphabet.length() / 2;
		while (ret_str.length() < minHashLength)
		{
			alphabet = consistentShuffle(alphabet, alphabet);
			ret_str = alphabet.substring(halfLen) + ret_str + alphabet.substring(0, halfLen);
			int excess = ret_str.length() - minHashLength;
			if (excess > 0)
			{
				int start_pos = excess / 2;
				ret_str = ret_str.substring(start_pos, start_pos + minHashLength);
			}
		}

		return ret_str;
	}

	private static String hash(long input, String alphabet)
	{
		String hash = "";
		int alphabetLen = alphabet.length();

		do
		{
			hash = alphabet.charAt((int) (input % alphabetLen)) + hash;
			input /= alphabetLen;
		}
		while (input > 0);

		return hash;
	}

}
