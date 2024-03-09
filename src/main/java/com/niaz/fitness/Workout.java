package com.niaz.fitness;
import java.util.ArrayList;
import java.time.LocalDate;

public class Workout {
    private String name;
    private ArrayList<Exercise> exerciseArray = new ArrayList<Exercise>();
    private ArrayList<ExerciseState> exerciseStateArray = new ArrayList<ExerciseState>();
    private LocalDate startDate;
    private int interval;

    public void setStartDate(int theYear,int theMonth,int theDay){
        this.startDate = LocalDate.of(theYear,theMonth,theDay);
    }

    public boolean isEmpty(){
        return this.exerciseArray.size() == 0;
    }

    public Exercise getExercise(int index){
        return this.exerciseArray.get(index);
    }

    public int getExerciseCount(){
        return this.exerciseArray.size();
    }

    public void addExercise(Exercise exercise){
        exerciseArray.add(exercise);
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

}
