package service.test;

import model.test.BenhNhan;
import repository.test.BenhNhanRepositoryImpl;
import repository.test.IBenhNhanRepository;

import java.util.List;

public class BenhNhanServiceImpl implements IBenhNhanService {

    IBenhNhanRepository benhNhanRepository = new BenhNhanRepositoryImpl();
    @Override
    public List<BenhNhan> findAll() {
        return benhNhanRepository.findAll();
    }
}
