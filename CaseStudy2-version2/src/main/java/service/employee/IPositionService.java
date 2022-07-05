package service.employee;

import model.employee.Division;
import model.employee.Position;

import java.sql.SQLException;
import java.util.List;

public interface IPositionService {
    List<Position> findAll() throws SQLException;
}
