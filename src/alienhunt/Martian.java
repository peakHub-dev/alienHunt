/*
 * W20- Java Intermediate
 * Final Assignment
 * 
 */
package alienhunt;
import javafx.scene.canvas.GraphicsContext;
/**
 * Martian Class = Supplies an extended version of the Alien constructor which
 * sets the constructor's required arguments for Martians. Includes a draw()
 * method which receives Graphic Contexts and uses its methods to draw a Martian using x, y coordinates, lines, ovals and
 * rectangles and the draw method also uses the strokeText() method to label the
 * drawing as a Martian.
 *
 * @author Kerry Nelson Milovic
 * @version 2.0
 * @since 2020-04-21
 */
public class Martian extends Alien {
    
    /**
     * Martian() constructor: Supplies an extended version of the Alien constructor which sets the
     * constructor's required arguments for Martians.
     *
     * @param typeID String stating the name of the alien
     * @param homePlanet String stating the planet the alien calls home
     * @param typeName String stating the name of the alien
     * @param numberEyes Integer representing the number of eyes
     */

	public Martian(int typeID, String homePlanet, String typeName, int numberEyes) {
		super(2, "Mars", "Martian", 2);
    
	
	}
    /**
     * draw() method: receives Graphic Contexts and uses its methods to draw a Martian using x, y coordinates, lines, ovals and
    * rectangles and the draw method also uses the strokeText() method to label the
    * drawing as a Martian.
     *
     * @param aMartianPic - the graphics context to draw onto canvas
     * @param aMartianPicDetails - the graphics context to draw onto canvas
     *
     * 
     */
 public void draw(GraphicsContext aMartianPic, GraphicsContext aMartianPicDetails){
         
                aMartianPic.setFill(javafx.scene.paint.Color.RED);// set the colour to red
                aMartianPic.fillOval(100, 100, 50, 50);// head
		aMartianPic.fillRect(110, 140, 20, 20); // neck
		aMartianPic.strokeLine(110, 110, 80, 80); // left antennae line
		aMartianPic.strokeLine(140, 110, 180, 80);// right antennae line
	
		
		aMartianPicDetails.setFill(javafx.scene.paint.Color.GRAY);// set the colour to grey
		aMartianPicDetails.fillOval(120, 120, 8, 8);// left eye
		aMartianPicDetails.fillOval(130, 120, 8, 8);// right eye
		aMartianPicDetails.fillOval(78, 78, 10, 10);// left antennae top 
		aMartianPicDetails.fillOval(178, 78, 10, 10);// right antennae top 
                aMartianPic.strokeText("A Martian", 200, 200); 
		
           
   }
}