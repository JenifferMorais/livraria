package br.edu.ifg.projetoweb.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifg.projetoweb.model.Usuario;
import br.edu.ifg.projetoweb.utils.Hashing;

public class UsuarioDAO {
	private Connection connection;
	private PreparedStatement statement;
	private boolean estadoOperacao;

	public UsuarioDAO(Connection connection) {
		this.connection = connection;
	}

	public long inserirUsuario(Usuario usuario) throws SQLException {
		String sql = null;
		long id_gerado = 0;
		estadoOperacao = false;

		try {
			connection.setAutoCommit(false);
			sql = "INSERT INTO usuario (nome, password, telefone, email, imagem) VALUES(?,?,?,?,?)";
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, usuario.getNome());
			statement.setString(2, usuario.getPassword());
			statement.setString(3, usuario.getTelefone());
			statement.setString(4, usuario.getEmail());
			statement.setString(5, usuario.getImagem());

			estadoOperacao = statement.executeUpdate() > 0;
			if (estadoOperacao == false) {
				throw new SQLException("Falha no cadastro de usuário!");

			}
			try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					id_gerado = generatedKeys.getLong(1);

				} else {
					throw new SQLException("Falha no cadastro de usuário, nenhum ID obtido.");
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

	public void alterarUsuario(Usuario usuario) {

		String parameter = usuario.getPassword() != null && usuario.getPassword().trim().length() != 0 ? ",password = ?"
				: "";
		String sql = (String.format("UPDATE usuario SET nome = ?, email = ?, telefone = ?, imagem =? %s WHERE id = ?",
				parameter));

		try {
			statement = connection.prepareStatement(sql.toString());

			statement.setString(1, usuario.getNome());
			statement.setString(2, usuario.getEmail());
			statement.setString(3, usuario.getTelefone());
			statement.setString(4, usuario.getImagem());

			if (usuario.getPassword() != null && usuario.getPassword().trim() != "") {

				statement.setString(5, usuario.getPassword());
				statement.setInt(6, usuario.getId());
			} else {
				statement.setInt(5, usuario.getId());
			}
			statement.executeUpdate();
			statement.close();
			System.out.println("Sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean isAdmin(int id) {
		try {
			String sql = "SELECT COUNT(id) FROM usuario WHERE admin = true AND id = ?;";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);

			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				if (resultSet.getInt(1) != 0) {
					return true;
				}
				statement.close();
			}
		} catch (NullPointerException e) {
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void removerUsuario(int id) {
		try {
			String sql = "DELETE FROM usuario where id = ?;";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Usuario buscarUsuario(int id) {
		try {
			String sql = "SELECT id, nome, email, telefone, password, admin, imagem FROM usuario WHERE id=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				Usuario usuario = new Usuario();

				usuario.setId(resultSet.getInt(1));
				usuario.setNome(resultSet.getString(2));
				usuario.setEmail(resultSet.getString(3));
				usuario.setTelefone(resultSet.getString(4));
				usuario.setPassword(resultSet.getString(5));
				usuario.setAdmin(resultSet.getBoolean(6));
				usuario.setImagem(resultSet.getString(7));

				return usuario;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Usuario> listarUsuario() throws SQLException {
		ResultSet resultSet = null;
		List<Usuario> listaUsuario = new ArrayList<>();
		String sql = null;
		estadoOperacao = false;

		try {
			sql = "SELECT id, nome, email, telefone, imagem FROM usuario ORDER BY nome ASC";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(resultSet.getInt(1));
				usuario.setNome(resultSet.getString(2));
				usuario.setEmail(resultSet.getString(3));
				usuario.setTelefone(resultSet.getString(4));
				usuario.setImagem(resultSet.getString(5));
				listaUsuario.add(usuario);
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaUsuario;
	}

	public Usuario login(String email, String password) {
		String sql = null;
		try {
			connection.setAutoCommit(false);
			sql = "SELECT id, email, password FROM usuario where email=?;";
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, email);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				String dbPassword = resultSet.getString(3);
				Hashing bCrypt = new Hashing(11);
				estadoOperacao = bCrypt.verifyHash(password, dbPassword);
				if (estadoOperacao) {
					int id = resultSet.getInt(1);
					return buscarUsuario(id);
				}
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
