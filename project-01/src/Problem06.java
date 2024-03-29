import processing.core.*;

public class Problem06 extends PApplet {
    float alpha, beta , delta;
    float posX;
    float posY;
    float drSun, drEarth, drMoon, drVenus;// изменение радиуса
    float radSun, radEarth, radMoon, radVenus;
    float yel;

    public void settings() {
        fullScreen();
    }

    public void setup() {
        frameRate(260);
        radSun = 225f;
        radEarth = 75f;
        radMoon = 25f;
        radVenus = 50f;
        posX = 1300;
        posY = 35;
        drSun = radSun / 255f;
        drEarth = radEarth / 255f;
        drMoon = radMoon / 255f;
        drVenus = radVenus / 255f;
        yel = 0;

    }

    public void draw() {
        background(0, 0, 0);
        stroke(255, 255, 255);
        strokeWeight(1);
        fill(0, 0, 255);
        rect(posX, posY, 200, 50);
        rect(posX, posY + 48, 200, 50);
        rect(posX, posY + 2 * 48, 200, 50);
        rect(posX, posY + 3 * 47, 200, 50);
        noStroke();
        textSize(30);
        fill(255, 255, 255);
        text("Sun", posX + 70, posY + 35);
        text("Venus", posX + 70, posY + 85);
        text("Earth", posX + 70, posY + 135);
        text("Moon", posX + 70, posY + 185);

        if (mouseX >= posX && mouseX <= posX + 200 && mouseY >= posY && mouseY <= posY + 48) {
            fill(255, 0, 0);
            text("Sun", posX + 70, posY + 35);
            noFill();
            pushMatrix();
            translate( width / 2f , height / 2f);
            stroke(255,0 , 0);
            circle(0,0 , 225);
            noFill();
            noStroke();
            popMatrix();

        } else if (mouseX >= posX && mouseX <= posX + 200 && mouseY >= posY + 48 && mouseY <= posY + 2 * 48) {
            fill(255, 0, 0);
            stroke(255, 0, 0);
            text("Venus", posX + 70, posY + 85);
            noFill();
            noStroke();
            pushMatrix();
            translate(width / 2f, height / 2f);
            rotate(alpha);
            stroke(255, 0 ,0);
            circle(200,15 ,75);
            circle(0, 0, 400);
            noStroke();
            alpha += 0.07f;
            popMatrix();

        } else if (mouseX >= posX && mouseX <= posX + 200 && mouseY >= posY + 2 * 48 && mouseY <= posY + 3 * 48) {
            fill(255, 0, 0);
            text("Earth", posX + 70, posY + 135);
            noStroke();
            noFill();
            pushMatrix();
            translate(width / 2f, height / 2f);
            stroke(255,0 ,0 );
            circle(0 , 0 , 725);
            rotate(alpha);
            circle(300 , -200 ,95);
            noStroke();
            popMatrix();

        } else if (mouseX >= posX && mouseX <= posX + 200 && mouseY >= posY + 3 * 48 && mouseY <= posY + 4 * 48) {
            fill(255, 0, 0);
            text("Moon", posX + 70, posY + 185);
            noFill();
            noStroke();
            pushMatrix();
            translate(width / 2f , height / 2f);
            rotate(alpha);
            stroke(255, 0 ,0);
            circle(300 , -200 ,160);
            translate(300 , -200);
            rotate(beta);
            stroke(255,0 ,0);
            circle(-75 , 0 ,50);
            noStroke();
            popMatrix();
        }

        pushMatrix();

        translate(width / 2f, height / 2f);
        drawSun(0, 0, 255, 255, 0, 225);

        rotate(alpha);
        drawVenus(48, 213, 200, 200, 0, 75);
        translate(300, -200);
        drawEarth(0, 0, 100);
        rotate(beta);
        drawMoon(-75, 0, 220, 220, 220, 50);

        alpha += 0.1f;
        beta += 0.14f;
        popMatrix();
    }

    public static void main(String[] args) {
        PApplet.main("Problem06");
    }

    public void drawVenus(int cR, int cG, int cB, int x, int y, int r) {
        float dr = r / 255f;
        for (int i = 0; i < 255; i++) {
            fill(cR, cG, cB, 10);
            circle(x, y, r);
            cR++;
            cG++;
            cB++;
            r -= dr;
        }
    }

    public void drawEarth(int x, int y, int r) {
        float dr = r / 255f;
        float cB = 200;
        for (int i = 0; i < 255; i++) {
            fill(0, 0, cB, 10);
            circle(x, y, r);
            cB++;
            r -= dr;
        }
    }

    public void drawSun(int x, int y, int cR, int cG, int cB, int r) {
        float dr = r / 255f;
        for (int i = 0; i < 255; i++) {
            fill(cR, cG, cB, 10);
            circle(x, y, r);
            cB++;
            cR++;
            cG++;
            r -= dr;
        }
    }
    public void drawMoon(int x, int y, int cR, int cG, int cB, int r) {
        float dr = r / 255f;
        for (int i = 0; i < 255; i++) {
            fill(cR, cG, cB, 10);
            circle(x, y, r);
            cR++;
            cG++;
            cB++;
            r -= dr;
        }
    }
}
