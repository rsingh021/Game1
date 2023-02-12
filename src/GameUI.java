import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GameUI {


    /**
     * you will need to create a method to play the game. or you can create
     * this one inside  of the main method or create a seprate method. if you
     * are creating a new method to play the game, then you will need to
     * create a Player object, Room object, and you will start the game with
     * prompt to provide instruction. Then, you will use the loop to play the
     * game by asking questions what the player wants to do....
     *
     * @param args
     */




    public static void main(String[] args) {
        //Player player = new Player();


        //System.out.println("Welcome to my adventure game. You will proceed through rooms based upon your entries.");
        //System.out.println("You can navigate by using the entire direction or just the first letter.");
        //reading room.txt
        File roomFile = new File("Rooms.txt");
        Scanner read = null;
        try{
            read = new Scanner(roomFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found");
        }
        ArrayList<Room> rooms = new ArrayList<>();

        while(read.hasNext()){
            ArrayList<Exit> exits = new ArrayList<>();
            Room room = new Room();
            int roomNum = read.nextInt();
            room.setRoomNumber(roomNum);
            read.nextLine();
            String roomName = read.nextLine();
            room.setRoomName(roomName);


            //trying to get the reader to stop reading the description and stop when it reaches "----"
            StringBuilder description = new StringBuilder();
            String text = read.nextLine();
            while (!text.equals("----")) {
                description.append(text).append("\n");
                text = read.nextLine();
            }
            room.setDescription(description.toString());


            //reading exits
            String direction = read.next();
            while(!direction.equals("----"))
            {
                int nextRoom = read.nextInt();
                exits.add((new Exit(direction,nextRoom)));
                direction = read.next();
            }
            room.setExits(exits);
            rooms.add(room);



          //  rooms.add(new Room(roomNum,roomName,description.toString(),true, exits));
        }





    }
}
