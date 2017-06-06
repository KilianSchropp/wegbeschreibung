package calculator;

import java.util.ArrayList;
import java.util.List;

import building.Room;

public class CalculateRoute
{
    List<Room> storeShortestPath = new ArrayList<Room>();
    List<Room> localeStore = new ArrayList<Room>();
    double routeLenght = Double.MAX_VALUE;
    
    public void search(Room root, Room end, double localLenght)
    {
        List<Room> neighbours = root.getNeighboursAsRoomObject();
        
        if(!neighbours.isEmpty()) //maybe last leaf so no further check because we know there is nothing more
        {
            localeStore.add(root);
            
            if(neighbours.contains(end))
            {
                localLenght += root.calculateDistanceToNeighbour(end);
                if(localLenght < routeLenght)
                {
                    routeLenght = localLenght;
                    storeShortestPath = localeStore;
                    storeShortestPath.add(end);
                }
            }
            else
            {
                double storeLocalLenght = localLenght;
                for(Room neighbour : neighbours)
                {
                    localLenght = storeLocalLenght;
                    localLenght += root.calculateDistanceToNeighbour(neighbour);
                    search(neighbour, end, localLenght);
                }
            }
            localeStore.remove(localeStore.size()-1);  
        }
    }
}
