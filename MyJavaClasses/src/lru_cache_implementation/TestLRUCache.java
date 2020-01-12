package lru_cache_implementation;

public class TestLRUCache
{

	public static void main(String[] args)
	{
		int[] pageNumberArray = { 1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5 };

		int cacheSize = 3;

		LRUCache lruCache = new LRUCache(cacheSize);

		int hitCount = 0;
		int faultCount = 0;
		for (int key : pageNumberArray)
		{
			if (-1 != lruCache.get(key))
			{
				// System.out.println("hit");
				hitCount++;
			}
			else
			{
				// System.out.println("fault");
				faultCount++;
				lruCache.set(key, key);
			}
		}
		System.out.println("hitCount : " + hitCount);
		System.out.println("faultCount : " + faultCount);
	}

}
