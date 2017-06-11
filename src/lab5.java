import java.util.ArrayList;
import java.util.List;
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
            System.out.println("\n\nCreational Design Patterns");
            System.out.println("Singleton - 1");
            System.out.println("Builder - 2");
            System.out.println("Prototype - 3");
            System.out.println("\nStructural Design Patterns");
            System.out.println("Adapter - 4");
            System.out.println("Decorator - 5");
            System.out.println("Bridge - 6");
            System.out.println("\nBehavioral Design Patterns");
            System.out.println("Mediator - 7");
            System.out.println("Visitor - 8");
            System.out.println("Iterator - 9\n");
            System.out.println("Exit - 10");

            try {
                value = in.nextInt();
            }
            catch (Exception e){
                System.out.println("You have chosen uncorrect number!");
                continue;
            }
            switch (value){
                case 1: testSingleton();
                        break;
                case 2: testBuilder();
                        break;
                case 3: testPrototype();
                        break;
                case 4: testAdapter();
                        break;
                case 5: testDecorator();
                        break;
                case 6: testBridge();
                        break;
                case 7: testMediator();
                        break;
                case 8: testVisitor();
                        break;
                case 9: testIterator();
                        break;
                case 10: flag=false;
                        break;
                default: System.out.println("You have choosen uncorrect number!");
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
        System.out.println("HDD "+comp.getHDD()+ " "+ "RAM "+ comp.getRAM()+" "+
        "BluetoothEnabled "+comp.isBluetoothEnabled()+" "+"GraphicsCardEnabled "+comp.isGraphicsCardEnabled());
    }

    private void testPrototype(){
        class Employees implements Cloneable{

            private List<String> empList;

            public Employees(){
                empList = new ArrayList<String>();
            }

            public Employees(List<String> list){
                this.empList=list;
            }
            public void loadData(){
                //read all employees from database and put into the list
                empList.add("Pankaj");
                empList.add("Raj");
                empList.add("David");
                empList.add("Lisa");
            }

            public List<String> getEmpList() {
                return empList;
            }

            @Override
            public Object clone() throws CloneNotSupportedException{
                List<String> temp = new ArrayList<String>();
                for(String s : this.getEmpList()){
                    temp.add(s);
                }
                return new Employees(temp);
            }

        }

        Employees emps = new Employees();
        Employees empsNew =null;
        Employees empsNew1=null;
        emps.loadData();
        try {
            //Use the clone method to get the Employee object
            empsNew = (Employees) emps.clone();
            empsNew1 = (Employees) emps.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        List<String> list = empsNew.getEmpList();
        list.add("John");
        List<String> list1 = empsNew1.getEmpList();
        list1.remove("Pankaj");


        System.out.println("emps List: "+emps.getEmpList());
        System.out.println("empsNew List: "+list);
        System.out.println("empsNew1 List: "+list1);
    }

    private void testAdapter(){
        Adapter.SocketAdapter sockAdapter = new Adapter.SocketClassAdapterImpl();
        Adapter.Volt v3 = Adapter.getVolt(sockAdapter,3);
        Adapter.Volt v12 = Adapter.getVolt(sockAdapter,12);
        Adapter.Volt v120 = Adapter.getVolt(sockAdapter,120);
        System.out.println("v3 volts using Class Adapter="+v3.getVolts());
        System.out.println("v12 volts using Class Adapter="+v12.getVolts());
        System.out.println("v120 volts using Class Adapter="+v120.getVolts());
    }

    private void testDecorator(){
        Decorator.Car sportsCar = new Decorator.SportsCar(new Decorator.BasicCar());
        sportsCar.assemble();
        System.out.println("\n*****");

        Decorator.Car sportsLuxuryCar = new Decorator.SportsCar(new Decorator.LuxuryCar(new Decorator.BasicCar()));
        sportsLuxuryCar.assemble();
    }

    private void testBridge(){
        Bridge.Shape tri = new Bridge.Triangle(new Bridge.RedColor());
        tri.applyColor();

        Bridge.Shape pent = new Bridge.Pentagon(new Bridge.GreenColor());
        pent.applyColor();
    }

    private void testMediator(){
        Mediator.ChatMediator mediator = new  Mediator.ChatMediatorImpl();
        Mediator.User user1 = new  Mediator.UserImpl(mediator, "Pankaj");
        Mediator.User user2 = new  Mediator.UserImpl(mediator, "Lisa");
        Mediator.User user3 = new  Mediator.UserImpl(mediator, "Saurabh");
        Mediator.User user4 = new  Mediator.UserImpl(mediator, "David");
        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);
        mediator.addUser(user4);

        user1.send("Hi All");
    }

    private void testVisitor(){
        Visitor.ItemElement[] items = new Visitor.ItemElement[]{new Visitor.Book(20, "1234"),new Visitor.Book(100, "5678"),
                new Visitor.Fruit(10, 2, "Banana"), new Visitor.Fruit(5, 5, "Apple")};

        int total = Visitor.calculatePrice(items);
        System.out.println("Total Cost = "+total);
    }

    private void testIterator(){
        Iterator.ChannelCollection channels = Iterator.populateChannels();
        Iterator.ChannelIterator baseIterator = channels.iterator(Iterator.ChannelTypeEnum.ALL);
        while (baseIterator.hasNext()) {
            Iterator.Channel c = baseIterator.next();
            System.out.println(c.toString());
        }
        System.out.println("******");
        // Channel Type Iterator
        Iterator.ChannelIterator englishIterator = channels.iterator(Iterator.ChannelTypeEnum.ENGLISH);
        while (englishIterator.hasNext()) {
            Iterator.Channel c = englishIterator.next();
            System.out.println(c.toString());
        }
    }
    }
