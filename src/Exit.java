public class Exit {
    private String direction;
    private int destination;

    public Exit(String direction, int destination) {
        this.direction = direction;
        this.destination = destination;
    }

    public Exit(){
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public String getDirection() {
        return direction;
    }

    public int getDestination() {
        return destination;
    }

    @Override
    public String toString() {
        return "Exit{" +
                "direction='" + direction + '\'' +
                ", destination=" + destination +
                '}';
    }
}


//This class has two instance variables: direction and destination. The direction variable holds the name of the exit direction (e.g. "NORTH"). The destination variable holds the room number of the room that the exit leads to.
//
//The class has two public getter methods to access the direction and destination variables.


