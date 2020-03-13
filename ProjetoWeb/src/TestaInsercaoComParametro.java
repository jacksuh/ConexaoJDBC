import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TestaInsercaoComParametro {

	public static void main(String[] args)throws SQLException {
		
		int id = 9;
		String nome ="Teste";
		String descricao="Mouse sem fio";
		
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();
		
		PreparedStatement stm = connection.prepareStatement("INSERT INTO PRODUTO(id, nome, descricao) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
		
		stm.setInt(1, id);
		stm.setString(2, nome);
		stm.setString(3, descricao);
		
		stm.execute();
		
		ResultSet rst = stm.getGeneratedKeys();
		while(rst.next()){
			Integer id1 = rst.getInt(1);
			System.out.println("o id criado foi" + id1);
	}
}	
}
