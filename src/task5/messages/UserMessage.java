package task5.messages;

/**
 * Created by alexander on 17.05.16.
 */
public class UserMessage extends Message {
    //Message's sub name to show if a message is admin's or user's
    String subName = "user: ";

    public String getSubName(){
        return subName;
    }

    @Override
    public Object clone(){
        UserMessage copy = (UserMessage) super.clone();
        return copy;
    }
}
