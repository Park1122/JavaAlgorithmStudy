package codeup.codeUp1001to1019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeUp1019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String time = br.readLine();
        StringTokenizer st = new StringTokenizer(time, ".");

        int[] arr = new int[3];
        int i = 0;
        while (st.hasMoreTokens()) {
            arr[i] = Integer.parseInt(st.nextToken());
            i++;
        }
        System.out.println(String.format("%04d", arr[0]) + "." + String.format("%02d", arr[1]) + "." + String.format("%02d", arr[2]));

    }
}
