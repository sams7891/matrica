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
		
		teksts = matricas.get(izv).nolasit(matricas.get(izv).vertibas, matricas.get(izv).rindas, matricas.get(izv).kolonnas);
		
		
		JOptionPane.showMessageDialog(null, teksts, "Matrica", JOptionPane.PLAIN_MESSAGE);
	}
			
	public static void saskaititMatricas() {
		
		String teksts = "", pagVert;
		boolean korektaVertiba;
		int izv1 = 0, izv2 = 0;
		
		for(int i = 0; i < matricas.size(); i++) {
			teksts += ( i + 1 ) + " - Matrica ar rindu un kolonnu skaitu: " + matricas.get(i).rindas + "; " + matricas.get(i).kolonnas + "\n";
		}
		
		do {
			try {
				pagVert = JOptionPane.showInputDialog(null, "Kuru matricu apskatīsi\n" + teksts, "Jautājums", JOptionPane.QUESTION_MESSAGE);
				
				if(pagVert == null)
					return;
				
				izv1 = Integer.parseInt(pagVert) - 1;
				korektaVertiba = true;
			}catch(NumberFormatException e) {
				korektaVertiba = false;
			}
		}while(!korektaVertiba);
		
		do {
			try {
				pagVert = JOptionPane.showInputDialog(null, "Kuru matricu apskatīsi\n" + teksts, "Jautājums", JOptionPane.QUESTION_MESSAGE);
				
				izv2 = Integer.parseInt(pagVert) - 1;
				korektaVertiba = true;
			}catch(NumberFormatException e) {
				korektaVertiba = false;
			}
		}while(!korektaVertiba);
		
		MatricasObjekts matrica = new MatricasObjekts();
		matrica.vertibas = matrica.Saskaitit(matricas.get(izv1).vertibas, matricas.get(izv1).rindas, matricas.get(izv1).kolonnas, matricas.get(izv2).vertibas, matricas.get(izv2).rindas, matricas.get(izv2).kolonnas);
		matrica.kolonnas = matricas.get(izv1).rindas;
		matrica.rindas = matricas.get(izv1).kolonnas;
		
		if(matrica.vertibas != null) {
			JOptionPane.showMessageDialog(null, matrica.nolasit(matrica.vertibas, matrica.rindas, matrica.kolonnas));
			matricas.add(matrica);
		} else {
			JOptionPane.showMessageDialog(null, "Nevarēja saskaitīt matricu", "Nav iespējams", JOptionPane.WARNING_MESSAGE);
		}
			
	}
	
		public static void atnemtMatricas() {
			
			String teksts = "", pagVert;
			boolean korektaVertiba;
			int izv1 = 0, izv2 = 0;
			
			for(int i = 0; i < matricas.size(); i++) {
				teksts += ( i + 1 ) + " - Matrica ar rindu un kolonnu skaitu: " + matricas.get(i).rindas + "; " + matricas.get(i).kolonnas + "\n";
			}
			
			do {
				try {
					pagVert = JOptionPane.showInputDialog(null, "Kuru matricu apskatīsi\n" + teksts, "Jautājums", JOptionPane.QUESTION_MESSAGE);
					
					if(pagVert == null)
						return;
					
					izv1 = Integer.parseInt(pagVert) - 1;
					korektaVertiba = true;
				}catch(NumberFormatException e) {
					korektaVertiba = false;
				}
			}while(!korektaVertiba);
			
			do {
				try {
					pagVert = JOptionPane.showInputDialog(null, "Kuru matricu apskatīsi\n" + teksts, "Jautājums", JOptionPane.QUESTION_MESSAGE);
					
					izv2 = Integer.parseInt(pagVert) - 1;
					korektaVertiba = true;
				}catch(NumberFormatException e) {
					korektaVertiba = false;
				}
			}while(!korektaVertiba);
			
			MatricasObjekts matrica = new MatricasObjekts();
			matrica.vertibas = matrica.Saskaitit(matricas.get(izv1).vertibas, matricas.get(izv1).rindas, matricas.get(izv1).kolonnas, matricas.get(izv2).vertibas, matricas.get(izv2).rindas, matricas.get(izv2).kolonnas);
			matrica.kolonnas = matricas.get(izv1).rindas;
			matrica.rindas = matricas.get(izv1).kolonnas;
			
			if(matrica.vertibas != null) {
				JOptionPane.showMessageDialog(null, matrica.nolasit(matrica.vertibas, matrica.rindas, matrica.kolonnas));
				matricas.add(matrica);
			} else {
				JOptionPane.showMessageDialog(null, "Nevarēja saskaitīt matricu", "Nav iespējams", JOptionPane.WARNING_MESSAGE);
			}
		
	}
}
