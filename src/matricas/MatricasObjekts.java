package matricas;

public class MatricasObjekts {
	
	int rindas, kolonnas;
	double[][] vertibas;
	
	MatricasObjekts(int r, int k, double[][] vertibas){
		this.rindas = r;
		this.kolonnas = k;
		this.vertibas = vertibas;
	}
	
	public MatricasObjekts() {
	}

	double[][] Saskaitit(double[][] matrica1, int r1, int k1, double[][] matrica2, int r2, int k2){
	    if(!(r1 == r2 && k1 == k2))
	        return null;

	    double[][] matrica = new double[r1][k1];

	    for(int i = 0; i < r1; i++) {
	        for(int j = 0; j < k1; j++) {
	            matrica[i][j] = matrica1[i][j] + matrica2[i][j];
	        }
	    }

	    return matrica;
	}
	
	double[][] Atnemt(double[][] matrica1, int r1, int k1, double[][] matrica2, int r2, int k2){
	    if(!(r1 == r2 && k1 == k2))
	        return null;

	    double[][] matrica = new double[r1][k1];

	    for(int i = 0; i < r1; i++) {
	        for(int j = 0; j < k1; j++) {
	            matrica[i][j] = matrica1[i][j] - matrica2[i][j];
	        }
	    }

	    return matrica;
	}

	
	String nolasit(double[][] matrica, int r, int k) {
		
		String teksts = "";
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < k; j++) {
				teksts += matrica[i][j];
				
				if(matrica[i][j] >= 0)
					teksts += " ";
				
				if(matrica[i][j] < 10) {
					teksts += "   ";
				} else if(matrica[i][j] < 100) {
					teksts += "  ";
				}else {
					teksts += " ";
				}
			}
			teksts += "\n";
		}
		
		return teksts;
		
	}
	
}
