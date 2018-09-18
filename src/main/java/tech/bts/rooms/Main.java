package tech.bts.rooms;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Room currentRoom = prepareRooms();
        Scanner input = new Scanner(System.in);

        while (true) {

            displaySituation(currentRoom);

            currentRoom = moveToNextRoom(currentRoom);

        }

    }

    /** Creates the rooms, links them and returns the initial room */
    private static Room prepareRooms () {
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

        return red;
    }
    /** Displays where you are and where you can go */
    private static void displaySituation (Room currentRoom) {
        System.out.println("You are now in: " + currentRoom);
        System.out.println("You can go to: ");
        for (Room room : currentRoom.connectedRooms) {
            System.out.println(" - " + room);
        }
    }

    /** Reads the user choice and moves to there */
    private static Room moveToNextRoom (Room currentRoom) {
        Scanner input = new Scanner(System.in);
        System.out.println("Where do you want to go?");
        String nextRoom = input.nextLine();

        for (Room room : currentRoom.connectedRooms) {
            if (nextRoom.equals(room.name)) {
                System.out.println("OK, let's go to " + room);
                currentRoom = room;
            }
        }

        return currentRoom;
    }


}
