package dadoscontrole;

import dadosbean.Despesas;
import dadosdao.DaoDespesas;
import java.sql.SQLException;
import java.util.List;

public class ControleDespesas {
	static DaoDespesas daoD;

	public ControleDespesas() throws SQLException, ClassNotFoundException {
		daoD = new DaoDespesas();
	}

	public Despesas inserir(Despesas cEntrada) throws SQLException {
		return daoD.inserir(cEntrada);
	}

	public List<Despesas> listar(Despesas cEntrada) throws SQLException {
		return daoD.listar(cEntrada);
	}

	public Despesas alterar(Despesas cEntrada) throws SQLException {
		return daoD.alterar(cEntrada);
	}

	public Despesas validar(Despesas cEntrada) throws SQLException {
		return daoD.alterar(cEntrada);
	}

	public Despesas buscar(Despesas sEntrada) throws SQLException {
		return daoD.buscar(sEntrada);
	}

	public Despesas excluir(Despesas cEntrada) throws SQLException {
		return daoD.excluir(cEntrada);
	}

}
