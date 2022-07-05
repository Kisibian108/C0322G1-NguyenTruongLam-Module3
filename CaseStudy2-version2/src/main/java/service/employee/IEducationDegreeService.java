package service.employee;

import model.employee.Division;
import model.employee.EducationDegree;

import java.sql.SQLException;
import java.util.List;

public interface IEducationDegreeService {
    List<EducationDegree> findAll() throws SQLException;

}
