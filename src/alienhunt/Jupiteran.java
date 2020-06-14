/*
 * W20- Java Intermediate
 * Final Assignment
 * and open the template in the editor.
 */
package alienhunt;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;


/**
 * Jupiteran class = Supplies an extended version of the Alien constructor which sets the constructor's required
 * arguments for Jupiteran. Includes a draw() method which receives GraphicContexts and uses its methods to which draws a 
 * Jupiteran using x, y coordinates, lines, ovals and rectangles and the draw method also uses the strokeText() method to label the drawing as a Jupiteran.
 * 
 * @author Kerry Nelson Milovic
 * @version 2.0
 * @since 2020-04-21
 */
public class Jupiteran extends Alien {

    /**
     * Jupiteran() constructor = Supplies an extended version of the Alien constructor which sets the
     * constructor's required arguments for Jupiteran.
     *
     * @param typeID String stating the name of the alien
     * @param homePlanet String stating the planet the alien calls home
     * @param typeName String stating the name of the alien
     * @param numberEyes Integer representing the number of eyes
     */
    
	public Jupiteran(int typeID, String homePlanet, String typeName, int numberEyes) {
		super(1, "Jupiter", "Jupiteran", 3);
		// 
	}
        
    /**
     * draw()method = receives GraphicContexts and uses its methods to draw a Jupiteran using x, y coordinates, lines, ovals and
    * rectangles and the strokeText() method to label the drawing as aJupiteran.
     *
     *
     * @param aJupiteranPic GraphicContext to draw onto canvas2
     * @param aJupiteranPicDetails GraphicContext to draw onto canvas2
     */
       public void draw(GraphicsContext aJupiteranPic, GraphicsContext aJupiteranPicDetails){
		 		aJupiteranPic.setFill(javafx.scene.paint.Color.GREEN); // set the colour to green
				aJupiteranPic.fillOval(200, 100, 50, 50); // head
				aJupiteranPic.fillRect(210, 140, 20, 20); // neck
		 		// main Jupiteran parts
		 		
		 		
		 		aJupiteranPic.setFill(javafx.scene.paint.Color.GRAY);
		 		aJupiteranPicDetails.fillOval(212, 120, 8, 8);// left eye
		 		aJupiteranPicDetails.fillOval(225, 120, 8, 8);// middle eye
		 		aJupiteranPicDetails.fillOval(238, 120, 8, 8);// right eye
		 		aJupiteranPic.strokeText("A Jupiteran", 200, 200); 
		 		// details of the Jupiteran and the description "A Jupiteran" 
			
        }
    /**
    * drawEnd()method = receives GraphicContexts and uses its methods to draw a Jupiteran using x, y coordinates, lines, ovals, a
    * rectangle and arcs to the draw a full picture of a Jupiteran's head and body. 
    *
    *
     * @param endGamePic GraphicContext to draw onto canvas3
     * @param endGamePicDetails GraphicContext to draw onto canvas3
    */
              public void drawEnd(GraphicsContext endGamePic, GraphicsContext endGamePicDetails){
		 		endGamePic.setFill(javafx.scene.paint.Color.GREEN); // set the colour to green
				endGamePic.fillOval(200, 100, 50, 50); // head
				endGamePic.fillRect(210, 140, 20, 20); // neck
                                endGamePic.fillOval(190, 155, 70, 100); //body
         
                               
		 		// main Jupiteran parts of second Jupiteran
		 		
		 		
		 		endGamePicDetails.setFill(javafx.scene.paint.Color.GRAY);
		 		endGamePicDetails.fillOval(212, 120, 8, 8);// left eye
		 		endGamePicDetails.fillOval(225, 120, 8, 8);// middle eye
		 		endGamePicDetails.fillOval(238, 120, 8, 8);// right eye
                                endGamePicDetails.fillOval(185, 245, 30, 30);// left foot
                                endGamePicDetails.fillOval(215, 245, 30, 30);// right foot
                        
                                endGamePicDetails.fillArc(180, 180, 30, 30, 45, 240, ArcType.ROUND);
                                endGamePicDetails.fillArc(200, 180, 30, 30, 45, 240, ArcType.ROUND);
                                endGamePicDetails.fillArc(220, 180, 30, 30, 45, 240, ArcType.ROUND);
                                endGamePicDetails.fillArc(240, 180, 30, 30, 45, 240, ArcType.ROUND);
                                
                                
                                // detailed Jupiteran parts of second Jupiteran
                                
                                
                                
                                
                                
			
        }

}