package servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface BookDAO {
	//공통적인 로직
	public Connection getConnection() throws SQLException;
	public void close(PreparedStatement ps, Connection conn)throws SQLException;
	public void close(ResultSet rs,PreparedStatement ps, Connection conn)throws SQLException;
	
	//비지니스로직...2
	public void registerBook(Book book)throws SQLException;
	public ArrayList<Book> showAllBook()throws SQLException;
}









