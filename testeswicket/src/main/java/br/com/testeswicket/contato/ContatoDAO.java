package br.com.testeswicket.contato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {
	
	private Connection conexao;
	
	private static final String INSERT_SQL = "INSERT INTO contato (nome, email, telefone) VALUES (?, ?, ?)";
	private static final String LIST_SQL = "SELECT id, nome, email, telefone FROM contato WHERE nome LIKE ?";

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
	
	public List<Contato> listarPorNome(String nome){
		List<Contato> contatos = new ArrayList<Contato>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conexao.prepareStatement(LIST_SQL);
			ps.setString(1, nome + "%");
			rs = ps.executeQuery();
			
			while(rs.next()){
				Contato contato = new Contato();
				contato.setId(rs.getInt(1));
				contato.setNome(rs.getString(2));
				contato.setEmail(rs.getString(3));
				contato.setTelefone(rs.getString(4));
				contatos.add(contato);
			}
			return contatos;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if(ps != null){
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}
		}
		
	}

}
