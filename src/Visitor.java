/**
 * Created by BusinessPC on 6/11/2017.
 */
public class Visitor {
    public interface ItemElement {

        public int accept(ShoppingCartVisitor visitor);
    }
    public static class Book implements ItemElement {

        private int price;
        private String isbnNumber;

        public Book(int cost, String isbn){
            this.price=cost;
            this.isbnNumber=isbn;
        }

        public int getPrice() {
            return price;
        }

        public String getIsbnNumber() {
            return isbnNumber;
        }

        @Override
        public int accept(ShoppingCartVisitor visitor) {
            return visitor.visit(this);
        }

    }
    public static class Fruit implements ItemElement {

        private int pricePerKg;
        private int weight;
        private String name;

        public Fruit(int priceKg, int wt, String nm){
            this.pricePerKg=priceKg;
            this.weight=wt;
            this.name = nm;
        }

        public int getPricePerKg() {
            return pricePerKg;
        }


        public int getWeight() {
            return weight;
        }

        public String getName(){
            return this.name;
        }

        @Override
        public int accept(ShoppingCartVisitor visitor) {
            return visitor.visit(this);
        }

    }
    public interface ShoppingCartVisitor {

        int visit(Book book);
        int visit(Fruit fruit);
    }
    public static class ShoppingCartVisitorImpl implements ShoppingCartVisitor {

        @Override
        public int visit(Book book) {
            int cost=0;
            //apply 5$ discount if book price is greater than 50
            if(book.getPrice() > 50){
                cost = book.getPrice()-5;
            }else cost = book.getPrice();
            System.out.println("Book ISBN::"+book.getIsbnNumber() + " cost ="+cost);
            return cost;
        }

        @Override
        public int visit(Fruit fruit) {
            int cost = fruit.getPricePerKg()*fruit.getWeight();
            System.out.println(fruit.getName() + " cost = "+cost);
            return cost;
        }

    }
    public static int calculatePrice(ItemElement[] items) {
        ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
        int sum=0;
        for(ItemElement item : items){
            sum = sum + item.accept(visitor);
        }
        return sum;
    }
}
