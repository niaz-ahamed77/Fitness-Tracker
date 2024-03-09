package com.niaz.fitness;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

public class Window {
    private JFrame frame;
    private ProgramData programData;
    private Workout currentWorkout;
    private Database database;

    Window(){
        // Instantiate the Database and ProgramData classes
        this.database = new Database();
        List<Exercise> exercises = database.getAllExercises();
        this.programData = new ProgramData(exercises);

        //1. Create the frame.
        this.frame = new JFrame("Fitness Tracker");

        //2. Optional: What happens when the frame closes?
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //3. Create components and put them in the frame.
        //...create emptyLabel...
        // this.frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);
        this.MainMenu();

        //4. Size the frame.
        this.frame.pack();

        //5. Show it.
        this.frame.setVisible(true);
    }

    public void MainMenu(){
        frame.getContentPane().removeAll();
        JButton b1 = new JButton("New Workout");
        JButton b2 = new JButton("Workouts");
        this.frame.getContentPane().add(b1, BorderLayout.NORTH);
        this.frame.getContentPane().add(b2, BorderLayout.SOUTH);
        ActionListener buttonListener = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                currentWorkout = new Workout();
                NewWorkout();
                System.out.println("click!");
            }};
        ActionListener buttonListener2 = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Workouts();
            }};
            
        b1.addActionListener(buttonListener);
        b2.addActionListener(buttonListener2);
        frame.revalidate();
        frame.repaint();
        }
            
    public void NewWorkout(){
        frame.getContentPane().removeAll();

        JButton b1 = new JButton("Cancel");
        JButton b2 = new JButton("Add Exercise");
            ActionListener buttonListener = new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                System.out.println("You just clicked 'Back'");
                MainMenu();
            }};
            ActionListener buttonListener2 = new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                AddExercise();
                System.out.println("You just clicked 'Add Exercise'");
            }};
            
        b1.addActionListener(buttonListener);
        b2.addActionListener(buttonListener2);
        

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JTextField nameField = new JTextField();
        if (currentWorkout.getName() == null) {
            nameField.setText("New Workout");
        } else {
            nameField.setText(currentWorkout.getName());
        }
        nameField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {
                currentWorkout.setName(nameField.getText());
            }
        });
        p1.setLayout(new BorderLayout());
        p1.add(nameField, BorderLayout.NORTH);
        p1.add(p3, BorderLayout.CENTER);
        p2.add(b2);
        if(currentWorkout.isEmpty()){
            JLabel l1 = new JLabel("You currently have zero exercises in this workout.");
            p3.add(l1);
        }
        else{
            //Exercise panel stuff
            for(int i=0; i<currentWorkout.getExerciseCount(); i++){
                JButton b3 = new JButton(currentWorkout.getExercise(i).getName());    
                p3.add(b3);
            }
            JButton b4 = new JButton("Save Workout");
            p2.add(b4);

            ActionListener buttonListener4  = new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    currentWorkout.setName(nameField.getText());
                    programData.saveWorkout(currentWorkout);
                    MainMenu();
                }};
            b4.addActionListener(buttonListener4);
        }

        
        this.frame.getContentPane().add(b1, BorderLayout.NORTH);
        this.frame.getContentPane().add(p1, BorderLayout.CENTER);
        this.frame.getContentPane().add(p2, BorderLayout.SOUTH);
        
        
        

        frame.revalidate();
        frame.repaint();
    }

    // public void Save(){
    //     JButton b1 = new JButton("Save");
    //     this.frame.getContentPane().add(b1, BorderLayout.SOUTH);

    //         ActionListener buttonListener  = new ActionListener(){
    //             @Override
    //             public void actionPerformed(ActionEvent e) {
    //             System.out.println("You just clicked 'Save'");
    //             programData.saveWorkout(currentWorkout);
    //         }};
    //     b1.addActionListener(buttonListener);
    //     frame.revalidate();
    //     frame.repaint();
    // }

    public void AddExercise(){
        frame.getContentPane().removeAll();
        
        // combobox content
        final DefaultComboBoxModel exercises = new DefaultComboBoxModel<>();
        for (int i = 0; i < this.programData.getExerciseCount(); i++){
            exercises.addElement(this.programData.getExercise(i));
        }
        JComboBox exerciseSelect = new JComboBox<>(exercises);
        frame.getContentPane().add(exerciseSelect, BorderLayout.CENTER);
        
        JButton b1 = new JButton("Cancel");
        JButton b2 = new JButton("Add Exercise");
        this.frame.getContentPane().add(b1, BorderLayout.NORTH);
        this.frame.getContentPane().add(b2, BorderLayout.SOUTH);
        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                NewWorkout();
            }});
        b2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                currentWorkout.addExercise((Exercise) exerciseSelect.getSelectedItem());
                NewWorkout();
            }});

        frame.revalidate();
        frame.repaint();
    }

    public void Workouts(){
        frame.getContentPane().removeAll();
        
        JButton back = new JButton("Back");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainMenu();
            }
        });
        frame.getContentPane().add(back, BorderLayout.NORTH);
        JPanel p1 = new JPanel();
        frame.getContentPane().add(p1, BorderLayout.CENTER);

        for(int i = 0; i < programData.getWorkoutCount(); i++){
            Workout workout = programData.getWorkout(i);
            JButton b1 = new JButton(programData.getWorkout(i).getName());
            p1.add(b1);
            // b1.addActionListener(new ActionListener() {
            //     @Override
            //     public void actionPerformed(ActionEvent e) {
            //         WorkoutMenu(workout);
            //     }
            // });
        }

        frame.revalidate();
        frame.repaint();
    }
}
