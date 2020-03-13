import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TestaInsercaoComParametro {

	public static void main(String[] args)throws SQLException {
		
		String nome ="Mouse";
		String descricao="Mouse sem fio";
		
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();
		
		Statement stm = connection.createStatement();
		stm.execute("INSERT INTO PRODUTO(id, nome, descricao) VALUES ('6','" + nome +"','"+ descricao + "')", Statement.RETURN_GENERATED_KEYS);
		
		ResultSet rst = stm.getGeneratedKeys();
		while(rst.next()){
			Integer id = rst.getInt(1);
			System.out.println("o id criado foi" + id);
	}
}	
}
