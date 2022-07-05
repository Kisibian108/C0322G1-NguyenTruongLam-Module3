package service.employee;

import model.employee.Position;
import repository.employee.IPositionRepository;
import repository.employee.PositionRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class IPositionServiceImpl implements IPositionService{
    IPositionRepository positionRepository = new PositionRepositoryImpl();
    @Override
    public List<Position> findAll() throws SQLException {
        return positionRepository.findAll();
    }
}
