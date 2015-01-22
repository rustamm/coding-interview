package algorithms.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * http://www.careercup.com/question?id=5705619461898240
 *
 * Given a mapping of alphabets to integers as follows:
 *
 * 1 = A
 * 2 = B
 * 3 = C
 * ...
 * 26 = Z
 *
 * Given any combination of the mapping numbers as string, return the number of ways in which the input string can be
 * split into sub-strings and represented as character strings. For e.g. given
 * "111" -> "AAA", "AK", "KA" -> 3
 * Valid combinations are ({1,1,1}, {1,11},{11,1}) = 3
 * "11" -> "AA", "K" -> 2
 * Valid combinations are ({1,1},{11}) = 2
 * "123" -> "ABC", "LC", "AW" -> 3
 * Valid combinations are ({1,2,3},{1,23},{12,3}) = 3
 *
 * You don't have to return all the mappings, only the number of valid mappings.
 *
 * Created by Rustam Miftakhutdinov on 03.12.14.
 */
public class NumberOfRepresentations {

    public static int getNumberOfValidSlices(String input) {
        Map<Integer, Integer> startPosToSlicesNum = new HashMap<>();
        startPosToSlicesNum.put(input.length(), 1);

        for (int i = input.length() - 1; i >= 0; i--) {
            if (digitToNumber(input.charAt(i)) == 0) {
                startPosToSlicesNum.put(i, 0);
                continue;
            }

            int slicesNum = startPosToSlicesNum.get(i + 1);

            if (input.length() - i > 1) {
                int number = digitToNumber(input.charAt(i)) * 10 + digitToNumber(input.charAt(i + 1));
                if (number <= 26) {
                    slicesNum += startPosToSlicesNum.get(i + 2);
                }
            }

            startPosToSlicesNum.put(i, slicesNum);
        }

        return startPosToSlicesNum.get(0);
    }

    private static int digitToNumber(char digit) {
        return digit - '0';
    }
}
