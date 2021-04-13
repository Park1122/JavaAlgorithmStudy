package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Swea1288 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int testCase = Integer.parseInt(br.readLine());
            for (int i = 0; i < testCase; i++) {
                int num = Integer.parseInt(br.readLine());
                Set<String> countSet = new HashSet<>();
                int m = 1;
                int temp = 0;
                while (countSet.size() < 10) {
                    temp = num * m;
                    //m번째 숫자를 한글자씩 나눠서 배열로 만든 후, Set에 하나씩 추가.
                    String[] arr = Integer.toString(temp).split("");
                    for (String s : arr) {
                        countSet.add(s);
                    }
                    m++;
                }
                System.out.println("#" + (i+1) + " " + temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
