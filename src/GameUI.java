import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GameUI {
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
