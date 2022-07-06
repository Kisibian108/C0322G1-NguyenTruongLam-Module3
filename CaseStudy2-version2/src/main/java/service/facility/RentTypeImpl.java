package service.facility;

import model.facility.RentType;
import repository.facility.IRentTypeRepository;
import repository.facility.RentTypeRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class RentTypeImpl implements IRentTypeService{
    IRentTypeRepository rentTypeRepository = new RentTypeRepositoryImpl();
    @Override
    public List<RentType> findAll() throws SQLException {
        return rentTypeRepository.findAll();
    }
}
