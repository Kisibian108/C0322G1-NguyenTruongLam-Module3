package repository.test;

import model.customer.CustomerType;
import model.test.BenhNhan;
import repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BenhNhanRepositoryImpl implements IBenhNhanRepository{
    static List<BenhNhan> benhNhanArrayList = new ArrayList<>();
    private static final String FIND_ALL = "SELECT * FROM benh_nhan join ";
    @Override
    public List<BenhNhan> findAll() {
        benhNhanArrayList.clear();
        try {
            Connection connection = new BaseRepository().getConnection();
//          Tạo câu lệnh SQL
            PreparedStatement preparedStatement =
                    connection.prepareStatement(FIND_ALL);
//          Dùng executeQuery/Update để thực thi.
//          ResultSet : Nhận kết quả từ DB trả về để xử lý
            ResultSet resultSet = preparedStatement.executeQuery();
            BenhNhan benhNhan = null;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("ma_benh_nhan");
                benhNhan = new BenhNhan(id, name);
                benhNhanArrayList.add(benhNhan);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return benhNhanArrayList;
    }
    }

