import processing.core.PApplet;
import java.util.ArrayList;
public class FourBalls extends PApplet {

    public static final int WIDTH = 1280;
    public static final int HEIGHT = 960;
    public static final int DIAMETER = 10;
    public static final int MAX_COUNT = 4;
    private static ArrayList<FourBalls> balls;
    private int ballX, ballY, incrementUnit;

    public FourBalls() {
        balls = new ArrayList<>();
        for(int i=0; i < MAX_COUNT; i++){
            FourBalls ball = new FourBalls(i);
            balls.add(ball);
        }
    }

    public FourBalls(int index){
        this.ballX = 0;
        this.ballY = (HEIGHT/5)*(index + 1);
        this.incrementUnit = index + 1;
    }

    public static void main(String[] args) {
        FourBalls ball = new FourBalls();
        PApplet.main("FourBalls", args);
    }

    @Override
    public void settings() {
        super.settings();
        size(WIDTH, HEIGHT);
    }

    @Override
    public void draw() {
        for(FourBalls ball : balls) {
            drawBall(ball);
            incrementX(ball);
        }
    }

    private void incrementX(FourBalls ball) {
        ball.ballX += ball.incrementUnit;
    }

    private void drawBall(FourBalls ball) {
        ellipse(ball.ballX, ball.ballY, DIAMETER, DIAMETER);
    }
}