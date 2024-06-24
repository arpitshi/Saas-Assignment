import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;


public class Assignment9 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        List<Integer> list1 = new ArrayList<>();
        while (true) {
            int coeff = s.nextInt();
            int power = s.nextInt();
            if (coeff == -1 && power == -1) break;
            list1.add(coeff);
            list1.add(power);
        }

        List<Integer> list2 = new ArrayList<>();
        while (true) {
            int coeff = s.nextInt();
            int power = s.nextInt();
            if (coeff == -1 && power == -1) break;
            list2.add(coeff);
            list2.add(power);
        }

        s.close();

        List<Integer> result = addPoly(list1, list2);

        for (int i = 0; i < result.size(); i += 2) {
            System.out.print(result.get(i) + " " + result.get(i + 1) + " ");
        }
        System.out.println();
    }

    public static List<Integer> addPoly(List<Integer> list1, List<Integer> list2) {
        Map<Integer, Integer> m = new HashMap<>();
        addToMap(m, list1);
        addToMap(m, list2);

        List<Integer> sortedPowers = new ArrayList<>(m.keySet());
        Collections.sort(sortedPowers, Collections.reverseOrder());

        List<Integer> res = new ArrayList<>();
        for (int power : sortedPowers) {
            int coeff = m.get(power);
            if (coeff != 0) {
                res.add(coeff);
                res.add(power);
            }
        }

        return res;
    }

    public static void addToMap(Map<Integer, Integer> map, List<Integer> list) {
        for (int i = 0; i < list.size(); i += 2) {
            int coeff = list.get(i);
            int power = list.get(i + 1);
            map.put(power, map.getOrDefault(power, 0) + coeff);
        }
    }
}
