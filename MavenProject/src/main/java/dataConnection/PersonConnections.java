package dataConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import element.Person;

public class PersonConnections extends DataBaseConnections<Person> {

	@Override
	public String remove(String id) {
		if (id != null) {
			try {
				if (ConnectionSingleton.getInstance() != null){
					PreparedStatement ps = ConnectionSingleton.getInstance().con.prepareStatement("DELETE FROM PERSON WHERE ID=?");
					ps.setInt(1, new Integer(id));
					ps.executeUpdate();
				}
				else
					return "Couldnt get data base Connections";
			} catch (SQLException e) {
				return "Couldnt Erase the person";
			}
			return null;
		}
		return "Couldnt Get the person";
	}

	@Override
	public String modify(Person p) {
		
		if (p != null) {
			try {
				if (ConnectionSingleton.getInstance() != null){
					PreparedStatement ps = ConnectionSingleton.getInstance().con.prepareStatement("UPDATE PERSON SET NAME=?,SURNAME=? WHERE ID=?");
					ps.setString(1, p.getName());
					ps.setString(2, p.getSurname());
					ps.setInt(3, p.getId());
					ps.executeUpdate();
					}
				else
					return "Couldnt get data base Connections";
			} catch (SQLException e) {
				return "Couldnt Modify Person";
			}
			return null;
		}
		return "Person Dosnt Exist";
	}

	@Override
	public String add(Person p) {

		try {
			if (ConnectionSingleton.getInstance() != null){
				PreparedStatement ps = ConnectionSingleton.getInstance().con.prepareStatement("INSERT INTO PERSON (NAME,SURNAME) VALUES (?,?)");
				ps.setString(1, p.getName());
				ps.setString(2, p.getSurname());
				ps.executeUpdate();
			}
			else
				return "Couldnt get data base Connections";
		} catch (SQLException e) {
			return "Couldnt inser a person";
		}
		return null;
	}

	public Person getPerson(Person p) {

		try {
			if (ConnectionSingleton.getInstance() != null){
				PreparedStatement ps = ConnectionSingleton.getInstance().con.prepareStatement("SELECT ID,NAME,SURNAME FROM PERSON where NAME=? AND SURNAME=?");
				ps.setString(1, p.getName());
				ps.setString(2, p.getSurname());
				ResultSet rs = ps.executeQuery();
				if (!rs.next())
					return null;
				p.setId(rs.getInt(1));
				return p;
				}
			return null;

		} catch (SQLException e) {

			return null;
		}

	}
	
	public Person getPersonById(String id) {

		try {
			if (ConnectionSingleton.getInstance() != null){
				PreparedStatement ps = ConnectionSingleton.getInstance().con.prepareStatement("SELECT NAME,SURNAME FROM PERSON where ID=?");
				ps.setInt(1, new Integer(id));
				ResultSet rs = ps.executeQuery();
				if (!rs.next())
					return null;
				Person p = new Person(rs.getString(1),rs.getString(2));
				p.setId(new Integer(id));
				return p;}
			else
				return null;

		} catch (SQLException e) {
			return null;
		}

	}
	
	public ArrayList<Person> getAll() {

		PreparedStatement p = null;
		try {
			if (ConnectionSingleton.getInstance() != null){
				p = ConnectionSingleton.getInstance().con.prepareStatement("SELECT * FROM PERSON");
				ResultSet rs = p.executeQuery();
				ArrayList<Person> retorno = new ArrayList<Person>();
				while (rs.next()) {
	
					retorno.add(createPerson(rs));
				}
				return retorno;
				}
			return null;
		} catch (SQLException e) {
			return null;
		}
	}

	private Person createPerson(ResultSet rs) {
		Person retorno = null;
		try {
			retorno = new Person (rs.getString(2),rs.getString(3));
			retorno.setId(rs.getInt(1));
		} catch (SQLException e) {
			return null;
		}
		
		return retorno;
	}

}
