package com.niaz.fitness;
import java.util.ArrayList;
import java.util.List;

public class ProgramData {
    private List<Workout> workouts;
    private List<Exercise> exercises;

    ProgramData(){
        this.workouts = new ArrayList<Workout>();
        this.exercises = new ArrayList<Exercise>();
    }

    ProgramData(List<Exercise> exerciseList){
        this.workouts = new ArrayList<Workout>();
        this.exercises = exerciseList;
    }

    public void saveWorkout(Workout newWorkout){
        workouts.add(newWorkout);
    }

    public void saveExercise(Exercise newExercise){
        exercises.add(newExercise);
    }

    public Exercise getExercise(int index){
        return this.exercises.get(index);
    }

    public int getExerciseCount(){
        return this.exercises.size();
    }

    public Workout getWorkout(int index){
        return this.workouts.get(index);
    }

    public int getWorkoutCount(){
        return this.workouts.size();
    }

    @Override
    public String toString(){
        String workoutName = "";
        for(Workout workout: this.workouts){
            workoutName += workout.getName() + "\n";
        }
        return workoutName;
    }

}
