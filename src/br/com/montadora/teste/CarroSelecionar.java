package br.com.montadora.teste;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.montadora.conexao.Conexao;
import br.com.montadora.dao.CarroDAO;
import br.com.montadora.model.Carro;

public class CarroSelecionar {
	public static void main(String[] args) {
		Connection con = Conexao.abrirConexao();
		CarroDAO carrodao = new CarroDAO(con);
		
		
		ArrayList<Carro> lista= carrodao.retornarDados();
		
		if(lista != null)
			for(Carro carro: lista) {
				System.out.println("Montadora: " + carro.getMontadora());
				System.out.println("Nome: " + carro.getNomeVeiculo());
				System.out.println("Quantidade de Portas: " + carro.getQuantidadePortas());
				System.out.println("----------------------");
			}
		
		Conexao.fecharConexao(con);
	}
}