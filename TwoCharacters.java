import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'alternate' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int alternate(String s) {
        Set<Character> set= new HashSet<>();
        List<Character> list= new ArrayList<>();
        int maxLen=0;
        for(char c: s.toCharArray()){
            set.add(c);
        }

        for(int i=0;i<s.length();i++){
            if(set.contains(s.charAt(i))){
                list.add(s.charAt(i));
                set.remove(s.charAt(i));
            }
        }

        for(int i=0;i<list.size()-1;i++){
            for(int j=i+1;j<list.size();j++){
                char c=list.get(i);
                char x=list.get(j);

                StringBuilder sb=new StringBuilder();
                for(int k=0;k<s.length();k++){
                    if(s.charAt(k)==c || s.charAt(k)==x){
                        sb.append(s.charAt(k));
                    }
                }
                String str=sb.toString();
                boolean flag=true;
                for(int l=0;l<str.length()-1;l++){
                    if(str.charAt(l)==str.charAt(l+1)){
                        flag=false;
                    }
                }
                if(flag==true){
                    maxLen=Math.max(maxLen,str.length());
                }
            }
        }
        return maxLen;
    }

}

public class TwoCharacters {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = Result.alternate(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
