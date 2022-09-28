package repository.hokhau.Impl;

import model.hokhau.HoKhau;
import model.phongtro.PhongTro;
import repository.BaseRepository;
import repository.hokhau.IHoKhauRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HoKhauRepositoryImpl implements IHoKhauRepository {

    static List<HoKhau> hoKhauList = new ArrayList<>();

    private static final String FIND_ALL = "SELECT * FROM ho_khau ";
    private static final String FIND_BY_ID = "SELECT * FROM ho_khau where id = ? ";
    private static final String UPDATE = " UPDATE ho_khau SET ma_ho_khau_id = ?, ten_chu_ho = ? , so_luong_thanh_vien = ? , " +
            " ngay_lap_ho_khau = ?, dia_chi_nha = ?  where id = ? ";


    @Override
    public List<HoKhau> findAll() {
        hoKhauList.clear();
        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            HoKhau hoKhau = null;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int maHoKhau = resultSet.getInt("ma_ho_khau_id");
                String tenChuHoId = resultSet.getString("ten_chu_ho");
                String soLuongThanhVien = resultSet.getString("so_luong_thanh_vien");
                String ngayLapHoKhau = resultSet.getString("ngay_lap_ho_khau");
                String diaChiNha = resultSet.getString("dia_chi_nha");

                hoKhau = new HoKhau(id, maHoKhau, tenChuHoId, soLuongThanhVien, ngayLapHoKhau, diaChiNha);
                hoKhauList.add(hoKhau);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return hoKhauList;
    }

    @Override
    public void edit(HoKhau hoKhau) {
        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(UPDATE);
            preparedStatement.setInt(1, hoKhau.getIdHoKhau());
            preparedStatement.setString(2, hoKhau.getName());
            preparedStatement.setString(3, hoKhau.getNumber());
            preparedStatement.setString(4, hoKhau.getDate());
            preparedStatement.setString(5, hoKhau.getAddress());
            preparedStatement.setInt(6, hoKhau.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public HoKhau findById(int id) {
        HoKhau hoKhau = null;
        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(FIND_BY_ID);

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idS = resultSet.getInt("id");
                int maHoKhau = resultSet.getInt("ma_ho_khau_id");
                String tenChuHoId = resultSet.getString("ten_chu_ho");
                String soLuongThanhVien = resultSet.getString("so_luong_thanh_vien");
                String ngayLapHoKhau = resultSet.getString("ngay_lap_ho_khau");
                String diaChiNha = resultSet.getString("dia_chi_nha");

                hoKhau = new HoKhau(idS, maHoKhau, tenChuHoId, soLuongThanhVien, ngayLapHoKhau, diaChiNha);
                hoKhauList.add(hoKhau);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return hoKhau;
    }


}
