package org.wondergems.aoc.days;

import org.wondergems.aoc.common.Day;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Day02 implements Day<Integer> {

    @Override
    public Integer part1(List<String> input) {
        int ans = 0;

        for(String s : input){
            List<Integer> levels = Stream.of(s.split(" ")).map(Integer::parseInt).toList();


            if(isSafe(levels)) {
                ans++;
            }

        }

        return ans;
    }

    @Override
    public Integer part2(List<String> input) {
        // loop over inputs
        // check with above logic if safe. if so + 1
        // if not
        //loop over remove 1 and check if safe. if so +1;
        int ans = 0;

        for(String s : input){
            List<Integer> levels = Stream.of(s.split(" ")).map(Integer::parseInt).toList();


            if(isSafe(levels)) {
                ans++;
            } else {

                for(int i = 0; i < levels.size(); i++){
                    List<Integer> newLevels = new ArrayList<>(levels);
                    newLevels.remove(i);
                    if(isSafe(newLevels)){
                        ans++;
                        break;
                    }
                }

            }

        }

        return ans;
    }

    private boolean isSafe(List<Integer> levels) {

        int prevSign = -2;
        boolean safe = true;

        for(int i = 1; i < levels.size(); i++) {
            int difference = levels.get(i -1) - levels.get(i);
            int sign = Integer.signum(difference);
            if(difference == 0){
                safe = false;
                break;
            }

            if(Math.abs(difference) > 3){
                safe = false;
                break;
            }

            if (prevSign != -2 && prevSign != sign ) {
                safe = false;
                break;
            }
            prevSign = sign;
        }

        return safe;

    }
}
