package com.hhq.hq.HqSpringDI;


public class HqPerson implements HqSpeak{

    private  HqSpeak speak;

    public HqPerson (HqSpeak speak){
        this.speak = speak;
    }
    @Override
    public void speak(String word) {
        System.out.println("HqPerson-"+word);
        speak.speak(word);
    }
}
