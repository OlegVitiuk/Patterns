/**
 * Created by BusinessPC on 6/11/2017.
 */
public class Bridge {
    public interface Color {

        public void applyColor();
    }
    public static abstract class Shape {
        //Composition - implementor
        protected Color color;

        //constructor with implementor as input argument
        public Shape(Color c){
            this.color=c;
        }

        abstract public void applyColor();
    }
    public static class Triangle extends Shape{

        public Triangle(Color c) {
            super(c);
        }

        @Override
        public void applyColor() {
            System.out.print("Triangle filled with color ");
            color.applyColor();
        }

    }
    public static class Pentagon extends Shape{

        public Pentagon(Color c) {
            super(c);
        }

        @Override
        public void applyColor() {
            System.out.print("Pentagon filled with color ");
            color.applyColor();
        }

    }
    public static class RedColor implements Color{

        public void applyColor(){
            System.out.println("red.");
        }
    }
    public static class GreenColor implements Color{

        public void applyColor(){
            System.out.println("green.");
        }
    }
}
