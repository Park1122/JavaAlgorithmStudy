package boj.silver;

import java.io.*;
import java.util.ArrayList;

public class BOJ11723 {
    ArrayList<String> arr = new ArrayList<>();

    void add(String x) {
        if (!arr.contains(x)) {
            arr.add(x);
        }
    }

    void remove(String x) {
        if (arr.contains(x)) {
            arr.remove(x);
        }
    }

    int check(String x) {
        if (arr.contains(x)) {
            return 1;
        } else {
            return 0;
        }
    }

    void toggle(String x) {
        if (arr.contains(x)) {
            arr.remove(x);
        } else {
            arr.add(x);
        }
    }

    void all() {
        arr = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            arr.add(Integer.toString(i));
        }
    }

    void empty() {
        arr = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        BOJ11723 main = new BOJ11723();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            String question = br.readLine();
            if (question.contains("add")) {
                main.add(question.split(" ")[1]);
            } else if (question.contains("remove")) {
                main.remove(question.split(" ")[1]);
            }else if (question.contains("check")) {
                bw.write(main.check(question.split(" ")[1]) + "\n");
            }else if (question.contains("toggle")) {
                main.toggle(question.split(" ")[1]);
            } else if (question.contains("all")) {
                main.all();
            } else {
                main.empty();
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
