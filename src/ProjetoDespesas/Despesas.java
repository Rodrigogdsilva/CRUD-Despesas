package ProjetoDespesas;

import dadostelas.ManterDespesas;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Despesas {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		int ops = 1;

		while (ops != 0) {

			JOptionPane.showMessageDialog(null,
					" ENTRE 1 - Cadastrar Despesa \n ENTRE 2 - Listar Despesa \n ENTRE 3 - Buscar Despesa \n ENTRE 4 - Soma total dos produtos \n ENTRE 5 - Excluir um produto \n ENTRE 0 - Para sair e encerrar o programa");

			ops = Integer.parseInt(JOptionPane.showInputDialog("OPÇÃO"));

			switch (ops) {

			case 1:

				ManterDespesas.Cadastrar();

				break;

			case 2:

				ManterDespesas.Listar();

				break;

			case 3:

				ManterDespesas.Buscar();

				break;

			case 4:

				ManterDespesas.Somar();

				break;

			case 5:

				ManterDespesas.Excluir();

				break;

			case 0:

				System.exit(0);

				break;
			}
		}
	}
}
