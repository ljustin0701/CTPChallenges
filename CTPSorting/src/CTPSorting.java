import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Justin on 10/3/2016.
 */
public class CTPSorting {

    static void customSort(ArrayList<Integer> arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(Integer i : arr){
            if(!map.containsKey(i))
                map.put(i, 1);
            else
                map.put(i, map.get(i)+ 1);
        }
        ArrayList<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                int result = o1.getValue().compareTo(o2.getValue());
                if (result != 0) {
                    return result;
                } else {
                    return o1.getKey().compareTo(o2.getKey());
                }
            }
        });
        LinkedHashMap<Integer, Integer> sortedMap = new LinkedHashMap<>();
        for(Map.Entry<Integer, Integer> entry : list){
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        for(Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
            for(int i = 0; i < entry.getValue(); i++){
                System.out.println(entry.getKey());
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException{
        Scanner in = new Scanner(new File("input007.txt"));
        ArrayList<Integer> arr = new ArrayList<>();
        while(in.hasNextInt()) {
            int next = in.nextInt();
            arr.add(next);
        }

        customSort(arr);
    }

}
