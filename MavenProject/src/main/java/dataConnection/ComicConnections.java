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
			PreparedStatement p = ConnectionSingleton.getInstance().con.prepareStatement("INSERT INTO COMIC (NAME,TYPE,COPYS) VALUES (?,?,?)");
			p.setString(1, c.getName());
			p.setString(2,c.getType());
			p.setInt(3,c.getCopys());
			p.executeUpdate();

		} catch (SQLException e) {
			
			return "Error al insertar un comic";
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
					PreparedStatement p = ConnectionSingleton.getInstance().con.prepareStatement("DELETE FROM COMIC WHERE ID=?");
					p.setInt(1, c.getId());
					p.executeUpdate();
				} catch (SQLException e) {
				
					return "Error al eliminar un comic";
				}
			}
			return null;
		} else
			return "No existe el comic";

	}

	@Override
	public String modify(Comic c) {
		if (c.getId() == null || c.getId() == 0)
			c = getComic(c);
		if (c != null) {
			try {
				PreparedStatement p = ConnectionSingleton.getInstance().con.prepareStatement("UPDATE COMIC SET NAME=?, TYPE=?,COPYS=? WHERE ID=?");
				p.setString(1, c.getName());
				p.setString(2, c.getType());
				p.setInt(3, c.getCopys());
				p.setInt(4, c.getId());
				p.executeUpdate();

			} catch (SQLException e) {
				return "Error al insertar un comic";
			}
			return null;
		}
		return "No se pudo obtener el comic";
	}

	public ArrayList<Comic> getAll() {

		PreparedStatement p = null;
		try {
			p = ConnectionSingleton.getInstance().con.prepareStatement("SELECT * FROM COMIC");
			ResultSet rs = p.executeQuery();
			ArrayList<Comic> retorno = new ArrayList<Comic>();
			while (rs.next()) {

				retorno.add(new Comic(rs));
			}
			return retorno;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Integer getId(Comic c) {
		try {
			
			PreparedStatement p = ConnectionSingleton.getInstance().con.prepareStatement("SELECT ID FROM COMIC where NAME=? AND TYPE=?");
			p.setString(1, c.getName());
			p.setString(2, c.getType());
			p.executeUpdate();
			ResultSet rs = p.executeQuery();
			rs.next();
			return rs.getInt(1);

		} catch (SQLException e) {

			return null;
		}

	}

	public Comic getComic(Comic c) {


		try {
			PreparedStatement p = ConnectionSingleton.getInstance().con.prepareStatement("SELECT ID,COPYS FROM COMIC where NAME=? AND TYPE=?");
			p.setString(1, c.getName());
			p.setString(2, c.getType());
			ResultSet rs = p.executeQuery();
			if (!rs.next())
				return null;
			c.setId(rs.getInt(1));
			c.setCopys(rs.getInt(2));
			return c;

		} catch (SQLException e) {
			return null;
		}

	}
	
	public Comic getComicById(String id){
			try {
				
				PreparedStatement p = ConnectionSingleton.getInstance().con.prepareStatement("SELECT NAME,COPYS,TYPE FROM COMIC where ID=?");
				p.setString(1, id);
				ResultSet rs = p.executeQuery();
				if (!rs.next())
					return null;
				Comic c = new Comic(rs.getString(3), rs.getString(1), rs.getInt(2));
				c.setId(new Integer(id));
				return c;

			} catch (SQLException e) {
				return null;
			}
		
	}

}
