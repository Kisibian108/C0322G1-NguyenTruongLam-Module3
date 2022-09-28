package service.phongtro.Impl;

import model.phongtro.ThanhToan;
import repository.phongtro.IThanhToanRepository;
import repository.phongtro.Impl.ThanhToanRepositoryImpl;
import service.phongtro.IThanhToanService;

import java.util.List;

public class ThanhToanServiceImpl implements IThanhToanService {
    IThanhToanRepository thanhToanRepository = new ThanhToanRepositoryImpl();
    @Override
    public List<ThanhToan> findAll() {
        return thanhToanRepository.findAll();
    }
}
