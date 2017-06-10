import java.util.Scanner;

/**
 * Created by BusinessPC on 6/8/2017.
 */
class main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Choose number for lab");
        switch (in.nextInt()){
            case 5:
                break;
            case 6:
                lab6 laba = new lab6();
                laba.solveIt();
        }
    }
}
