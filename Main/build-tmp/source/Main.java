import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Main extends PApplet {

PImage archar1,archar2,go,sabertext,saber1,saber2,stage;	//pictures

public void setup() {
		
	archar1 = loadImage("img/ARCHER1.png");
	archar2 = loadImage("img/ARCHER2.png");
	go = loadImage("img/go.png");
	sabertext = loadImage("img/saber.PNG");
	saber1 = loadImage("img/SABER1.png");
	saber2 = loadImage("img/SABER2.png");
	stage = loadImage("img/stage.png");

}

int condition = 1;  //\u72c0\u614b\u5224\u5b9a
public void draw() {
	background(0); // tmp
	// String condition = chooseRole;  //\u72c0\u614b\u5224\u5b9a
	switch (condition) {
		case 0 :
		{	
			//start page
		break;	
		}
		case 1:
		{
		image(archar2,120,60);	
		image(saber1,528,60);
		break;
		}
		case 2:
		{

		break;
		}
		case 3:
		{

		break;
		}
	}

	
		
}
  public void settings() { 	size(1024, 768); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Main" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
