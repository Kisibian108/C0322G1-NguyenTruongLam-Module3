package service.facility;

import model.facility.FacilityType;

import java.sql.SQLException;
import java.util.List;

public interface IFacilityTypeService {
    List<FacilityType> findAll() throws SQLException;
}
