package br.com.montadora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.montadora.model.Carro;
import br.com.montadora.model.Moto;

public class MotoDAO {
	private Connection con = null;

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public MotoDAO(Connection con) {
		setCon(con);
	}

	public String inserir(Moto moto) 
	{
		String sql = "insert into Moto(montadora, nome, quantidadeadesivos) values (?,?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, moto.getMontadora());
			ps.setString(2, moto.getNomeVeiculo());
			ps.setInt(3, moto.getQuantidadeAdesivos());
			if (ps.executeUpdate() > 0) {
				return "Moto inserida com sucesso";
			} else {
				return "Erro ao inserir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	public String deletar(Moto moto) 
	{
		String sql = "delete from Moto where montadora = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, moto.getMontadora());
			if (ps.executeUpdate() > 0) {
				return "Moto deletada com sucesso";
			} else {
				return "Erro ao deletar a moto";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	public String atualizar(Moto moto) {
		String sql = "update Moto set montadora = ?, nome = ?, quantidadeadesivos = ? where Id > 3";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, moto.getMontadora());
			ps.setString(2, moto.getNomeVeiculo());
			ps.setInt(3, moto.getQuantidadeAdesivos());
			if (ps.executeUpdate() > 0) {
				return "Moto atualizada com sucesso";
			} else {
				return "Erro ao atualizar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	
	
	
	
	
	
	
	
}