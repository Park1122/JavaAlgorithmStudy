package codeup.codeUp1020To1039;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeUp1027 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String time = br.readLine();
        StringTokenizer st = new StringTokenizer(time, ".");
        String y = st.nextToken();
        String m = st.nextToken();
        String d = st.nextToken();

        System.out.println(d + "-" + m + "-" + y);
    }
}
