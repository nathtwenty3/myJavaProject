package services;

import models.Position;

import java.util.List;

public interface PositionService {
    List<Position>getAllPositions();
    Position getPositionsById(int id);
}
