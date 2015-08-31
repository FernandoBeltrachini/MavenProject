package dataConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import element.Comic;
import element.Loan;

public class LoanConnections extends DataBaseConnections<Loan> {

	@Override
	public String add(Loan l) {
		if (l.getComic() != null && l.getPerson() != null) {
			ComicConnections c = new ComicConnections();
			String id = l.getComic().getId().toString();
			l.setComic(c.getComicById(id));
			if (l.getComic() == null)
				return "Couldnt get Comic";

			if (!(l.getComic().getCopys() > getCantLoans(l.getComic())))
				return "No Copys availables";

			try {
				if (ConnectionSingleton.getInstance() != null) {
					PreparedStatement p = ConnectionSingleton.getInstance().con.prepareStatement("INSERT INTO LOAN (idComic,idPerson) VALUES (?,?)");
					p.setInt(1, l.getComic().getId());
					p.setInt(2, l.getPerson().getId());
					p.executeUpdate();
				} else
					return "Cant open data base Connections";
			} catch (SQLException e) {
				return "Cant insert Loan";
			}
			return null;
		}
		return "Couldnt get the person or comic ";
	}

	@Override
	public String remove(String id) {
		try {
			if (ConnectionSingleton.getInstance() != null) {
				PreparedStatement p = ConnectionSingleton.getInstance().con.prepareStatement("DELETE FROM LOAN WHERE ID=?");
				p.setInt(1, new Integer(id));

				p.executeUpdate();
			} else
				return "Cant open data base Connections";
		} catch (SQLException e) {
			return "Cant erase Loan";
		}
		return null;
	}

	@Override
	public String modify(Loan l) {
		if (l.getComic() != null && l.getPerson() != null) {
			try {
				if (ConnectionSingleton.getInstance() != null) {
					PreparedStatement p = ConnectionSingleton.getInstance().con.prepareStatement("UPDATE LOAN SET IDCOMIC=?,IDPERSON=? WHERE ID=?");
					p.setInt(1, l.getComic().getId());
					p.setInt(2, l.getPerson().getId());
					p.setInt(3, l.getId());
					p.executeUpdate();
				} else
					return "Cant open data base Connections";
			} catch (SQLException e) {
				return "Couldnt modify Loan";
			}
			return null;
		}
		return "Couldnt get the person or comic ";
	}

	public Integer getCantLoans(Comic c) {

		try {
			if (ConnectionSingleton.getInstance() != null){
				PreparedStatement p = ConnectionSingleton.getInstance().con.prepareStatement("SELECT COUNT(*) FROM LOAN where idComic=?");
				p.setInt(1, c.getId());
				ResultSet rs = p.executeQuery();
				rs.next();
				return rs.getInt(1);
				}
			else
				return 0;

		} catch (SQLException e) {

			return 0;
		}
	}

	public ArrayList<Loan> getAllLoans() {
		ArrayList<Loan> retorno = new ArrayList<Loan>();
		try {
			if (ConnectionSingleton.getInstance() != null){
				PreparedStatement p = ConnectionSingleton.getInstance().con
						.prepareStatement("SELECT * FROM COMIC C INNER JOIN LOAN L ON L.IDCOMIC = C.ID INNER JOIN PERSON P ON L.IDPERSON = P.ID");
				ResultSet rs = p.executeQuery();
	
				while (rs.next()) {
	
					retorno.add(new Loan(rs));
				}
				return retorno;
			}
			return null;
		} catch (SQLException e) {
			return null;
		}
	}

}
