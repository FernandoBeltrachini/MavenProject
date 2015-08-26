package dataConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import element.Person;

public class PersonConnections extends DataBaseConnections<Person> {

	@Override
	public String remove(Person p) {
		if (p.getId() == null || p.getId() == 0)
			p = getPerson(p);
		if (p != null) {

			try {
				PreparedStatement ps = ConnectionSingleton.getInstance().con.prepareStatement("DELETE FROM PERSON WHERE ID=?");
				ps.setInt(1, p.getId());
				ps.executeUpdate();
			} catch (SQLException e) {
				return "Error al eliminar una persona";
			}
			return null;
		}
		return "No se pudo obtener la persona";
	}

	@Override
	public String modify(Person p) {
		if (p.getId() == null || p.getId() == 0)
			p = getPerson(p);
		if (p != null) {
			try {
				PreparedStatement ps = ConnectionSingleton.getInstance().con.prepareStatement("UPDATE PERSON SET NAME=?,SURNAME=? WHERE ID=?");
				ps.setString(1, p.getName());
				ps.setString(2, p.getSurname());
				ps.setInt(3, p.getId());
				ps.executeUpdate();
			} catch (SQLException e) {
				return "Error al modificar una persona";
			}
			return null;
		}
		return "La persona no existe en la base de datos.";
	}

	@Override
	public String add(Person p) {

		try {
			PreparedStatement ps = ConnectionSingleton.getInstance().con.prepareStatement("INSERT INTO PERSON (NAME,SURNAME) VALUES (?,?)");
			ps.setString(1, p.getName());
			ps.setString(2, p.getSurname());
			ps.executeUpdate();
		} catch (SQLException e) {
			return "Error al insertar una persona";
		}
		return null;
	}

	public Person getPerson(Person p) {

		try {
			PreparedStatement ps = ConnectionSingleton.getInstance().con.prepareStatement("SELECT ID,NAME,SURNAME FROM PERSON where NAME=? AND SURNAME=?");
			ps.setString(1, p.getName());
			ps.setString(2, p.getSurname());
			ResultSet rs = ps.executeQuery();
			if (!rs.next())
				return null;
			p.setId(rs.getInt(1));
			return p;

		} catch (SQLException e) {

			return null;
		}

	}

}
