package service.employee;

import model.employee.Division;

import java.sql.SQLException;
import java.util.List;

public interface IDisivionService {
    List<Division> findAll() throws SQLException;
}
