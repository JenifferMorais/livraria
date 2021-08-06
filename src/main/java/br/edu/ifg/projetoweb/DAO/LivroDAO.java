package br.edu.ifg.projetoweb.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import br.edu.ifg.projetoweb.model.Livro;


public class LivroDAO {
	private Connection connection;
	private PreparedStatement statement;
	private boolean estadoOperacao;
	
	public LivroDAO(Connection connection) {
		this.connection = connection;
	}
	
	public long inserirLivro(Livro livro) throws SQLException {
		String sql = null;
		long id_gerado = 0;
		estadoOperacao = false;
		
		try {
			connection.setAutoCommit(false);
			sql = "INSERT INTO livros (isbn, nome, autor, valor, descricao) VALUES(?,?,?,?,?)";
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, livro.getISBN());
			statement.setString(2, livro.getNome());
			statement.setString(3, livro.getAutor());
			statement.setDouble(4, livro.getValor());
			statement.setString(5, livro.getDescricao());

			estadoOperacao = statement.executeUpdate() > 0;
			if (estadoOperacao == false) {
				throw new SQLException("Falha na criação do livro");

			}
			try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					id_gerado = generatedKeys.getLong(1);
					String sqlE = "INSERT INTO estoque (quantidade, livros_id) VALUES(?,?)";
					statement = connection.prepareStatement(sqlE, Statement.RETURN_GENERATED_KEYS);
					statement.setInt(1, livro.getQuantidade());
					statement.setLong(2, id_gerado);
					statement.executeUpdate();
				} else {
					throw new SQLException("Falha na criação do livro, nenhum ID obtido.");
				}
			}
			connection.commit();
			statement.close();
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}
		return id_gerado;

	}
	
	public void alterarLivro(Livro livro) {
       
       String sql = ("UPDATE livros SET isbn = ?, nome = ?, autor = ?, valor = ?, descricao = ? WHERE id = ?");
       
        try {
        	statement = connection.prepareStatement(sql.toString());
            statement.setString(1, livro.getISBN());
			statement.setString(2, livro.getNome());
			statement.setString(3, livro.getAutor());
			statement.setDouble(4, livro.getValor());
			statement.setString(5, livro.getDescricao());
			statement.setInt(6, livro.getId());
			statement.executeUpdate();
			statement.close();
			
			System.out.println("Sucesso!");
        } catch (SQLException e) {
			e.printStackTrace();
		}
    }
	
	public void alterarEstoque(Livro livro) {
		String sql = ("UPDATE estoque SET quantidade = ? WHERE livro.id = ?");
		
		try {
			statement = connection.prepareStatement(sql.toString());
			statement.setInt(1, livro.getQuantidade());
			statement.setInt(2, livro.getId());
			statement.executeUpdate();
			statement.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void removerLivro(int id) {
		try {
			String sql = "DELETE FROM livros where id = ?;";
			statement = connection.prepareStatement(sql);
			statement.setInt(1,id);
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Livro buscarLivro(int id) {
		try {
			String sql ="SELECT l.isbn, l.id, l.nome, l.autor, l.valor, l.descricao, e.quantidade FROM livros l JOIN estoque e on l.id=e.livros_id WHERE l.id=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1,id);
			ResultSet resultSet = statement.executeQuery();
			
			
			if(resultSet.next()) {
				Livro livro = new Livro();
				livro.setISBN(resultSet.getString(1));
				livro.setId(resultSet.getInt(2));
				livro.setNome(resultSet.getString(3));
				livro.setAutor(resultSet.getString(4));
				livro.setValor(resultSet.getDouble(5));
				livro.setDescricao(resultSet.getString(6));
				livro.setQuantidade(resultSet.getInt(7));
				statement.close();
				return livro;
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	public List<Livro> listarLivros() throws SQLException {
		ResultSet resultSet = null;
		List<Livro> listaLivros = new ArrayList<>();
		String sql = null;
		estadoOperacao = false;
		

		try {
			
			sql = " SELECT l.isbn, l.id, l.nome, l.autor, l.valor, l.descricao, e.quantidade FROM livros l JOIN estoque e on l.id=e.livros_id ORDER BY nome ASC;";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Livro livro = new Livro();
				livro.setISBN(resultSet.getString(1));
				livro.setId(resultSet.getInt(2));
				livro.setNome(resultSet.getString(3));
				livro.setAutor(resultSet.getString(4));
				livro.setValor(resultSet.getDouble(5));
				livro.setDescricao(resultSet.getString(6));
				livro.setQuantidade(resultSet.getInt(7));
				listaLivros.add(livro);
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaLivros;
	}
	
	
	
}
