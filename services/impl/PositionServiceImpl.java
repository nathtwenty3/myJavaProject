package services.impl;

import models.Position;
import repositories.PositionRepository;
import services.PositionService;

import java.util.List;

public class PositionServiceImpl implements PositionService {
    private PositionRepository positionRepository;
    public PositionServiceImpl(){
        positionRepository = new PositionRepository();
    }

    @Override
    public List<Position> getAllPositions() {
        return positionRepository.getAllPositions();
    }

    @Override
    public Position getPositionsById(int id) {
        return positionRepository.getById(id);
    }
}
