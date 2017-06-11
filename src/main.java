import java.util.Scanner;

/**
 * Created by BusinessPC on 6/8/2017.
 */
class main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Choose number for lab");
        switch (in.nextInt()){
            case 5: {
                lab5 laba = new lab5();
                laba.solveIt();
                break;
            }
            case 6: {
                lab6 laba = new lab6();
                laba.solveIt();
                break;
            }
            case 7: {
                lab7 laba = new lab7();
                System.out.println("Sum = "+laba.getSum());
                break;
            }
            default: System.out.println("not number of lab");
        }
    }
}
