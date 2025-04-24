package br.com.montadora.teste;

import java.sql.Connection;

import br.com.montadora.conexao.Conexao;
import br.com.montadora.dao.CaminhaoDAO;
import br.com.montadora.model.Caminhao;

public class CaminhaoDeletar {
	public static void main(String[] args) {
		Connection con = Conexao.abrirConexao();
		
		Caminhao caminhao = new Caminhao();
		CaminhaoDAO caminhaodao = new CaminhaoDAO(con);
		
		caminhao.setMontadora("Qualquercoisa");
		
		System.out.println(caminhaodao.deletar(caminhao));
	}
}
