package co.edu.usb.parser;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;

public class Parser 
{

	private static int countRoute=0;
	private static String [][] arregloTextual = null;
	private static String [][] arregloEstructural = null;
	private static String[] arregloRoute =null;
	private static int profundidad = 0;
	private static int indice = 0;

	private static String[][] arregloTransitions = null;
	
	private static String[][] arregloTransitionsActivities = null;

	private static  int posicionVector = 0;
	private static String idInicio = "";

	//COnstructor donde alisto toda la data 
	public static void contructor( String ruta )
	{	
		
		try {

			//Obtener data textual
			obtenerEstructuraTextual(new File(ruta));
			//Obtener data estructural
			obtenerDatosEstructurales(new File(ruta));

			arregloRoute = new String [arregloEstructural.length];

			//Arreglo que me permite guardar todos los caminos posibles
			arregloTransitions = new String [(arregloEstructural.length)][(arregloEstructural.length)];
			
			//Arreglo de transiciones tipo de actividad
			arregloTransitionsActivities = new String [(arregloEstructural.length)][(arregloEstructural.length)];
			
			int posicion = 0;
			//Ingreso las transiciones de los router para saber si son de a uno o dos  
			for (int j = 0; j < arregloTextual.length; j++) {
			for (int i = 0; i < arregloEstructural.length; i++) {

					if(arregloTextual[j][3]!=null && arregloEstructural[i][1] !=null && 
							 arregloTextual[j][1].equalsIgnoreCase("Route")==true &&
							arregloTextual[j][3].equals(arregloEstructural[i][1])==true
							){
						
						//Guardo los routers en una matriz route 
						arregloRoute[posicion]=arregloTextual[j][3];
						
						posicion++;

					}


				}

			}
			
			
			for (int i = 0; i < arregloTextual.length; i++) {

				//Si es Start event lo guarndo, ya que es la primera transition
				if(arregloTextual[i][1].equalsIgnoreCase("StartEvent")==true){
					idInicio =arregloTextual[i][3];
				}

			}
			


			
			//Arreglo de actividades 
			for (int i = 0; i < arregloTransitionsActivities.length; i++) {
				for (int j = 0; j < arregloTransitionsActivities.length; j++) {
					if(arregloTransitionsActivities[i][j]!=null){
						System.out.println(arregloTransitionsActivities[i][j]);
					}
					
				}
			}
			
			

		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	public static String [][] obtenerMatrizTextual(String ruta){
		//Obtener data textual
		try {
			obtenerEstructuraTextual(new File(ruta));
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return arregloTextual;
	}
	
	
	//Permite obtener el arreglo de caminos del proceso de negocio con las transitions
	public static String[][] obtenerCaminosTransitions(String ruta){
		long time_start, time_end;
		time_start = System.currentTimeMillis();
		
		contructor(ruta);
		//armo todos los caminos del proceso de negocio con los transition
		obtenerHijos(idInicio,0);
		
		time_end = System.currentTimeMillis();
		System.out.println("the task has taken "+ ( time_end - time_start ) +" milliseconds");
		return arregloTransitions;
		
	} 
	
	//Permite obtener el arreglo de caminos del proceso de negocio con las activities
	public static String[][] obtenerCaminosActivities(String ruta){
		long time_start, time_end;
		time_start = System.currentTimeMillis();
		
		contructor(ruta);
		//armo todos los caminos del proceso de negocio con los transition
		obtenerHijos(idInicio,0);
		
		//Primer for para obtener la primera fila
		for (int i = 0; i < arregloTransitions.length; i++) {
			//Segundo for para obtener 
			for (int j = 0; j < arregloTransitions.length; j++) {
				if(arregloTransitions[i][j]!=null){
					for (int j2 = 0; j2 < arregloTextual.length; j2++) {
						if(arregloTransitions[i][j].trim().equalsIgnoreCase(arregloTextual[j2][3].trim())==true
								){
							arregloTransitionsActivities[i][j] =arregloTextual[j2][0] ;

						}
					}
				}

			}
		}
		
		time_end = System.currentTimeMillis();
		System.out.println("the task has taken "+ ( time_end - time_start ) +" milliseconds");
		return arregloTransitionsActivities;
		
	}
	
	
	


	private static  String [][] obtenerEstructuraTextual(File arcFile) throws JDOMException, IOException {
		//Setup para acceder al xpdl 
		SAXBuilder builder = new SAXBuilder();
		Document doc = (Document) builder.build(arcFile);

		//Obtengo la raiz del documento y guardo sus hijos en una lista.
		Element raiz = doc.getRootElement();
		List<Element> hijosRaiz = raiz.getChildren();

		for (int i = 0; i < hijosRaiz.size(); i++) {
			Element nodo = hijosRaiz.get(i);
			List<Element> hijosNodo = nodo.getChildren();
			//Si hay algo en el documento
			if (hijosNodo.size() > 0) {

				for (int j = 0; j < hijosNodo.size(); j++) {
					Element nodoNIvel2 = hijosNodo.get(j);
					//Filtrar por Activities
					List<Element> hijosNodonivel2 = nodoNIvel2.getChildren("Activities",Namespace.getNamespace("http://www.wfmc.org/2009/XPDL2.2"));

					for (int k = 0; k < hijosNodonivel2.size(); k++) {
						Element nodoNIvel3 = hijosNodonivel2.get(k);
						//Filtrar por Activity
						List<Element> hijosNodonivel3 = nodoNIvel3.getChildren("Activity",Namespace.getNamespace("http://www.wfmc.org/2009/XPDL2.2"));
						//Arreglo textual que va contener los datos.
						arregloTextual = new String[hijosNodonivel3.size()][5];
						//Nombre de las actividades
						String[] nombreActividad = {
								"RouteComplex", "MarkerVisible", "RouteParallel", 
								"RouteInclusive", "ResultError", "TriggerTimer", 
								"TaskService", "Task", "StartEvent", 
								"Route", "EndEvent", "IntermediateEvent", 
								"TriggerResultMessage", "TaskUser", 
								"TaskManual", "BlockActivity", "TriggerResultSignal",
								"TaskScript", "TriggerConditional", "TriggerEscalation"
						};
						//Guardo los datos textuales
						for (int l = 0; l < hijosNodonivel3.size(); l++) {
							Element nodoNIvel4 = hijosNodonivel3.get(l);
							List<Element> hijosNodonivel4 = nodoNIvel4.getChildren();

							for (int n = 0; n < hijosNodonivel3.get(l).getChildren().size(); n++) {
								if(hijosNodonivel3.get(l).getChildren().get(n).getName().equalsIgnoreCase("Route")==true){
									arregloTextual[l][1] = hijosNodonivel3.get(l).getChildren().get(n).getName();
									countRoute++;
								}


								//Busco los tipo de actividades
								for (int typeActivity = 0; typeActivity < hijosNodonivel4.size(); typeActivity++) {
									//Verifico que no este vacio	
									if(!hijosNodonivel4.get(typeActivity).getChildren().isEmpty()){
										//Recorro el arreglo de actividades que existen 
										for (int m = 0; m < nombreActividad.length; m++) {
											//Comparo el tipo de actividad que encuentro con el del arreglo de tipo de actividades
											if(hijosNodonivel4.get(typeActivity).getChildren().get(0).getName().
													equals(nombreActividad[m])==true){
												if(hijosNodonivel4.get(typeActivity).getChildren().get(0).getChildren().isEmpty()!=true){
													arregloTextual[l][2] = hijosNodonivel4.get(typeActivity).getChildren().get(0).getChildren()
															.get(0).getName();
													
												}
												
												//Si encuentro un tipo de actividad lo guardo
												arregloTextual[l][1] = nombreActividad[m];

											}
										}

									}

								}

							}


							//Obtengo el nombre de la actividad
							arregloTextual[l][0] = hijosNodonivel3.get(l).getAttributeValue("Name");
							//Obtengo la descripcion de la actividad
							//arregloTextual[l][2] = hijosNodonivel3.get(l).getChildren("Description",Namespace.getNamespace("http://www.wfmc.org/2009/XPDL2.2")).get(0).getTextTrim();
							/*Guardo las transiciones para cada actividad para despues mapearla
                        	este dato no se usa para la busqueda textual, pero si para la estructural*/
							arregloTextual[l][3] = hijosNodonivel3.get(l).getAttributeValue("Id");



						}
					}
				}
			}
		}

		return arregloTextual;
	}


	private static  String [][] obtenerDatosEstructurales(File arcFile) throws JDOMException, IOException {
		//Setup para acceder al xpdl 
		SAXBuilder builder = new SAXBuilder();
		Document doc = (Document) builder.build(arcFile);

		//Obtengo la raiz del documento y guardo sus hijos en una lista.
		Element raiz = doc.getRootElement();
		List<Element> hijosRaiz = raiz.getChildren();

		//
		for (int i = 0; i < hijosRaiz.size(); i++) {
			Element nodo = hijosRaiz.get(i);
			List<Element> hijosNodo = nodo.getChildren();
			//Si hay algo en el documento
			if (hijosNodo.size() > 0) {

				for (int j = 0; j < hijosNodo.size(); j++) {
					Element nodoNIvel2 = hijosNodo.get(j);
					//Filtrar por Transitions
					List<Element> hijosNodonivel2 = nodoNIvel2.getChildren("Transitions",Namespace.getNamespace("http://www.wfmc.org/2009/XPDL2.2"));

					for (int k = 0; k < hijosNodonivel2.size(); k++) {
						Element nodoNIvel3 = hijosNodonivel2.get(k);
						//Filtrar por Transition
						List<Element> hijosNodonivel3 = nodoNIvel3.getChildren("Transition",Namespace.getNamespace("http://www.wfmc.org/2009/XPDL2.2"));
						//Arreglo estructural que va contener los datos.
						arregloEstructural = new String[hijosNodonivel3.size()][3];

						//Guardo los datos textuales
						for (int l = 0; l < hijosNodonivel3.size(); l++) {

							//Obtengo el nombre de la actividad
							arregloEstructural[l][0] = hijosNodonivel3.get(l).getAttributeValue("Id");
							arregloEstructural[l][1] = hijosNodonivel3.get(l).getAttributeValue("From");
							arregloEstructural[l][2] = hijosNodonivel3.get(l).getAttributeValue("To");

						}
					}
				}
			}
		}

		return arregloEstructural;
	}


	/**
	 * Obtener todos los comaninos posibles para un workflow dado un o muchos  start events
	 * @author Dilan Steven Mejia Buitrago
	 * @param id Este parametro va ser el nodo que se va estar buscando hasta que termina el camino,al principio por lo general se ingresa el start event
	 * @param arregloTransicion Este parametro  es la la matriz  de transiciones obtenidos en el xpdl
	 * @param indice Este patarametro es el contador que aumenta a medida que se van ingresando nodos en una iteracion del metodo ( es decir indice +1 )
	 * @param arregloEstructural este parametro va ser la matriz que contenga los caminos del workflow 
	 * @param posicionVector Este parametro permite llevar la cuenta de cada uno de los nuevos caminos que aparecen. es decir (posicionVector +1)
	 * @return String [][] Retorna la matriz con los caminos 
	 * */





	private static  void obtenerHijos(String arregloCompuertas,int indice){
		/*Busco primero el eventStart  y luego en la siguiente iteracion el que le sigue hasta recorrer un camino*/
		int	indiceBifulcacion = 0;
		int contador = 0;

		//Itero para preguntar si es una compuerta para poder entrar
		for (int i = 0; i < arregloRoute.length; i++) {
			if(arregloCompuertas !=null && arregloRoute[i]!=null && arregloCompuertas.equals(arregloRoute[i])==true){
				contador++;
				indiceBifulcacion=indice-1;

			}
		}

		if( arregloCompuertas!=null ){
			indice++;
			arregloTransitions[posicionVector][indice-1] =arregloCompuertas;
			obtenerHijos(obtenerSiguienteNodo2(arregloCompuertas,0),indice);

			if(contador==2){

				for (int i = 0; i < indice-1; i++) {
					arregloTransitions[posicionVector+1][i] = arregloTransitions[posicionVector][i];
				}

				posicionVector++;
				arregloTransitions[posicionVector][indice-1] =arregloCompuertas;
				obtenerHijos(obtenerSiguienteNodo2(arregloCompuertas,1),indice);
			}

		}

	}


	private static  String obtenerSiguienteNodo2(String id,int bifulcacion){
		/*Busco primero el eventStart  y luego en la siguiente iteracion el que le sigue hasta recorrer un camino*/
		String nodo ="";
		int contador=0;
		String nodoRepetido="";
		for (int i = 0; i <arregloEstructural.length;i++) {
			if (arregloEstructural[i][1].equals(id)==true) {
				contador ++;

				if(contador==1){
					nodo = arregloEstructural[i][2];
				}

				if(contador==2){
					if(bifulcacion==1){
						nodoRepetido = arregloEstructural[i][2];

					}
				}

			}

		}
		if(nodoRepetido!=null && nodoRepetido!=""){
			return nodoRepetido;
		}

		if(nodo!=null && nodo!=""){
			return nodo;
		}

		return null;

	}



}
