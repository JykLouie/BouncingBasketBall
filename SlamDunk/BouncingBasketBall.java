package SlamDunk;
import SlamDunk.StdDraw;
import java.awt.Color;

public class BouncingBasketBall {
    public static final String allInt = "0123456789";

    public String solicitNCharsInput(int n) {
        String inputString = "";
        drawFrame(inputString);
        while(inputString.length() < n){
            if(!StdDraw.hasNextKeyTyped()){
                continue;
            }
            char str = StdDraw.nextKeyTyped();
            inputString = inputString + str;
            drawFrame(inputString);
            StdDraw.pause(50);
        }
        return inputString;
    }

    public void drawFrame(String s) {
        StdDraw.clear();
        StdDraw.clear(Color.black);
        StdDraw.setFont();
        StdDraw.setPenColor(Color.white);
        StdDraw.text(512000/2,512000/2,s);
        StdDraw.show();
        }

    public static void main(String args[]){
        BouncingBasketBall world = new BouncingBasketBall();
        boolean entered = false;
        StdDraw.setCanvasSize(1546,980);
        StdDraw.setScale(0,512000);
        StdDraw.setPenColor(Color.white);
        String number = "";
        while(!entered){
            StdDraw.clear(Color.black);
            StdDraw.text(512000/2,512000/2,"Please enter the number of ball you want in the court(An integer!)");
            StdDraw.show();
            StdDraw.pause(3000);
            number = world.solicitNCharsInput(1);
            StdDraw.pause(1000);
            if(allInt.contains(number)){
                entered = true;
            }else{
                continue;
            }
        }
        Integer numofBall = Integer.valueOf(number);
        balls[] ballList = new balls[numofBall];
        for(int i = 0; i < numofBall; i++){
            balls newball = new balls();
            ballList[i] = newball;
        }
        StdDraw.picture(256000, 256000, "court.jpg");
        StdDraw.enableDoubleBuffering();
        StdDraw.show();
        
        while(true){
            StdDraw.clear();
            StdDraw.picture(256000,256000,"court.jpg");
            for(int i = 0; i < numofBall; i++){
                ballList[i].update();
                StdDraw.picture(ballList[i].xpos, ballList[i].ypos, ballList[i].fileName);
            }
            StdDraw.show();
            StdDraw.pause(10);
        }
    }
}
