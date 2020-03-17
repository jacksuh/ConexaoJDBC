import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.jdbc.modelo.Produto;


public class TestaInsercaoComProduto {
	
	public static void main(String[] args) throws SQLException {
		
		
		Produto comoda = new Produto(26 ,"Comoda", "Comoda Vertical");
		
		try(Connection connection = new ConnectionFactory().recuperarConexao()){
			
			String sql = "INSERT INTO PRODUTO (ID,NOME,DESCRICAO)VALUES(?,?,?)";
			
			try(PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
					
					pstm.setInt(1, comoda.getId());
					pstm.setString(2, comoda.getNome());
					pstm.setString(3, comoda.getDescricao());
					
					pstm.execute();
					
					try(ResultSet rst = pstm.getGeneratedKeys()){
						while(rst.next()){
							comoda.setId(rst.getInt(1));
							
						}
					}
		}
	}
}

}