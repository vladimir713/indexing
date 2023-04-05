import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Mytest {
    private final Port port = new Port();

    @Test
    void testConvertToInt(){
        List<Integer> intOut1 = Arrays.asList(1,3,4,5,7,8,9);
        List<Integer> intOut2 = Arrays.asList(2,3,6,7,8,9);
        List<List<Integer>>intOut = new ArrayList<>();
        intOut.add(intOut1);
        intOut.add(intOut2);

        assertThat(port.convertToInt(new String[]{"1,3-5,7-9", "2,3,6-9"}))
                .isEqualTo(intOut);
    }

    @Test
    void testConvertToInt2(){
        List<Integer> intOut1 = Arrays.asList(1, 3, 4, 5);
        List<Integer> intOut2 = Arrays.asList(2);
        List<Integer> intOut3 = Arrays.asList(3, 4);
        List<List<Integer>>intOut = new ArrayList<>();
        intOut.add(intOut1);
        intOut.add(intOut2);
        intOut.add(intOut3);

        assertThat(port.convertToInt(new String[]{"1,3-5", "2", "3-4"}))
                    .isEqualTo(intOut);
    }

    @Test
    void testGetUniqueGroups() {
        List<Integer> intIn1 = Arrays.asList(1, 2, 3);
        List<Integer> intIn2 = Arrays.asList(4, 5);
        List<List<Integer>>intIn = new ArrayList<>();
        intIn.add(intIn1);
        intIn.add(intIn2);

        int[][] IntOut = new int[][]{{1, 4}, {1, 5}, {2, 4}, {2, 5}, {3, 4}, {3, 5}};
        assertThat(port.getUniqueGroups(intIn)).isEqualTo(IntOut);
    }

    @Test
    void testGetUniqueGroups2() {
        List<Integer> intIn1 = Arrays.asList(1, 3, 4, 5);
        List<Integer> intIn2 = Arrays.asList(2);
        List<Integer> intIn3 = Arrays.asList(3, 4);
        List<List<Integer>>intIn = new ArrayList<>();
        intIn.add(intIn1);
        intIn.add(intIn2);
        intIn.add(intIn3);

        int[][] IntOut = new int[][]{{1, 2, 3}, {1, 2, 4}, {3, 2, 3}, {3, 2, 4}, {4, 2, 3}, {4, 2, 4}, {5, 2, 3}, {5, 2, 4}};
        assertThat(port.getUniqueGroups(intIn)).isEqualTo(IntOut);
    }
}
