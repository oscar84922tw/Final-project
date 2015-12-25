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

	void setup() {
		size(1024, 768);
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

	void draw() {

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

	boolean isHit(int ax, int ay, int aw, int ah, int bx, int by, int bw, int bh)
	{
	// Collision x-axis?
    boolean collisionX = (ax + aw >= bx) && (bx + bw >= ax);
    // Collision y-axis?
    boolean collisionY = (ay + ah >= by) && (by + bh >= ay);
    return collisionX && collisionY;
	}

	void keyPressed(){
	  switch(keyCode){
	  	
	    case UP : isMovingUp = true ; println("hi: ");break ;
	    case DOWN : isMovingDown = true ; break ;
	    case LEFT : isMovingLeft = true ; println("LEFT") ;break ;
	    case RIGHT : isMovingRight = true ; println("RIGHT"); break ;
	    default :break ;
	  }
	}
	void keyReleased(){
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

