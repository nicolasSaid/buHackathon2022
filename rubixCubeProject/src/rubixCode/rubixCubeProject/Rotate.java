package rubixCode.rubixCubeProject;
import java.awt.Color;

public class Rotate{

    public static void transpose(Cube[][] data){
        for (int i = 0; i < data.length; i++){
            for (int j = i; j < data.length; j++){
                Color temp = data[i][j].getColor();
                data[i][j].setColor(data[j][i].getColor());
                data[j][i].setColor(temp);
            }
        }
    }

    public static void reverseColumns(Cube[][] data){
        for (int i = 0; i < data.length; i++){
            Color temp = data[0][i].getColor();
            data[0][i].setColor(data[2][i].getColor());
            data[2][i].setColor(temp);    
        }
    }

    public static void shift(Cube[] one, Cube[] two, Cube[] three, Cube[] four, boolean reverse){   //if its anticlockwise, add 2 to the side numbers when calling function
        if (!reverse){
            for(int i = 0; i < one.length; i++){
                Color temp = four[i].getColor();
                four[i].setColor(three[i].getColor());
                three[i].setColor(two[i].getColor());
                two[i].setColor(one[i].getColor());
                one[i].setColor(temp);
            }
        }
        else{
            for(int i = 0; i < one.length; i++){
                Color temp = four[i].getColor();
                four[i].setColor(one[i].getColor());
                one[i].setColor(two[i].getColor());
                two[i].setColor(three[i].getColor());
                three[i].setColor(temp);
            }
        }
    }

    public static void turn(String input, Cube[][][] data1, Cube[][][] data2){
        
        if (input.equalsIgnoreCase("f")){
            transpose(data1[0]);
            reverseColumns(data1[0]);
            shift(data1[2][0], data1[1][0], data2[2][2], data2[1][2], false);
        }
        else if (input.equalsIgnoreCase("f'")){
            for (int i = 0; i < 3; i++){
                transpose(data1[0]);
                reverseColumns(data1[0]);
            }
            shift(data2[2][2], data2[1][2], data1[2][0], data1[1][0], true);
        }

        else if (input.equalsIgnoreCase("r")){
            transpose(data1[1]);
            reverseColumns(data1[1]);
            Cube custom1[] = {data1[2][2][2], data1[2][1][2], data1[2][0][2]};
            Cube custom2[] = {data2[2][2][0], data2[2][1][0], data2[2][0][0]};
            shift(custom1, data2[0][0], custom2, data1[0][2], false);        
        }
        else if (input.equalsIgnoreCase("r'")){
            for (int i = 0; i < 3; i++){
                transpose(data1[1]);
                reverseColumns(data1[1]);
            }
            Cube custom1[] = {data1[2][2][2], data1[2][1][2], data1[2][0][2]};
            Cube custom2[] = {data2[2][2][0], data2[2][1][0], data2[2][0][0]};
            shift(custom2, data1[0][2], custom1, data2[0][0], true);
        }

        else if (input.equalsIgnoreCase("u")){
            transpose(data1[2]);
            reverseColumns(data1[2]);
            Cube custom1[] = {data2[0][0][2], data2[0][1][2], data2[0][2][2]};
            Cube custom2[] = {data1[1][0][0], data1[1][1][0], data1[1][2][0]};
            Cube custom3[] = {data1[0][0][0], data1[0][1][0], data1[0][2][0]};
            Cube custom4[] = {data2[1][0][2], data2[1][1][2], data2[1][2][2]};
            shift(custom1, custom2, custom3, custom4, false);
        }
        else if (input.equalsIgnoreCase("u'")){
            for (int i = 0; i < 3; i++){
                transpose(data1[2]);
                reverseColumns(data1[2]);
            }
            Cube custom1[] = {data2[0][0][2], data2[0][1][2], data2[0][2][2]};
            Cube custom2[] = {data1[1][0][0], data1[1][1][0], data1[1][2][0]};
            Cube custom3[] = {data1[0][0][0], data1[0][1][0], data1[0][2][0]};
            Cube custom4[] = {data2[1][0][2], data2[1][1][2], data2[1][2][2]};
            shift(custom3, custom4, custom1, custom2, true);
        }
 
        else if (input.equalsIgnoreCase("l")){
            transpose(data2[1]);
            reverseColumns(data2[1]);
            Cube custom1[] = {data1[2][2][0], data1[2][1][0], data1[2][0][0]};
            Cube custom2[] = {data2[2][2][2], data2[2][1][2], data2[2][0][2]};
            shift(custom1, data1[0][0], custom2, data2[0][2], false);
        }
        else if (input.equalsIgnoreCase("l'")){
            for (int i = 0; i < 3; i++){
                transpose(data2[1]);
                reverseColumns(data2[1]);
            }
            Cube custom1[] = {data1[2][2][0], data1[2][1][0], data1[2][0][0]};
            Cube custom2[] = {data2[2][2][2], data2[2][1][2], data2[2][0][2]};
            shift(custom2, data2[0][2], custom1, data1[0][0], true);
        }

        else if (input.equalsIgnoreCase("b")){
            transpose(data2[0]);
            reverseColumns(data2[0]);
            shift(data1[2][2], data1[1][2], data2[2][0], data2[1][0], false);
        }
        else if (input.equalsIgnoreCase("b'")){
            for (int i = 0; i < 3; i++){
                transpose(data2[0]);
                reverseColumns(data2[0]);
            }
            shift(data2[2][0], data2[1][0], data1[2][2], data1[1][2], true);
        }

        else if (input.equalsIgnoreCase("d")){
            transpose(data2[2]);
            reverseColumns(data2[2]);
            Cube custom1[] = {data2[0][0][0], data2[0][1][0], data2[0][2][0]};
            Cube custom2[] = {data1[1][0][2], data1[1][1][2], data1[1][2][2]};
            Cube custom3[] = {data1[0][0][2], data1[0][1][2], data1[0][2][2]};
            Cube custom4[] = {data2[1][0][0], data2[1][1][0], data2[1][2][0]};
            shift(custom1, custom2, custom3, custom4, false);
        }
        else if (input.equalsIgnoreCase("d'")){
            for (int i = 0; i < 3; i++){
                transpose(data2[2]);
                reverseColumns(data2[2]);
            }
            Cube custom1[] = {data2[0][0][0], data2[0][1][0], data2[0][2][0]};
            Cube custom2[] = {data1[1][0][2], data1[1][1][2], data1[1][2][2]};
            Cube custom3[] = {data1[0][0][2], data1[0][1][2], data1[0][2][2]};
            Cube custom4[] = {data2[1][0][0], data2[1][1][0], data2[1][2][0]};
            shift(custom3, custom4, custom1, custom2, true);
        }
    }
}