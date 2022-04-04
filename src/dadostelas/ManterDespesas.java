package dadostelas;

import dadosbean.Despesas;
import dadoscontrole.ControleDespesas;
import dadosdao.DaoDespesas;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

public class ManterDespesas {
	static int Id;
	static String Item;
	static float Valor;
	static float SomaDespesas;

	static ControleDespesas contD;

	public static void Cadastrar() throws SQLException, ClassNotFoundException {
		Item = JOptionPane.showInputDialog("Item");
		Valor = Float.parseFloat(JOptionPane.showInputDialog("Valor"));
		// SomaDespesas = (float.parseFloat( Valor));
		Despesas sEntrada = new Despesas(Item, Valor);
		contD = new ControleDespesas();
		Despesas sSaida = contD.inserir(sEntrada);
		JOptionPane.showMessageDialog(null, sSaida.toString());
	}

	public static void Listar() throws SQLException, ClassNotFoundException {
		// Id = Integer.parseInt(JOptionPane.showInputDialog("Id"));

		for (int i = 0; i < 10; i++) {
			Despesas sEntrada = new Despesas(Id);
			contD = new ControleDespesas();
			List<Despesas> sSaida = contD.listar(sEntrada);
			sSaida.forEach((sServ) -> {
				JOptionPane.showMessageDialog(null, sServ.toString());
			});
		}
	}

	public static void Alterar() throws SQLException, ClassNotFoundException {
		Id = Integer.parseInt(JOptionPane.showInputDialog("id"));
		Item = JOptionPane.showInputDialog("Item");
		Valor = Float.parseFloat(JOptionPane.showInputDialog("Valor"));
		Despesas sEntrada = new Despesas(Id, Item, Valor);
		contD = new ControleDespesas();
		Despesas sSaida = contD.alterar(sEntrada);
		JOptionPane.showMessageDialog(null, sSaida.toString());
	}

	public static void Buscar() throws SQLException, ClassNotFoundException {
		Id = Integer.parseInt(JOptionPane.showInputDialog("Id"));
		Despesas sEntrada = new Despesas(Id);
		contD = new ControleDespesas();
		Despesas sSaida = contD.buscar(sEntrada);
		JOptionPane.showMessageDialog(null, sSaida.toString());
	}

	public static void Excluir() throws SQLException, ClassNotFoundException {
		Id = Integer.parseInt(JOptionPane.showInputDialog("Id"));
		Despesas sEntrada = new Despesas(Id);
		contD = new ControleDespesas();
		Despesas sSaida = contD.excluir(sEntrada);
		JOptionPane.showMessageDialog(null, sSaida.toString());
	}

	public static void Somar() throws SQLException, ClassNotFoundException {

		DaoDespesas s = new DaoDespesas();
		s.calcularTotal();
	}
}
