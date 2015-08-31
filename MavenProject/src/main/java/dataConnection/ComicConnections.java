package dataConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import element.Comic;

public class ComicConnections extends DataBaseConnections<Comic> {

	
	@Override
	public String add(Comic c) {

		try {
			if (ConnectionSingleton.getInstance() != null){
				PreparedStatement p = ConnectionSingleton.getInstance().con.prepareStatement("INSERT INTO COMIC (NAME,TYPE,COPYS) VALUES (?,?,?)");
				p.setString(1, c.getName());
				p.setString(2,c.getType());
				p.setInt(3,c.getCopys());
				p.executeUpdate();
			}
			else
				return "Cant open data base Connections";
		} catch (SQLException e) {
			
			return "Cant insert Comic";
		}
		return null;
	}

	@Override
	public String remove(String id) {

		if (id != null) {
			LoanConnections loans = new LoanConnections();
			Comic c = getComicById(id);
			Integer cantLoans = loans.getCantLoans(c);
			if (c.getCopys() > 1 && c.getCopys() > cantLoans) {

				c.setCopys(c.getCopys() - 1);
				modify(c);
			} else if (cantLoans >= c.getCopys()) {
				System.out.println("Debes recuperar el comic antes de borrarlo");
			} else {
				try {
					if (ConnectionSingleton.getInstance() != null){
						PreparedStatement p = ConnectionSingleton.getInstance().con.prepareStatement("DELETE FROM COMIC WHERE ID=?");
						p.setInt(1, c.getId());
						p.executeUpdate();
						}
					else
						return "Cant open data base Connections";
				} catch (SQLException e) {
				
					return "Cant erase Comic";
				}
			}
			return null;
		} else
			return "Comic does not exists";

	}

	@Override
	public String modify(Comic c) {
		if (c.getId() == null || c.getId() == 0)
			c = getComic(c);
		if (c != null) {
			try {
				if (ConnectionSingleton.getInstance() != null){
					PreparedStatement p = ConnectionSingleton.getInstance().con.prepareStatement("UPDATE COMIC SET NAME=?, TYPE=?,COPYS=? WHERE ID=?");
					p.setString(1, c.getName());
					p.setString(2, c.getType());
					p.setInt(3, c.getCopys());
					p.setInt(4, c.getId());
					p.executeUpdate();
				}
				else
					return "Cant open data base Connections";
			} catch (SQLException e) {
				return "Cant insert Comic";
			}
			return null;
		}
		return "Cant obtain Comic";
	}

	public ArrayList<Comic> getAll() {

		PreparedStatement p = null;
		try {
			if (ConnectionSingleton.getInstance() != null){
				p = ConnectionSingleton.getInstance().con.prepareStatement("SELECT * FROM COMIC");
				ResultSet rs = p.executeQuery();
				ArrayList<Comic> retorno = new ArrayList<Comic>();
				while (rs.next()) {
	
					retorno.add(new Comic(rs));
				}
				return retorno;
				}
			else
				return null; 
		} catch (SQLException e) {
			return null;
		}
	}

	public Comic getComic(Comic c) {


		try {
			
			if (ConnectionSingleton.getInstance() != null){
				PreparedStatement p = ConnectionSingleton.getInstance().con.prepareStatement("SELECT ID,COPYS FROM COMIC where NAME=? AND TYPE=?");
				p.setString(1, c.getName());
				p.setString(2, c.getType());
				ResultSet rs = p.executeQuery();
				if (!rs.next())
					return null;
				c.setId(rs.getInt(1));
				c.setCopys(rs.getInt(2));
				return c;
				}
			return null;

		} catch (SQLException e) {
			return null;
		}

	}
	
	public Comic getComicById(String id){
			try {
				if (ConnectionSingleton.getInstance() != null){
					PreparedStatement p = ConnectionSingleton.getInstance().con.prepareStatement("SELECT NAME,COPYS,TYPE FROM COMIC where ID=?");
					p.setString(1, id);
					ResultSet rs = p.executeQuery();
					if (!rs.next())
						return null;
					Comic c = new Comic(rs.getString(3), rs.getString(1), rs.getInt(2));
					c.setId(new Integer(id));
					return c;
				}
				return null;
			} catch (SQLException e) {
				return null;
			}
		
	}

}
