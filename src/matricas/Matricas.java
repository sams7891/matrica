package matricas;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Matricas {

	static ArrayList<MatricasObjekts> matricas = new ArrayList<>();
	
	public static void izveidotMatricu() {
		int rindas = 0, kolonas = 0;
		String pagVertiba;
		
		do {
			try {
				pagVertiba = (String) JOptionPane.showInputDialog(null, "Ievadi matricas rindas skaitu", "Jautājums", JOptionPane.QUESTION_MESSAGE, null, null, 3);
				
				if(pagVertiba == null)
					break;
				
				rindas = Integer.parseInt(pagVertiba);
				
				
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Ievadiet korektu vērtību", "Brīdinājums", JOptionPane.WARNING_MESSAGE);
			}
			
			
			if(rindas <= 0)
				JOptionPane.showMessageDialog(null, "Ievadiet korektu vērtību", "Brīdinājums", JOptionPane.WARNING_MESSAGE);
			
		}while(rindas < 1);
		
		do {
			try {
				pagVertiba = (String) JOptionPane.showInputDialog(null, "Ievadi matricas kolonnu skaitu", "Jautājums", JOptionPane.QUESTION_MESSAGE, null, null, 3);
				
				if(pagVertiba == null)
					break;
				
				kolonas = Integer.parseInt(pagVertiba);
				
				
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Ievadiet korektu vērtību", "Brīdinājums", JOptionPane.WARNING_MESSAGE);
			}
			
			
			if(kolonas <= 0)
				JOptionPane.showMessageDialog(null, "Ievadiet korektu vērtību", "Brīdinājums", JOptionPane.WARNING_MESSAGE);
			
		}while(kolonas < 1);
		
		double[][] matricasVertibas = new double[rindas][kolonas];
		boolean korektaVertiba;
		
		for(int i = 0; i < rindas; i++) {
			for(int j = 0; j < kolonas; j++) {
				do {
					
					try {
						pagVertiba = (String) JOptionPane.showInputDialog(null, "Ievadiet " + ( i + 1 )+ ". rindas " + ( j + 1 ) + ". kolonnas vērtibu", "Jautājums", JOptionPane.QUESTION_MESSAGE);
						
						matricasVertibas[i][j] = Integer.parseInt(pagVertiba);
						korektaVertiba = true;
					}catch(NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Ievadiet korektu vērtību", "Brīdinājums", JOptionPane.WARNING_MESSAGE);
						korektaVertiba = false;

					}
					
				}while(!korektaVertiba);
			}
		}
		MatricasObjekts matrica = new MatricasObjekts(kolonas, kolonas, matricasVertibas);
		matricas.add(matrica);
		
	}

	
	
}
