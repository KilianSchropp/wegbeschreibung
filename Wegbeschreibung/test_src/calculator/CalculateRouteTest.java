package calculator;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import building.FirstFloor;
import building.Room;
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
        floor.createLinkedRoomObjectsList();
        List<Room> rooms = floor.getRoomsObj();
        assertFalse(rooms.isEmpty());
        
        Room roomAmsterdam = rooms.get(3);
        Room roomSanFrancisco = rooms.get(2);
        
        calc.search(roomAmsterdam, roomSanFrancisco, 0.0);
    }

}
