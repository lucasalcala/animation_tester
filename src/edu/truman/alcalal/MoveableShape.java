package edu.truman.alcalal;

import java.awt.Graphics2D;

/**
 * A shape that can be moved around
 * @author Lucas Alcala
 * @version 09 October 2015
 */
public interface MoveableShape
{
   /**
    * draws the shape
    * @param g2 the graphics context
    */
   void draw(Graphics2D g2);

   /**
    * Moves the shape by a given amount
    * 
    * @param dx the amount to translate in x-direction
    * @param dy the amount to translate in y-direction
    */
   void translate(int dx, int dy);
   
   /**
    * function to increase or decrease the dimension of the car
    */
   void changeDimension(int newWidth);
}
