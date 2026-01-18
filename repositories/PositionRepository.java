package repositories;

import models.Position;

import java.util.ArrayList;
import java.util.List;

public class PositionRepository {
    private List<Position> positionList = new ArrayList<>();

    public PositionRepository(){
        positionList.add(new Position(1, "Junior"));
        positionList.add(new Position(2, "Senior"));
        positionList.add(new Position(3, "Lead"));
        positionList.add(new Position(4, "Manager"));
    }

    public List<Position> getAllPositions(){
        return positionList;
    }
    public Position getById(int id){
        for(Position position: positionList){
            if(position.getId()==id){
                return position;
            }
        }
        return null;
    }
}
