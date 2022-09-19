import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
    // Write your code here
        double pos=0.0;
        double neg=0.0;
        double zero=0.0;
        for(int i=0;i<arr.size();i++){
            if(arr.get(i)<0){
                neg=neg+1;
            }else if(arr.get(i)>0){
                pos=pos+1;
            }else{
                zero=zero+1;
            }
        }

        System.out.println(String.format("%.6f",pos/arr.size()));
        System.out.println(String.format("%.6f",neg/arr.size()));
        System.out.println(String.format("%.6f",zero/arr.size()));
    }

}

public class PlusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}

