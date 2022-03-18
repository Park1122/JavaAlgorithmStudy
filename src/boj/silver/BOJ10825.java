package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ10825 {
    static class Person {
        String name;
        int a, b, c;

        public Person(String name, int a, int b, int c) {
            this.name = name;
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    static int n;
    static Person[] ps;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        ps = new Person[n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            ps[i] = new Person(st.nextToken()
                    , Integer.parseInt(st.nextToken())
                    , Integer.parseInt(st.nextToken())
                    , Integer.parseInt(st.nextToken()));
        }
    }

    static void solve() {
        Arrays.sort(ps, (p1, p2) -> {
            if(p1.a != p2.a) return p2.a - p1.a;
            if(p1.b != p2.b) return p1.b - p2.b;
            if(p1.c != p2.c) return p2.c - p1.c;
            return p1.name.compareTo(p2.name);
        });

        for(Person p : ps) {
            sb.append(p.name).append('\n');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
