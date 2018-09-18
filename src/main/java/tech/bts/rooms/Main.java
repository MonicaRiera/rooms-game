package tech.bts.rooms;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

            Room red = new Room("red");
            Room green = new Room("green");
            Room blue = new Room("blue");
            Room purple = new Room("purple");
            Room yellow = new Room("yellow");
            Room white = new Room("white");

            red.connectedRooms = Arrays.asList(green);
            green.connectedRooms = Arrays.asList(red, blue, purple);
            blue.connectedRooms = Arrays.asList(green, white);
            purple.connectedRooms = Arrays.asList(green, yellow);
            yellow.connectedRooms = Arrays.asList(purple);
            white.connectedRooms = Arrays.asList(blue);

            Room currentRoom = green;

        while (true) {

            System.out.println("You are now in: " + currentRoom);
            System.out.println("You can go to: ");
            for (Room room : currentRoom.connectedRooms) {
                System.out.println(" - " + room);
            }

            Scanner input = new Scanner(System.in);
            System.out.println("Where do you want to go?");
            String nextRoom = input.nextLine();

            for (Room room : currentRoom.connectedRooms) {
                if (nextRoom.equals(room.name)) {
                    System.out.println("OK, let's go to " + room);
                    currentRoom = room;
                }
            }

            if (nextRoom.equals("exit")){
                break;
            }

        }

    }
}
