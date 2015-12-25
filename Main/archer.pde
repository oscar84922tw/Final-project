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

  void draw() {
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

    

 void attack() {
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

	void move(int direct) {
		
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