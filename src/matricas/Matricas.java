package matricas;

import javax.swing.JOptionPane;

public class Matricas {

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
	}

	
	
}
