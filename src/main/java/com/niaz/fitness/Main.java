package com.niaz.fitness;
import java.util.List;

import javax.swing.JFrame;

class Main{
    
    public static void main(String[] args){
        Window window = new Window();
        System.out.println("Hello World");
        ExerciseState test = new ExerciseState (9,16);
        test.print();
        Database database = new Database();
        List<Exercise> exercises = database.getAllExercises();
        database.printExercises(exercises);
    }
    
}