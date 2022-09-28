package service.hokhau.Impl;

import model.hokhau.HoKhau;
import repository.hokhau.IHoKhauRepository;
import repository.hokhau.Impl.HoKhauRepositoryImpl;
import service.hokhau.IHoKhauService;

import java.util.List;

public class HoKhauServiceImpl implements IHoKhauService {

    IHoKhauRepository hoKhauRepository = new HoKhauRepositoryImpl();
    @Override
    public List<HoKhau> findAll() {
        return hoKhauRepository.findAll();
    }

    @Override
    public void edit(HoKhau hoKhau) {
        hoKhauRepository.edit(hoKhau);
    }

    @Override
    public HoKhau findById(int id) {
        return hoKhauRepository.findById(id);
    }
}
