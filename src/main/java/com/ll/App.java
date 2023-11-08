package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    Scanner scanner;
    int lastQuotaionId; // 명언의 ID 값을 관리하기 위한 변수로, 초기값은 0으로 설정
    List<Quotation> quotations; // 명언 객체(Quotation)를 저장하기 위한 리스트를 생성

    App() {
        scanner = new Scanner(System.in);
        lastQuotaionId = 0;
        quotations = new ArrayList<>();
    }

    void run() {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");

            String cmd = scanner.nextLine(); // 사용자가 입력한 명령을 읽어와 cmd 변수에 저장

            Rq rq = new Rq(cmd);

            switch (rq.getAction()) {
                case "종료":
                    break;
                case "등록":
                    actionWrite();
                    break;
                case "목록":
                    actionList();
                    break;
                case "삭제":
                    actionRemove(rq);
                    break;
                case "수정":
                    actionModify(rq);
                    break;
            }
        }
    }

    // 리팩토링
    void actionWrite() {
        System.out.print("명언 : ");
        String content = scanner.nextLine();

        System.out.print("작가 : ");
        String authorName = scanner.nextLine();

        lastQuotaionId++;
        int id = lastQuotaionId;

        Quotation quotation = new Quotation(id, content, authorName);
        quotations.add(quotation);

        System.out.printf("%d번 명언이 등록 되었습니다.\n", lastQuotaionId);
    }

    void actionList() {
        System.out.println("번호 / 작가 / 명언");

        System.out.println("-------------------------------------------");

        if (quotations.isEmpty()) {
            System.out.println("등록된 명언이 없습니다.");
        }
        for (int i = quotations.size() - 1; i >= 0; i--) {
            Quotation quotation = quotations.get(i);
            System.out.printf("%d / %s / %s\n", quotation.id, quotation.authorName, quotation.content);
        }
    }

    void actionRemove(Rq rq) {
        int id = rq.getParamAsInt("id", 0);

        if (id == 0) {
            System.out.println("id를 정확히 입력해주세요.");
            return; // 함수를 끝냄
        }

        int index = getIndexOfQuotationById(id);

        if (index == -1) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
            return;
        }

        quotations.remove(index);

        System.out.printf("%d번 명언이 삭제 되었습니다.\n", id);
    }

    int getIndexOfQuotationById(int id) {
        for (int i = 0; i < quotations.size(); i++) {
            Quotation quotation = quotations.get(i);

            if (quotation.id == id) {
                return i;
            }
        }
        return -1;
    }

    void actionModify(Rq rq) {
        int id = rq.getParamAsInt("id", 0);

        if (id == 0) {
            System.out.println("id를 정확히 입력해주세요.");
            return; // 함수를 끝냄
        }

        System.out.printf("%d번 명언을 수정합니다.\n", id);
    }
}