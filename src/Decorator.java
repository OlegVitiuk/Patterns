/**
 * Created by BusinessPC on 6/11/2017.
 */
public class Decorator {
    public interface Car {

        public void assemble();
    }
    public static class BasicCar implements Car {

        @Override
        public void assemble() {
            System.out.print("Basic Car.");
        }

    }

    public static class CarDecorator implements Car {

        protected Car car;

        public CarDecorator(Car c){
            this.car=c;
        }

        @Override
        public void assemble() {
            this.car.assemble();
        }

    }
    public static class SportsCar extends CarDecorator {

        public SportsCar(Car c) {
            super(c);
        }

        @Override
        public void assemble(){
            super.assemble();
            System.out.print(" Adding features of Sports Car.");
        }
    }

    public static class LuxuryCar extends CarDecorator {

        public LuxuryCar(Car c) {
            super(c);
        }

        @Override
        public void assemble(){
            super.assemble();
            System.out.print(" Adding features of Luxury Car.");
        }
    }

}
