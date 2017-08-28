package com.hhq.hq.HqSpringDI;

public class HqSchool {

    private HqTeacher teacher;

    public void setTeacher(HqTeacher teacher) {
        this.teacher = teacher;
    }
    public void zhaoPin(){
        System.out.println("招聘一个老师");
        teacher.speak("我来应聘！");
    }
}
