import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'lilysHomework' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int lilysHomework(List<Integer> arr) {
    // Write your code here
        int count1=0,count2=0;
        List<Integer> cloned= new ArrayList<Integer>(arr);
        List<Integer> sorted= new ArrayList<Integer>(arr);
        Collections.sort(sorted);
        for(int i=0;i<sorted.size();i++){
            if(sorted.get(i)!=arr.get(i)){
                Collections.swap(arr, i, arr.indexOf(sorted.get(i)));
                 count1++;
            }
            if(sorted.get(i)!=cloned.get(sorted.size()-1-i)){
                  Collections.swap(cloned, sorted.size()-1-i,cloned.indexOf(sorted.get(i)));
                   count2++;
              }
        }
        if(count1<count2){
            return count1;
        }else{
            return count2;
        }
    }
}

public class LilysHomework {
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

        int result = Result.lilysHomework(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

