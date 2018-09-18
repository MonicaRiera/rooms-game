package tech.bts.rooms;

import java.util.ArrayList;
import java.util.List;

public class Room {

    public String name;
    public List<Room> connectedRooms;

    public Room (String name){
        this.name = name;
        //this.connectedRooms = new ArrayList<Room>();
    }

    @Override
    public String toString() {
        return this.name + " room";
    }
}
