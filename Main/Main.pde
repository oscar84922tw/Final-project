//	pictures initial  
PImage archar1,archar2,go,sabertext,saber1,saber2,stage;	

// 	press initial
boolean upPressed = false, downPressed = false, leftPressed = false, rightPressed = false;

//	hero initial
int heroX = 0; heroy = 0; speed = 0;

void setup() {
	size(1024, 768);	
	archar1 = loadImage("img/ARCHER1.png");
	archar2 = loadImage("img/ARCHER2.png");
	go = loadImage("img/go.png");
	sabertext = loadImage("img/saber.PNG");
	saber1 = loadImage("img/SABER1.png");
	saber2 = loadImage("img/SABER2.png");
	stage = loadImage("img/stage.png");

}

int condition = 1;  //狀態判定
void draw() {
	background(0); // tmp
	// String condition = chooseRole;  //狀態判定
	switch (condition) {
		case 0 :
		{	
			//start page
		break;	
		}
		case 1:
		{
			//Choose Role Page
		image(archar2,120,60);	
		image(saber1,528,60);

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
			// End Page
		break;	
	}

	
		
}
void pressSetting() {
    if (upPressed) {// 按件判別
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

void keyPressed() {
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

void keyReleased() {
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

void keyPress(){

}