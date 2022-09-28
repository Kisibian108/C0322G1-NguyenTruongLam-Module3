package repository.test;

import model.test.DanhSachBenhNhan;
import repository.BaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DanhSachRepositoryImpl implements IDanhSachRepository{

    static List<DanhSachBenhNhan> danhSachBenhNhans = new ArrayList<>();
    private static final String FIND_ALL = "SELECT * FROM danhsach ";
    private static final String FIND_BY_NAME = "SELECT * FROM danhsach where name like ? ";
    private static final String FIND_BY_ID = "SELECT * FROM danhsach where id = ? ";
    private static final String DELETE = "delete FROM danhsach where id = ? ";
    private static final String INSERT = " INSERT INTO danhsach (id_benh_an, id_benh_nhan, ten_benh_nhan, ngay_nhap_vien, ngay_ra_vien, " +
            "ly_do ) " +
            " values( ?, ?, ?, ?, ?, ? ) ";

    private static final String UPDATE = " UPDATE danhsach SET id_benh_an = ? , id_benh_nhan = ? , " +
            " ten_benh_nhan = ?, ngay_nhap_vien = ?,ngay_ra_vien = ?, ly_do = ?  where id = ? ";
    @Override
    public List<DanhSachBenhNhan> findAll() {
        danhSachBenhNhans.clear();
        try {
            Connection connection = new BaseRepository().getConnection();
//          Tạo câu lệnh SQL
            PreparedStatement preparedStatement =
                    connection.prepareStatement(FIND_ALL);
//          Dùng executeQuery/Update để thực thi.
//          ResultSet : Nhận kết quả từ DB trả về để xử lý
            ResultSet resultSet = preparedStatement.executeQuery();
            DanhSachBenhNhan danhSachBenhNhan = null;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int idBenhAn = resultSet.getInt("id_benh_an");
                int idBenhNhan = resultSet.getInt("id_benh_nhan");
                String name = resultSet.getString("ten_benh_nhan");
                String enter = resultSet.getString("ngay_nhap_vien");
                String outer = resultSet.getString("ngay_ra_vien");
                String reason = resultSet.getString("ly_do");

                danhSachBenhNhan = new DanhSachBenhNhan(id, idBenhAn, idBenhNhan, name, enter, outer, reason );
                danhSachBenhNhans.add(danhSachBenhNhan);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return danhSachBenhNhans;
    }

    @Override
    public void create(DanhSachBenhNhan danhSachBenhNhan) {
        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(INSERT);
            preparedStatement.setInt(1, danhSachBenhNhan.getIdBenhAn());
            preparedStatement.setInt(2, danhSachBenhNhan.getIdBenhNhan());
            preparedStatement.setString(3, danhSachBenhNhan.getName());
            preparedStatement.setDate(4, Date.valueOf(danhSachBenhNhan.getEnterDate()));
            preparedStatement.setDate(5, Date.valueOf(danhSachBenhNhan.getOutDate()));
            preparedStatement.setString(6, danhSachBenhNhan.getReason());

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void edit(DanhSachBenhNhan danhSachBenhNhan) {
        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(UPDATE);
            preparedStatement.setInt(1, danhSachBenhNhan.getIdBenhAn());
            preparedStatement.setInt(2, danhSachBenhNhan.getIdBenhNhan());
            preparedStatement.setString(3, danhSachBenhNhan.getName());
            preparedStatement.setDate(4, Date.valueOf(danhSachBenhNhan.getEnterDate()));
            preparedStatement.setDate(5, Date.valueOf(danhSachBenhNhan.getOutDate()));
            preparedStatement.setString(6, danhSachBenhNhan.getReason());
            preparedStatement.setInt(7, danhSachBenhNhan.getId());

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
    public DanhSachBenhNhan findById(int id) {
        DanhSachBenhNhan danhSachBenhNhan = null;
// cho gender dang chua nhap dc
        try {
            Connection connection = new BaseRepository().getConnection();
//          Tạo câu lệnh SQL
            PreparedStatement preparedStatement =
                    connection.prepareStatement(FIND_BY_ID);
//          Dùng executeQuery/Update để thực thi.
//          ResultSet : Nhận kết quả từ DB trả về để xử lý
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
//            int idS = resultSet.getInt("id");
//                int id = resultSet.getInt("id");
                int idBenhAn = resultSet.getInt("id_benh_an");
                int idBenhNhan = resultSet.getInt("id_benh_nhan");
                String name = resultSet.getString("ten_benh_nhan");
                String enter = resultSet.getString("ngay_nhap_vien");
                String outer = resultSet.getString("ngay_ra_vien");
                String reason = resultSet.getString("ly_do");

                danhSachBenhNhan = new DanhSachBenhNhan(id, idBenhAn, idBenhNhan, name, enter, outer, reason );
                danhSachBenhNhans.add(danhSachBenhNhan);       }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachBenhNhan;
    }

    @Override
    public List<DanhSachBenhNhan> findByName(String name) {
        return null;
    }
}
