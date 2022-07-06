package repository.facility;

import model.facility.RentType;

import java.sql.SQLException;
import java.util.List;

public interface IRentTypeRepository {
    List<RentType> findAll() throws SQLException;
}
