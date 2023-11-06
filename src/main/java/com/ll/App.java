package com.ll;

import java.util.Scanner;

public class App {
    void run(){
        System.out.println("== 명언 앱 ==");
        System.out.print("명령) ");

        Scanner scanner = new Scanner(System.in);
        String cmd = scanner.nextLine();

        System.out.printf("입력받은 명령어 : %s\n", cmd);
    }
}
