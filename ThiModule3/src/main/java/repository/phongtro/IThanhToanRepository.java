package repository.phongtro;

import model.phongtro.ThanhToan;

import java.util.List;

public interface IThanhToanRepository {
    List<ThanhToan> findAll();
}
