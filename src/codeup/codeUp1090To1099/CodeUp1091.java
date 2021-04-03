package codeup.codeUp1090To1099;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeUp1091 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());
        long d = Integer.parseInt(st.nextToken());
        long n = Integer.parseInt(st.nextToken());
        for (int i = 1; i < n; i++) {
            a = a*m + d;
        }
        System.out.println(a);
    }
}
