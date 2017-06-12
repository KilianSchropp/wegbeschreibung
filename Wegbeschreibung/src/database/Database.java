package database;

import java.util.List;

import building.GraphPoint;

public abstract interface Database
{
    public List<String> getNeighboursOfGraphPoint(String roomName);

    public List<Double> getCoordinatesOfRoom(String roomName);

    public List<String> getRoomsForFloor(String floorName);

    public List<GraphPoint> getGraphPointsForFloor(String floorName);

}
