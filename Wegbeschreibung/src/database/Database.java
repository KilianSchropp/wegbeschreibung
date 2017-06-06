package database;

import java.util.List;

public abstract interface Database
{
    public List<String> getNeighboursOfRoom(String roomName);

    public List<Double> getCoordinatesOfRoom(String roomName);

    public List<String> getRoomsForFloor(String floorName);

}
