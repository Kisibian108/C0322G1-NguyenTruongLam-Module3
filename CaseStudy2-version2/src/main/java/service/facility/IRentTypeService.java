package service.facility;

import model.facility.RentType;

import java.sql.SQLException;
import java.util.List;

public interface IRentTypeService {
    List<RentType> findAll() throws SQLException;
}
