package br.com.montadora.teste;

import java.sql.Connection;

import br.com.montadora.conexao.Conexao;
import br.com.montadora.dao.CaminhaoDAO;
import br.com.montadora.model.Caminhao;

public class CaminhaoInserir {
	public static void main (String[] args) {
		Connection con = Conexao.abrirConexao();
		
		Caminhao caminhao = new Caminhao();
		CaminhaoDAO caminhaodao = new CaminhaoDAO(con);
		
		caminhao.setMontadora("QualquerCoisa");
		caminhao.setNomeVeiculo("OutraCoisa");
		caminhao.setQuantidadeRodas(12);
		
		System.out.println(caminhaodao.inserir(caminhao));
		
		Conexao.fecharConexao(con);
	}

}
