package tech.bts.rooms;

import java.util.ArrayList;
import java.util.List;

public class Room {

    public String name;
    public List<Room> connectedRooms;
    public boolean exit;

    public Room (String name){
        this.name = name;
        this.exit = false;
    }

    @Override
    public String toString() {
        return this.name + " room";
    }
}
