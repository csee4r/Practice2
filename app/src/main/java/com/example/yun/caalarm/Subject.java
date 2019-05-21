package com.example.yun.caalarm;

public class Subject {
    String subject;
    String professor;
    String location;
    Boolean isAlarm;
    int startTime;
    int day;
    int period;
    int red;
    int green;
    int blue;

    public Subject(String subject, String location){
        this.subject = subject;
        this.location = location;
    }

//    public Subject(String subject, String professor, String location, Boolean isAlarm, int startTime, int day, int period, int red, int green, int blue) {
//        this.subject = subject;
//        this.professor = professor;
//        this.location = location;
//        this.isAlarm = isAlarm;
//        this.startTime = startTime;
//        this.day = day;
//        this.period = period;
//        this.red = red;
//        this.green = green;
//        this.blue = blue;
//    }
}