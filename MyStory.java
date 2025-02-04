import org.code.theater.*;
import org.code.media.*;

public class MyStory extends Scene {

  // Instance Variables
  private String[][] variable1;
  private ImageFilter[][] variable2;
  
  // Constructor
  public MyStory(String[][] variable1, ImageFilter[][] variable2) {
    this.variable1 = variable1;
    this.variable2 = variable2;
  }

  // Calls all the parts of  animation
  public void drawScene() {
     // ImageFilter image = new ImageFilter ("texas.png");

    drawFirstScene();
    drawSecondScene();
  }

//displays white background with text to show the state names before image is shown 
  public void drawFirstScene() {
    clear("white");
    //plays music
    playSound("music.wav");
//gets each name of each state from the array
    drawText(variable1[0][0], 50, 100);
    pause(0.5);
    drawText(variable1[0][1], 250, 100);
    pause(0.5);
    drawText(variable1[1][0], 50, 300);
    pause(0.5);
    drawText(variable1[1][1], 250, 300);

    pause(1.0);

  }
//trial and error process to get to if else statement
  
  /*public void drawSecondScene() {
    clear("white");

    drawImage(variable2[0][0], 0, 0, 200);
    pause(0.5);
    drawImage(variable2[0][1], 200, 0, 200);
    pause(0.5);
    drawImage(variable2[1][0], 0, 200, 200);
    pause(0.5);
    drawImage(variable2[1][1], 200, 200, 200);

    pause(1.0);
  }*/

  //shows next scene with white background and images with filters applied to them 
  public void drawSecondScene() {
    clear("white");
//more trial and error process (for reference)
    // Apply filters to images
   /* variable2[0][0].mirrorVertical(); // Mirror first image
    variable2[0][1].makeNegative();   // use negative filter to second image
    variable2[1][0].darkenImage(80); // Darken third image
    variable2[1][1].threshold(128);   // use threshold filter to fourth image

    drawImage(variable2[0][0], 0, 0, 200);
    pause(0.5);
    drawImage(variable2[0][1], 200, 0, 200);
    pause(0.5);
    drawImage(variable2[1][0], 0, 200, 200);
    pause(0.5);
    drawImage(variable2[1][1], 200, 200, 200);

    pause(1.0);
}*/
   
//goes through each image in order to see which image each filter should be applied to 
    for (int i = 0; i < variable2.length; i++) {
        for (int k = 0; k < variable2[i].length; k++) {
            // Apply different filters based on the position in array
            if (i == 0 && k == 0) {
                variable2[i][k].mirrorVertical();  //applies mirrorVertical to texas
            } else if (i == 0 && k == 1) {
                variable2[i][k].darkenImage(-80);  //applied darkenImage to oregon
            } else if (i == 1 && k == 0) {
                variable2[i][k].threshold(128);    //applies threshold to washington
            } else if (i == 1 && k == 1) {
                variable2[i][k].makeNegative();    //applied makeNegative to nevada
            }

            drawImage(variable2[i][k], k * 200, i * 200, 200);
            pause(0.5);
        }
    }

    pause(1.0);
}
}