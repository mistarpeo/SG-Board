package io.mistarpeo.sgboard;

import java.util.Arrays;
import java.util.Random;

public class LottoGenerator {
    public static void main(String[] args) {
        int[] lottoNumbers = new int[6];
        Random random = new Random();

        int[] lowNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21};
        int[] highNumbers = {25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45};

        int lowCount = 0;
        int highCount = 0;

        // 1부터 45까지의 숫자 중 높은 숫자와 낮은 숫자 비율을 맞추어 선택
        for (int i = 0; i < 6; i++) {
            if (i == 0 || i == 1 || i == 2) {
                // 첫 번째, 두 번째, 세 번째 숫자는 낮은 숫자로 선택
                int lowIndex = random.nextInt(lowNumbers.length - lowCount);
                lottoNumbers[i] = lowNumbers[lowIndex];
                lowNumbers[lowIndex] = lowNumbers[lowNumbers.length - 1 - lowCount];
                lowCount++;
            } else if (i == 3 || i == 4) {
                // 네 번째, 다섯 번째 숫자는 높은 숫자로 선택
                int highIndex = random.nextInt(highNumbers.length - highCount);
                lottoNumbers[i] = highNumbers[highIndex];
                highNumbers[highIndex] = highNumbers[highNumbers.length - 1 - highCount];
                highCount++;
            } else {
                // 여섯 번째 숫자는 1부터 45까지의 모든 숫자에서 무작위로 선택
                int randomNum;
                do {
                    randomNum = random.nextInt(45) + 1;
                } while (contains(lottoNumbers, randomNum));
                lottoNumbers[i] = randomNum;
            }
        }

        // 선택된 숫자를 정렬하여 출력
        Arrays.sort(lottoNumbers);
        System.out.println("로또 번호: " + Arrays.toString(lottoNumbers));
    }

    // 배열에 특정 숫자가 포함되어 있는지 확인하는 메서드
    private static boolean contains(int[] array, int num) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) {
                return true;
            }
        }
        return false;
    }
}
