import org.code.theater.*;
import org.code.media.*;

public class ImageFilter extends ImagePlus {

  public ImageFilter (String filename){
    super(filename);
  }
  

  //makes image into a negative hue
 public void makeNegative() {

Pixel [] [] pixels = getImagePixels ();
    for (int row= 0; row<pixels.length; row++){
          for (int col= 0; col<pixels[row].length; col++){
            Pixel currentPixel = pixels [row][col];

            int red = 255 - currentPixel.getRed();
            int blue = 255 - currentPixel.getBlue();
            int green = 255 - currentPixel.getGreen();

            currentPixel.setColor (new Color (red, green, blue)); 

    }
    }
    }
  
//mirrors image to make both sides symmetric 
 public void mirrorVertical() {
   
Pixel [] [] pixels = getImagePixels ();
    for (int row= 0; row<pixels.length; row++){
          for (int col= 0; col<pixels[row].length/2; col++){
            Pixel leftPixel = pixels [row][col];
           int rightIndex = pixels [row].length-1 - col;
            Pixel rightPixel = pixels[row][rightIndex];
            Color rightColor = rightPixel.getColor();
           leftPixel.setColor(rightColor);
            
    
  }
    }
 }
  //makes an image high contrast and black and white 
   public void threshold(int value) {
    
Pixel [] [] pixels = getImagePixels ();
    for (int row= 0; row<pixels.length; row++){
          for (int col= 0; col<pixels[row].length; col++){
            Pixel currentPixel = pixels [row][col];
int red = currentPixel.getRed();
int green = currentPixel.getGreen();            
int blue = currentPixel.getBlue();

      int average = (red+green+blue) / 3;

            if (average < value) {
              currentPixel.setColor (Color.BLACK);
            } else  
              currentPixel.setColor (Color.WHITE);
            }


    }
}
//filter for reference (not used in presentation)
/*public void keepColor(String color){
  Pixel[][] pixels = getImagePixels();
  for(int row = 0; row< pixels.length; row++){
      for(int col = 0; col< pixels[0].length; col++){
        Pixel currentPixel = pixels[row][col];
       if(color.equals("red")){
         currentPixel.setGreen(0);
         currentPixel.setBlue(0);
       } else if(color.equals("blue")){
          currentPixel.setGreen(0);
         currentPixel.setRed(0);
       } else if(color.equals("green")){
          currentPixel.setRed(0);
         currentPixel.setBlue(0);
       }
    }
  }
}*/

//darkens image when a negative int amount is declared 
  public void darkenImage (int amount){
    Pixel [] [] pixels = getImagePixels ();
    for (int row= 0; row<pixels.length; row++){
          for (int col= 0; col<pixels[row].length; col++){
      int red = pixels [row][col].getRed () + amount; 
      int green = pixels [row][col].getGreen()+amount;
      int blue = pixels [row][col].getBlue()+amount;

      pixels[row][col].setRed(red);
      pixels[row][col].setGreen(green);
      pixels[row][col].setBlue(blue);


  }
}
  }
}
