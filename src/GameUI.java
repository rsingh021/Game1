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
        File roomFile = new File("secondRooms.txt");
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
            String exit = "";
            String[] x = new String[2];
            Exit exi = new Exit();

                rooms.add(new Room(roomNumber,roomName,description,true, exits));
                System.out.println(description);

            //boolean visited = Boolean.parseBoolean(read.nextLine());



//            ArrayList<String> directions = new ArrayList<>();
//            String N = read.nextLine();
//            directions.add(N);
//            String S = read.nextLine();
//            directions.add(S);
//            String E = read.nextLine();
//            directions.add(E);
//            String W = read.nextLine();
//            directions.add(W);
            //Room rooms = new Room(roomNumber,roomName,description, true, directions);
        }

        //validating user input
//        String userInput = "W";
//        boolean isValidMove = false;
//        for(Room r: RL)
//            if(r.getExits().equals(userInput))
//                isValidMove == true;
    }
}
