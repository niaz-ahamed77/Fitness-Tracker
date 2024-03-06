package com.niaz.fitness;
import java.util.ArrayList;
import java.util.List;

public class ProgramData {
    private ArrayList<Workout> workouts;
    private List<Exercise> exercises;

    ProgramData(){
        this.workouts = new ArrayList<Workout>();
        this.exercises = new ArrayList<Exercise>();
    }

    public void saveWorkout(Workout newWorkout){
        workouts.add(newWorkout);
    }

    public void saveExercise(Exercise newExercise){
        exercises.add(newExercise);
    }
}
