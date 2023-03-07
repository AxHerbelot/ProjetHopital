package projetHopital.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import projetHopital.model.Patient;
import projetHopital.model.Visite;

public class VisiteDaoImp implements VisiteDao{

	@Override
	public void insert(Visite obj) {
		try {
			PreparedStatement preparedStatement = Context.getContext().getConnection().prepareStatement("insert into visite(numeroVisite,idPatient,idMedecin,cout,salle,dateVisite) values(?,?,?,20,?,?)");
			preparedStatement.setInt(1, obj.getNumeroVisite());
			preparedStatement.setInt(2, obj.getPatient().getIdPatien());
			preparedStatement.setInt(3, obj.getIdMedecin());
			preparedStatement.setString(4, obj.getSalle());
			preparedStatement.setDate(5, Date.valueOf(obj.getDateVisite()));
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch(SQLException e) {e.printStackTrace();} finally {Context.destroy();}
	}

	@Override
	public void update(Visite obj) {
		 try {
			PreparedStatement preparedStatement=Context.getContext().getConnection().prepareStatement("update compte set idPatient=?, idMedecin=?, cout=20, salle=?, dateVisite=?  where inumeroVisite=?");
			preparedStatement.setInt(1, obj.getPatient().getIdPatien());
			preparedStatement.setInt(2, obj.getIdMedecin());
			preparedStatement.setString(3, obj.getSalle());
			preparedStatement.setDate(4, Date.valueOf(obj.getDateVisite()));
			preparedStatement.setInt(5, obj.getNumeroVisite());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {e.printStackTrace();} finally {Context.destroy();}
	}

	@Override
	public void deleteByKey(Integer key) {
		try {
			PreparedStatement preparedStatement=Context.getContext().getConnection().prepareStatement("delete from visite where numeroVisite=?");
			preparedStatement.setInt(1,key);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {e.printStackTrace();} finally {Context.destroy();}
		
	}

	@Override
	public void delete(Visite obj) {
		deleteByKey(obj.getNumeroVisite());
		
	}

	private Patient getPatient(ResultSet rs) throws SQLException {
		Patient patient = new Patient(rs.getInt("idPatient"), rs.getString("nom"), rs.getString("prenom")); 
		return patient;
	}
	
	@Override
	public Visite findByKey(Integer key) {
		try {
			PreparedStatement preparedStatement=Context.getContext().getConnection().prepareStatement(
					"select v.*, p.nom, p.prenom "
					+ "from visite v "
					+ "join patient p "
					+ "where v.idPatient=p.idPatient "
					+ "and numeroVisite=?");
			preparedStatement.setInt(1,key);
			ResultSet rs=preparedStatement.executeQuery();
			if(rs.next()) {
				Visite visiteRes = new Visite(rs.getInt("numeroVisite"), null ,rs.getInt("idMedecin"), rs.getString("salle"),rs.getDate("dateVisite").toLocalDate());
				visiteRes.setPatient(getPatient(rs));
				return visiteRes;
			}
			preparedStatement.close();
		} catch (SQLException e) {e.printStackTrace();} finally {Context.destroy();}

		System.out.println("findKey unsuccessful");
		return null;
	}

	@Override
	public List<Visite> findAll() {
		List<Visite> tabFull=new ArrayList<>();
		try {
			PreparedStatement preparedStatement=Context.getContext().getConnection().prepareStatement(
					"select v.*, p.nom, p.prenom "
					+ "from visite v "
					+ "join patient p "
					+ "where v.idPatient=p.idPatient");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				tabFull.add(new Visite(rs.getInt("numeroVisite"), getPatient(rs) ,rs.getInt("idMedecin"), rs.getString("salle"),rs.getDate("dateVisite").toLocalDate()));
			}
		} catch (SQLException e) {e.printStackTrace();} finally {Context.destroy();}
		return tabFull;
	}
	
}
