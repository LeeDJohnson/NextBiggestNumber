package com.labs1904;

import java.util.ArrayList;
import java.util.Collections;

public class NextBiggestNumber {

    public static void main(String[] args) {
        Integer input = Integer.parseInt(args[0]);
        Integer nextBiggestNumber = getNextBiggestNumber(input);
        System.out.println("Input: " + input);
        System.out.println("Next biggest number: " + nextBiggestNumber);
    }

    public static ArrayList<Integer> swap(ArrayList<Integer> list, int a, int b) {
        Integer temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
        return list;
    }

    public static int getNextBiggestNumber(Integer i) {
        boolean possible = false;
        ArrayList<Integer> digits = new ArrayList<Integer>();
        while (i > 0) {
            digits.add(i % 10);
            i = i / 10;
        }
        int j = digits.size();
        int k;
        for (k = 0; k < j - 1; k++) {
            if (digits.get(k) > digits.get(k + 1)) {
                possible = true;
                break;
            }
        }
        if (!possible) {
            return -1;
        }
        int min = k;
        for (int l = k; l >= 0; l--) {
            if (digits.get(l) > digits.get(k + 1) && digits.get(l) < digits.get(min)) {
                min = l;
            }
        }
        ArrayList<Integer> sortedDigits = swap(digits, k + 1, min);
        Collections.sort(sortedDigits.subList(0, k + 1));
        Collections.reverse(sortedDigits.subList(0, k + 1));
        int answer = 0;
        Integer place = 1;
        for (int l = 0; l < j; l++) {
            answer = answer + sortedDigits.get(l) * place;
            place = place * 10;
        }
        return answer;
    }
}
