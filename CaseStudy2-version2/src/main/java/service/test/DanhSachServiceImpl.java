package service.test;

import model.test.DanhSachBenhNhan;
import repository.test.DanhSachRepositoryImpl;
import repository.test.IDanhSachRepository;

import java.sql.SQLException;
import java.util.List;

public class DanhSachServiceImpl implements IDanhSachService{
    IDanhSachRepository danhSachRepository = new DanhSachRepositoryImpl();
    @Override
    public List<DanhSachBenhNhan> findAll() {
        return danhSachRepository.findAll();
    }

    @Override
    public void create(DanhSachBenhNhan danhSachBenhNhan) {
        danhSachRepository.create(danhSachBenhNhan);
    }

    @Override
    public void edit(DanhSachBenhNhan danhSachBenhNhan) {
        danhSachRepository.edit(danhSachBenhNhan);
    }

    @Override
    public void delete(int id) throws SQLException {
        danhSachRepository.delete(id);
    }

    @Override
    public DanhSachBenhNhan findById(int id) {
        return danhSachRepository.findById(id);
    }

    @Override
    public List<DanhSachBenhNhan> findByName(String name) {
        return danhSachRepository.findByName(name);
    }
}
