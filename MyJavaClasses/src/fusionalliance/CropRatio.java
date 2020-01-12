package fusionalliance;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CropRatio
{
    private int totalWeight;

    private HashMap<String, Integer> crops = new HashMap<String, Integer>();

    public void add(String name, int cropWeight)
    {
        System.out.println(">>> add - name : " + name + " and cropWeight : " + cropWeight);
        Integer currentCropWeight = (Integer) crops.get(name);
        System.out.println("currentCropWeight : " + currentCropWeight);

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
        System.out.println("<<< add - totalWeight : " + totalWeight);
    }

    public double proportion(String name)
    {
        System.out.println(">>> proportion");
        System.out.println("crops.get(name) : " + (Integer) crops.get(name));
        System.out.println("totalWeight : " + totalWeight);
        return ((double) crops.get(name)) / totalWeight;
    }

    public static void main(String[] args)
    {
        CropRatio cropRatio = new CropRatio();

        cropRatio.add("Wheat", 4);
        cropRatio.add("Wheat", 5);
        cropRatio.add("Rice", 1);

        System.out.println("Fraction of wheat: " + cropRatio.proportion("Wheat"));
    }

    public static void printMap(Map mp)
    {
        System.out.println(">>>>>> printMap");
        Iterator it = mp.entrySet().iterator();
        while (it.hasNext())
        {
            Map.Entry pair = (Map.Entry) it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            // it.remove(); // avoids a ConcurrentModificationException
        }
        System.out.println("<<<<<< printMap");
    }
}
