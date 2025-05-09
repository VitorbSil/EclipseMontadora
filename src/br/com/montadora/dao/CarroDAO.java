package br.com.montadora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.montadora.model.Carro;

public class CarroDAO {
	private Connection con = null;

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public CarroDAO(Connection con) {
		setCon(con);
	}

	public String inserir(Carro carro) {
		String sql = "insert into Carro(montadora, nome, quantidadeportas) values (?,?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, carro.getMontadora());
			ps.setString(2, carro.getNomeVeiculo());
			ps.setInt(3, carro.getQuantidadePortas());
			if (ps.executeUpdate() > 0) {
				return "Carro adicionado com sucesso!";
			} else {
				return "Erro ao inserir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public String deletar(Carro carro) {
		String sql = "delete from Carro where montadora = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, carro.getMontadora());
			if (ps.executeUpdate() > 0) {
				return "Carro deletado com sucesso";
			} else {
				return "Erro ao deletar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public String alterar(Carro carro) {
		String sql = "update Carro set montadora = ? where nome = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, carro.getMontadora());
			ps.setString(2, carro.getNomeVeiculo());
			if (ps.executeUpdate() > 0) {
				return "Atualizado com sucesso";
			} else {
				return "Erro ao atualizar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public ArrayList<Carro> retornarDados() {
		String sql = "select * from Carro";
		ArrayList<Carro> retornarCarro = new ArrayList<Carro>();

		try 
		{
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) 
			{
				while (rs.next())
				{
					Carro carro = new Carro();
					carro.setNomeVeiculo(rs.getString(1));
					carro.setMontadora(rs.getString(2));
					carro.setQuantidadePortas(rs.getInt(3));
					retornarCarro.add(carro);
				}
				return retornarCarro;
			} 
			else 
			{
				return null;
			}
		} 
		catch (SQLException e)
		{
			return null;
		}
	}

	
	
	
	
	
	
	
	
	
}