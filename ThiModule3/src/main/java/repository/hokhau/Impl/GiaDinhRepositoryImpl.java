package repository.hokhau.Impl;

import model.hokhau.GiaDinh;
import model.phongtro.ThanhToan;
import repository.BaseRepository;
import repository.hokhau.IGiaDinhRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GiaDinhRepositoryImpl implements IGiaDinhRepository {

    static List<GiaDinh> giaDinhList = new ArrayList<>();
    private static final String FIND_ALL = "select * from gia_dinh ";
    @Override
    public List<GiaDinh> findAll() {
        giaDinhList.clear();
        try {
            Connection connection = new BaseRepository().getConnection();
//          Tạo câu lệnh SQL
            PreparedStatement preparedStatement =
                    connection.prepareStatement(FIND_ALL);
//          Dùng executeQuery/Update để thực thi.
//          ResultSet : Nhận kết quả từ DB trả về để xử lý
            ResultSet resultSet = preparedStatement.executeQuery();
            GiaDinh giaDinh = null;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String hoKhau = resultSet.getString("ho_khau");
                int chungMinhThu = resultSet.getInt("chung_minh_thu");
                String ho_ten = resultSet.getString("ho_ten");
                String ngaySinh = resultSet.getString("ngay_sinh");
                giaDinh = new GiaDinh(id, hoKhau,chungMinhThu,ho_ten,ngaySinh);
                giaDinhList.add(giaDinh);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return giaDinhList;
    }
}
