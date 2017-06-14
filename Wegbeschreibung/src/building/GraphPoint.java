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
    private String floorname ="";
    private boolean isRoom = false;


    public GraphPoint(Double x, Double y, String name)
    {
        this.x = x;
        this.y = y;
        this.name = name;
    }
    
    public GraphPoint(Double x, Double y, String name, boolean isRoom)
    {
        this(x, y, name);
        this.isRoom = isRoom;
    }
    
    public GraphPoint(List<Double> points, String name)
    {
        this(points.get(0), points.get(1), name);
    }
    
    public GraphPoint(List<Double> points, String name, boolean isRoom)
    {
        this(points.get(0), points.get(1), name);
        this.isRoom = isRoom;
    }
    
    public boolean isRoom(){return this.isRoom;}
    
    public void setFloorname(String floorname){this.floorname = floorname;}
    
    public GraphPoint getPredecessor(){return predecessor;}
    
    public void setPredecessor(GraphPoint predecessor){this.predecessor = predecessor;}
    
    public double getX(){return x;}
    
    public double getY(){return y;}

    public String getName(){return this.name;}
    
    public Double getShortesDistance(){return shortesDistance;}
    
    public void setShortesDistance(Double shortesDistance){this.shortesDistance = shortesDistance;}
    
    public List<String> getNeighboursAsString(){return neighbours;} 
    
    public void addToNeighbours(GraphPoint point){this.graphPoints.add(point);}
    
    public List<GraphPoint> getNeighboursAsGraphPointObject(){return graphPoints;}
    
    public void setNeighboursOfGraphPoint(List<String> neighbours){this.neighbours = neighbours;}
    
    public Double calculateDistanceToNeighbour(GraphPoint point)
    {
        Double localDistance;
        localDistance =  Math.hypot(x - y,point.getX() - point.getY());
        return localDistance;
    }
    
    @Override
    public String toString()
    {
        return floorname + ":" + name;
    }
}
