package database;

import java.util.ArrayList;
import java.util.List;

import building.Floor;
import building.GraphPoint;
import building.StairwayGraphPoint;
import database.Database;

public class MockSQLiteDatabase implements Database
{
    
    public List<String> getNeighboursOfGraphPoint(String roomName, String floorName)
    {
        List<String> neighbours = new ArrayList<>();
        if("EG".equals(floorName))
        {
            if("Stair1".equals(roomName))
            {
                neighbours.add("WP17");
                neighbours.add("WP16");
            }
            else if("HR".equals(roomName))
            {
                neighbours.add("HR1");
                neighbours.add("HR2");
            }
            else if("R&D".equals(roomName))
            {
                neighbours.add("R&D1");
                neighbours.add("R&D2");
                neighbours.add("R&D3");
                neighbours.add("R&D4");
            }
            else if("WP17".equals(roomName))
            {
                neighbours.add("WP16");
                neighbours.add("R&D1");
                neighbours.add("Stair1");
            }
            else if("WP16".equals(roomName))
            {
                neighbours.add("WP17");
                neighbours.add("HR2");
                neighbours.add("WP15");
                neighbours.add("Stair1");
            }
            else if("HR2".equals(roomName))
            {
                neighbours.add("WP15");
                neighbours.add("HR");
                neighbours.add("WP16");
            }
            else if("WP15".equals(roomName))
            {
                neighbours.add("WP16");
                neighbours.add("HR1");
                neighbours.add("HR2");
            }
            else if("HR1".equals(roomName))
            {
                neighbours.add("WP15");
                neighbours.add("WP14");
                neighbours.add("WP8");
                neighbours.add("HR");
            }
            else if("WP8".equals(roomName))
            {
                neighbours.add("WP14");
                neighbours.add("HR1");
            }
            else if("WP14".equals(roomName))
            {
                neighbours.add("HR1");
                neighbours.add("R&D2");
            }
            else if("R&D2".equals(roomName))
            {
                neighbours.add("R&D1");
                neighbours.add("R&D");
                neighbours.add("WP9");
                neighbours.add("WP14");
            }
            else if("R&D1".equals(roomName))
            {
                neighbours.add("WP17");
                neighbours.add("R&D2");
                neighbours.add("R&D");
            }
            else if("WP9".equals(roomName))
            {
                neighbours.add("R&D2");
                neighbours.add("R&D3");
            }
            else if("R&D3".equals(roomName))
            {
                neighbours.add("WP9");
                neighbours.add("WP4");
                neighbours.add("R&D4");
                neighbours.add("R&D");
            }
            else if("R&D4".equals(roomName))
            {
                neighbours.add("WP21");
                neighbours.add("R&D3");
                neighbours.add("R&D");
            }
            else if("WP21".equals(roomName))
            {
                neighbours.add("R&D4");
                neighbours.add("Stair4");
                neighbours.add("WP20");
            }
            else if("WP20".equals(roomName))
            {
                neighbours.add("WP4");
                neighbours.add("Stair4");
                neighbours.add("WP21");
            }
            else if("WP4".equals(roomName))
            {
                neighbours.add("R&D3");
                neighbours.add("WP20");
            }
        }
        else if("OG1".equals(floorName))
        {
            if("Stair1".equals(roomName))
            {
                neighbours.add("WP2");
                neighbours.add("WP3");
            }
            else if("WP1".equals(roomName))
            {
                neighbours.add("CS1");
                neighbours.add("WP6");
                neighbours.add("CS2");
                neighbours.add("WP2");
            }
            else if("WP3".equals(roomName))
            {
                neighbours.add("Stair1");
                neighbours.add("SALE1");
                neighbours.add("WP4");
            }
            else if("CS2".equals(roomName))
            {
                neighbours.add("WP2");
                neighbours.add("WP1");
                neighbours.add("CS");
            }
            else if("CS".equals(roomName))
            {
                neighbours.add("CS1");
                neighbours.add("CS2");
            }
            else if("CS1".equals(roomName))
            {
                neighbours.add("WP6");
                neighbours.add("WP1");
                neighbours.add("CS");
            }
            else if("SALE1".equals(roomName))
            {
                neighbours.add("WP3");
                neighbours.add("SALE");
                neighbours.add("WP4");
            }
            else if("SALE".equals(roomName))
            {
                neighbours.add("SALE1");
                neighbours.add("SALE2");
            }
            else if("SALE2".equals(roomName))
            {
                neighbours.add("WP4");
                neighbours.add("WP5");
            }
            else if("WP5".equals(roomName))
            {
                neighbours.add("SALE2");
                neighbours.add("WP6");
            }
            else if("WP6".equals(roomName))
            {
                neighbours.add("WP5");
                neighbours.add("CS1");
                neighbours.add("WP1");
            }
            else if("WP2".equals(roomName))
            {
                neighbours.add("CS2");
                neighbours.add("WP1");
                neighbours.add("Stair1");
            }
        }
        return neighbours;
    }

    @Override
    public List<GraphPoint> getGraphPointsForFloor(Floor floor)
    {
        String floorName = floor.getFloorName();
        List<GraphPoint> points = new ArrayList<>();
        if(floorName.equals("EG"))
        {
            points.add(new GraphPoint(220.0, 530.0, "R&D", true));
            points.add(new GraphPoint(678.0, 260.0, "HR", true));
            points.add(new GraphPoint(304.0, 221.0, "R&D1"));
            points.add(new GraphPoint(350.0, 413.0, "R&D2"));
            points.add(new GraphPoint(380.0, 530.0, "WP9"));
            points.add(new GraphPoint(350.0, 650.0, "R&D3"));
            points.add(new GraphPoint(565.0, 614.0, "WP4"));
            points.add(new GraphPoint(545.0, 945.0, "WP20"));
            points.add(new GraphPoint(326.0, 940.0, "WP21"));
            points.add(new GraphPoint(434.0, 364.0, "WP14"));
            points.add(new GraphPoint(305.0, 851.0, "R&D4"));
            points.add(new GraphPoint(565.0, 311.0, "HR1"));
            points.add(new GraphPoint(565.0, 208.0, "HR2"));
            points.add(new GraphPoint(547.0, 255.0, "WP15"));
            points.add(new GraphPoint(538.0, 123.0, "WP16"));
            points.add(new GraphPoint(372.0, 123.0, "WP17"));
            points.add(new GraphPoint(565.0, 447.0, "WP8"));
            points.addAll(getStairwayGraphPoints(floorName));
            
            for(GraphPoint point : points)
            {
                List<String> neighbours = getNeighboursOfGraphPoint(point.getName(),floorName);
                point.setNeighboursOfGraphPoint(neighbours); 
            }
        }
        else if(floorName.equals("OG1"))
        {
            points.add(new GraphPoint(800.0, 250.0, "SALE", true));
            points.add(new GraphPoint(640.0, 200.0, "SALE1"));
            points.add(new GraphPoint(640.0, 310.0, "SALE2"));
            points.add(new GraphPoint(295.0, 537.0, "CS",true));
            points.add(new GraphPoint(380.0, 401.0, "CS1"));
            points.add(new GraphPoint(367.0, 200.0, "CS2"));
            points.add(new GraphPoint(388.0, 278.0, "WP1"));
            points.add(new GraphPoint(390.0, 112.0, "WP2"));
            points.add(new GraphPoint(613.0, 112.0, "WP3"));
            points.add(new GraphPoint(613.0, 250.0, "WP4"));
            points.add(new GraphPoint(613.0, 370.0, "WP5"));
            points.add(new GraphPoint(388.0, 368.0, "WP6"));
            points.addAll(getStairwayGraphPoints(floorName));
            
            for(GraphPoint point : points)
            {
                List<String> neighbours = getNeighboursOfGraphPoint(point.getName(), floorName);
                point.setNeighboursOfGraphPoint(neighbours); 
            }
        }
        
        return points;
    }

    public List<GraphPoint> getStairwayGraphPoints(String floorname)
    {
        List<GraphPoint> stairway = new ArrayList<>();
        if("EG".equals(floorname))
        {
            stairway.add(new StairwayGraphPoint(434.0, 125.0, "Stair1"));
            stairway.add(new StairwayGraphPoint(1210.0, 125.0, "Stair2"));
            stairway.add(new StairwayGraphPoint(1210.0, 948.0, "Stair3"));
            stairway.add(new StairwayGraphPoint(434.0, 948.0, "Stair4"));
        }
        else if("OG1".equals(floorname))
        {
            stairway.add(new StairwayGraphPoint(506.0, 108.0, "Stair1"));
            stairway.add(new StairwayGraphPoint(1210.0, 973.0, "Stair2"));
            stairway.add(new StairwayGraphPoint(1210.0, 948.0, "Stair3"));
            stairway.add(new StairwayGraphPoint(505.0, 973.0, "Stair4"));
        }
        
        return stairway;
    }
    
}
