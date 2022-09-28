package repository.hokhau;

import model.hokhau.GiaDinh;

import java.util.List;

public interface IGiaDinhRepository {
    List<GiaDinh> findAll();
}
