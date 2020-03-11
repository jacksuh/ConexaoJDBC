import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {
	
	public static void main(String[] args) throws SQLException {
		
	ConnectionFactory factory = new ConnectionFactory();
	Connection connection = factory.recuperarConexao();
	
	Statement stm = connection.createStatement();
	stm.execute("INSERT INTO PRODUTO(id, nome, descricao)VALUES('5','MOUSE','MOUSE')"
			, Statement.RETURN_GENERATED_KEYS);
	
	ResultSet rst = stm.getGeneratedKeys();
	while(rst.next()){
		Integer id = rst.getInt(1);
		System.out.println("o id criado foi" + id);
	}

}
}