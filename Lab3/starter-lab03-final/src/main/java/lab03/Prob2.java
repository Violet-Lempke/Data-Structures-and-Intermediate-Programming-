package lab03; 

 
 

import world.*; 

import image.*; 

 
 
/**
 *Sets the scene for a snowcreature to be built.
 *
 * @author Nat Tuck
 *
 */
public class Prob2 { 
    /**
    *Sets the stage for problem 2 to run.
    *
    *@author Nat Tuck
    *
    *@param args some sweet args
    */
    public static void main(String[] args) { 

        Snowman snowman = Snowman.build(5); 

        //Snowman snowman = Snowman.build(5); 

        var scene = snowman.drawAt(new EmptyScene(800, 600), 300); 

        World.display(scene); 

    } 

} 

 
 
/**
 *Interface setting abstracts for a snowman.
 *
 *@author Nat Tuck
 *
 */
interface Snowman { 
  

    /**
    *A method for creating a snowman.
    *
    *@author Nat Tucl
    *
    * @param height an integer
    *
    * @return a Snowman
    */
    static Snowman build(int height) { 
    
        if (height == 0) { 

            return new Hat(); 

        } 

        else { 

            var top = build(height - 1); 

            return new Ball(top); 

        } 

    } 

 
 
    /**
    *determines the height of a snowman.
    *
    *@author Nat Tuck
    *
    * @return the number 30
    */
    int height(); 

 
 
    /**
    *Creates the image of a snowman.
    *
    *@author Nat Tuck
    *
    * @return the image
    */
    Image image(); 
    /**
    * Draws the scene.
    *
    * @author Nat Tuck
    *
    * @param scene a scene
    *
    * @param yy a coordinate
    * 
    * @return an image 
    */
    Scene drawAt(Scene scene, int yy); 

} 

 
 
/**
 *Holds the information for a hat.
 *
 *@author Nat Tuck
 *
 */
record Hat() implements Snowman { 
    /**
    *Returns the height aka thirty.
    *
    *@author Nat Tuck
    *
    */
    public int height() { 

        return 30; 

    } 

 
 

    @Override 
   
    public Image image() { 

        return new Rectangle(30, 60, "solid", "black"); 

    } 

 
 

    @Override 

    public Scene drawAt(Scene scene, int yy) { 

        return scene.placeImage(this.image(), 400, yy + 8); 

    } 

} 

 
 
/**
 *holds the information for a ball.
 *
 *@author Nat Tuck
 *
 *@param above reprsents something
 *
 */
record Ball(Snowman above) implements Snowman { 
    /**
     *Determines the height of a snowball.
     *
     *@author Nat Tuck
     *
     *@return an integer 
     */
    public int height() { 

        return (int) (1.25 * above.height()); 

    } 

 
 

    @Override 

    public Image image() { 

        return new Circle(this.height() / 2, "outline", "black"); 

    } 

 
 

    @Override 

    public Scene drawAt(Scene scene, int yy) { 

        int dy = (int) (this.height() / 1.33); 

        var scene1 = above.drawAt(scene, yy - dy); 

        return scene1.placeImage(this.image(), 400, yy + dy); 

    } 

} 
