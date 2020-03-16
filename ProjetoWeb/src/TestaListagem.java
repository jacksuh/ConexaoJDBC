import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;





public class TestaListagem {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionfactory = new ConnectionFactory();
		Connection connection = connectionfactory.recuperarConexao();
		
		PreparedStatement stm = connection.prepareStatement("select id, nome, descricao from produto");
		stm.execute();
		ResultSet rst = stm.getResultSet();
		while(rst.next()){
			Integer id = rst.getInt("id");
			String nome = rst.getString("NOME");
			String descricao = rst.getString("Descricao");
			System.out.println(id);
			System.out.println(nome);
			System.out.println(descricao);
		}
	}

}
