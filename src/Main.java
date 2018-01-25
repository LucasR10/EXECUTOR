import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	private static final String NOME_COLUNA = "tel";
	private static final String ID = "id";

	public static void main(String[] args) throws SQLException {

		List<Coluna> telefones = new ArrayList<>();

		Connection con = ConexaoMySQL.getConexaoMySQL();

		ResultSet resultado = con.prepareStatement("SELECT c.id, c.tel  FROM tb_cliente c").executeQuery();

		while (resultado.next()) {

			String tel = resultado.getString(NOME_COLUNA);
			String id = resultado.getString(ID);

			telefones.add( new Coluna(id, tel));

			System.err.println(" Telefone : " + tel);
		}
		
		 int row = 0 ;
		 
		 for (Coluna c : telefones) {
			 
			String removerPipe = c.getTelefone().replace("|", ";");
			String novo [] =  removerPipe.split(";");
			
			String tel = novo[row];
			String dd = novo[row];
		    
			 row++;
			
			 System.out.println("Tel - " + tel + " dd "+ dd);
			 
			
		}
	}

}
