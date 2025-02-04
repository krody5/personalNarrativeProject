import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
  public static void main(String[] args) {

    // 2D Array that gets the text displayed 
    String[][] array1 = {
      {"texas", "oregon"},
      {"washington", "nevada"}
    };
//Array that gets the images 
    ImageFilter[][] array2 = {
      { new ImageFilter("texas.png"), new ImageFilter("oregon.png") },
      { new ImageFilter("spaceNeedle.png"), new ImageFilter("lasVegas.png") },
    };

    // MyStory object
    MyStory scene = new MyStory(array1, array2);
    
    // Call drawScene
    scene.drawScene();
    
    // Play scene in Theater
    Theater.playScenes(scene);
    
  }
}
 