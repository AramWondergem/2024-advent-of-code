package org.wondergems.aoc.days;

import org.wondergems.aoc.common.Day;

import java.util.List;


public class Day04 implements Day<Integer> {
    private final int lastIndex;
    private final String word;
    private int length;
    private int width;
    private List<String> input;
    private final char firstChar;

    public Day04(String word) {
        this.word = word;
        this.lastIndex = word.length() - 1;
        this.firstChar = word.charAt(0);
    }
    @Override
    public Integer part1(List<String> input) {
        this.length = input.size();
        this.width = input.get(0).length();
        this.input = input;

        int ans = 0;

        for(int y = 0; y < this.length; y++){
            for(int x = 0; x < this.width; x++){
                char c = this.input.get(y).charAt(x);
                if(c == this.firstChar){
                    for(Dir dir: Dir.values()){
                     ans += findWord(0, x, y, dir);
                    }
                }
            }
        }
        return ans;
    }

    @Override
    public Integer part2(List<String> input) {
        this.length = input.size();
        this.width = input.get(0).length();
        this.input = input;
        int ans = 0;

        for(int y = 0; y < this.length; y++){
            for(int x = 0; x < this.width; x++){
                char c = this.input.get(y).charAt(x);
                if(c == this.firstChar){
                    for(Dir dir: Dir.values()){
                        if(canSearchDir(x, y , dir)){
                            ans += findWordCross(0, x, y, dir);
                        }

                    }
                }
            }
        }
        return ans;
    }

    private int findWordCross(int index, int x, int y, Dir dir){
        int firstX = -1;
        int firstY = -1;

        int secondX = -1;
        int secondY = -1;

        switch (dir) {
            case UP -> {
                switch (index){
                    case 0 -> {
                        firstX = x;
                        firstY = y;
                        secondX = x + 2;
                        secondY = y;
                    }
                    case 1 -> {
                        firstX = x + 1;
                        firstY = y - index;
                        secondX = firstX;
                        secondY = firstY;
                    }
                    case 2 -> {
                        firstX = x;
                        firstY = y - index;
                        secondX = x + 2;
                        secondY = y - index;
                    }
                }
            }
            case DOWN -> {
                switch (index){
                    case 0 -> {
                        firstX = x;
                        firstY = y;
                        secondX = x + 2;
                        secondY = y;
                    }
                    case 1 -> {
                        firstX = x + 1;
                        firstY = y + index;
                        secondX = firstX;
                        secondY = firstY;
                    }
                    case 2 -> {
                        firstX = x;
                        firstY = y + index;
                        secondX = x + 2;
                        secondY = y + index;
                    }
                }

            }
            case LEFT -> {
                switch (index){
                    case 0 -> {
                        firstX = x;
                        firstY = y;
                        secondX = x;
                        secondY = y + 2;
                    }
                    case 1 -> {
                        firstX = x - index;
                        firstY = y + 1 ;
                        secondX = firstX;
                        secondY = firstY;
                    }
                    case 2 -> {
                        firstX = x - index;
                        firstY = y;
                        secondX = x - index;
                        secondY = y + 2;
                    }
                }

            }
            case RIGHT -> {
                switch (index){
                    case 0 -> {
                        firstX = x;
                        firstY = y;
                        secondX = x;
                        secondY = y + 2;
                    }
                    case 1 -> {
                        firstX = x + index;
                        firstY = y + 1 ;
                        secondX = firstX;
                        secondY = firstY;
                    }
                    case 2 -> {
                        firstX = x + index;
                        firstY = y;
                        secondX = x + index;
                        secondY = y + 2;
                    }
                }

            }
        }

        char firstChar = this.input.get(firstY).charAt(firstX);
        char secondChar = this.input.get(secondY).charAt(secondX);

        if(index == lastIndex && firstChar == secondChar && firstChar == this.word.charAt(index)){
            return 1;
        }

        if(firstChar == secondChar && firstChar == this.word.charAt(index)) {
            return findWordCross(index + 1, x, y , dir);
        }

        return 0;

    }

    private boolean canSearchDir(int x, int y, Dir dir) {

        return switch(dir) {
            case UP -> {
                boolean xValid = 0 <= x && x < this.width - 2;
                boolean yValid = 2 <= y && y < this.length;
                yield xValid && yValid;
            }
            case DOWN, RIGHT -> {
                boolean xValid = 0 <= x && x < this.width - 2;
                boolean yValid = 0 <= y && y < this.length - 2;
                yield xValid && yValid;
            }
            case LEFT -> {
                boolean xValid = 2 <= x && x < this.width;
                boolean yValid = 0 <= y && y < this.length -2;
                yield xValid && yValid;
            }
            default -> false;
        };
    }

    private int findWord(int index, int x, int y, Dir dir){
        if(!isValid(x,y)){
            return 0;
        }
        char c = this.word.charAt(index);
        char currC = this.input.get(y).charAt(x);

        if(c == currC && index == lastIndex){
            return 1;
        }

        int ans = 0;

        if(c == currC){
           ans =switch (dir) {
               case UP -> findWord(index + 1, x , y - 1, dir);
               case DOWN -> findWord(index + 1, x , y + 1, dir);
               case LEFT -> findWord(index + 1, x - 1 , y , dir);
               case RIGHT -> findWord(index + 1, x + 1 , y , dir);
               case UP_LEFT -> findWord(index + 1, x - 1 , y - 1 , dir);
               case UP_RIGHT -> findWord(index + 1, x + 1 , y - 1 , dir);
               case DOWN_LEFT -> findWord(index + 1, x - 1 , y + 1 , dir);
               case DOWN_RIGHT -> findWord(index + 1, x + 1 , y + 1 , dir);
           };
        }

        return ans;

    }

    private boolean isValid(int x, int y){
        boolean xValid = 0 <= x && x < this.width;
        boolean yValid = 0 <= y && y < this.length;
        return xValid && yValid;
    }
}

enum Dir{
    UP,DOWN,LEFT,RIGHT,UP_LEFT,UP_RIGHT,DOWN_LEFT,DOWN_RIGHT
}
