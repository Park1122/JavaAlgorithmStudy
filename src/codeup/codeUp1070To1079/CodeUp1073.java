package codeup.codeUp1070To1079;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeUp1073 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (true){
            int num = Integer.parseInt(st.nextToken());
            if(num == 0) break;
            System.out.print(num + " ");
        }
    }
}
