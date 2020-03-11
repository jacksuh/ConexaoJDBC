import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {

	public Connection recuperarConexao() throws SQLException{
		
		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/loja_virtual?useTimezone=true&serverTimezone=UTC","postgres","admin");
		
	}
}
