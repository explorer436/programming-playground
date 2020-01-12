import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 
 * 
 * 
 */
public class CreditCardValidation
{

	public static void main(String args[]) throws Exception
	{
		String[] swipedCreditCards = { "6724843711060148", "6745343711060149" };
		// String[] swipedCreditCards = {"6724843711060148"};

		String[] invalidPrefixes = { "11", "3434", "67453", "9" };

		// Scanner input = new Scanner(System.in);
		// String[] bannedPrefixes = input.nextLine().split(",");
		// int lines = Integer.parseInt(input.nextLine());
		// String[] cardsToValidate = new String[lines];
		// IntStream.range(0, lines).forEach(i -> cardsToValidate[i] =
		// input.nextLine());
		List<Map<String, Object>> processedCards = validateCards(invalidPrefixes, swipedCreditCards);
		// List<Map<String, Object>> processedCards = validateCards(invalidPrefixes,
		// null);
		// List<Map<String, Object>> processedCards = validateCards(null,
		// swipedCreditCards);
		// List<Map<String, Object>> processedCards = validateCards(null, null);
		processedCards.stream().forEach(CreditCardValidation::printCardResult);
	}

	static List<Map<String, Object>> validateCards(String[] bannedPrefixes, String[] cardsToValidate)
	{
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();

		Map<String, Object> map;
		if (null != cardsToValidate)
		{

			for (String swipedCard : cardsToValidate)
			{
				boolean isAllowed = true;

				if (null != bannedPrefixes)
				{
					for (String banned : bannedPrefixes)
					{
						if (swipedCard.startsWith(banned))
						{
							isAllowed = false;
							break;
						}
					}
				}

				boolean isValid = isValid(swipedCard);

				map = new HashMap<>();
				map.put("card", swipedCard);
				map.put("isValid", isValid);
				map.put("isAllowed", isAllowed);

				result.add(map);
			}
		}
		return result;

	}

	public static boolean isValid(String ccNumber)
	{
		int sum = 0;

		for (int i = 0; i < ccNumber.length() - 1; i++)
		{
			sum = sum + (2 * Integer.parseInt(String.valueOf(ccNumber.charAt(i))));
		}

		return ((sum % 10) == Integer.parseInt(String.valueOf(ccNumber.charAt(ccNumber.length() - 1))));
	}

	public static void printCardResult(Map<String, Object> cardResult)
	{
		System.out.print("{\"card\":\"" + cardResult.get("card") + "\",");
		System.out.print("\"isValid\":" + cardResult.get("isValid") + ",");
		System.out.println("\"isAllowed\":" + cardResult.get("isAllowed") + "}");
	}

}
