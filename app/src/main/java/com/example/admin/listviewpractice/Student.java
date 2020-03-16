package com.example.admin.listviewpractice;

/**
 * Created by admin on 3/16/2020.
 */

public class Student {


    private String Sno,Name,Subject;

    public Student(String sno, String name, String subject) {
        Sno = sno;
        Name = name;
        Subject = subject;
    }

    public String getSno() {
        return Sno;
    }

    public void setSno(String sno) {
        Sno = sno;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }
}
