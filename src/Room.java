import java.util.ArrayList;


public class Room {
    private int roomNumber;
    private String roomName;
    private String description;
    private boolean isVisited;
    private ArrayList<Exit> exits;

    public Room(){

    }

    public Room(int roomNumber, String roomName, String description, boolean isVisited, ArrayList<Exit> exits) {
        this.roomNumber = roomNumber;
        this.roomName = roomName;
        this.description = description;
        this.isVisited = isVisited;
        this.exits = exits;
    }

    //getters setters
    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        this.isVisited = visited;
    }

    public ArrayList<Exit> getExits() {
        return exits;
    }

    public void setExits(ArrayList<Exit> exits) {
        this.exits = exits;
    }

}
