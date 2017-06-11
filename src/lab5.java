import java.util.Scanner;

/**
 * Created by BusinessPC on 6/11/2017.
 */
public class lab5 {

    lab5(){

    }
    public void solveIt(){
        boolean flag =true;

        while (flag){
            int value=0;
            Scanner in = new Scanner(System.in);
            System.out.println("Singleton - 1");
            System.out.println("Builder - 2");

            try {
                value = in.nextInt();
            }
            catch (Exception e){
                System.out.println(e);
                continue;
            }
            switch (value){
                case 1: testSingleton();
                        break;
                case 2: testBuilder();
                        break;
            }
        }
    }
    private void testSingleton(){
        class LazyInitializedSingleton {

            private LazyInitializedSingleton instance;

            private LazyInitializedSingleton(){}

            public LazyInitializedSingleton getInstance(){
                if(instance == null){
                    instance = new LazyInitializedSingleton();
                }
                return instance;
            }
        }
        LazyInitializedSingleton singleton = new LazyInitializedSingleton();
        System.out.println(singleton.getInstance());
        System.out.println(singleton.getInstance());
    }

    private void testBuilder(){
        //Using builder to get the object in a single line of code and
        //without any inconsistent state or arguments management issues
        Computer comp = new Computer.ComputerBuilder("500 GB", "2 GB").setBluetoothEnabled(true)
                .setGraphicsCardEnabled(true).build();
    }


    }
