public class Player {
    public boolean isAlive;
    public int location;

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

}
