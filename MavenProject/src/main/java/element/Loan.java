package element;

import java.sql.ResultSet;
import java.sql.SQLException;

import dataConnection.ComicConnections;
import dataConnection.PersonConnections;

public class Loan extends Element{
	
	private Comic comic;
	private Person person;
	
	public Loan (Comic comic, Person person){
		this.comic = comic;
		this.person = person;
		if (this.comic.getId() == null || this.comic.getId() != 0){
			ComicConnections c = new ComicConnections();
			this.comic = c.getComic(this.comic);
		}
		if (this.person.getId() == null || this.comic.getId() != 0){
			PersonConnections p = new PersonConnections();
			this.person = p.getPerson(this.person);
		}
	}
	
	public Loan (ResultSet rs){
		try {
			this.id = rs.getInt(7);
			this.comic = new Comic(rs.getString(3),rs.getString(2));
			this.person = new Person (rs.getString(8),rs.getString(9));
		} catch (SQLException e) {
		}
		
		
	}
	
	public Loan (String comicId,String personId){
		this.comic = new Comic(comicId);
		this.person = new Person(personId);
		
	}
	
	public Loan(Integer loanId) {
		this.id = loanId;
	}

	public Comic getComic() {
		return comic;
	}
	public void setComic(Comic comic) {
		this.comic = comic;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	
	

}
