package dataConnection;

import java.sql.Connection;
import java.sql.DriverManager;
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
			if (!(l.getComic().getCopys() > getCantLoans(l.getComic())))
				return "No hay copias disponibles";

			try {
				PreparedStatement p = ConnectionSingleton.getInstance().con.prepareStatement("INSERT INTO LOAN (idComic,idPerson) VALUES (?,?)");
				p.setInt(1, l.getComic().getId());
				p.setInt(2, l.getPerson().getId());
				p.executeUpdate();
			} catch (SQLException e) {
				return "Error al insertar un comic";
			}
			return null;
		}
		return "No se pudo obtener la persona o el comic";
	}

	@Override
	public String remove(Loan l) {
			try {
				PreparedStatement p = ConnectionSingleton.getInstance().con.prepareStatement("DELETE FROM LOAN WHERE IDCOMIC=? AND IDPERSON=?");
				p.setInt(1, l.getComic().getId());
				p.setInt(2, l.getPerson().getId());
				p.executeUpdate();
			} catch (SQLException e) {
				return "Error al eliminar un prestamo";
			}
			return null;
	}

	@Override
	public String modify(Loan l) {
		if (l.getComic() != null && l.getPerson() != null) {
			try {
				PreparedStatement p = ConnectionSingleton.getInstance().con.prepareStatement("UPDATE LOAN SET IDCOMIC=?,IDPERSON=? WHERE ID=?");
				p.setInt(1, l.getComic().getId());
				p.setInt(2, l.getPerson().getId());
				p.setInt(3, l.getId());
				p.executeUpdate();
			} catch (SQLException e) {
				return "Error al modificar un prestamo";
			}
			return null;
		}
		return "No se pudo obtener la persona o el comic";
	}

	public Integer getCantLoans(Comic c) {

		try {
			PreparedStatement p = ConnectionSingleton.getInstance().con.prepareStatement("SELECT COUNT(*) FROM LOAN where idComic=?");
			p.setInt(1, c.getId());
			ResultSet rs = p.executeQuery();
			rs.next();
			return rs.getInt(1);

		} catch (SQLException e) {

			return 0;
		}
	}

	public ArrayList<Loan> getAllLoans() {
		ArrayList<Loan> retorno = new ArrayList<Loan>();
		try {
			PreparedStatement p = ConnectionSingleton.getInstance().con
					.prepareStatement("SELECT * FROM COMIC C INNER JOIN LOAN L ON L.IDCOMIC = C.ID INNER JOIN PERSON P ON L.IDPERSON = P.ID");
			ResultSet rs = p.executeQuery();

			while (rs.next()) {

				retorno.add(new Loan(rs));
			}
			return retorno;
		} catch (SQLException e) {
			return null;
		}
	}

}
