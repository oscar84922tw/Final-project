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

void setup() {
	size(1024, 768);	
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

int condition = 0;  //狀態判定

void draw() {
	
	// String condition = chooseRole;  //狀態判定
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
			String end = "                    Congradulations!!\n不論你是Jones老師，\n還是同班的同學們，\n謝謝你們願意玩完他";
			textMode(LEFT);
			
			text(end, 20, 50); 
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

