package service.facility;

import model.facility.Facility;
import repository.facility.FacilityRepositoryImpl;
import repository.facility.IFacilityRepository;

import java.sql.SQLException;
import java.util.List;

public class FacilityServiceImpl implements IFacilityService {

    IFacilityRepository facilityRepository = new FacilityRepositoryImpl();

    @Override
    public List<Facility> findAll() throws SQLException {
        return facilityRepository.findAll();
    }

    @Override
    public void create(Facility facility) {
        facilityRepository.create(facility);
    }

    @Override
    public void edit(Facility facility) {
        facilityRepository.edit(facility);
    }

    @Override
    public void delete(int id) {
        facilityRepository.delete(id);
    }

    @Override
    public Facility findById(int id) {
        return facilityRepository.findById(id);
    }

    @Override
    public List<Facility> findByName(String name) {
        return facilityRepository.findByName(name);
    }
}
