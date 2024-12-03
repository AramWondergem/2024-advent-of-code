package org.wondergems.aoc.days;

import org.wondergems.aoc.common.Day;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Day03 implements Day<Integer> {
    @Override
    public Integer part1(List<String> input) {
        int sum = 0;
        for (String s : input) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if(s.charAt(i) == 'm') {
                    sum += checkSum(i, s);
                }
            }
        }
        return sum;
    }

    @Override
    public Integer part2(List<String> input) {
        StringBuilder sb = new StringBuilder();
        for(String s: input) {
            sb.append(s);
        }
        String total = sb.toString();
        int sum = 0;
        boolean mulEnabled = true;

        for(int i = 0; i < total.length(); i++) {
            char c = total.charAt(i);

            if(c == 'd'){
                int endIndex = Math.min(i + 7, total.length());
                String sub = total.substring(i, endIndex);
                int resCheck = consistDoOrDont(sub); // return 1 if contains do(), returns -1 if contains don't(), otherwise it returns 0;
                if(resCheck == 1) {
                    mulEnabled = true;
                } else if (resCheck == -1){
                    mulEnabled = false;
                }
            }

            if(mulEnabled){
                if(c == 'm') {
                    sum += checkSum(i, total);
                }
            }


        }
        return sum;
    }

    public Integer part1Refined(List<String> input) {
        StringBuilder sb = new StringBuilder();
        for(String s : input ){
            sb.append(s);
        }

        String total = sb.toString();

        Pattern pattern = Pattern.compile("mul\\(([0-9]{1,3}),([0-9]{1,3})\\)");
        Matcher matcher = pattern.matcher(total);

        return matcher.results().mapToInt(result -> Integer.parseInt(result.group(1)) * Integer.parseInt(result.group(2))).sum();
    }

    public Integer part2Refined(List<String> input) {
        StringBuilder sb = new StringBuilder();
        for(String s : input ){
            sb.append(s);
        }

        String total = sb.toString();

        Pattern pattern = Pattern.compile("mul\\(([0-9]{1,3}),([0-9]{1,3})\\) | do\\(\\) | don't\\(\\)");
        Matcher matcher = pattern.matcher(total);

        //loop over matchings
    }

    private int checkSum(int i, String s) {
        int endIndex = Math.min(i + 12, s.length());
        if (hasClose(s, i, endIndex)) {
            String curr = s.substring(i, endIndex);

            String[] step1 = curr.split("mul\\(");
            String[] step2 = new String[]{};
            String[] step3 = new String[]{};
            if (step1.length >= 2) {
                step2 = step1[1].split("\\)");
            }
            if (step2.length > 0) {
                step3 = step2[0].split(",");
            }

            if (step3.length == 2) {
                try {
                    int x = Integer.parseInt(step3[0]);
                    int y = Integer.parseInt(step3[1]);

                    if (x < 1000 && y < 1000) {
                        return x * y;
                    }

                } catch (Exception ignore) {

                }
            }


        }
        return 0;
    }

    private boolean hasClose(String s, int index, int endIndex) {
        if (index + 7 < s.length()) {
            for (int i = index + 7; i < endIndex; i++) {
                if (s.charAt(i) == ')') {
                    return true;
                }
            }
        }
        return false;
    }

    private int consistDoOrDont(String sub){
        if(sub.contains("do()")){
            return 1;
        }

        if(sub.contains("don't()")){
            return -1;
        }

        return 0;
    }
}
