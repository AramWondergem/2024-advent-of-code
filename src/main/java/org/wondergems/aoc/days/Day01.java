package org.wondergems.aoc.days;

import org.wondergems.aoc.common.Day;

import java.util.*;

public class Day01 implements Day<Integer> {

    @Override
    public Integer part1(List<String> input) {
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        for(String s : input) {
            String[] split = s.split("   ");
            pq1.add(Integer.parseInt(split[0]));
            pq2.add(Integer.parseInt(split[1]));
        }
        int sum = 0;

        for(int i = 0; i < input.size(); i++) {
            sum += Math.abs(pq1.poll() - pq2.poll());
        }

        return sum;
    }

    @Override
    public Integer part2(List<String> input) {
        Map<Integer,Integer> rightList = new HashMap<>();
        List<Integer> leftList = new ArrayList<>();

        for(String s : input) {
            String[] split = s.split("   ");
            leftList.add(Integer.parseInt(split[0]));
            int right = Integer.parseInt(split[1]);
            rightList.putIfAbsent(right,0);
            rightList.put(right, rightList.get(right) + 1);
        }

        int sum = 0;

        for(int left : leftList){
            if(rightList.containsKey(left)) {
                sum += left * rightList.get(left);
            }
        }

        return sum;
    }
}
