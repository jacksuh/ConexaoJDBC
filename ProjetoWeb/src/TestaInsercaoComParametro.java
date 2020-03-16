import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TestaInsercaoComParametro {

public static void main(String[] args) throws SQLException {
		ConnectionFactory factory = new ConnectionFactory();
		try(Connection connection = factory.recuperarConexao()){
		
		connection.setAutoCommit(false);
	try (
		PreparedStatement stm = connection.prepareStatement("INSERT INTO PRODUTO(id, nome, descricao) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
			){
		adicionarVariavel( 19,"SmartTVv","45 polegadass", stm);
		adicionarVariavel( 20,"Radios","Radio de baterias", stm);
		
		connection.commit();
		
		}catch(Exception e){
		e.printStackTrace();
		System.out.println("Rollback executado");
		connection.rollback();
	}
	}
}
	
	private static void adicionarVariavel(int id, String nome, String descricao, PreparedStatement stm)throws SQLException{
		stm.setInt(1, id);
		stm.setString(2, nome);
		stm.setString(3, descricao);
		
		
		stm.execute();
		
		try(ResultSet rst = stm.getGeneratedKeys()){
		while(rst.next()){
			Integer id1 = rst.getInt(1);
			System.out.println("o id criado foi" + id1);
		}
	}
	}
}
