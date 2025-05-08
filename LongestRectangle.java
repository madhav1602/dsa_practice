import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'largestRectangle' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY h as parameter.
     */

    public static int[] rightMin(List<Integer> h){
        int n = h.size();
        int[] right = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(n);

        for(int i=n-1;i>=0;i--){
            while(st.peek()!=(n) && h.get(st.peek())>=h.get(i)){
                st.pop();
            }
            right[i] = st.peek();
            st.push(i);
        }
        return right;
    }
    public static int[] leftMin(List<Integer> h){
        int n = h.size();
        int[] left = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(-1);

        for(int i=0;i<n;i++){
            while(st.peek()!=-1 && h.get(st.peek())>=h.get(i)){
                st.pop();
            }
            left[i] = st.peek();
            st.push(i);
        }
        return left;
    }

    public static long largestRectangle(List<Integer> h) {

        int n = h.size();

        int[] left = leftMin(h);
        int[] right = rightMin(h);

        long max = 0;

        for(int i=0;i<n;i++){
            int l = left[i];
            int r = right[i];
            int height = h.get(i);
            System.out.println(r-l-1);

            long sum = (r-l-1)*height;

            max = Math.max(max,sum);
        }
        // return max;
        System.out.println(max);
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));

        return max;

    }

}

public class LongestRectangle {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> h = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        long result = Result.largestRectangle(h);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
