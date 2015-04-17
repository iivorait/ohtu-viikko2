package ohtu;

import java.util.ArrayList;

public class Submission {
    private String student_number;
    private int week;
    private int hours;
    private boolean a1;
    private boolean a2;
    private boolean a3;
    private boolean a4;
    private boolean a5;
    private boolean a6;
    private boolean a7;
    private boolean a8;
    private boolean a9;
    private boolean a10;
    private boolean a11;
    private boolean a12;
    private boolean a13;
    private boolean a14;
    private boolean a15;
    private boolean a16;
    private boolean a17;
    private boolean a18;
    private boolean a19;
    private boolean a20;
    private boolean a21;
    private boolean a22;
    
    
//    private ArrayList<Assigment> assigments;
//
//    public Submission() {
//        assigments = new ArrayList<Assigment>();
//    }

    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    public int getWeek() {
        return week;
    }

    public int getHours() {
        return hours;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

   
    
    @Override
    public String toString() {
        
        return "viikko " + week + ": tehtyjä tehtäviä yhteensä " + assigmentCount() + ", aikaa kului " + hours + " tuntia, tehdyt tehtävät: " + assigmentNumbers();
    }

    //Huhhuh mitä metodeita!
    public int assigmentCount() {
        int tehtyjaTehtavia = 0;
        if(a1) {
            tehtyjaTehtavia++;
        }
        if(a2) {
            tehtyjaTehtavia++;
        }
        if(a3) {
            tehtyjaTehtavia++;
        }
        if(a4) {
            tehtyjaTehtavia++;
        }
        if(a5) {
            tehtyjaTehtavia++;
        }
        if(a6) {
            tehtyjaTehtavia++;
        }
        if(a7) {
            tehtyjaTehtavia++;
        }
        if(a8) {
            tehtyjaTehtavia++;
        }
        if(a9) {
            tehtyjaTehtavia++;
        }
        if(a10) {
            tehtyjaTehtavia++;
        }
        if(a11) {
            tehtyjaTehtavia++;
        }
        if(a12) {
            tehtyjaTehtavia++;
        }
        if(a13) {
            tehtyjaTehtavia++;
        }
        if(a14) {
            tehtyjaTehtavia++;
        }
        if(a15) {
            tehtyjaTehtavia++;
        }
        if(a16) {
            tehtyjaTehtavia++;
        }
        if(a17) {
            tehtyjaTehtavia++;
        }
        if(a18) {
            tehtyjaTehtavia++;
        }
        if(a19) {
            tehtyjaTehtavia++;
        }
        if(a20) {
            tehtyjaTehtavia++;
        }
        if(a21) {
            tehtyjaTehtavia++;
        }
        if(a22) {
            tehtyjaTehtavia++;
        }
        return tehtyjaTehtavia;
    }
    
    public String assigmentNumbers() {
        StringBuilder tehtavat = new StringBuilder();
        
        if(a1) {
            tehtavat.append("1 ");
        }
        if(a2) {
            tehtavat.append("2 ");
        }
        if(a3) {
            tehtavat.append("3 ");
        }
        if(a4) {
            tehtavat.append("4 ");
        }
        if(a5) {
            tehtavat.append("5 ");
        }
        if(a6) {
            tehtavat.append("6 ");
        }
        if(a7) {
            tehtavat.append("7 ");
        }
        if(a8) {
            tehtavat.append("8 ");
        }
        if(a9) {
            tehtavat.append("9 ");
        }
        if(a10) {
            tehtavat.append("10 ");
        }
        if(a11) {
            tehtavat.append("11 ");
        }
        if(a12) {
            tehtavat.append("12 ");
        }
        if(a13) {
            tehtavat.append("13 ");
        }
        if(a14) {
            tehtavat.append("14 ");
        }
        if(a15) {
            tehtavat.append("15 ");
        }
        if(a16) {
            tehtavat.append("16 ");
        }
        if(a17) {
            tehtavat.append("17 ");
        }
        if(a18) {
            tehtavat.append("18 ");
        }
        if(a19) {
            tehtavat.append("19 ");
        }
        if(a20) {
            tehtavat.append("20 ");
        }
        if(a21) {
            tehtavat.append("21 ");
        }
        if(a22) {
            tehtavat.append("22 ");
        }
        return tehtavat.toString();
    }
}