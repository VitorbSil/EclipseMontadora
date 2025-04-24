package br.com.montadora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.montadora.model.Caminhao;

public class CaminhaoDAO {
	private Connection con = null;

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public CaminhaoDAO(Connection con) {
		setCon(con);
	}
	
	public String inserir(Caminhao caminhao) {
		String sql = "insert into Caminhao (montadora, nome, quantidaderodas) values (?,?,?)";
		try {
			 PreparedStatement ps = getCon().prepareStatement(sql);
			 ps.setString(1, caminhao.getMontadora());
			 ps.setString(2, caminhao.getNomeVeiculo());
			 ps.setInt(3, caminhao.getQuantidadeRodas());
			 
			 if(ps.executeUpdate() > 0) {
				 return "Caminhao inserido com sucesso!";
			 }else {
				 return "Erro ao inserir caminhão";
			 }
		}catch(SQLException e) {
			return e.getMessage();
		}
	}
	
	public String deletar(Caminhao caminhao) {
		String sql = "delete from Caminhao where montadora = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			
			ps.setString(1, caminhao.getMontadora());
			
			if(ps.executeUpdate() > 0) {
				return "Caminhao deletado com sucesso!";
			}else {
				return "Erro ao deletar";
			}
		}catch(SQLException e) {
			return e.getMessage();
		}
	}
	

}
