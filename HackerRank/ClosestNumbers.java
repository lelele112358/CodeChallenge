import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'closestNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> closestNumbers(List<Integer> arr) {
    // Write your code here
        Collections.sort(arr);
        int diff=Math.abs(arr.get(0)-arr.get(1));
        List<Integer> ans= new ArrayList<>();
        for(int i=0;i<arr.size()-1;i++){
            if(Math.abs(arr.get(i)-arr.get(i+1))<diff){
                ans.clear();
                ans.add(arr.get(i));
                ans.add(arr.get(i+1));
                diff=Math.abs(arr.get(i)-arr.get(i+1));
            }else if(Math.abs(arr.get(i)-arr.get(i+1))==diff){
                ans.add(arr.get(i));
                ans.add(arr.get(i+1));
            }else{
                continue;
            }
        }
        return ans;
    }

}

public class ClosestNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        List<Integer> result = Result.closestNumbers(arr);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

