package rubixCode.rubixCubeProject;
import java.awt.Color;

public class Cube {
    private double[] xcords;
    private double[] ycords;
    private Color cubeColor;

    public Cube(){
        this.xcords = new double[0];
        this.ycords = new double[0];
        this.cubeColor = Color.BLACK;
    }

    public Cube(double[] x, double[] y){
        this.xcords = x;
        this.ycords = y;
        this.cubeColor = Color.BLACK;
    }

    public Cube(double[] x, double[] y, Color cubeCol){
        this.xcords = x;
        this.ycords = y;
        this.cubeColor = cubeCol;
    }

    public Color getColor(){
        return cubeColor;
    }

    public void setColor(Color cubeCol){
        this.cubeColor = cubeCol;
    }

    public void draw(){
        StdDraw.setPenColor(cubeColor);
        StdDraw.filledPolygon(xcords,ycords);
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.polygon(xcords,ycords);
    }

}
