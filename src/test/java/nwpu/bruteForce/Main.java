package nwpu.bruteForce;

import java.util.Scanner;
import java.util.LinkedList;

public class Main {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] input;
        input = sc.nextLine().split(" ");

        LinkedList<String> b = new LinkedList<String>();

        for(int i=0; i<input.length; i++) {

            if(input[i].matches("[+|-|*|/|%]")) {

                String operation = input[i];
                int right = Integer.parseInt(b.pop());
                int left = Integer.parseInt(b.pop());

                switch (operation) {

                    case "+":
                        b.push(Integer.toString((left + right)));
                        break;
                    case "*":
                        b.push(Integer.toString((left * right)));
                        break;
                    case "/":
                        b.push(Integer.toString((left / right)));
                        break;
                    case "-":
                        b.push(Integer.toString((left - right)));
                        break;
                    case "%":
                        b.push(Integer.toString((left % right)));
                        break;
                }
            }else {

                b.push(input[i]);

            }
        }

        System.out.println(b.pop());
        sc.close();
    }
}