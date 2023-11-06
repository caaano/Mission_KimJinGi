package com.ll;

import java.util.Scanner;

public class App {
    void run() {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");

            Scanner scanner = new Scanner(System.in);
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                System.out.println("명언 : ");
                System.out.println("작가 : ");
            }

            System.out.printf("입력받은 명령어 : %s\n", cmd);
        }
    }
}