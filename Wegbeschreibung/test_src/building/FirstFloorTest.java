package building;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import database.MockSQLiteDatabase;


public class FirstFloorTest
{

    @Test
    public void testgetRoomList()
    {
        Floor floor = new Floor("OG1", true);
        MockSQLiteDatabase sql = new MockSQLiteDatabase();
        floor.setSql(sql);
        floor.createRoomList();
        List<GraphPoint> answer = floor.getRoomList();
        assertFalse(answer.isEmpty());
        assertTrue(answer.contains("Amsterdam"));
    }

    @Test
    public void testCreateLinkedRoomObjectsList()
    {
        Floor floor = new Floor("EG",true);
        MockSQLiteDatabase sql = new MockSQLiteDatabase();
        floor.setSql(sql);
        floor.createRoomList();
        floor.createLinkedGraphPointObjectsList();
        floor.createGraphPointList();
        List<GraphPoint> rooms = floor.getGraphPoints();
        assertFalse(rooms.isEmpty());
        
        GraphPoint roomRome = rooms.get(0);
        assertFalse(roomRome.getName().isEmpty());
        assertFalse(roomRome.getNeighboursAsString().isEmpty());
        assertEquals(roomRome.getNeighboursAsString().size(), 2);
        
        GraphPoint roomSanFrancisco = rooms.get(2);
        assertFalse(roomSanFrancisco.getName().isEmpty());
        assertFalse(roomSanFrancisco.getNeighboursAsString().isEmpty());
        assertEquals(roomSanFrancisco.getNeighboursAsString().size(), 2);
    }
}
