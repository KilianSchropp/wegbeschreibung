package building;

import java.util.ArrayList;
import java.util.List;

public class GraphPoint
{
    double x,y;
    private String name;
    private List<GraphPoint> graphPoints = new ArrayList<GraphPoint>();
    private List<String> neighbours = new ArrayList<>();
    private Double shortesDistance = Double.MAX_VALUE;
    private GraphPoint predecessor = null;



    public GraphPoint(double x, double y, String name)
    {
        this.x = x;
        this.y = y;
        this.name = name;
    }
    
    public GraphPoint(List<Double> points, String name)
    {
        this.x = points.get(0);
        this.y = points.get(1);
        this.name = name;
    }
    
    public GraphPoint getPredecessor()
    {
        return predecessor;
    }
    
    public void setPredecessor(GraphPoint predecessor)
    {
        this.predecessor = predecessor;
    }
    
    public double getX(){return x;}
    
    public double getY(){return y;}

    public String getName(){return this.name;}
    
    public Double calculateDistanceToNeighbour(GraphPoint point)
    {
        Double localDistance;
        localDistance =  Math.hypot(x - y,point.getX() - point.getY());
        return localDistance;
    }
    
    public List<String> getNeighboursAsString()
    {
        return neighbours;
    } 

    public void addToNeighbours(GraphPoint point){this.graphPoints.add(point);}
    
    public List<GraphPoint> getNeighboursAsGraphPointObject()
    {
        return graphPoints;
    }

    public void setNeighboursOfGraphPoint(List<String> neighbours)
    {
        this.neighbours = neighbours;    
    }
    
    public Double getShortesDistance()
    {
        return shortesDistance;
    }
    
    public void setShortesDistance(Double shortesDistance)
    {
        this.shortesDistance = shortesDistance;
    }
}
