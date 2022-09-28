package service.test;

import model.test.BenhAn;
import repository.test.BenhAnRepository;
import repository.test.IBenhAnRepository;

import java.util.List;

public class BenhAnServiceImple implements IBenhAnService{

    IBenhAnRepository benhAnRepository = new BenhAnRepository();
    @Override
    public List<BenhAn> findAll() {
        return benhAnRepository.findAll();
    }
}
