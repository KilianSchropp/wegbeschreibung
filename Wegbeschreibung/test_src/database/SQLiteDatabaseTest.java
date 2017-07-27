package database;

import static org.junit.Assert.*;

import org.junit.Test;

public class SQLiteDatabaseTest
{

    @Test
    public void testConnect()
    {
        SQLiteDatabase db = new SQLiteDatabase();
        try
        {
            db.init();
        }
        catch(Exception e)
        {
            fail("No exception should occure :" + e);
        }
    }

}
