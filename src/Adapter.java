/**
 * Created by BusinessPC on 6/11/2017.
 */
public class Adapter {
    public static class Volt {

        private int volts;

        public Volt(int v){
            this.volts=v;
        }

        public int getVolts() {
            return volts;
        }

        public void setVolts(int volts) {
            this.volts = volts;
        }

    }

    public static class Socket {

        public Volt getVolt(){
            return new Volt(120);
        }
    }

    public interface SocketAdapter {

        public Volt get120Volt();

        public Volt get12Volt();

        public Volt get3Volt();
    }

    public static class SocketClassAdapterImpl extends Socket implements SocketAdapter{

        @Override
        public Volt get120Volt() {
            return getVolt();
        }

        @Override
        public Volt get12Volt() {
            Volt v= getVolt();
            return convertVolt(v,10);
        }

        @Override
        public Volt get3Volt() {
            Volt v= getVolt();
            return convertVolt(v,40);
        }

        private Volt convertVolt(Volt v, int i) {
            return new Volt(v.getVolts()/i);
        }
    }

    public static Volt getVolt(SocketAdapter sockAdapter, int i) {
            switch (i){
                case 3: return sockAdapter.get3Volt();
                case 12: return sockAdapter.get12Volt();
                case 120: return sockAdapter.get120Volt();
                default: return sockAdapter.get120Volt();
            }
    }

}
