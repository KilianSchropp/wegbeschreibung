package calculator;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import building.GraphPoint;

public class CalculateRoute
{
    HashSet<GraphPoint> nodesTodo = new HashSet<>();
    HashSet<GraphPoint> finishedNodes = new HashSet<>();
    
    public void search(GraphPoint source)
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
        final List<GraphPoint> adjacentNodes = node.getNeighboursAsGraphPointObject();
        for(GraphPoint target : adjacentNodes)
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
    
    public LinkedList<GraphPoint> getShortestPath(GraphPoint target)
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
}
