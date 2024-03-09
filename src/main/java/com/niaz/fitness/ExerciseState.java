package com.niaz.fitness;
import java.util.ArrayList;

public class ExerciseState {
    private ArrayList<Integer> sets;
    private ArrayList<String> intensity; 
    private int restTime;
    private ArrayList<Integer> repsDone;

    // Constructor
    ExerciseState(int sets, int reps){
        this.sets = new ArrayList<Integer>(sets);
        this.intensity = new ArrayList<String>(sets);
        this.repsDone = new ArrayList<Integer>(sets);
        for (int i = 0; i < sets; i++) {
            this.sets.add(reps);
            this.intensity.add("");
            this.repsDone.add(0);
        }
        
    }

    // Getter methods
    public ArrayList<Integer> getSets(){
        return this.sets;
    }

    // Setter methods
    public void setIntensity(int index, String intensity){
        this.intensity.set(index, intensity);
    }

    public void setReps(int index, int reps){
        this.sets.set(index, reps);
    }

    public void setRestTime(int restTime){
        this.restTime = restTime;
    }

    public void setRepsDone(int index, int repsDone){
        this.repsDone.set(index, repsDone);
    }



}
