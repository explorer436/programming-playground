package fusionalliance;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
 * Calculate the ratio of each crop - based on the values being added in the main method.
 */
public class CropRatio
{
    private int totalWeight;

    private HashMap<String, Integer> crops = new HashMap<String, Integer>();

    public void add(String name, int cropWeight)
    {
        Integer currentCropWeight = (Integer) crops.get(name);

        if (currentCropWeight == null)
        {
            crops.put(name, (Integer) cropWeight);
        }
        else
        {
            currentCropWeight = currentCropWeight + cropWeight;
            crops.put(name, (Integer) currentCropWeight);
        }

        printMap(crops);

        totalWeight = totalWeight + cropWeight;
    }

    public double proportion(String name)
    {
        // System.out.println(">>> proportion - name : " + name);
        // System.out.println("crops.get(name) : " + (Integer) crops.get(name));
        // System.out.println("totalWeight : " + totalWeight);
        return ((double) crops.get(name)) / totalWeight;
    }

    public static void main(String[] args)
    {
        CropRatio cropRatio = new CropRatio();

        cropRatio.add("Wheat", 4);
        cropRatio.add("Wheat", 5);
        cropRatio.add("Rice", 1);

        System.out.println("Fraction of wheat: " + cropRatio.proportion("Wheat"));
        System.out.println("Fraction of rice: " + cropRatio.proportion("Rice"));
    }

    public static void printMap(Map mp)
    {
        Iterator it = mp.entrySet().iterator();
        while (it.hasNext())
        {
            Map.Entry pair = (Map.Entry) it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
        }
    }
}
