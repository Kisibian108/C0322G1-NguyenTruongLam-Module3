package service.employee;

import model.employee.Division;
import repository.employee.DivisionRepositoryImpl;
import repository.employee.IDivisionRepository;

import java.sql.SQLException;
import java.util.List;

public class IDevisionServiceImpl implements IDisivionService{
    IDivisionRepository divisionRepository = new DivisionRepositoryImpl();
    @Override
    public List<Division> findAll() throws SQLException {
        return divisionRepository.findAll();
    }
}
