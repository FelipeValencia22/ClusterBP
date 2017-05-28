package co.edu.usb.parser;

import java.io.IOException;

import org.jdom2.JDOMException;

public class Codebook {

	/**
	 * @author Hugo Ordoñez
	 * Metodo para formar el codebook de N componentes parametros una matriz con
	 * los nombres de los elementos N para formar los codebook
	 */
	public String formaCodebooN(String[][] matrizNombre, int n) throws JDOMException, IOException {

		matrizNombre = matrizNombre;
		String codeN = "";
		String codeInser = "";
		int nCodebook = n;

		if (nCodebook == 1) {

			System.out.println("  SIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII " + codeN);
			for (int i = 0; i < matrizNombre.length; i++) {

				codeN += " " + matrizNombre[i][1];
				codeInser = matrizNombre[i][1];

				System.out.println("  HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH  " + codeN);
			}


		} else {


			n = n - 1;
			for (int i = 0; i < matrizNombre.length - n; i++) {
				codeN += matrizNombre[i][1] + "_" + matrizNombre[i][2];
				codeInser = matrizNombre[i][1] + "_" + matrizNombre[i][2];
				for (int j = i; j < n + i; j++) {
					if (matrizNombre[j][2].equals(matrizNombre[j + 1][2])) {
						codeN += "_" + matrizNombre[j + 1][1];
						codeInser += "_" + matrizNombre[j + 1][1];
					} else {
						if (matrizNombre[j][1].equals(matrizNombre[j + 1][1])) {
							codeN += "_" + matrizNombre[j + 1][2];
							codeInser += "_" + matrizNombre[j + 1][2];

						} else {
							codeN += "_" + matrizNombre[j + 1][1];
							codeInser += "_" + matrizNombre[j + 1][1];

						}
					}

				}


				codeN += " ";
				codeInser = "";
			}
		}
		System.out.println("   " + codeN);
		return codeN;
	}





	/**
	 * 
	 * @author dilan steven mejia
    	codebook: Arreglo que contiene las actividades del proceso de negocio.
    	i =  Este es el eneriario del codebook, ejemplo si se quiere un codebook de 
    	4 entonces seria (0+1)*(4-1) = 3. 
    	aux = Concateno el codebook, codebook[3]+codebook[2]+codebook[1]+codebook[0]
	 **/

	public String  concatenarActividades(String[] caminoProceso,int i,String aux,int limite){
		//Mientras que i sea mayor a -1 concatena las actividades.


		if(i >= limite){
			if(caminoProceso[i]!=null){
				return concatenarActividades(caminoProceso,i-1,aux+="_"+caminoProceso[i],limite);			
			}
		}

		return aux;

	}


	/**
    codebook: Arreglo que contiene las actividades del proceso de negocio.
	 **/

	public String [] obtenerCodebook(String[] caminoProceso,int i,int n,String[] codebookAux,int j){
		j = j==0?(i+1)*(n-1):j;
		if(caminoProceso[j]==null){
			return codebookAux;
		}
		codebookAux[i]=concatenarActividades(caminoProceso,j-1,caminoProceso[j],i);
		return caminoProceso.length >i && caminoProceso[j]!=null ? obtenerCodebook(caminoProceso,i+1,n,codebookAux,j+1):
			codebookAux;

	}



}
