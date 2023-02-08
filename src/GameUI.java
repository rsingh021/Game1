import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GameUI {
    public static void main(String[] args) {
        //Player player = new Player();


        System.out.println("Welcome to my adventure game. You will proceed through rooms based upon your entries.");
        System.out.println("You can navigate by using the entire direction or just the first letter.");
        //reading room.txt
        File roomFile = new File("Rooms.txt");
        Scanner read = null;
        Room room = new Room();
        try{
            read = new Scanner(roomFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found");
        }
        //all arraylists needed
        ArrayList<Room> rooms = new ArrayList<>();
        //ArrayList<String> description = new ArrayList<>();
        ArrayList<Exit> exits = new ArrayList<>();

        while(read.hasNext()){

            int roomNum = Integer.parseInt(read.nextLine());
            room.setRoomNumber(roomNum);
            System.out.println(room.getRoomNumber());
            String roomName = read.nextLine();
            room.setRoomName(roomName);
            System.out.println(room.getRoomName());


            //trying to get the reader to stop reading the description and stop when it reaches "----"
            StringBuilder description = new StringBuilder();
            String text = read.nextLine();
            while (!text.equals("----")) {
                description.append(text).append("\n");
                text = read.nextLine();
            }
            room.setDescription(description.toString());
            System.out.println(room.getDescription());


            //reading exits





            rooms.add(new Room(roomNum,roomName,description.toString(),true, exits));





        }

    }
}
