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

class GameState {
	static final int START = 0;
	static final int CHOOSE = 1;
	static final int STAGE1 = 2;
	static final int STAGE2 = 3;
	static final int STAGE3 = 4;
	static final int DIE = 5;
	static final int END = 7;
}

class Direction {
	static final int LEFT = 0;
	static final int RIGHT = 1;
	static final int UP = 2;
	static final int DOWN = 3;
}



boolean leftPressed;
boolean rightPressed;
boolean attack;
boolean shoot;
boolean jump;
boolean[] arrow_appear;

Archer player;
 
int state = GameState.START;
// picture start
PImage start1, start2;
// pictures initial
PImage archar1, archar2, go, sabertext, saber1, saber2, stage, archartext;
//
PImage background1;
// archer
// PImage archerAttack1, archerAttack2, archerWalk1, archerWalk2, arrow;
PImage end1,end2,end3;
PFont myFont;
	
int heroX = 0;
int heroy = 0;
// int speed = 2;
boolean isMovingUp;
boolean isMovingDown;
boolean isMovingLeft;
boolean isMovingRight;

	public void setup() {
		
		player = new Archer();
		start1 = loadImage("img/start/start1.png");
		start2 = loadImage("img/start/start2.png");
		archar1 = loadImage("img/initialHero/ARCHER1.png");
		archar2 = loadImage("img/initialHero/ARCHER2.png");
		go = loadImage("img//initialHero/go.png");
		archartext = loadImage("img/initialHero/archer.PNG");
		sabertext = loadImage("img/initialHero/saber.PNG");
		saber1 = loadImage("img/initialHero/SABER1.png");
		saber2 = loadImage("img/initialHero/SABER2.png");
		// stage = loadImage("img/initialHero/stage.png");
		background1 = loadImage("img/background1.jpg");
		myFont = createFont("W7.TTC", 48);
		end1 = loadImage("img/Die/end1.PNG");
		end2 = loadImage("img/Die/end2.PNG");
		end3 = loadImage("img/Die/end3.PNG");
		textFont(myFont);
	}

	String role;

	public void draw() {

		//Start
		if (state == GameState.START) {
			// start page
			println("status");
			if (mouseX >= 31 && mouseY >= 530) {
				if (mouseX <= 353 && mouseY <= 683) {
					if (mousePressed) { // GameStart
						// fill(255, 40);
						state = GameState.CHOOSE;
					} else {
						background(start2);
					}
				}
			} else {
				background(start1);
			}
		
		//Choose Role
		} else if (state == GameState.CHOOSE) {
			
			// Choose Role Page
			println("fuck");
			background(0);
			
			//Top of text 
			textSize(48);
			String end = "Please Choose Your Hero";
			textMode(CENTER);
			textFont(myFont);
			
			// blink text
			if (frameCount % 30 < 15) {
				fill(0);
			} else {
				fill(255);
			}
			text(end, 230, 50);
			

			// image(saber2, 518, 60, 461, 614);
			// image(archar2, 110, 60, 384, 540);
			image(archartext, 160, 650, 260, 87);
			image(sabertext, 618, 650, 260, 87);

			//click 
			if (mouseX >= 160 && mouseY >= 650) {
				if (mouseX <= 420 && mouseY <= 737) {
					if (mousePressed) {
						state = GameState.STAGE1;
						role = "archer";
					} else {
						image(archar1, 110, 60, 384, 540);
						image(saber2, 518, 60, 461, 614);
					}
				} else {
					image(saber2, 518, 60, 461, 614);
					image(archar2, 110, 60, 384, 540);
				}
			}
			if (mouseX >= 618 && mouseY >= 650) {
				if (mouseX <= 878 && mouseY <= 737) {
					image(saber1, 518, 60, 461, 614);
					image(archar2, 110, 60, 384, 540);
					if (mousePressed) {
						state = GameState.STAGE1;
						role = "saber";
					
				} else {
					
					image(saber2, 518, 60, 461, 614);
					image(archar2, 110, 60, 384, 540);
				}
			}
		}
		} else if (state == GameState.STAGE1) {
				println("hi");
				// Runnung Page
				background(0);
				background(background1);

				if (role == "archer") {
					// image(archerWalk1, heroX, heroy);
					// println("Archer.pde");
					
					player.draw();
					player.attack();

				 } else if (role == "saber") {

				 }

		} else if (state == GameState.STAGE2) {
		

		} else if (state == GameState.STAGE3) {


		} else if (state == GameState.DIE) {
			background(end1);
			if (mouseX >= 267 && mouseY >= 211) {
				if (mouseX <= 741 && mouseY <= 324) {
					image(end3,0,0);
				}else{
					image(end1,0,0);
				}
			}

			if (mouseX >= 267 && mouseY >= 371) {
				if (mouseX <= 733 && mouseY <= 481) {
					image(end2,0,0);
				}else  {
					image(end1,0,0);
				}
				
			}
		} else if (state == GameState.END) {

		}
		
	}

	public boolean isHit(int ax, int ay, int aw, int ah, int bx, int by, int bw, int bh)
	{
	// Collision x-axis?
    boolean collisionX = (ax + aw >= bx) && (bx + bw >= ax);
    // Collision y-axis?
    boolean collisionY = (ay + ah >= by) && (by + bh >= ay);
    return collisionX && collisionY;
	}

	public void keyPressed(){
	  switch(keyCode){
	  	
	    case UP : isMovingUp = true ; println("hi: ");break ;
	    case DOWN : isMovingDown = true ; break ;
	    case LEFT : isMovingLeft = true ; println("LEFT") ;break ;
	    case RIGHT : isMovingRight = true ; println("RIGHT"); break ;
	    default :break ;
	  }
	}
	public void keyReleased(){
	  switch(keyCode){
		case UP : isMovingUp = false ;break ;
	    case DOWN : isMovingDown = false ; break ;
	    case LEFT : isMovingLeft = false ; break ;
	    case RIGHT : isMovingRight = false ; break ;
	    default :break ;
	  }
	  if (key == ' ') {
	  	if (state == GameState.STAGE1) {
			player.attack();
		}
	  }
	  
	}

class Archer {
  PImage[] archerwalk;
PImage archerwalk1 ;

  PImage[] archerattack;
  

  PImage arrow;

  int run_currentPosition;
  int speed = 3;
  int timerw = 0;
  int timerj = 0;
  int timera = 0;
  int timers = 0;
  int ID_arrow = 0;

  int  archerx;
  int  archery;

  boolean walking ;
  int[] arrowx;
  int[] arrowy;
  
  // FlameMgr archerwalk;
  Archer() {
    this.archerwalk = loadImages("img/archer/archer walk",".png",2);
    this.archerwalk1 = loadImage("img/archer/archer walk1.png");
    this.archerattack = loadImages("img/archer/archer attack",".png",2);
    // this.archerattack2 = loadImage("img/archer/archer attack2.png");
    this.arrow = loadImage("img/archer/arrow.png");
    this.archerx = 0;
    this.archery = 470;

  }

  public void draw() {
   		if(!walking){
   			image(archerwalk1,this.archerx,this.archery);
		}
    // }else{
		// 	image(archerwalk2,this.archerx,this.archery);
		// }
		if (isMovingUp) {
			this.move(Direction.UP);
		}
		if (isMovingDown) {
			this.move(Direction.DOWN);	
		}
		if (isMovingLeft) {
			println("hoho"+"+hoho");
			this.move(Direction.LEFT);
		}
		if (isMovingRight) {
			this.move(Direction.RIGHT);	
		}
	} 

    

 public void attack() {
  //   if (attack) {
  //     timera++;
  //     if (timera <= 10) {
  //       image(archerattack1, archerx, archery);
  //     } else if (timera > 10 && timera <= 20) {
  //       image(archerattack2, archerx, archery);
  //     }
  //   }
    
  //   if (timera > 20) {
  //     timera = 0;
  //     attack = false;
  //   }

  //   if (shoot) {
  //     for (int i = 0; i < arrowx.length; i++) {
  //       arrowx[i] += 10;
  //       image(arrow, arrowx[i], arrowy[i]);
  //     }
  //   }
  }

	public void move(int direct) {
		
		switch (direct) {
			case Direction.UP: 
				break;

			case Direction.LEFT:
				
				if (this.archerx - speed > 0) {
					image(archerwalk[run_currentPosition], archerx, archery);
					this.archerx -= speed;
          run_currentPosition += 1;
          if(run_currentPosition >= archerwalk.length){
           run_currentPosition = 0;
          }
					println(archerx);
				}

				walking = false;
				break;
			case Direction.RIGHT:
				// if (this.archerx + speed < width - this.archerwalk.width) {
				// 	this.archerx+= speed;
				// }
				break;
		}
	}
}
//The MIT License (MIT)

//Copyright (c) 2013 Mick Grierson, Matthew Yee-King, Marco Gillies

//Permission is hereby granted, free of charge, to any person obtaining a copy\u2028of this software and associated documentation files (the "Software"), to deal\u2028in the Software without restriction, including without limitation the rights\u2028to use, copy, modify, merge, publish, distribute, sublicense, and/or sell\u2028copies of the Software, and to permit persons to whom the Software is\u2028furnished to do so, subject to the following conditions:
//The above copyright notice and this permission notice shall be included in\u2028all copies or substantial portions of the Software.

//THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR\u2028IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,\u2028FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE\u2028AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER\u2028LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,\u2028OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN\u2028THE SOFTWARE.


public PImage [] loadImages(String stub, String extension, int numImages)
{
  PImage [] images = new PImage[0];
  for(int i =0; i < numImages; i++)
  {
    PImage img = loadImage(stub+i+extension);
    if(img != null)
    {
      images = (PImage [])append(images,img);
    }
    else
    {
      break;
    }
  }
  return images;
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
