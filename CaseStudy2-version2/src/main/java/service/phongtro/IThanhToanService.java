package service.phongtro;

import model.customer.CustomerType;
import model.phongtro.ThanhToan;

import java.util.List;

public interface IThanhToanService {
    List<ThanhToan> findAll();
}
