package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import building.Building;
import building.Floor;
import building.GraphPoint;
import building.StairwayGraphPoint;
import calculator.RouteCalculator;

public class StartRouteButton extends JButton implements ActionListener
{
    private static final long serialVersionUID = 1L;
    static final Log LOG = LogFactory.getLog(StartRouteButton.class);
    JComboBox<GraphPoint> roomComboboxLeft;
    JComboBox<GraphPoint> roomComboboxRight;
    Building building;

    RouteCalculator routeCalculator;

    public StartRouteButton(String text)
    {
        super(text);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        GraphPoint startRoom = (GraphPoint) roomComboboxLeft.getSelectedItem();
        routeCalculator.setSource(startRoom);
        
        GraphPoint destinationRoom = (GraphPoint) roomComboboxRight.getSelectedItem();
        routeCalculator.setTarget(destinationRoom);
        routeCalculator.search();
        LinkedList<GraphPoint> fastestRoute = routeCalculator.getShortestPath();
        drawLines(startRoom, fastestRoute);
        drawLines(destinationRoom, fastestRoute);
        routeCalculator.clear();
        building.setVisibleForSelectedFloors(startRoom.getFloor(), destinationRoom.getFloor());
    }
    
    private void drawLines(GraphPoint room, LinkedList<GraphPoint> fastestRoute)
    {
        List<GraphPoint> splitted = splitUpForFloor(room, fastestRoute);
        List<Line2D> lines = connectLines(splitted);
        Floor floor = room.getFloor();
        floor.setLinesToDraw(lines);
    }

    private List<GraphPoint> splitUpForFloor(GraphPoint room, LinkedList<GraphPoint> fastestRoute)
    {
        final GraphPoint splitPoint = getSplitPoint(room, fastestRoute);
        int index = fastestRoute.indexOf(splitPoint);
        if(index != -1)
        {
            int secondIndex = fastestRoute.indexOf(room);
            List<GraphPoint> sublist;
            if(index < secondIndex)
            {
                sublist = fastestRoute.subList(index, secondIndex +1);  
            }
            else
            {
                sublist = fastestRoute.subList(secondIndex, index+1);  
            }
            return sublist; 
        }
        return fastestRoute;
    }

    private GraphPoint getSplitPoint(GraphPoint room, LinkedList<GraphPoint> fastestRoute)
    {
        for(GraphPoint point : fastestRoute)
        {
            if(point instanceof StairwayGraphPoint)
            {
                if(point.getFloor().equals(room.getFloor()))
                {
                    return point;
                }
            }
        }
        return null;
    }

    public void setRoomComboboxLeft(JComboBox<GraphPoint> roomComboboxLeft){this.roomComboboxLeft = roomComboboxLeft;}
    
    public void setRoomComboboxRight(JComboBox<GraphPoint> roomComboboxRight){this.roomComboboxRight = roomComboboxRight;}
    
    public void setRouteCalculator(RouteCalculator routeCalculator){this.routeCalculator = routeCalculator;}
    
    private List<Line2D> connectLines(List<GraphPoint> fastestRoute)
    {
        List<Line2D> lines = new ArrayList<>();
        for (int i = 0; i < fastestRoute.size(); i++) 
        {
            GraphPoint point = fastestRoute.get(i);
            if(fastestRoute.size() > i+1)
            {
                GraphPoint point2 = fastestRoute.get(i+1);
                
                double x = point.getX();
                double y = point.getY();
                double x1 = point2.getX();
                double y1 = point2.getY();
                
                Line2D.Double line = new Line2D.Double(x,y,x1,y1);
                lines.add(line);
            }
        }
        return lines;
    }
    
    public void setBuilding(Building building)
    {
        this.building = building;
    }
}
