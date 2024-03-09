package com.niaz.fitness;

import java.util.ArrayList;

public class Print {
    public void printExerciseState(ExerciseState state){
        ArrayList<Integer> sets = state.getSets();
        String out = "[";
        for (Integer reps : sets) {
            out +=  reps + ", ";
        }
        out = out.substring(0, out.length()-2) + "]";
        System.out.println("Reps:" + out);
    }
    
}
