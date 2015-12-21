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

//	picture start
PImage start1,start2;
//	pictures initial  
PImage archar1,archar2,go,sabertext,saber1,saber2,stage,archartext;



PFont myFont;
// 	press initial
boolean upPressed = false, downPressed = false, 
leftPressed = false, rightPressed = false;

//	hero initial
int heroX = 0; 
int heroy = 0; 
int speed = 0;

public void setup() {
		
	start1 = loadImage("img/start/start1.png");
	start2 = loadImage("img/start/start2.png");
	archar1 = loadImage("img/initialHero/ARCHER1.png");
	archar2 = loadImage("img/initialHero/ARCHER2.png");
	go = loadImage("img//initialHero/go.png");
	archartext = loadImage("img/initialHero/archer.PNG");
	sabertext = loadImage("img/initialHero/saber.PNG");
	saber1 = loadImage("img/initialHero/SABER1.png");
	saber2 = loadImage("img/initialHero/SABER2.png");
	stage = loadImage("img/initialHero/stage.png");
	myFont = createFont("W7.TTC",48);
	textFont(myFont);
}

int condition = 0;  //\u72c0\u614b\u5224\u5b9a

public void draw() {
	
	// String condition = chooseRole;  //\u72c0\u614b\u5224\u5b9a
	switch (condition) {
		case 0 :
		{	
			//start page
			if(mouseX >= 31 && mouseY >=530){
				if (mouseX <= 353 && mouseY <=683) {
					if(mousePressed) { //GameStart
						// fill(255, 40);
						condition = 1;
					}else  {
						background(start2);
					}
				}
			}else {
					background(start1);
			}
		break;	
		}
		case 1:
		{
			//Choose Role Page
		background(0); 
		textSize(48);
		String end = "Please Choose Your Hero";
		textMode(CENTER);
		textFont(myFont);
		fill(255);
		text(end, 230, 50); 
		image(saber2,518,60,461,614);
		image(archar2,110,60,384,540);
		image(archartext,160, 650,260,87);
		image(sabertext, 618, 650, 260, 87);		
		
		if(mouseX >= 160 && mouseY >= 650){
			if(mouseX <= 420 && mouseY <= 737){
				image(archar1,110,60,384,540);
				image(saber2,518,60,461,614);
			}else  {
					image(saber2,518,60,461,614);
					image(archar2,110,60,384,540);
			}
		}
		if(mouseX >= 618 && mouseY >= 650){
			if(mouseX <= 878 && mouseY <= 737){
				image(saber1,518,60,461,614);
				image(archar2,110,60,384,540);

			}else {					
					image(saber2,518,60,461,614);
					image(archar2,110,60,384,540);
			}
		}
		break;
		}
		case 2:
		{
			//Runnung Page
		break;
		}
		case 3:
		{
			// Dead Page
		break;
		}
		case 4 :
			textSize(32);
			String end = "                    Congradulations!!\n\u4e0d\u8ad6\u4f60\u662fJones\u8001\u5e2b\uff0c\n\u9084\u662f\u540c\u73ed\u7684\u540c\u5b78\u5011\uff0c\n\u8b1d\u8b1d\u4f60\u5011\u9858\u610f\u73a9\u5b8c\u4ed6";
			textMode(LEFT);
			
			text(end, 20, 50); 
			// End Page
		break;	
	}

	
		
}
public void pressSetting() {
    if (upPressed) {// \u6309\u4ef6\u5224\u5225
      heroy -= speed;
    }
    if (downPressed) {
      heroy += speed;
    }
    if (leftPressed) {
      heroX -= speed;
    }
    if (rightPressed) {
      heroX += speed;
    }

 }

public void keyPressed() {
    if (key == CODED) {
      switch (keyCode) {
      case UP:
        upPressed = true;
        break;
      case DOWN:
        downPressed = true;
        break;
      case LEFT:
        leftPressed = true;
        break;
      case RIGHT:
        rightPressed = true;
        break;
      }
    }

    if (key == ' ' ) {
      //attack
    }
    if (key == 'z') {
      //go to Die    	
    }    
  }

public void keyReleased() {
    if (key == CODED) {
      switch (keyCode) {
      case UP:
        upPressed = false;
        break;
      case DOWN:
        downPressed = false;
        break;
      case LEFT:
        leftPressed = false;
        break;
      case RIGHT:
        rightPressed = false;
        break;
      }
    }
}

public void keyPress(){

}

//	picture poly
PImage poly1,polyHit,polyRun;
//  pictures archer
PImage archerAttack1,archerAttack2,archerWalk1,archerWalk2,arrow;
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
