package repository.facility;

import model.facility.FacilityType;

import java.sql.SQLException;
import java.util.List;

public interface IFacilityTypeRepository {
    List<FacilityType> findAll() throws SQLException;

}
