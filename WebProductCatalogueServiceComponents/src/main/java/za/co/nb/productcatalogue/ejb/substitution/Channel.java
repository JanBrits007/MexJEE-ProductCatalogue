package za.co.nb.productcatalogue.ejb.substitution;

import java.util.ArrayList;
import java.util.List;

public class Channel  extends Substitution {


    private List<String> channelIDWhitelist;

    public Channel(String type) {
        setType(type);
    }


    public List<String> getChannelIDWhitelist() {
        if(channelIDWhitelist == null)
            channelIDWhitelist = new ArrayList<String>();
        return channelIDWhitelist;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "channelIDWhitelist=" + channelIDWhitelist +
                '}';
    }
}
