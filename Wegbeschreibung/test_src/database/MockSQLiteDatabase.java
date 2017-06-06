package database;

import java.util.ArrayList;
import java.util.List;

import database.Database;

public class MockSQLiteDatabase implements Database
{
    @Override
    public List<String> getNeighboursOfRoom(String roomName)
    {
        List<String> neighbours = new ArrayList<>();
        if("Amsterdam".equals(roomName))
        {
            neighbours.add("Rome");
            neighbours.add("Vienna");
            neighbours.add("San Francisco");
        }
        else if("Rome".equals(roomName))
        {
            neighbours.add("Vienna");
            neighbours.add("San Francisco");
            neighbours.add("Amsterdam");
        }
        else if("Vienna".equals(roomName))
        {
            neighbours.add("San Francisco");
            neighbours.add("Amsterdam");
            neighbours.add("Rome");
        }
        else if("San Francisco".equals(roomName))
        {
            neighbours.add("Amsterdam");
            neighbours.add("Rome");
        }
        return neighbours;
    }

    @Override
    public List<Integer> getCoordinatesOfRoom(String roomName)
    {
        List<Integer> coordinates = new ArrayList<>();
        if("Amsterdam".equals(roomName))
        {
            coordinates.add(100);
            coordinates.add(300);
        }
        else if("Rome".equals(roomName))
        {
            coordinates.add(500);
            coordinates.add(700);
        }
        else if("Vienna".equals(roomName))
        {
            coordinates.add(1000);
            coordinates.add(1500);
        }
        else if("San Francisco".equals(roomName))
        {
            coordinates.add(2000);
            coordinates.add(2200);
        }
        
        return coordinates;
    }

    @Override
    public List<String> getRoomsForFloor(String floorName)
    {
        List<String> rooms = new ArrayList<>();
        rooms.add("Rome");
        rooms.add("Vienna");
        rooms.add("San Francisco");
        rooms.add("Amsterdam");
        return rooms;
    }
}
