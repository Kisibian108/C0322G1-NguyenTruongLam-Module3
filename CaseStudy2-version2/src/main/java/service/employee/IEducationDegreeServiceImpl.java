package service.employee;

import model.employee.EducationDegree;
import repository.employee.EducationRepositoryImpl;
import repository.employee.IEducationDegreeRepository;

import java.sql.SQLException;
import java.util.List;

public class IEducationDegreeServiceImpl implements IEducationDegreeService{
    IEducationDegreeRepository educationDegreeRepository = new EducationRepositoryImpl();
    @Override
    public List<EducationDegree> findAll() throws SQLException {
        return educationDegreeRepository.findAll();
    }
}
