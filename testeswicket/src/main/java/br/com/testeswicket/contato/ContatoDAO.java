package br.com.testeswicket.contato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContatoDAO {
	
	private Connection conexao;
	
	private static final String INSERT_SQL = "INSERT INTO contato (nome, email, telefone) VALUES (?, ?, ?)";

	public ContatoDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void inserir(Contato contato){
		PreparedStatement ps = null;
		try {
			ps = conexao.prepareStatement(INSERT_SQL);
			ps.setString(1, contato.getNome());
			ps.setString(2, contato.getEmail());
			ps.setString(3, contato.getTelefone());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			if(ps != null){
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}
		}
	}

}
