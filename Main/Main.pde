PImage archar1,archar2,go,sabertext,saber1,saber2,stage;	//pictures

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