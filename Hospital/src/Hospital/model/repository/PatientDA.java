package Hospital.model.repository;

import Hospital.model.entity.Patient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PatientDA implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public PatientDA() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "mahdi", "mahdi123");
        connection.setAutoCommit(false);
    }

    public void insert(Patient patient) throws Exception {
        preparedStatement = connection.prepareStatement("insert into patient (id,name,family,typeOfIllness,receptionDate,Doctor) values (?,?,?,?,?,?)");
        preparedStatement.setLong(1, patient.getId());
        preparedStatement.setString(2, patient.getName());
        preparedStatement.setString(3, patient.getFamily());
        preparedStatement.setString(4, patient.gettypeOfIllness());
        preparedStatement.setString(5, patient.getreceptionDate());
        preparedStatement.setString(6, patient.getDoctor());
        preparedStatement.executeUpdate();
    }

    public void update(Patient patient) throws Exception {
        preparedStatement = connection.prepareStatement("update patient set name=? , family=? , typeOfIllness=?, receptionDate=?, Doctor=? where id=?");
        preparedStatement.setString(1, patient.getName());
        preparedStatement.setString(2, patient.getFamily());
        preparedStatement.setString(4, patient.gettypeOfIllness());
        preparedStatement.setString(5,patient.getreceptionDate());
        preparedStatement.setString(6,patient.getDoctor());
        preparedStatement.setLong(3, patient.getId());
        preparedStatement.executeUpdate();
    }

    public void delete(String family) throws Exception {
        preparedStatement = connection.prepareStatement("delete from patient where family=?");
        preparedStatement.setString(1, family);
        preparedStatement.executeUpdate();
    }

    public Patient selectOne(String family) throws Exception {
        preparedStatement = connection.prepareStatement("select * from patient where family=?");
        preparedStatement.setString(1, family);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            Patient patient = new Patient();
            patient.setId(resultSet.getInt("id"));
            patient.setName(resultSet.getString("name"));
            patient.setFamily(resultSet.getString("family"));
            patient.settypeOfIllness(resultSet.getString("typeOfIllness"));
            patient.setreceptionDate(resultSet.getString("receptionDate"));
            patient.setDoctor(resultSet.getString("Doctor"));
            return patient;
        }
        throw new Exception();
    }

    public List<Patient> selectAll() throws Exception {
        preparedStatement = connection.prepareStatement("select * from patient");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Patient> patientList = new ArrayList<>();
        while (resultSet.next()) {
            Patient patient = new Patient();
            patient.setId(resultSet.getInt("id"));
            patient.setName(resultSet.getString("name"));
            patient.setFamily(resultSet.getString("family"));
            patient.settypeOfIllness(resultSet.getString("typeOfIllness"));
            patient.setreceptionDate(resultSet.getString("receptionDate"));
            patient.setDoctor(resultSet.getString("Doctor"));
            patientList.add(patient);
        }
        return patientList;
    }

    public void close() throws Exception {
        connection.commit();
        preparedStatement.close();
        connection.close();
    }
}


