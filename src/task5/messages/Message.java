package task5.messages;


import java.util.Date;

/**
 * Created by alexander on 17.05.16.
 */
public abstract class Message implements Cloneable{
    //All required parameters
    private int id;
    private String author;
    private String theme;
    private String text;
    private Date createDate;
    private Date updateDate;

    //All needed getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getUpdateDate() {
        return updateDate;
    }


    // Initialization block
    {
        createDate = new Date();
        updateDate = new Date();
    }

    @Override
    public String toString(){
        return new StringBuilder().append(id).append("\t")
                .append("Author: ").append(author).append("\n\t")
                .append("Theme: ").append(theme).append("\n\t")
                .append("Message\n").append(text).append("\n\n\t")
                .append("Created on ").append(createDate).append("\n\t")
                .append("Last update ").append(updateDate).append("\n\n").toString();
    }

    @Override
    public boolean equals(Object object){
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Message){
            Message temp = (Message) object;
            return temp.id == this.id &&
                    temp.author.equals(this.author) &&
                    temp.theme.equals(this.theme) &&
                    temp.text.equals(this.text) &&
                    temp.createDate.equals(this.createDate) &&
                    temp.updateDate.equals(this.updateDate);
        }
        return false;
    }

    @Override
    public int hashCode(){
        return 31 * id + ((author == null) ? 0 : author.hashCode()) +
                ((theme == null) ? 0 : theme.hashCode()) +
                ((text == null) ? 0 : theme.hashCode()) +
                ((createDate == null) ? 0 : createDate.hashCode()) +
                ((updateDate == null) ? 0 : createDate.hashCode());
    }

    @Override
    public Object clone(){
        try{
            Message copy = (Message) super.clone();
            copy.createDate = (Date) createDate.clone();
            copy.updateDate = (Date) updateDate.clone();
            return copy;
        }
        catch (CloneNotSupportedException e){
            throw new AssertionError("Can't clone object");
        }
    }

    //A method to return short info of a message
    public String shortInfo(){
        return new StringBuilder().append(id).append("\t")
                .append(author).append("\t")
                .append(theme).append("\n").toString();
    }

    //A method to update updateDate parameter
    public void update(){
        this.updateDate = new Date();
    }
}
