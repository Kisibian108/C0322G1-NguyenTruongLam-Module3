package service.hokhau.Impl;

import model.hokhau.GiaDinh;
import repository.hokhau.IGiaDinhRepository;
import repository.hokhau.Impl.GiaDinhRepositoryImpl;
import service.hokhau.IGiaDinhService;

import java.util.List;

public class GiaDinhServiceImpl implements IGiaDinhService {

    IGiaDinhRepository giaDinhRepository = new GiaDinhRepositoryImpl();
    @Override
    public List<GiaDinh> findAll() {
        return giaDinhRepository.findAll();
    }
}
