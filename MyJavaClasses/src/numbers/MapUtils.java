package collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MapUtils {
	
	public static void printMap(Map mp)
    {
        Iterator it = mp.entrySet().iterator();
        while (it.hasNext())
        {
            Map.Entry pair = (Map.Entry) it.next();
            if (pair.getValue() instanceof List)
            {
            	System.out.println(pair.getKey() + " = " + Arrays.toString(((List) pair.getValue()).toArray()));
            }
            else 
            {
            	System.out.println(pair.getKey() + " = " + pair.getValue());
            }
            
        }
    }
}
