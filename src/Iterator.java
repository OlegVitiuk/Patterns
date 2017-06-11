import java.util.ArrayList;
import java.util.List;

/**
 * Created by BusinessPC on 6/11/2017.
 */
public class Iterator {
    public enum ChannelTypeEnum {

        ENGLISH, HINDI, FRENCH, ALL;
    }
    public static class Channel {

        private double frequency;
        private ChannelTypeEnum TYPE;

        public Channel(double freq, ChannelTypeEnum type){
            this.frequency=freq;
            this.TYPE=type;
        }

        public double getFrequency() {
            return frequency;
        }

        public ChannelTypeEnum getTYPE() {
            return TYPE;
        }

        @Override
        public String toString(){
            return "Frequency="+this.frequency+", Type="+this.TYPE;
        }

    }
    public interface ChannelCollection {

        public void addChannel(Channel c);

        public void removeChannel(Channel c);

        public ChannelIterator iterator(ChannelTypeEnum type);

    }
    public interface ChannelIterator {

        public boolean hasNext();

        public Channel next();
    }
    public static class ChannelCollectionImpl implements ChannelCollection {

        private List<Channel> channelsList;

        public ChannelCollectionImpl() {
            channelsList = new ArrayList<>();
        }

        public void addChannel(Channel c) {
            this.channelsList.add(c);
        }

        public void removeChannel(Channel c) {
            this.channelsList.remove(c);
        }

        @Override
        public ChannelIterator iterator(ChannelTypeEnum type) {
            return new ChannelIteratorImpl(type, this.channelsList);
        }

        private class ChannelIteratorImpl implements ChannelIterator {

            private ChannelTypeEnum type;
            private List<Channel> channels;
            private int position;

            public ChannelIteratorImpl(ChannelTypeEnum ty,
                                       List<Channel> channelsList) {
                this.type = ty;
                this.channels = channelsList;
            }

            @Override
            public boolean hasNext() {
                while (position < channels.size()) {
                    Channel c = channels.get(position);
                    if (c.getTYPE().equals(type) || type.equals(ChannelTypeEnum.ALL)) {
                        return true;
                    } else
                        position++;
                }
                return false;
            }

            @Override
            public Channel next() {
                Channel c = channels.get(position);
                position++;
                return c;
            }

        }
    }
    public static ChannelCollection populateChannels() {
        ChannelCollection channels = new ChannelCollectionImpl();
        channels.addChannel(new Channel(98.5, ChannelTypeEnum.ENGLISH));
        channels.addChannel(new Channel(99.5, ChannelTypeEnum.HINDI));
        channels.addChannel(new Channel(100.5, ChannelTypeEnum.FRENCH));
        channels.addChannel(new Channel(101.5, ChannelTypeEnum.ENGLISH));
        channels.addChannel(new Channel(102.5, ChannelTypeEnum.HINDI));
        channels.addChannel(new Channel(103.5, ChannelTypeEnum.FRENCH));
        channels.addChannel(new Channel(104.5, ChannelTypeEnum.ENGLISH));
        channels.addChannel(new Channel(105.5, ChannelTypeEnum.HINDI));
        channels.addChannel(new Channel(106.5, ChannelTypeEnum.FRENCH));
        return channels;
    }
}
