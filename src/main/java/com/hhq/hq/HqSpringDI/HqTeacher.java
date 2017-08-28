package com.hhq.hq.HqSpringDI;

public class HqTeacher implements HqSpeak {
    @Override
    public void speak(String word) {
        System.out.println("HqTeacher-"+word);
    }
}
