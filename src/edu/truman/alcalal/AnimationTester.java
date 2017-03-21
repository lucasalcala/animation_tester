package edu.truman.alcalal;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * This program implements an animation that moves a car shape. it includes a
 * button that when clicked it stops the movement of the car and when clicked
 * again it resumes the movement. Also includes a slider to increase or decrease
 * the size of the car.
 * @author Lucas Alcala
 * @version 9 October 2015
 */
public class AnimationTester
{
   private static final int ICON_WIDTH = 400;
   private static final int ICON_HEIGHT = 200;
   private static final int CAR_WIDTH = 100;
   private static int xHorizontal = 0;
   private static int yVertical = 0;
   private static boolean stop = true;

   public static void main(String[] args)
   {
      JFrame frame = new JFrame();
      final MoveableShape shape = new CarShape(0, 0, CAR_WIDTH);
      ShapeIcon icon = new ShapeIcon(shape, ICON_WIDTH, ICON_HEIGHT);
      JLabel label = new JLabel(icon);
      frame.setLayout(new FlowLayout());
      frame.add(label);

      // Button that resumes and stops the car movement
      
      JButton stopResume = new JButton("Resume");   
      frame.add(stopResume);
      stopResume.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent evt)
         {
            if (stop)
            {
               xHorizontal = 1;
               stop = false;
               stopResume.setText("Pause");
            }
            else
            {
               xHorizontal = 0;
               stop = true;
               stopResume.setText("Resume");
            }
         }
      });
        
      
        
      // slider to increase or decrease the size of the car
      JSlider sizeSlider = new JSlider(JSlider.HORIZONTAL, 0, 200, CAR_WIDTH);
      
      sizeSlider.setMajorTickSpacing(0);
      sizeSlider.setMinorTickSpacing(0);
      sizeSlider.setPaintLabels(true);
      sizeSlider.setPaintTicks(true);

      sizeSlider.addChangeListener(new ChangeListener()
      {
         public void stateChanged(ChangeEvent e)
         {
            JSlider source = (JSlider) e.getSource();
            int size = (int) source.getValue();
            shape.changeDimension(size);
         }
      });
      
      frame.add(label);
      frame.add(sizeSlider);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);

      final int DELAY = 100;
      // Milliseconds between timer ticks
      Timer time = new Timer(DELAY, new ActionListener()
      {
         public void actionPerformed(ActionEvent event)
         {
            shape.translate(xHorizontal, yVertical);
            label.repaint();
         }
      });
      time.start();
   }

}