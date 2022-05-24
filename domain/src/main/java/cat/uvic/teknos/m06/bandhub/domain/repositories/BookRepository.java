package cat.uvic.teknos.m06.bandhub.domain.repositories;

import cat.uvic.teknos.m06.bandhub.domain.exceptions.RepositoryException;
import cat.uvic.teknos.m06.bandhub.domain.models.book;
import java.util.Date;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BookRepository {
    private final Connection connection;

    public BookRepository(Connection connection) {
        this.connection = connection;
    }
    public void insert(book book ) {
        try (var prepareStatement = connection.prepareStatement("INSERT INTO book VALUES (?, ?)")) {
            prepareStatement.setString(1, book.getCod_book);
            prepareStatement.setString(2, book.getTitle);


            prepareStatement.executeUpdate();

            prepareStatement.close();
        }
        catch (SQLException e) {
            throw new RepositoryException("Exception while executing getAll", e);
        }
    }
    public void update(book book, String id){
        try (var prepareStatement = connection.prepareStatement("UPDATE book set title=? where cod_book=?")) {
            book book = null;
            prepareStatement.setString(1, book.getTitle);
            prepareStatement.setInt(2, id);


            prepareStatement.executeUpdate();

            prepareStatement.close();
        catch (SQLException e) {
            throw new RepositoryException("Exception while executing update", e);
        }
    }


    public void delete(String cod) {
        try (var prepareStatement = connection.prepareStatement("delete from book where cod_book= ?")){
            prepareStatement.setInt(1, cod);
            prepareStatement.executeUpdate();

            prepareStatement.close();

        }
        catch (SQLException e) {
            throw new RepositoryException("Exception while executing delete<", e);
        }
    }


    public book GetById(String id) {
        try (var preparedStatement = connection.prepareStatement("select * from book where cod_book = ?")) {
            book book = null;
            preparedStatement.setString(1, id);

            var resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                book = new book();

                book.setCod_book(resultSet.getInt("cod_book"));
                book.setTitle(resultSet.getString("title"));



            }

            return book;
        } catch (SQLException e) {
            throw new RepositoryException("Exception while executing GetById", e);
        }
    }
    public List<book> getAll() {
        var books = new ArrayList<book>();//ficar dins try i el return tambe haveure si funciona
        try (var Statement = connection.createStatement()) {

            var resultSet = Statement.executeQuery("select * from book");
            while (resultSet.next()) {
                book = new book();
                book.setCod_book(resultSet.getInt("cod_book"));
                book.setTitle(resultSet.getString("title"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return books;
    }
}
