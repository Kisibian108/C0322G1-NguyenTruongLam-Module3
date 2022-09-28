package repository.phongtro.Impl;

import model.phongtro.PhongTro;
import repository.BaseRepository;
import repository.phongtro.IPhongTroRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhongTroRepositoryImpl implements IPhongTroRepository {
    static List<PhongTro> phongTroList = new ArrayList<>();
    private static final String FIND_ALL = "SELECT * FROM danh_sach_phong_tro ";
    private static final String FIND_BY_NAME = "SELECT * FROM danh_sach_phong_tro where id_rent like ? and name like ? and phone like ? ";
    private static final String FIND_BY_ID = "SELECT * FROM danh_sach_phong_tro where id = ? ";
    private static final String DELETE = "delete FROM danh_sach_phong_tro where id = ? ";
    private static final String INSERT = " INSERT INTO danh_sach_phong_tro (id_rent, name, phone, start_date, payment_id, " +
            "note ) " +
            " values( ?, ?, ?, ?, ?, ?) ";

    private static final String UPDATE = " UPDATE danh_sach_phong_tro SET id_rent = ?, name = ? , phone = ? , " +
            " start_date = ?, payment_id = ?, note = ?  where id = ? ";

    @Override
    public List<PhongTro> findAll() {
        phongTroList.clear();
        try {
            Connection connection = new BaseRepository().getConnection();
//          Tạo câu lệnh SQL
            PreparedStatement preparedStatement =
                    connection.prepareStatement(FIND_ALL);
//          Dùng executeQuery/Update để thực thi.
//          ResultSet : Nhận kết quả từ DB trả về để xử lý
            ResultSet resultSet = preparedStatement.executeQuery();
            PhongTro phongTro = null;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String idRent = resultSet.getString("id_rent");
                String name = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                String startDate = resultSet.getString("start_date");
                int paymentId = resultSet.getInt("payment_id");
                String note = resultSet.getString("note");
                phongTro = new PhongTro(id, idRent, name, phone, startDate, paymentId, note);
                phongTroList.add(phongTro);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return phongTroList;
    }

    @Override
    public void create(PhongTro phongTro) {
        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(INSERT);
            preparedStatement.setString(1, phongTro.getIdRent());
            preparedStatement.setString(2, phongTro.getName());
            preparedStatement.setString(3, phongTro.getPhone());
            preparedStatement.setString(4, (phongTro.getStartDate()));
            preparedStatement.setInt(5, phongTro.getPaymentId());
            preparedStatement.setString(6, phongTro.getNote());

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @Override
    public void edit(PhongTro phongTro) {
        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(UPDATE);
//            preparedStatement.setInt(1, customer.getId());
            preparedStatement.setString(1, phongTro.getIdRent());
            preparedStatement.setString(2, phongTro.getName());
            preparedStatement.setString(3, phongTro.getPhone());
            preparedStatement.setString(4, phongTro.getStartDate());
            preparedStatement.setInt(5, phongTro.getPaymentId());
            preparedStatement.setString(6, phongTro.getNote());
            preparedStatement.setInt(7, phongTro.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted = false;
        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public PhongTro findById(int id) {
        PhongTro phongTro = null;
        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(FIND_BY_ID);

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idS = resultSet.getInt("id");
                String idRent = resultSet.getString("id_rent");
                String name = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                String startDate = resultSet.getString("start_date");
                int paymentId = resultSet.getInt("payment_id");
                String note = resultSet.getString("note");
                phongTro = new PhongTro(idS, idRent, name, phone, startDate, paymentId, note);
                phongTroList.add(phongTro);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return phongTro;
    }

    @Override
    public List<PhongTro> findByName(String idRent, String name, String phone) {
        phongTroList.clear();
        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(FIND_BY_NAME);
            preparedStatement.setString(1, "%" + idRent + "%");
            preparedStatement.setString(2, "%" + name + "%");
            preparedStatement.setString(3, "%" + phone + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            PhongTro phongTro = null;
            while (resultSet.next()) {
                int idS = resultSet.getInt("id");
                String idRentS = resultSet.getString("id_rent");
                String nameS = resultSet.getString("name");
                String phoneS = resultSet.getString("phone");
                String startDate = resultSet.getString("start_date");
                int paymentId = resultSet.getInt("payment_id");
                String note = resultSet.getString("note");
                phongTro = new PhongTro(idS, idRentS, nameS, phoneS, startDate, paymentId, note);
                phongTroList.add(phongTro);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return phongTroList;
    }

}
