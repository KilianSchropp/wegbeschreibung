package calculator;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import building.FirstFloor;
import building.GraphPoint;
import database.MockSQLiteDatabase;

public class CalculateRouteTest
{

    @Test
    public void testSearch()
    {
        CalculateRoute calc = new CalculateRoute();
        
        FirstFloor floor = new FirstFloor();
        MockSQLiteDatabase sql = new MockSQLiteDatabase();
        floor.setSql(sql);
        floor.createRoomList();
        floor.createGraphPointList();
        floor.createLinkedGraphPointObjectsList();
        List<GraphPoint> points = floor.getGraphPoints();
        assertFalse(points.isEmpty());
        
        GraphPoint pointA = points.get(0);
        GraphPoint vienna = points.get(9);
        
        calc.execute(pointA);
        LinkedList<GraphPoint> path = calc.getPath(vienna);
        assertFalse(path.isEmpty());
        assertEquals("PointA", path.getFirst().getName());
        assertEquals("PointB",path.get(1).getName());
        assertEquals("Amsterdam", path.get(2).getName());
        assertEquals("PointD", path.get(3).getName());
        assertEquals("PointG", path.get(4).getName());
        assertEquals("Vienna", path.getLast().getName());
    }

}
