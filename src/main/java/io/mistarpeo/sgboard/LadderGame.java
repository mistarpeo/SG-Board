package io.mistarpeo.sgboard;

import java.util.Scanner;

public class LadderGame {
    public static void main(String[] args) {
        
        try(
            Scanner scanner = new Scanner(System.in);
        ){
            System.out.println("사다리 게임을 시작합니다.");
            System.out.print("참여할 인원 수를 입력해주세요: ");
            int playerCount = scanner.nextInt();
    
            System.out.print("사다리 높이를 입력해주세요: ");
            int ladderHeight = scanner.nextInt();
    
            String[] playerNames = new String[playerCount];
            for (int i = 0; i < playerCount; i++) {
                System.out.print("참여자의 이름을 입력해주세요: ");
                playerNames[i] = scanner.next();
            }
    
            // 사다리 생성
            String[][] ladder = new String[ladderHeight][playerCount];
            for (int i = 0; i < ladderHeight; i++) {
                for (int j = 0; j < playerCount; j++) {
                    ladder[i][j] = "|   ";
                }
            }
    
            // 사다리에 랜덤하게 가로줄 추가
            for (int i = 0; i < ladderHeight; i++) {
                for (int j = 0; j < playerCount - 1; j++) {
                    if (Math.random() > 0.5) {
                        ladder[i][j + 1] = "├──";
                        ladder[i][j] = "──┤";
                    }
                }
            }
            // 결과 출력
            for (int i = 0; i < playerCount; i++) {
                System.out.print("   " + playerNames[i] + "   ");
            }
            System.out.println();
    
            for (int i = 0; i < ladderHeight; i++) {
                for (int j = 0; j < playerCount; j++) {
                    System.out.print(ladder[i][j]);
                }
                System.out.println();
            }
    
            // 결과 예측 및 출력
            System.out.println("결과를 예측해주세요.");
            for (int i = 0; i < playerCount; i++) {
                System.out.print(playerNames[i] + "의 결과: ");
                String result = scanner.next();
                System.out.println(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
