package com.hhq.hq.HqSpringDI;

public class HqStudent implements HqSpeak{
    @Override
    public void speak(String word) {
        System.out.println("HqStudent-"+word);
    }
}
