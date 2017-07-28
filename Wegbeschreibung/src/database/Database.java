package database;

import java.util.List;

import building.Floor;
import building.GraphPoint;

public abstract interface Database
{
    public List<GraphPoint> getGraphPointsForFloor(Floor floor);
}
