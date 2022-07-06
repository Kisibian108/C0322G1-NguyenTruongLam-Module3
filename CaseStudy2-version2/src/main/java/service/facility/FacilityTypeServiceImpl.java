package service.facility;

import model.facility.FacilityType;
import repository.facility.FacilityRepositoryImpl;
import repository.facility.FacilityTypeRepositoryImpl;
import repository.facility.IFacilityRepository;
import repository.facility.IFacilityTypeRepository;

import java.sql.SQLException;
import java.util.List;

public class FacilityTypeServiceImpl implements IFacilityTypeService{
    IFacilityTypeRepository facilityTypeRepository = new FacilityTypeRepositoryImpl();
    @Override
    public List<FacilityType> findAll() throws SQLException {
        return facilityTypeRepository.findAll();
    }
}
