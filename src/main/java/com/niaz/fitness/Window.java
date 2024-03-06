package com.niaz.fitness;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window {
    private JFrame frame;
    private ProgramData programData;
    private Workout currentWorkout;
    private Database database;

    Window(){
        // Instantiate the Database and ProgramData classes
        this.database = new Database();
        this.programData = new ProgramData();

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
                NewWorkout();
                System.out.println("click!");
            }};
        ActionListener buttonListener2 = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("click2!");
            }};
            
        b1.addActionListener(buttonListener);
        b2.addActionListener(buttonListener2);
        frame.revalidate();
        frame.repaint();
        }
            
    public void NewWorkout(){
        currentWorkout = new Workout(); // should this be here as it isn't "window logic"?
        frame.getContentPane().removeAll();
        JButton b1 = new JButton("Back");
        JButton b2 = new JButton("Add Exercise");
        this.frame.getContentPane().add(b1, BorderLayout.NORTH);
        this.frame.getContentPane().add(b2, BorderLayout.CENTER);

            ActionListener buttonListener = new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                System.out.println("You just clicked 'Back'");
                MainMenu();
            }};

            ActionListener buttonListener2 = new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                System.out.println("You just clicked 'Add Exercise'");
                
            }};

        b1.addActionListener(buttonListener);
        b2.addActionListener(buttonListener2);
        frame.revalidate();
        frame.repaint();
    }

    public void Save(){
        JButton b1 = new JButton("Save");
        this.frame.getContentPane().add(b1, BorderLayout.SOUTH);

            ActionListener buttonListener  = new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                System.out.println("You just clicked 'Save'");
                programData.saveWorkout(currentWorkout);
            }};
        b1.addActionListener(buttonListener);
        frame.revalidate();
        frame.repaint();
    }

}
