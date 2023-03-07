package projetHopital.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import projetHopital.model.Compte;
import projetHopital.model.Medecin;

public class CompteDaoImp implements CompteDao{

	@Override
	public void insert(Compte obj) {
		try {
			PreparedStatement preparedStatement = Context.getContext().getConnection().prepareStatement("insert into compte(id,login,mdp,typeCompte) values(?,?,?,?)");
			preparedStatement.setInt(1, obj.getId());
			preparedStatement.setString(2, obj.getLogin());
			preparedStatement.setString(3, obj.getMdp());
			preparedStatement.setString(4, obj.getTypeCompte());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch(SQLException e) {e.printStackTrace();} finally {Context.destroy();}
	}

	@Override
	public void update(Compte obj) {
		 try {
			PreparedStatement preparedStatement=Context.getContext().getConnection().prepareStatement("update compte set login=?, mdp=?, typeCompte=? where id=?");
			preparedStatement.setString(1, obj.getLogin());
			preparedStatement.setString(2, obj.getMdp());
			preparedStatement.setString(3, obj.getTypeCompte());
			preparedStatement.setInt(4, obj.getId());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {e.printStackTrace();} finally {Context.destroy();}
	}

	@Override
	public void deleteByKey(Integer key) {
		try {
			PreparedStatement preparedStatement=Context.getContext().getConnection().prepareStatement("delete from compte where id=?");
			preparedStatement.setInt(1,key);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {e.printStackTrace();} finally {Context.destroy();}
		
	}
	
	@Override
	public void delete(Compte obj) {
		deleteByKey(obj.getId());
		
	}

	@Override
	public Medecin findByKey(Integer key) {
		try {
			PreparedStatement preparedStatement=Context.getContext().getConnection().prepareStatement("select * from compte where id=?");
			preparedStatement.setInt(1,key);
			ResultSet rs=preparedStatement.executeQuery();
			if(rs.next()) {
				Medecin medecinRes = new Medecin(rs.getInt("id"), rs.getString("login"),rs.getString("mdp"));
				return medecinRes;
			}
			preparedStatement.close();
		} catch (SQLException e) {e.printStackTrace();} finally {Context.destroy();}

		
		return null;
	}

	@Override
	public List<Compte> findAll() {
		List<Compte> tabFull=new ArrayList<>();
		try {
			PreparedStatement preparedStatement=Context.getContext().getConnection().prepareStatement("select * from compte");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				tabFull.add(new Medecin(rs.getInt("id"),rs.getString("login"),rs.getString("mdp")));
			}
		} catch (SQLException e) {e.printStackTrace();} finally {Context.destroy();}
		return tabFull;
	}
}
