package repository.employee;

import model.employee.Division;
import model.employee.Position;

import java.sql.SQLException;
import java.util.List;

public interface IPositionRepository {
    List<Position> findAll() throws SQLException;

}
