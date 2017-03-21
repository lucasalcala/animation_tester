package edu.truman.alcalal;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Line2D;

/**
 * A car that can be moved around
 * @author Lucas Alcala
 * @version 09 October 2015
 */
public class CarShape implements MoveableShape
{
   private int x;
   private int y;
   private int width;
   
   /**
    * Constructs a car item
    * @param x the left of the bounding rectangle
    * @param y the top of the bounding rectangle
    * @param width the width of the bounding rectangle
    */
   public CarShape(int x, int y, int width)
   {
      this.x = x;
      this.y = y;
      this.width = width;
   }

   public void translate(int dx, int dy)
   {
      x += dx;
      y += dy;
   }

   public void draw(Graphics2D g2)
   {
    int bodyRectangleDivA = 6;
    int bodyRectangleDivB = 6;
    int bodyRectangleNegC = 6;
    
      Rectangle2D.Double body = new Rectangle2D.Double(x, y + width / bodyRectangleDivA,
            width - bodyRectangleNegC, width / bodyRectangleDivB);
      
      int frontTireA = 6;
      int frontTireB= 3;
      int frontTireC= 6;
      int frontTireD = 6;
      
      Ellipse2D.Double frontTire = new Ellipse2D.Double(x + width / frontTireA, y
            + width /  frontTireB, width / frontTireC, width / frontTireD);
      
      int rearTireMult = 2;
      int rearTiredivA = 3;
      int rearTiredivB = 3;
      int rearTiredivC = 6;
      int rearTiredivD = 6;
      
      Ellipse2D.Double rearTire = new Ellipse2D.Double(x + width * rearTireMult / rearTiredivA,
            +width / rearTiredivB, width / rearTiredivC, width / rearTiredivD);
      
      // The bottom of the front windshield
      
      int windshieldDivY = 6;
      int windshieldDivX = 6; 
      Point2D.Double r1 = new Point2D.Double(x + width / windshieldDivX, y + width / windshieldDivY);
      
      // The front of the roof
      int frontRoofDivX= 3;
      Point2D.Double r2 = new Point2D.Double(x + width / frontRoofDivX, y);
      
      // The rear of the roof
      int rearRoofDivX = 3;
      int rearRoofMultX = 2; 
      Point2D.Double r3 = new Point2D.Double(x + width * rearRoofMultX / rearRoofDivX, y);
      
      // The bottom of the rear windshield
      int bottomRearMultX = 5;
      int bottomRearDivX = 6;
      int bottomRearDivY = 6;
      
      Point2D.Double r4 = new Point2D.Double(x + width * bottomRearMultX / bottomRearDivX, y + width / bottomRearDivY);
      Line2D.Double frontWindshield = new Line2D.Double(r1, r2);
      Line2D.Double roofTop = new Line2D.Double(r2, r3);
      Line2D.Double rearWindshield = new Line2D.Double(r3, r4);

      g2.draw(body);
      g2.draw(frontTire);
      g2.draw(rearTire);
      g2.draw(frontWindshield);
      g2.draw(roofTop);
      g2.draw(rearWindshield);
   }
   
   public void changeDimension(int newWidth)
   {
      width = newWidth;
      
   }
}
