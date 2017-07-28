package calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import building.GraphPoint;
import building.StairwayGraphPoint;

public class RouteCalculator
{
    private HashSet<GraphPoint> nodesTodo = new HashSet<>();
    private HashSet<GraphPoint> finishedNodes = new HashSet<>();

    private GraphPoint source;
    private GraphPoint target;
    
    public void search()
    {
        //dijkstras algorithm
        source.setShortesDistance(0.0);
        nodesTodo.add(source);
        while(nodesTodo.size()>0)
        {
            GraphPoint node = getSmallestInQueue();
            finishedNodes.add(node);
            nodesTodo.remove(node);
            findMinimalDistances(node);
        }
    }
    
    public void setSource(GraphPoint source){this.source = source;}
    
    public void setTarget(GraphPoint target){this.target = target;}
    
    private GraphPoint getSmallestInQueue()
    {
        GraphPoint smallest = null;
        for(GraphPoint point : nodesTodo)
        {
            if(smallest == null)
            {
                smallest = point;
            }
            else
            {
                if(point.getShortesDistance() < smallest.getShortesDistance())
                {
                    smallest = point;
                }
            }
        }
        return smallest;
    }
    
    private void findMinimalDistances(GraphPoint node)
    {
        List<GraphPoint> adjacentNodes;
        adjacentNodes = node.getNeighboursAsGraphPointObject();
        
        if(node instanceof StairwayGraphPoint)
        {
            adjacentNodes.add(getStairSiblingOfTargetFloor(node));
        }

        
        for(GraphPoint target : adjacentNodes)
        {   
            if(!finishedNodes.contains(target))
            {
                final Double distanceBetweenNodes = node.calculateDistanceToNeighbour(target);
                if(target.getShortesDistance() > node.getShortesDistance() + distanceBetweenNodes)
                {
                    final Double shortestDistance = node.getShortesDistance() + distanceBetweenNodes;
                    target.setShortesDistance(shortestDistance);
                    target.setPredecessor(node);
                    nodesTodo.add(target);
                }
            }
        }
    }
    
    private GraphPoint getStairSiblingOfTargetFloor(GraphPoint node)
    {
        GraphPoint result = null;
        List<GraphPoint> tempList = new ArrayList<>();
        tempList = ((StairwayGraphPoint) node).getStairwaySiblings();
        for(GraphPoint point : tempList)
        {
            if(point.getFloor().equals(target.getFloor()))
            {
                result = point;
            }
        }
        
        return result;
    }
    
    public LinkedList<GraphPoint> getShortestPath()
    {
        LinkedList<GraphPoint> path = new LinkedList<GraphPoint>();
        GraphPoint step = target;
        if(!finishedNodes.contains(step))
        {
            return null;
        }
        
        path.add(step);
        while(step.getPredecessor() != null)
        {
            step = step.getPredecessor();
            path.add(step);
        }
        
        Collections.reverse(path);
        return path;
    }
    
    public void clear()
    {
        for(GraphPoint point : finishedNodes)
        {
            point.setShortesDistance(Double.MAX_VALUE);
            point.setPredecessor(null);
        }
        finishedNodes.clear();
    }
}
