package matricas;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class Matricas {

	static ArrayList<MatricasObjekts> matricas = new ArrayList<>();
	
	public static void izveidotMatricu() {
		int rindas = 0, kolonas = 0;
		String pagVertiba = null;
		
		do {
			try {
				pagVertiba = (String) JOptionPane.showInputDialog(null, "Ievadi matricas rindas skaitu", "Jautājums", JOptionPane.QUESTION_MESSAGE, null, null, 3);
				
				if(pagVertiba == null)
					return;
				
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
					return;
				
				kolonas = Integer.parseInt(pagVertiba);
				
				
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Ievadiet korektu vērtību", "Brīdinājums", JOptionPane.WARNING_MESSAGE);
			}
			
			
			if(kolonas <= 0)
				JOptionPane.showMessageDialog(null, "Ievadiet korektu vērtību", "Brīdinājums", JOptionPane.WARNING_MESSAGE);
			
		}while(kolonas < 1);
		
		double[][] matricasVertibas = new double[rindas][kolonas];
		boolean korektaVertiba, autoAizpilde = false;
		Random rand = new Random();
		
		for(int i = 0; i < rindas; i++) {
			for(int j = 0; j < kolonas; j++) {
				do {
					
					try {
						
						int vertiba = rand.nextInt(21)-10;
						if(!autoAizpilde)
							pagVertiba = (String) JOptionPane.showInputDialog(null, "Ievadiet " + ( i + 1 )+ ". rindas " + ( j + 1 ) + ". kolonnas vērtibu\nVai ierakstat AUTO", "Jautājums", JOptionPane.QUESTION_MESSAGE, null, null, vertiba);
						else
							pagVertiba = String.valueOf(vertiba);
						
						
						if(pagVertiba == null) {
							return;
						}else if(pagVertiba.equalsIgnoreCase("AUTO")) {
							autoAizpilde = true;
							pagVertiba = String.valueOf(vertiba);
						}
						
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

	public static void apskatitMatricas() {
		
		String teksts = "", pagVert;
		boolean korektaVertiba;
		int izv = 0;
		
		for(int i = 0; i < matricas.size(); i++) {
			teksts += ( i + 1 ) + " - Matrica ar rindu un kolonnu skaitu: " + matricas.get(i).rindas + "; " + matricas.get(i).kolonnas + "\n";
		}
		
		do {
			try {
				pagVert = JOptionPane.showInputDialog(null, "Kuru matricu apskatīsi\n" + teksts, "Jautājums", JOptionPane.QUESTION_MESSAGE);
				
				izv = Integer.parseInt(pagVert) - 1;
				korektaVertiba = true;
			}catch(NumberFormatException e) {
				korektaVertiba = false;
			}
		}while(!korektaVertiba);
		
		teksts = "";
		
		for(int i = 0; i < matricas.get(izv).rindas; i++) {
			for(int j = 0; j < matricas.get(izv).kolonnas; j++) {
				teksts += matricas.get(izv).vertibas[i][j];
				
				if(matricas.get(izv).vertibas[i][j] >= 0)
					teksts += " ";
				
				if(matricas.get(izv).vertibas[i][j] < 10) {
					teksts += "   ";
				} else if(matricas.get(izv).vertibas[i][j] < 100) {
					teksts += "  ";
				}else {
					teksts += " ";
				}
			}
			teksts += "\n";
		}
		
		JOptionPane.showMessageDialog(null, teksts, "Matrica", JOptionPane.PLAIN_MESSAGE);
	}
			
}
