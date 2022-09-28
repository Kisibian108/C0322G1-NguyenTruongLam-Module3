package repository.phongtro.Impl;

import model.phongtro.ThanhToan;
import model.product.Category;
import repository.BaseRepository;
import repository.phongtro.IThanhToanRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ThanhToanRepositoryImpl implements IThanhToanRepository {
    static List<ThanhToan> thanhToanList = new ArrayList<>();
    private static final String FIND_ALL = "select * from payment ";
    @Override
    public List<ThanhToan> findAll() {
        thanhToanList.clear();
        try {
            Connection connection = new BaseRepository().getConnection();
//          Tạo câu lệnh SQL
            PreparedStatement preparedStatement =
                    connection.prepareStatement(FIND_ALL);
//          Dùng executeQuery/Update để thực thi.
//          ResultSet : Nhận kết quả từ DB trả về để xử lý
            ResultSet resultSet = preparedStatement.executeQuery();
            ThanhToan thanhToan = null;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                thanhToan = new ThanhToan(id, name);
                thanhToanList.add(thanhToan);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return thanhToanList;
    }
}
