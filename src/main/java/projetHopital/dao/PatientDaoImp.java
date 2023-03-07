package projetHopital.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import projetHopital.model.Patient;

public class PatientDaoImp implements PatientDao{

	PatientDaoImp(){}

	@Override
	public void insert(Patient obj) {
		try {
			PreparedStatement preparedStatement = Context.getContext().getConnection().prepareStatement("insert into patient(idPatient,nom,prenom) values(?,?,?)");
			preparedStatement.setInt(1, obj.getIdPatien());
			preparedStatement.setString(2, obj.getNom());
			preparedStatement.setString(3, obj.getPrenom());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch(SQLException e) {e.printStackTrace();} finally {Context.destroy();}
	}

	@Override
	public void update(Patient obj) {
		 try {
			PreparedStatement preparedStatement=Context.getContext().getConnection().prepareStatement("update patient set nom=?, prenom=? where idPatient=?");
			preparedStatement.setString(1, obj.getNom());
			preparedStatement.setString(2, obj.getPrenom());
			preparedStatement.setInt(3, obj.getIdPatien());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {e.printStackTrace();} finally {Context.destroy();}
	}

	@Override
	public void delete(Patient obj) {
		deleteByKey(obj.getIdPatien());
		
	}

	@Override
	public void deleteByKey(Integer key) {
		try {
			PreparedStatement preparedStatement=Context.getContext().getConnection().prepareStatement("delete from patient where idPatient=?");
			preparedStatement.setInt(1,key);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {e.printStackTrace();} finally {Context.destroy();}
		
	}

	@Override
	public Patient findByKey(Integer key) {
		try {
			PreparedStatement preparedStatement=Context.getContext().getConnection().prepareStatement("select * from patient where idPatient=?");
			preparedStatement.setInt(1,key);
			ResultSet rs=preparedStatement.executeQuery();
			if(rs.next()) {
				Patient patientRes = new Patient(rs.getInt("idPatient"), rs.getString("nom"),rs.getString("prenom"));
				return patientRes;
			}
			preparedStatement.close();
		} catch (SQLException e) {e.printStackTrace();} finally {Context.destroy();}

		
		return null;
	}

	@Override
	public List<Patient> findAll() {
		List<Patient> tabFull=new ArrayList<>();
		try {
			PreparedStatement preparedStatement=Context.getContext().getConnection().prepareStatement("select * from patient");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				tabFull.add(new Patient(rs.getInt("idPatient"),rs.getString("nom"),rs.getString("prenom")));
			}
		} catch (SQLException e) {e.printStackTrace();} finally {Context.destroy();}
		return tabFull;
	}
	

}
