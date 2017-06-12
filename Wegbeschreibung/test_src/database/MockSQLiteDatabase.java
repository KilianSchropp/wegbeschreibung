package database;

import java.util.ArrayList;
import java.util.List;

import building.GraphPoint;
import database.Database;

public class MockSQLiteDatabase implements Database
{
    @Override
    public List<String> getNeighboursOfGraphPoint(String roomName)
    {
        List<String> neighbours = new ArrayList<>();
        if("Amsterdam".equals(roomName))
        {
            neighbours.add("Rome");
            neighbours.add("PointB");
            neighbours.add("PointE");
            neighbours.add("PointD");
            neighbours.add("PointC");
        }
        else if("Rome".equals(roomName))
        {
            neighbours.add("PointE");
            neighbours.add("Amsterdam");
            neighbours.add("POintB");
        }
        else if("Vienna".equals(roomName))
        {
            neighbours.add("PointG");
        }
        else if("PointA".equals(roomName))
        {
            neighbours.add("PointB");
            neighbours.add("PointC");
        }
        else if("PointB".equals(roomName))
        {
            neighbours.add("PointA");
            neighbours.add("Amsterdam");
        }
        else if("PointC".equals(roomName))
        {
            neighbours.add("PointA");
            neighbours.add("Amsterdam");
        }
        else if("PointD".equals(roomName))
        {
            neighbours.add("Amsterdam");
            neighbours.add("PointG");
        }
        else if("PointE".equals(roomName))
        {
            neighbours.add("Rome");
            neighbours.add("PointF");
            neighbours.add("Amsterdam");
        }
        else if("PointF".equals(roomName))
        {
            neighbours.add("PointG");
            neighbours.add("PointE");
        }
        else if("PointG".equals(roomName))
        {
            neighbours.add("PointF");
            neighbours.add("Vienna");
            neighbours.add("PointD");
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

    @Override
    public List<GraphPoint> getGraphPointsForFloor(String floorName)
    {
        List<GraphPoint> points = new ArrayList<>();
        points.add(new GraphPoint(20, 30, "PointA"));
        points.add(new GraphPoint(30, 200, "PointC"));
        points.add(new GraphPoint(100, 150, "PointB"));
        points.add(new GraphPoint(200, 180, "Amsterdam"));
        points.add(new GraphPoint(300, 20, "Rome"));
        points.add(new GraphPoint(500, 600, "PointD"));
        points.add(new GraphPoint(600, 40, "PointE"));
        points.add(new GraphPoint(800, 60, "PointF"));
        points.add(new GraphPoint(800, 100, "PointG"));
        points.add(new GraphPoint(800, 100, "Vienna"));
        
        for(GraphPoint point : points)
        {
            List<String> neighbours = getNeighboursOfGraphPoint(point.getName());
            point.setNeighboursOfGraphPoint(neighbours); 
        }
        
        return points;
    }
}
