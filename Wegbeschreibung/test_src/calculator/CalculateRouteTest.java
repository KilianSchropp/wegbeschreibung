package calculator;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import building.Floor;
import building.GraphPoint;
import database.MockSQLiteDatabase;

public class CalculateRouteTest
{

    @Test
    public void testSearch()
    {
        RouteCalculator calc = new RouteCalculator();
        
        Floor floor = new Floor("OG1");
        MockSQLiteDatabase sql = new MockSQLiteDatabase();
        floor.setSql(sql);
        floor.createRoomList();
        floor.createGraphPointList();
        floor.createLinkedGraphPointObjectsList();
        List<GraphPoint> points = floor.getGraphPoints();
        assertFalse(points.isEmpty());
        
        GraphPoint pointA = points.get(4);
        GraphPoint vienna = points.get(3);
        
        calc.setSource(pointA);
        calc.setTarget(vienna);
        calc.search();
        LinkedList<GraphPoint> path = calc.getShortestPath();
        assertFalse(path.isEmpty());
        assertEquals("PointA", path.getFirst().getName());
        assertEquals("PointB",path.get(1).getName());
        assertEquals("Amsterdam", path.get(2).getName());
        assertEquals("PointD", path.get(3).getName());
        assertEquals("PointG", path.get(4).getName());
        assertEquals("Vienna", path.getLast().getName());
    }

}
