package task5.messages;

/**
 * Created by alexander on 17.05.16.
 */
public class AdminMessage extends Message{
    //Message's sub name to show if a message is admin's or user's
    private String subName = "admin: ";

    public String getSubName(){
        return subName;
    }

    @Override
    public void setAuthor(String author){
        super.setAuthor(author.toUpperCase());
    }

    @Override
    public void setTheme(String theme){
        super.setTheme(theme.toUpperCase());
    }

    @Override
    public Object clone(){
        AdminMessage copy = (AdminMessage) super.clone();
        return copy;
    }


}
