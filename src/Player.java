import java.util.ArrayList;

public class Player {
    public boolean isAlive;
    public int location; //you can create another location to identify as a
    // current room or previous location

    private ArrayList<Room> listOfRooms = new ArrayList<>();

    public void setListOfRooms(ArrayList<Room> listOfRooms) {
        this.listOfRooms = listOfRooms;
    }

    public Player(){
    }

    public Player(boolean isAlive, int location) {
        this.isAlive = isAlive;
        this.location = location;
    }
    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }



    public void movePlayer(String direction){


        ArrayList<Exit> exit = listOfRooms.get(location).getExits();
        //you can get the current room before the play is moved and make sure
        // to save the copy of the current room as a newly set up previous room.

        //for example.
        Room current = listOfRooms.get(location); //
        // must change or find the way to identify as the current location
        setLocation(location);
        Room previous = listOfRooms.get(location);
        //must change or find the way to identify as the previous location. make sure change the
        // instance/attributes in the beginning. check the lines 5-6 above.

        //then use the loop to iterate the Exit data among the list of Exits
        // from the current Room type object.

        //im looping through the exits looking for the direction that equals the direction that the user input.
        // then i am setting the location to the destination of that direction

        for(Exit e: exit){
            if(e.getDirection().equalsIgnoreCase(direction)){
                setLocation(e.getDestination());
            }
        }

        //inside of the loop, you will need to check if the getter of the
        // direction equals to the direction which is taken when you call
        // movePlayer() method and check all possible way of input values.

        //then you will use the setter to change the destination value. in
        // this case, you may need to declare a variable for the destination
        // in this method.
        //also you  need to take care of the part if the player moved to a
        // room visited or not.


    }
}
