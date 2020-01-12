import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * 1. coupons whose category is not in the personalized list should be removed from the list.
 * 2. coupon code must not be displayed to the user - it should only be used in the company.
 * 3. sort by coupon discount percentage
 * 4. return only the first 10 coupons with highest percentage
 */
public class PersonalizedCoupons
{

	public static void main(String[] args) throws IOException
	{
		List<String> preferredCategories = new ArrayList<String>();
		preferredCategories.add("cat1");
		preferredCategories.add("cat2");
		preferredCategories.add("cat4");
		preferredCategories.add("cat5");
		preferredCategories.add("cat6");
		preferredCategories.add("cat7");
		preferredCategories.add("cat8");
		preferredCategories.add("cat9");
		preferredCategories.add("cat10");
		preferredCategories.add("cat11");
		preferredCategories.add("cat12");
		preferredCategories.add("cat13");
		List<Map<String, Object>> coupons = new ArrayList<>();
		coupons.add(getCoupon1());
		coupons.add(getCoupon2());
		coupons.add(getCoupon3());
		coupons.add(getCoupon4());
		coupons.add(getCoupon5());
		coupons.add(getCoupon6());
		coupons.add(getCoupon7());
		coupons.add(getCoupon8());
		coupons.add(getCoupon9());
		coupons.add(getCoupon10());
		coupons.add(getCoupon11());
		coupons.add(getCoupon12());
		coupons.add(getCoupon13());
		List<Map<String, Object>> personalizedCoupons = personalizeCoupons(coupons, preferredCategories);
		personalizedCoupons.stream().forEach(PersonalizedCoupons::printCoupon);
	}

	public static Map<String, Object> getCoupon1()
	{

		Map<String, Object> coupon = new HashMap<>();
		coupon.put("upc", "123");
		coupon.put("code", "123");
		coupon.put("category", "cat1");
		coupon.put("itemPrice", 100.0f);
		coupon.put("couponAmount", 25.0f);
		return coupon;
	}

	public static Map<String, Object> getCoupon2()
	{

		Map<String, Object> coupon = new HashMap<>();
		coupon.put("upc", "456");
		coupon.put("code", "456");
		coupon.put("category", "cat2");
		coupon.put("itemPrice", 100.0f);
		coupon.put("couponAmount", 15.0f);
		return coupon;
	}

	public static Map<String, Object> getCoupon3()
	{

		Map<String, Object> coupon = new HashMap<>();
		coupon.put("upc", "789");
		coupon.put("code", "789");
		coupon.put("category", "cat3");
		coupon.put("itemPrice", 40.0f);
		coupon.put("couponAmount", 20.0f);
		return coupon;
	}

	public static Map<String, Object> getCoupon4()
	{
		Map<String, Object> coupon = new HashMap<>();
		coupon.put("upc", "012");
		coupon.put("code", "012");
		coupon.put("category", "cat4");
		coupon.put("itemPrice", 100.0f);
		coupon.put("couponAmount", 20.0f);
		return coupon;
	}

	public static Map<String, Object> getCoupon5()
	{
		Map<String, Object> coupon = new HashMap<>();
		coupon.put("upc", "345");
		coupon.put("code", "345");
		coupon.put("category", "cat5");
		coupon.put("itemPrice", 200.0f);
		coupon.put("couponAmount", 40.0f);
		return coupon;
	}

	public static Map<String, Object> getCoupon6()
	{
		Map<String, Object> coupon = new HashMap<>();
		coupon.put("upc", "345");
		coupon.put("code", "345");
		coupon.put("category", "cat6");
		coupon.put("itemPrice", 200.0f);
		coupon.put("couponAmount", 40.0f);
		return coupon;
	}

	public static Map<String, Object> getCoupon7()
	{
		Map<String, Object> coupon = new HashMap<>();
		coupon.put("upc", "345");
		coupon.put("code", "345");
		coupon.put("category", "cat7");
		coupon.put("itemPrice", 200.0f);
		coupon.put("couponAmount", 40.0f);
		return coupon;
	}

	public static Map<String, Object> getCoupon8()
	{
		Map<String, Object> coupon = new HashMap<>();
		coupon.put("upc", "345");
		coupon.put("code", "345");
		coupon.put("category", "cat8");
		coupon.put("itemPrice", 200.0f);
		coupon.put("couponAmount", 40.0f);
		return coupon;
	}

	public static Map<String, Object> getCoupon9()
	{
		Map<String, Object> coupon = new HashMap<>();
		coupon.put("upc", "345");
		coupon.put("code", "345");
		coupon.put("category", "cat9");
		coupon.put("itemPrice", 200.0f);
		coupon.put("couponAmount", 40.0f);
		return coupon;
	}

	public static Map<String, Object> getCoupon10()
	{
		Map<String, Object> coupon = new HashMap<>();
		coupon.put("upc", "345");
		coupon.put("code", "345");
		coupon.put("category", "cat10");
		coupon.put("itemPrice", 200.0f);
		coupon.put("couponAmount", 40.0f);
		return coupon;
	}

	public static Map<String, Object> getCoupon11()
	{
		Map<String, Object> coupon = new HashMap<>();
		coupon.put("upc", "345");
		coupon.put("code", "345");
		coupon.put("category", "cat11");
		coupon.put("itemPrice", 200.0f);
		coupon.put("couponAmount", 40.0f);
		return coupon;
	}

	public static Map<String, Object> getCoupon12()
	{
		Map<String, Object> coupon = new HashMap<>();
		coupon.put("upc", "345");
		coupon.put("code", "345");
		coupon.put("category", "cat12");
		coupon.put("itemPrice", 200.0f);
		coupon.put("couponAmount", 40.0f);
		return coupon;
	}

	public static Map<String, Object> getCoupon13()
	{
		Map<String, Object> coupon = new HashMap<>();
		coupon.put("upc", "345");
		coupon.put("code", "345");
		coupon.put("category", "cat13");
		coupon.put("itemPrice", 200.0f);
		coupon.put("couponAmount", 40.0f);
		return coupon;
	}

	/*
	 * public static void main(String[] args) throws IOException{ Scanner input =
	 * new Scanner(System.in); List<String> preferredCategories =
	 * Arrays.asList(input.nextLine().split(",")); List<Map<String, Object>> coupons
	 * = new ArrayList<>(); int lines = Integer.parseInt(input.nextLine());
	 * IntStream.range(0, lines).forEach(i -> coupons.add(readCoupon(input)));
	 * List<Map<String, Object>> personalizedCoupons = personalizeCoupons(coupons,
	 * preferredCategories);
	 * personalizedCoupons.stream().forEach(PersonalizedCoupons::printCoupon); }
	 */

	public static Map<String, Object> readCoupon(Scanner input)
	{
		String[] couponItems = input.nextLine().split(",");
		Map<String, Object> coupon = new HashMap<>();
		coupon.put("upc", couponItems[0]);
		coupon.put("code", couponItems[1]);
		coupon.put("category", couponItems[2]);
		coupon.put("itemPrice", Float.parseFloat(couponItems[3]));
		coupon.put("couponAmount", Float.parseFloat(couponItems[4]));
		return coupon;
	}

	public static void printCoupon(Map<String, Object> coupon)
	{
		System.out.print("\t{");
		System.out.print("\"couponAmount\":" + coupon.get("couponAmount") + ",");
		System.out.print("\"upc\":\"" + coupon.get("upc") + "\",");
		if (coupon.containsKey("code"))
		{
			System.out.print("\"code\":\"" + coupon.get("code") + "\",");
		}
		System.out.print("\"itemPrice\":" + coupon.get("itemPrice") + ",");
		if (coupon.containsKey("percentage"))
		{
			System.out.print("\"percentage\":\"" + coupon.get("percentage") + "\",");
		}
		System.out.println("\"category\":\"" + coupon.get("category") + "\"}");
	}

	// Class to compare Fruits by rating
	static class CouponComparisonUsingComparator implements Comparator<Map<String, Object>>
	{
		public int compare(Map<String, Object> coupon1, Map<String, Object> coupon2)
		{
			float f1 = (float) coupon1.get("percentage");
			float f2 = (float) coupon2.get("percentage");
			int retval = Float.compare(f1, f2);

			if (retval > 0)
				return -1;
			else if (retval < 0)
				return 1;
			else
				return 0;
		}
	}

	static List<Map<String, Object>> personalizeCoupons(List<Map<String, Object>> coupons,
			List<String> preferredCategories)
	{
		for (Iterator<Map<String, Object>> iter = coupons.listIterator(); iter.hasNext();)
		{
			Map<String, Object> coupon = iter.next();
			if (preferredCategories.contains((String) coupon.get("category")))
			{
				coupon.remove("code");

				float itemPrice = (float) coupon.get("itemPrice");
				float couponAmount = (float) coupon.get("couponAmount");

				// calculate percentage here
				float percentage = couponAmount / itemPrice;
				percentage = percentage * 100;

				coupon.put("percentage", percentage);
			}
			else
			{
				iter.remove();
			}
		}

		Collections.sort(coupons, new CouponComparisonUsingComparator());

		if (coupons.size() > 10)
		{
			return new ArrayList<Map<String, Object>>(coupons.subList(0, 10));
		}
		else
		{
			return coupons;
		}
	}

	/*
	 * static List<Map<String, Object>> personalizeCoupons(List<Map<String, Object>>
	 * coupons, List<String> preferredCategories) { Map<Float, Map<String,Object>>
	 * filteredMap = new TreeMap<Float, Map<String,
	 * Object>>(Collections.reverseOrder()); for(Object obj : coupons) {
	 * 
	 * @SuppressWarnings("unchecked") Map<String,Object> coupon = (Map<String,
	 * Object>) obj;
	 * 
	 * if(preferredCategories.contains((String) coupon.get("category"))) {
	 * coupon.remove("code");
	 * 
	 * float itemPrice = (float) coupon.get("itemPrice"); float couponAmount =
	 * (float) coupon.get("couponAmount");
	 * 
	 * // calculate percentage here float percentage = couponAmount/itemPrice;
	 * percentage = percentage * 100;
	 * 
	 * 
	 * 
	 * filteredMap.put(percentage, coupon); } }
	 * 
	 * List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
	 * //List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
	 * for (Object value : filteredMap.values()) { if(result.size() < 10) {
	 * result.add((Map<String, Object>) value); } else { break; } }
	 * 
	 * return result; }
	 */
}
