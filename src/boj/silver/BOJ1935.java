package boj.silver;

import java.io.*;
import java.util.Stack;

public class BOJ1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine()); // 피연산자 갯수
        String question = br.readLine(); // 후위표기식
        double[] nums = new double[tc]; // 실제 숫자 피연산자가 있을 공간
        Stack<Double> stack = new Stack<>(); // nums 에 있는 피연산자를 후위표기식을 계산하면서 스택에 담음
        
        for (int i = 0; i < tc; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < question.length(); i++) {
            char token = question.charAt(i);
            if ('A' <= token && token <= 'Z') {
                int index = (int) token - 65; // 후위표기식에 있는 피연산자는 A(65), B(66), C(67), ...순으로 오기 때문에 65를 빼면 nums와 매핑 가능
                stack.push(nums[index]);
            } else { // 연산자가 온 경우
                double num1 = stack.pop();
                double num2 = stack.pop();
                switch (token) {
                    case '+':
                        stack.push(num2+num1);
                        break;
                    case '-':
                        stack.push(num2-num1);
                        break;
                    case '*':
                        stack.push(num2*num1);
                        break;
                    case '/':
                        stack.push(num2/num1);
                        break;
                }
            }
        }
        bw.write(String.format("%.2f", stack.pop()) + "\n");
        bw.flush();
    }
}
