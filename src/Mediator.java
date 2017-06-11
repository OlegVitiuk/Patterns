import java.util.ArrayList;
import java.util.List;

/**
 * Created by BusinessPC on 6/11/2017.
 */
public class Mediator {
    public interface ChatMediator {

        public void sendMessage(String msg, User user);

        void addUser(User user);
    }

    public static abstract class User {
        protected ChatMediator mediator;
        protected String name;

        public User(ChatMediator med, String name){
            this.mediator=med;
            this.name=name;
        }

        public abstract void send(String msg);

        public abstract void receive(String msg);
    }
    public static class ChatMediatorImpl implements ChatMediator {

        private List<User> users;

        public ChatMediatorImpl(){
            this.users=new ArrayList<>();
        }

        @Override
        public void addUser(User user){
            this.users.add(user);
        }

        @Override
        public void sendMessage(String msg, User user) {
            for(User u : this.users){
                //message should not be received by the user sending it
                if(u != user){
                    u.receive(msg);
                }
            }
        }
    }
    public static class UserImpl extends User {

        public UserImpl(ChatMediator med, String name) {
            super(med, name);
        }

        @Override
        public void send(String msg){
            System.out.println(this.name+": Sending Message="+msg);
            mediator.sendMessage(msg, this);
        }
        @Override
        public void receive(String msg) {
            System.out.println(this.name+": Received Message:"+msg);
        }

    }

}
