package matricas;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		String[] opcijas = {"Izveidot matricu", "Apskatit matricas", "saskaitīt matricu"};
		String izv;
		
		do {
			izv = (String) JOptionPane.showInputDialog(null, "Izvēlies operāciju", "Izvēlne", JOptionPane.PLAIN_MESSAGE, null, opcijas, opcijas[0]);
			
			if(izv == null)
				break;
			
			switch(izv) {
			case "Izveidot matricu":
				Matricas.izveidotMatricu();
				break;
			
			case "Apskatit matricas":
				Matricas.apskatitMatricas();
				break;
				
			case "saskaitīt matricu":
				Matricas.apskatitMatricas();
				break;
			}
			
		}while(izv != null);
	}

}
