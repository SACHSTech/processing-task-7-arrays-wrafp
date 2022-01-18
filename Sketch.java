import processing.core.PApplet;

public class Sketch extends PApplet {
  // Declaring global variables and arrays
  public int intSize = 400;
  public int intSpeed = 1;
  int indexPosition = 0;
  int[] xPos = new int[25];
  int[] yPos = new int[25];
  int[] snowPile = new int[intSize];
  
  float[] snowFall = new float[intSize];
  

  public void settings() {
    size(intSize, intSize);
  }

  public void setup() {
    // Gives a random value (determines the y-value of each index in snowFall array)
    fill(180, 150);
    for (int i = 0; i < snowFall.length; i++) {
      snowFall[i] = random(height);
    }

    /*
    for (int i = 0; i < intSize; i++) {
      snowPile[i] = intSize;
    }
    */
  }

  public void draw() {
    background(10);

    // Tracks last 25 mouse positions and creates a mouse trail
    xPos[indexPosition] = mouseX;
    yPos[indexPosition] = mouseY;
    indexPosition = (indexPosition + 1) % 25;

    for (int i = 0; i < 25; i++) {
      noStroke();
      int pos = (indexPosition + i) % 25;
      float radius = (25 + i) / 2;
      ellipse(xPos[pos], yPos[pos], radius, radius);
    }

    // Draws the falling snow by iterating through each index of the snowFall array
    for (int i = 0; i < intSize; i++) {
      strokeWeight(2);
      fill(180, 150);
      stroke(180, 150);
      point(i, snowFall[i]);
      snowFall[i] += intSpeed;

      /*
      // Snow fall at x-value will make the snow pile at same x-value taller
      if (snowFall[i] >= snowPile[i]) {
        strokeWeight(1);
        rect(i, snowPile[i], 1, intSize - snowPile[i]);
        snowPile[i]--;
      }
      */

      // When snow reaches the bottom of the screen it resets back to the top
      if (snowFall[i] > height) {
        snowFall[i] = 0;
      } 
    }
  }

  /**
   * Checks for when keyPressed event is triggered, when UP key is detected increases the 
   * speed which the snow falls and when DOWN key is detected decreases the speed of the snow fall.
   */
  public void keyPressed() {
    if (keyCode == UP && intSpeed < 10) {
      intSpeed++;
    }
    else if (keyCode == DOWN && intSpeed > 1) {
      intSpeed--;
    } 
  }

}


  
