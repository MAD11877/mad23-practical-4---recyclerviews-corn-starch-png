package sg.edu.np.mad.template;

public class User {
    private String name;
    private String description;
    private int id;
    private boolean followed;
    public User(String Name,String Description,int Id, boolean Followed){
            name = Name;
            description = Description;
            id = Id;
            followed = Followed;
    }
    public boolean getFollowed(){
        return followed;
    }
    public String getName() {return name;}
    public String getDescription() {return description;}
    public void setFollowed(boolean newFollowed) {
        followed = newFollowed;
    }

}
