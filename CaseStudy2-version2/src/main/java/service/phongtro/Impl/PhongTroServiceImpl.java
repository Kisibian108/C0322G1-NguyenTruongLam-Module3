package service.phongtro.Impl;

import common.Validate;
import model.phongtro.PhongTro;
import repository.phongtro.IPhongTroRepository;
import repository.phongtro.Impl.PhongTroRepositoryImpl;
import service.phongtro.IPhongTroService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhongTroServiceImpl implements IPhongTroService {

    IPhongTroRepository phongTroRepository = new PhongTroRepositoryImpl();

    @Override
    public List<PhongTro> findAll() {
        return phongTroRepository.findAll();
    }
//    private int id;
//    private String idRent;
//    private String name;
//    private String phone;
//    private String startDate;
//    private int paymentId;
//    private String note;

    @Override
    public Map<String, String> create(PhongTro phongTro) {
        Map<String,String> mapValidate = new HashMap<>();

        if (phongTro.getName().equals("")){
            mapValidate.put("name","Ten ko dc de trong");
        } else if(!phongTro.getName().matches(Validate.REGEX_NAME)){
            mapValidate.put("name","Ten sai dinh dang");
        }
        if (phongTro.getPhone().equals("")){
            mapValidate.put("phone","Sdt ko dc de trong");}
        else if (!phongTro.getPhone().matches(Validate.REGEX_PHONE_NUMBER)){
            mapValidate.put("phone","phone sai dinh dang");
        }

        if (!phongTro.getNote().matches(Validate.REGEX_NOTE)){
            mapValidate.put("note","note sai dinh dang");
        }
        if (mapValidate.isEmpty()){
            phongTroRepository.create(phongTro);
        }
        return mapValidate;
    }

    @Override
    public void edit(PhongTro phongTro) {
        phongTroRepository.edit(phongTro);
    }

    @Override
    public void delete(int id) throws SQLException {
        phongTroRepository.delete(id);
    }

    @Override
    public PhongTro findById(int id) {
        return phongTroRepository.findById(id);
    }

    @Override
    public List<PhongTro> findByName(String idRent, String name, String phone) {
        return phongTroRepository.findByName(idRent, name, phone);
    }


}
