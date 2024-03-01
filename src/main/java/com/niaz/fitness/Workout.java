package com.niaz.fitness;
import java.util.ArrayList;
import java.time.LocalDate;

public class Workout {
    private String name;
    private ArrayList<Exercise> exerciseArray = new ArrayList<Exercise>();
    private LocalDate startDate;
    private int interval;

    public void setStartDate(int theYear,int theMonth,int theDay){
        this.startDate = LocalDate.of(theYear,theMonth,theDay);
    }


}
