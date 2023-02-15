import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
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
        try {
            read = new Scanner(roomFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found");
        }
        ArrayList<Room> rooms = new ArrayList<>();

        while (read.hasNext()) {
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
            while (!direction.equals("----")) {
                int nextRoom = read.nextInt();
                exits.add((new Exit(direction, nextRoom)));
                direction = read.next();
            }
            room.setExits(exits);
            rooms.add(room);


        }

        Player player = new Player();
        player.setLocation(0);
        String direc;

        do {

            System.out.println(rooms.get(player.location).getRoomNumber());
            //System.out.println(rooms.get(player.location).getRoomName());
            if (rooms.get(player.location).isVisited()) {
                System.out.println("Welcome back to " + rooms.get(player.location).getRoomName());
            } else {
                System.out.println("Welcome to " + rooms.get(player.location).getRoomName());
                rooms.get(player.location).setVisited(true);
            }
            System.out.println(rooms.get(player.location).getDescription());
            System.out.println(rooms.get(player.location).getExits());
            //System.out.println();


            Exit exit = new Exit();
            List<String> compass = new ArrayList<String>();
            compass.add("west");
            compass.add("east");
            compass.add("north");
            compass.add("south");
            compass.add("w");
            compass.add("e");
            compass.add("n");
            compass.add("s");


            Scanner input = new Scanner(System.in);
            while (true) {
                direc = input.nextLine();
                if (compass.contains(direc.toLowerCase())) {
                    exit.setDirection(direc);
                    break;
                }
                if (direc.equalsIgnoreCase("quit")) {
                    break;
                }
            }
            if (direc.equalsIgnoreCase("quit")) {
                break;
            }
            //this is looping through the different exits and finding the direction that equals the direction that the user inputted.
            //when it is true the exit destination is set to the destination that matched the user input's direction
            //i know its confusing and i will have it fixed for game2, but it works:)
            for (int i = 0; i < rooms.get(player.location).getExits().size(); i++) {
                if (exit.getDirection().equalsIgnoreCase(rooms.get(player.location).getExits().get(i).getDirection())) {
                    exit.setDestination(rooms.get(player.location).getExits().get(i).getDestination());
                }
            }
            //System.out.println(exit.getDestination());
            System.out.println();
            //setting the
            player.setLocation(exit.getDestination());
        } while (true);

        System.out.println("quitted");


    }
}
