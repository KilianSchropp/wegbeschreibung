package database;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import building.Floor;
import building.GraphPoint;
import building.StairwayGraphPoint;

public class SQLiteDatabase implements Database
{
    Connection c = null;
    Statement stmt = null;
    static final Log LOG = LogFactory.getLog(SQLiteDatabase.class);
    
    public void init()
    {
        final String fileSep = File.separator;
        final String pathToFile = "ext-lib"+fileSep+"Waypoints.sqlite";
        try
        {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:"+pathToFile);
        }
        catch (ClassNotFoundException | SQLException e)
        {
            LOG.error("An SQLException occured while trying connect to database " + pathToFile,e);
        }
        LOG.info("Opened database sucessfully");
    }

    @Override
    public List<GraphPoint> getGraphPointsForFloor(Floor floor)
    {
        final String floorName = floor.getFloorName();
        List<GraphPoint> points = new ArrayList<>();
        try
        {
            stmt = c.createStatement();
            c.setAutoCommit(false);
            ResultSet rs = stmt.executeQuery( "SELECT * FROM "+floorName+";" );
            while ( rs.next() )
            {
                final String  name = rs.getString("NAME");
                final double xcoordinate  = rs.getDouble("XCOORDINATE");
                final double ycoordinate = rs.getDouble("YCOORDINATE");
                final String neigbours = rs.getString("NEIGBOURS");
                final int isRoom = rs.getInt("ISROOM");
                final GraphPoint point = createGraphPointWithSqlValues(name, xcoordinate, ycoordinate, neigbours, isRoom, floor);
                points.add(point);
             }
            rs.close();
        }
        catch (SQLException e)
        {
            LOG.error("An SQLException occured while trying to get the graphpoints for floor " + floorName,e);
        }
        return points;
    }
    
    private GraphPoint createGraphPointWithSqlValues(String name, double xcoordinate, double ycoordiante
            , String neigbours, int isRoom, Floor floor)
    {
        List<Double> points = new ArrayList<>();
        points.add(xcoordinate);
        points.add(ycoordiante);
        boolean isRoomAsBoolean = true;
        if(isRoom == 0)
        {
            isRoomAsBoolean = false;
        }
        GraphPoint point;
        if(name.startsWith("Stair"))
        {
            point = new StairwayGraphPoint(points, name);
        }
        else
        {
            point = new GraphPoint(points, name, isRoomAsBoolean);
        }
        
        point.setFloor(floor);
        List<String> result = Arrays.asList(neigbours.split(",\\s|,"));
        point.setNeighboursOfGraphPoint(result);
        return point;
    }
    
    public void closeAllStreamsSilently()
    {
        try
        {
            stmt.close();
            c.close();
        }
        catch (SQLException e)
        {
            LOG.debug("The closing of the stram threw an exception. It is ignored.",e);
        }
    }
}
