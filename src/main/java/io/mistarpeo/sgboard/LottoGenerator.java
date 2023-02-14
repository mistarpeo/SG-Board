package io.mistarpeo.sgboard;

import java.util.Arrays;
import java.util.Random;

public class LottoGenerator {
    public static void main(String[] args) {
        int[] lottoNumbers = generateLottoNumbers();
        System.out.println(Arrays.toString(lottoNumbers));
    }

    public static int[] generateLottoNumbers() {
        int[] lottoNumbers = new int[6];
        Random random = new Random();

        for (int i = 0; i < lottoNumbers.length; i++) {
            int number = random.nextInt(45);
            lottoNumbers[i] = number;
        }
        return lottoNumbers;
    }
}