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
        int circles = 1;
        int[][] groups = new int[lenOut][in.size()];
        for (int colunm = 0; colunm < in.size(); colunm++) {
           for (int countCircles = 0; countCircles < circles; countCircles++) {
               int columnHeight = lenOut / in.get(colunm).size() / circles;
               for (int currentElement = 0; currentElement < in.get(colunm).size(); currentElement++) {
                   for (int h = 0; h < columnHeight; h++) {
                       groups[h + countCircles * circles + currentElement * columnHeight][colunm]
                               = in.get(colunm).get(currentElement);
                   }
               }
           }
           circles *= in.get(colunm).size();
        }
        return groups;
    }
}
