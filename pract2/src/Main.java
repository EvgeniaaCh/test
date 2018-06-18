import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Integer> numbers = initList("in.txt");
        numbers.sort(Comparator.comparingInt(Main::numberOfFives));
        PrintWriter pw = new PrintWriter("out.txt");
        numbers.forEach(pw::println);
        pw.close();

    }
    private static List<Integer> initList(String filePath) throws IOException {
        List<Integer> result = new ArrayList<>();
        Stream<String> fileStream =  Files.lines(Paths.get(filePath));
        fileStream.forEach(x->{
            try {
                result.add(Integer.parseInt(x));
            }catch (Exception e){
                System.out.println("ERROR: Incorrect in.txt, make sure that all lines are numbers without non-number symbols");
                System.exit(1);
            }
        });
        return result;
    }
    private static int numberOfFives(int x){
        int k = 0;
        int digit;
        while (x>0){
            digit = x % 10;
            if (digit ==5 ){
                k++;
            }
            x /= 10;
        }
        return k;
    }
}
