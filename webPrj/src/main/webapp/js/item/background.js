export default class Background{
    constructor(y){
        this.y = y || 1200-700/3; //canvas.height
        this.y1 = this.y;
        this.speed = 1;
        
        this.img = new Image();
        this.img.src = '../../image/space.jpg';

    }
    draw(ctx){
        ctx.drawImage(this.img, 
            0, this.y, 360, 1200,
            0, 0, 360*3, 1200*3);
        ctx.drawImage(this.img, 
            0, this.y+1200, 360, 1200,
            0, 0, 360*3, 1200*3);
    }
    update(){
        this.y = this.y - this.speed;
        if(this.y <= -1200){
            this.y = 0;
        }
    }
    setSpeed(speed){
        this.speed = speed;
    }
}