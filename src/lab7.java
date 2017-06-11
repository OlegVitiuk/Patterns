import java.util.Random;
import java.util.Scanner;

/**
 * Created by BusinessPC on 6/10/2017.
 */
public class lab7 {
    private int n;
    private boolean flag=false;
    private int[][] matrix;
    private int sum;

    lab7(){
        sum=0;
        while(!flag) {
            try {
                Scanner in = new Scanner(System.in);
                flag = true;
                System.out.print("n = ");
                n=in.nextInt();
                if(n>100 || n<2){
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("You have inputed uncorrect number!");
                flag = false;
            }
        }
        matrix = new int[n][n];
        generateMatrix();
    }

    private final void generateMatrix(){
        Random rand = new Random();

        for (int i=0,leftItem=0,rightItem=n-1;i<n;i++,leftItem++,rightItem--){
            for (int j=0;j<n;j++){
                int valueToInsert = rand.nextInt(9) + 0;
                matrix[i][j] =valueToInsert;
                if(i==leftItem && j==rightItem || i==j) {
                    if(leftItem==rightItem) sum += matrix[i][j]*2;
                    else sum += matrix[i][j];
                }
            }
        }
    }
    private final void displayMatrix(){
        for (int []i:matrix) {
            for (int j:i) {
                    System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    public final double getSum(){
        displayMatrix();
        return sum;
    }
}
