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
        }
        else if("Rome".equals(roomName))
        {
            neighbours.add("Vienna");
            neighbours.add("Amsterdam");
        }
        else if("Vienna".equals(roomName))
        {
            neighbours.add("San Francisco");
            neighbours.add("Rome");
        }
        else if("San Francisco".equals(roomName))
        {
            neighbours.add("Amsterdam");
            neighbours.add("Vienna");
        }
        return neighbours;
    }

    @Override
    public List<Double> getCoordinatesOfRoom(String roomName)
    {
        List<Double> coordinates = new ArrayList<>();
        if("Amsterdam".equals(roomName))
        {
            coordinates.add(100.0);
            coordinates.add(300.0);
        }
        else if("Rome".equals(roomName))
        {
            coordinates.add(500.0);
            coordinates.add(700.0);
        }
        else if("Vienna".equals(roomName))
        {
            coordinates.add(1000.0);
            coordinates.add(1500.0);
        }
        else if("San Francisco".equals(roomName))
        {
            coordinates.add(2000.0);
            coordinates.add(2200.0);
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
