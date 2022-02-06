package rubixCode.rubixCubeProject;

import java.awt.Color;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RubixCube {
    //index 0 is the top side, index 1 is the left side, index 2 is the right side
    //3 sides of height 3 and width 3
    private Cube[][][] side1;
    private Cube[][][] side2;
    Set<String> validParameters;

    public RubixCube(){
        this.side1 = new Cube[3][3][3];
        this.side2 = new Cube[3][3][3];
        validParameters = new HashSet<String>();
        validParameters.add("f");
        validParameters.add("f'");
        validParameters.add("r");
        validParameters.add("r'");
        validParameters.add("u");
        validParameters.add("u'");
        validParameters.add("l");
        validParameters.add("l'");
        validParameters.add("b");
        validParameters.add("b'");
        validParameters.add("d");
        validParameters.add("d'");
        StdDraw.setCanvasSize(700, 400);
        StdDraw.setXscale(-200, 500);
        StdDraw.setYscale(-200, 200);
        initializeCube();
        printCube();
    }  

    public boolean rotateCube(String rotationOrientation){
        if(validParameters.contains(rotationOrientation.toLowerCase())){
            Rotate.turn(rotationOrientation,side1,side2);
            return true;
        } else {
            return false;
        }
    }

    public void printCube(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                for(int k = 0; k < 3; k++){
                    side1[i][j][k].draw();
                    side2[i][j][k].draw();
                }
            }
        }
        StdDraw.save("rubixCube.png");
    }

    public void initializeCube(){

        double line = Math.sqrt(Math.pow(129, 2) + Math.pow(129 / Math.sqrt(3), 2));
        for (int i = 0; i < 3; i++){           //face
            for (int j = 0; j < 3; j++){       //column
                for (int k = 0; k < 3; k++){   //row
                    if (i == 0){
                        double xcor[] = {j * 129 / 3 - 129, (j + 1) * 129 / 3 - 129, (j + 1) * 129 / 3 - 129, j * 129 / 3 - 129};
                        double ycor[] = {(129 - j * 129 / 3) / Math.sqrt(3) - k * line / 3, (129 - (j + 1) * 129 / 3) / Math.sqrt(3) - k * line / 3, (129 - (j + 1) * 129 / 3) / Math.sqrt(3) - (k + 1) * line / 3, (129 - j * 129 / 3) / Math.sqrt(3) - (k + 1) * line / 3}; 
                        side1[i][j][k] = new Cube(xcor, ycor, Color.GREEN);
                    }
                    else if (i == 1){
                        double xcor[] = {j * 129 / 3, (j + 1) * 129 / 3, (j + 1) * 129 / 3, j * 129 / 3};
                        double ycor[] = {j * 129 / 3 / Math.sqrt(3) - k * line / 3, (j + 1) * 129 / 3 / Math.sqrt(3)- k * line / 3, (j + 1) * 129 / 3 / Math.sqrt(3) - (k + 1) * line / 3, j * 129 / 3 / Math.sqrt(3) - (k + 1) * line / 3}; 
                        side1[i][j][k] = new Cube(xcor, ycor, Color.RED);
                    }
                    else{
                        double xcor[] = {(j + k) * 129 / 3 - 129, (j + k + 1) * 129 / 3 - 129, (j + k + 2) * 129 / 3 - 129, (j + k + 1) * 129 / 3 - 129};
                        double ycor[] = {j * 129 / 3 / Math.sqrt(3) + line / 2 - k * line / 6, j * 129 / 3 / Math.sqrt(3) + line / 2 - (k - 1) * line / 6, j * 129 / 3 / Math.sqrt(3) + line / 2 - k * line / 6, j * 129 / 3 / Math.sqrt(3) + line / 2 - (k + 1) * line / 6}; 
                        side1[i][j][k] = new Cube(xcor, ycor, Color.WHITE); 
                    }
                }
            }
        }

        for (int i = 0; i < 3; i++){           //face
            for (int j = 0; j < 3; j++){       //column
                for (int k = 0; k < 3; k++){   //row
                    if (i == 0){
                        double xcor[] = {j * 129 / 3 - 129 + 300, (j + 1) * 129 / 3 - 129 + 300, (j + 1) * 129 / 3 - 129 + 300, j * 129 / 3 - 129 + 300};
                        double ycor[] = {-((129 - j * 129 / 3) / Math.sqrt(3) - k * line / 3), -((129 - (j + 1) * 129 / 3) / Math.sqrt(3) - k * line / 3), -((129 - (j + 1) * 129 / 3) / Math.sqrt(3) - (k + 1) * line / 3), -((129 - j * 129 / 3) / Math.sqrt(3) - (k + 1) * line / 3)}; 
                        side2[i][j][k] = new Cube(xcor, ycor, Color.BLUE);
                    }
                    else if (i == 1){
                        double xcor[] = {j * 129 / 3 + 300, (j + 1) * 129 / 3 + 300, (j + 1) * 129 / 3 + 300, j * 129 / 3 + 300};
                        double ycor[] = {-(j * 129 / 3 / Math.sqrt(3) - k * line / 3), -((j + 1) * 129 / 3 / Math.sqrt(3)- k * line / 3), -((j + 1) * 129 / 3 / Math.sqrt(3) - (k + 1) * line / 3), -(j * 129 / 3 / Math.sqrt(3) - (k + 1) * line / 3)}; 
                        side2[i][j][k] = new Cube(xcor, ycor, Color.ORANGE);
                    }
                    else{
                        double xcor[] = {(j + k) * 129 / 3 - 129 + 300, (j + k + 1) * 129 / 3 - 129 + 300, (j + k + 2) * 129 / 3 - 129 + 300, (j + k + 1) * 129 / 3 - 129 + 300};
                        double ycor[] = {-(j * 129 / 3 / Math.sqrt(3) + line / 2 - k * line / 6), -(j * 129 / 3 / Math.sqrt(3) + line / 2 - (k - 1) * line / 6), -(j * 129 / 3 / Math.sqrt(3) + line / 2 - k * line / 6), -(j * 129 / 3 / Math.sqrt(3) + line / 2 - (k + 1) * line / 6)}; 
                        side2[i][j][k] = new Cube(xcor, ycor, Color.YELLOW);
                    }
                }
            }
        }
    }

    public void randomizeCube(){
        Random rand = new Random();
        int upperBound = 12;
        int randomizedNumber;
        for(int i = 0; i < 25; i++){
            randomizedNumber = rand.nextInt(upperBound) + 1;
            switch(randomizedNumber){
                case 1:     rotateCube("f");
                            break;
                case 2:     rotateCube("f'");
                            break;
                case 3:     rotateCube("r");
                            break;
                case 4:     rotateCube("r'");
                            break;
                case 5:     rotateCube("u");
                            break;
                case 6:     rotateCube("u'");
                            break;
                case 7:     rotateCube("l");
                            break;
                case 8:     rotateCube("l'");
                            break;
                case 9:     rotateCube("b");
                            break;
                case 10:    rotateCube("b'");
                            break;
                case 11:    rotateCube("d");
                            break;
                case 12:    rotateCube("d'");
                            break;
            }
        }
    }

    public void test(){
        //String moves[] = {"f", "f'", "r", "r'", "u", "u'", "l", "l'", "b", "b'", "d", "d'"};
        int i = 1;
        do{
            side2[i][0][0].setColor(Color.BLACK);
            side2[i][0][1].setColor(Color.BLUE);
            side2[i][0][2].setColor(Color.CYAN);
            side2[i][1][0].setColor(Color.PINK);
            side2[i][1][1].setColor(Color.GRAY);
            side2[i][1][2].setColor(Color.GREEN);
            side2[i][2][0].setColor(Color.RED);
            side2[i][2][1].setColor(Color.MAGENTA);
            side2[i][2][2].setColor(Color.ORANGE);
        }while(false);
        /*for (int i = 0; i < 3; i++){
            side2[i][0][0].setColor(Color.BLACK);
            side2[i][0][1].setColor(Color.BLUE);
            side2[i][0][2].setColor(Color.CYAN);
            side2[i][1][0].setColor(Color.PINK);
            side2[i][1][1].setColor(Color.GRAY);
            side2[i][1][2].setColor(Color.GREEN);
            side2[i][2][0].setColor(Color.RED);
            side2[i][2][1].setColor(Color.MAGENTA);
            side2[i][2][2].setColor(Color.ORANGE);
        }*/
        printCube();
        StdDraw.pause(10000);
        //for (int i = 0; i < 12; i++){
            rotateCube("u");
            printCube();
            StdDraw.pause(10000);
        //}
    }
}
