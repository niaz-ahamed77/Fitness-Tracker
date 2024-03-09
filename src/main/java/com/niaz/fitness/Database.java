package com.niaz.fitness;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Database {

    Database() {
        saveExercise();
    }

    
    public void saveExercise(){//Exercise exercise){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction(); // Begin transaction
            Exercise exercise = new Exercise("Squats");
            // session.save(exercise);
            transaction.commit(); // Commit
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); // Rollback the transaction in case of an error
            }
            e.printStackTrace(); // Proper exception handling recommended
        }
    }

    public List<Exercise> getAllExercises() {
        List<Exercise> exercises = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            exercises = session.createQuery("FROM Exercise", Exercise.class).list();
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
        return exercises;
    }

    public void printExercises(List<Exercise> exercises){ 
        // utility method to check database retrieval
        for (Exercise exercise : exercises){
            System.out.println("Exercise Name: " + exercise.getName());
            // System.out.println();
        }
    }

}
