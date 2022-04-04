package dadosdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import dadosbean.Despesas;
import util.ConexaoDb;

public class DaoDespesas {

	private final Connection c;

	public DaoDespesas() throws SQLException, ClassNotFoundException {
		this.c = new ConexaoDb().getConnection();
	}

	public Despesas buscar(Despesas s) throws SQLException {
		String sql = "select * from svc_Despesas WHERE svc_id = ?";
		Despesas retorno;
		// seta os valores
		try (PreparedStatement stmt = this.c.prepareStatement(sql)) {
			// seta os valores
			stmt.setInt(1, s.getId());
			// executa
			ResultSet rs = stmt.executeQuery();
			retorno = null;
			while (rs.next()) {
				// criando o objeto Usuario
				retorno = new Despesas(rs.getInt(1), rs.getString(2), rs.getFloat(3));
				// adiciona o usu à lista de pessoa
			}
		}
		c.close();
		return retorno;

	}

	public Despesas inserir(Despesas s) throws SQLException {
		String sql = "insert into svc_Despesas" + " (svc_Item,svc_Valor)" + " values (?,?)";

		// seta os valores
		try ( // prepared statement para inserção
				PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			// seta os valores

			stmt.setString(1, s.getItem());
			stmt.setFloat(2, s.getValor());

			// executa
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				int Id = rs.getInt(1);
				s.setId(Id);
			}
		}
		c.close();
		return s;
	}

	public Despesas alterar(Despesas s) throws SQLException {
		String sql = "UPDATE svc_Despesas SET svc_Item = ?, svc_Valor = ?,WHERE svc_id = ?";
		// seta os valores
		try ( // prepared statement para inserção
				PreparedStatement stmt = c.prepareStatement(sql)) {
			// seta os valores
			stmt.setString(1, s.getItem());
			stmt.setFloat(2, s.getValor());
			stmt.setInt(3, s.getId());

			// executa
			stmt.execute();
		}
		return s;

	}

	public Despesas excluir(Despesas s) throws SQLException {
		String sql = "delete from svc_Despesas WHERE svc_id = ?";
		// seta os valores
		try ( // prepared statement para inserção
				PreparedStatement stmt = c.prepareStatement(sql)) {
			// seta os valores
			stmt.setInt(1, s.getId());
			// executa
			stmt.execute();
		}
		c.close();
		return s;
	}

	public void consultar(Despesas s) throws SQLException {
		// usus: array armazena a lista de registros

		String sql = "select * from svc_Despesas";
		// seta os valores
		try (PreparedStatement stmt = this.c.prepareStatement(sql)) {

			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					// criando o objeto Usuario
					Despesas sSaida = new Despesas();
					sSaida.setId(rs.getInt("Id"));
					sSaida.setItem(rs.getString("Item"));
					sSaida.setValor(rs.getFloat("Valor"));

				}
			} finally {
				stmt.close();
			}
		}

	}

	public List<Despesas> listar(Despesas despesas) throws SQLException {

		String sql = "select * from svc_Despesas";

		PreparedStatement stmt = c.prepareStatement(sql);

		// REALIZ A CONSULTA NO BANCO
		ResultSet rs = stmt.executeQuery();
		rs.next();

		List<Despesas> list = new ArrayList<Despesas>();

		while (rs.next()) {

			Despesas saida = new Despesas();

			saida.setId(rs.getInt("Id"));
			saida.setItem(rs.getString("Item"));
			saida.setValor(rs.getFloat("Valor"));
			list.add(saida);

		}

		return list;

	}

	public void calcularTotal() {
		double total = 0;
		try {
			Statement stm = c.createStatement();

			ResultSet rs = stm.executeQuery("SELECT sum(svc_Valor)AS total FROM svc_Despesas");
			while (rs.next()) {
				total = rs.getDouble("total");
			}
		} catch (SQLException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JOptionPane.showMessageDialog(null, "Valor total em R$ : " + total);

	}

}
