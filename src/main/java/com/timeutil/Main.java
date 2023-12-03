package com.timeutil;

public class Main {
    public static void main(String[] args) {
        String t = "1:23:45";
        String tulos = TimeUtils.secToTime(TimeUtils.timeToSec(t));
        System.out.println("Tulos: " + tulos);
    }
}
