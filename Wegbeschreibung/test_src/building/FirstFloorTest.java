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
        FirstFloor floor = new FirstFloor();
        MockSQLiteDatabase sql = new MockSQLiteDatabase();
        floor.setSql(sql);
        floor.createRoomList();
        List<String> answer = floor.getRoomList();
        assertFalse(answer.isEmpty());
        assertTrue(answer.contains("Amsterdam"));
    }

    @Test
    public void testCreateLinkedRoomObjectsList()
    {
        FirstFloor floor = new FirstFloor();
        MockSQLiteDatabase sql = new MockSQLiteDatabase();
        floor.setSql(sql);
        floor.createRoomList();
        floor.createLinkedRoomObjectsList();
        List<Room> rooms = floor.getRoomsObj();
        assertFalse(rooms.isEmpty());
        
        Room roomRome = rooms.get(0);
        assertFalse(roomRome.getName().isEmpty());
        assertFalse(roomRome.getNeighbours().isEmpty());
        assertEquals(roomRome.getNeighbours().size(), 3);
        
        Room roomSanFrancisco = rooms.get(2);
        assertFalse(roomSanFrancisco.getName().isEmpty());
        assertFalse(roomSanFrancisco.getNeighbours().isEmpty());
        assertEquals(roomSanFrancisco.getNeighbours().size(), 2);
    }
}
