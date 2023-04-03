import java.util.ArrayList;
import java.util.List;

public class Port {

    public List<List<Integer>> convertToInt(String[] stringIn) {
        List<List<Integer>> intOut = new ArrayList<>();
        for (int i = 0; i < stringIn.length; i++) {
            List<String> inner = new ArrayList<>();
            inner = List.of(stringIn[i].split(","));
            List<Integer> integerList = new ArrayList<>();
            for (int j = 0; j < inner.size(); j++) {
                if (inner.get(j).contains("-")) {
                    String[] ab = inner.get(j).split("-");
                    int a = Integer.parseInt(ab[0]);
                    int b = Integer.parseInt(ab[1]);
                    for (int x = a; x <= b; x++) {
                        integerList.add(x);
                    }
                } else {
                    integerList.add(Integer.parseInt(inner.get(j)));
                }
            }
            intOut.add(integerList);
        }
        return intOut;
    }

    public int[][] getUniqueGroups(List<List<Integer>> in) {
        int lenOut = 1;
        for (int i = 0; i < in.size(); i++) {
            lenOut *= in.get(i).size();
        }
        int count = 1;
        int[][] groups = new int[lenOut][in.size()];
        for (int i = 0; i < in.size(); i++) {
           for (int c = 0; c < count; c++) {
               for (int g = 0; g < in.get(i).size(); g++) {
                   for (int h = 0; h < (lenOut / in.get(i).size() / count); h++) {
                       groups[h + g * lenOut / in.get(i).size() / count][i] = in.get(i).get(g);
                   }
               }
           }
           count *= in.get(i).size();
        }
        return groups;
    }
}
