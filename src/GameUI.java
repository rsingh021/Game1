import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GameUI {
    public static <Arraylist> void main(String[] args) {
        Player player = new Player();


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
        ArrayList<String> description = new ArrayList<>();
        ArrayList<Exit> exits = new ArrayList<>();

        while(read.hasNext()){

            int roomNumber = Integer.parseInt(read.nextLine());
            String roomName = read.nextLine();
            //trying to get the reader to stop reading the description and stop when it reaches "----"
            String descrip = read.nextLine();
            description.add(descrip);
            while (!descrip.equals("----")) {
                descrip = read.nextLine();
                description.add(descrip);
            }


                rooms.add(new Room(roomNumber,roomName,description,true, exits));
                System.out.println(description);




        }

    }
}
