package com.niaz.fitness;
import java.util.ArrayList;

public class ProgramData {
    private ArrayList<Workout> workouts;

    ProgramData(){
        this.workouts = new ArrayList<Workout>();
    }

    public void saveWorkout(Workout newWorkout){
        workouts.add(newWorkout);
    }
}
