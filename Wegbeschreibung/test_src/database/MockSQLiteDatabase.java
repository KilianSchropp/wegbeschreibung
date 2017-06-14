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
    public List<GraphPoint> getGraphPointsForFloor(String floorName)
    {
        List<GraphPoint> points = new ArrayList<>();
        points.add(new GraphPoint(600.0, 40.0, "PointE"));
        points.add(new GraphPoint(800.0, 60.0, "PointF"));
        points.add(new GraphPoint(800.0, 100.0, "PointG"));
        points.add(new GraphPoint(800.0, 100.0, "Vienna", true));
        points.add(new GraphPoint(20.0, 30.0, "PointA"));
        points.add(new GraphPoint(30.0, 200.0, "PointC"));
        points.add(new GraphPoint(100.0, 150.0, "PointB"));
        points.add(new GraphPoint(200.0, 180.0, "Amsterdam",true));
        points.add(new GraphPoint(300.0, 20.0, "Rome", true));
        points.add(new GraphPoint(500.0, 600.0, "PointD"));
        
        for(GraphPoint point : points)
        {
            List<String> neighbours = getNeighboursOfGraphPoint(point.getName());
            point.setNeighboursOfGraphPoint(neighbours); 
        }
        
        return points;
    }
}
