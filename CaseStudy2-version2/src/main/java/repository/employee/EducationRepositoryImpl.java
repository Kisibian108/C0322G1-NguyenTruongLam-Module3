package repository.employee;

import model.employee.EducationDegree;
import repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationRepositoryImpl implements IEducationDegreeRepository{

    private static final String FIND_ALL = "select * from education_degree";
    List<EducationDegree> educationDegreeList = new ArrayList<>();
    @Override
    public List<EducationDegree> findAll() throws SQLException {

        Connection connection = new BaseRepository().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
        ResultSet resultSet = preparedStatement.executeQuery();
        EducationDegree educationDegree = null;
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("education_degree_name");
            educationDegree = new EducationDegree(id, name);
            educationDegreeList.add(educationDegree);
        }
        return educationDegreeList;
    }
}
