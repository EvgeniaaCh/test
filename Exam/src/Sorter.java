import java.util.Arrays;
import java.util.List;

public class Sorter {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(123, 121212);
        numbers.sort((o1, o2) -> {
            Long result1 = numberCounter(o1);
            Long result2 = numberCounter(o2);
            return result1.compareTo(result2);
        });
        System.out.println(numbers);
    }

    private static Long numberCounter(Integer someInteger) {
        String someString = someInteger.toString();
        long result = 0;
        for (int i = 0; i < 10; i++) {
            char iChar = (char) (i + '0');
            long charCount = someString.chars().filter(ch -> ch == iChar).count();
            if (charCount != 0) {
                result++;
            }
        }
        return result;
    }
}
