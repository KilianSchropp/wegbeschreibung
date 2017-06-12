package calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import building.GraphPoint;

public class CalculateRoute
{
    List<GraphPoint> storeShortestPath = new ArrayList<GraphPoint>();
    List<GraphPoint> localeStore = new ArrayList<GraphPoint>();
    double routeLenght = Double.MAX_VALUE;
    List<GraphPoint> queue = new ArrayList<>();
    HashSet<GraphPoint> unsettledNodes = new HashSet<>();
    HashSet<GraphPoint> settledNodes = new HashSet<>();
    HashMap<GraphPoint, Double> distance = new HashMap<>();
    HashMap<GraphPoint, GraphPoint> predecessors = new HashMap<>();
    
    public void execute(GraphPoint source)
    {
        distance.put(source,0.0);
        unsettledNodes.add(source);
        while(unsettledNodes.size()>0)
        {
            GraphPoint node = getMinimum(unsettledNodes);
            settledNodes.add(node);
            unsettledNodes.remove(node);
            findMinimalDistances(node);
        }
    }
    
    private void findMinimalDistances(GraphPoint node)
    {
        List<GraphPoint> adjacentNodes = node.getNeighboursAsGraphPointObject();
        for(GraphPoint target : adjacentNodes)
        {
            Double distanceBetweenNodes = node.calculateDistanceToNeighbour(target);
            if(getShortestDistance(target) > getShortestDistance(node) + distanceBetweenNodes)
            {
                distance.put(target, getShortestDistance(node) + distanceBetweenNodes);
                predecessors.put(target, node);
                unsettledNodes.add(target);
            }

        }
        
    }

    private GraphPoint getMinimum(HashSet<GraphPoint> unsettledNodes2)
    {
        GraphPoint minimum = null;
        for(GraphPoint point : unsettledNodes2)
        {
            if(minimum == null)
            {
                minimum = point;
            }
            else
            {
                if(getShortestDistance(point) < getShortestDistance(minimum))
                {
                    minimum = point;
                }
            }
        }
        return minimum;
    }

    private Double getShortestDistance(GraphPoint point)
    {
       Double d = distance.get(point);
       if(d == null)
       {
           return Double.MAX_VALUE;
       }
       return d;
    }

    public LinkedList<GraphPoint> getPath(GraphPoint target) {
        LinkedList<GraphPoint> path = new LinkedList<GraphPoint>();
        GraphPoint step = target;
        // check if a path exists
        if (predecessors.get(step) == null) {
            return null;
        }
        path.add(step);
        while (predecessors.get(step) != null) {
            step = predecessors.get(step);
            path.add(step);
        }
        // Put it into the correct order
        Collections.reverse(path);
        return path;
    }
    
    public void searchQueue()
    {
        while(!queue.isEmpty())
        {
            
        }
    }
}
