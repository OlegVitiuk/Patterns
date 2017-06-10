import jdk.nashorn.internal.runtime.ECMAException;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by BusinessPC on 6/8/2017.
 */
public class lab6 {
    private double x;
    private final int n = 10000;
    private boolean flag = false;

    lab6(){
        while(!flag) {
            try {
                Scanner in = new Scanner(System.in);
                flag = true;
                System.out.print("x = ");
                x = in.nextDouble();
                if (x == 0 || x%BigDecimal.valueOf(Math.PI).setScale(3,BigDecimal.ROUND_HALF_DOWN).doubleValue()==0 || Math.abs(x)>39) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("You have inputed uncorrect number!");
                flag = false;
            }
        }
    }
    private double findCos(double x){
            double t = -x*x/2;
            double sum = 1 + t;
            for(int i=2;i<n;++i)
            {
                t*=-x*x/(2*i*(2*i-1));
                sum+=t;
            }
            return sum;
    }

    private double findZTaylor(){
        return findCos(x+2)/findCos(x+Math.toDegrees(Math.PI/2));
    }

    public void solveIt(){
            System.out.println("y(x) ="+findZTaylor());
            System.out.println("f(x) = "+findCos(x));
    }
}
