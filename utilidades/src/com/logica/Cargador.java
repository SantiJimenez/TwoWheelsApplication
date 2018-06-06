package com.logica;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

public class Cargador {
	URLClassLoader cargador;
	HashMap<String,String> registro=new HashMap<String,String>();
	URL urls[];
	public Cargador(String dir,ClassLoader padre) {
		cargarURL(dir,padre);
	}
	private void cargarURL(String dir,ClassLoader padre) {
		File archivos[] = new File(dir).listFiles();
		urls = new URL[archivos.length];
		for (int i=0;i<archivos.length;i++) {
			try {
				System.out.println("-----------------------------");
				JarFile archivo = new JarFile(archivos[i]);
				if (archivo.getManifest() == null) {
					System.out.println("Sin manifiesto");
				}else{
					System.out.println("Con manifiesto");
				}
				Manifest m = archivo.getManifest();
				//Attributes atributos = m.getMainAttributes();
				Attributes atributos = m.getAttributes("COMPONENTE");
				System.out.println("archivo: " + archivo.getName());
				System.out.println("atributos: " + atributos);
				String nc = atributos.getValue("nombre");
				String cl = atributos.getValue("clase");
				System.out.println("En cargador, nombre: " + nc + " - clase: " + cl);
				//Lo minimo que tiene un elemento
				urls[i] = archivos[i].toURI().toURL();
				registro.put(nc,cl);
				archivo.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		cargador = new URLClassLoader(urls,padre);
	}
	public Class cargarUnaClaseDesdeSuDirectorio(String nombre) {		
		try {
			String cad=(String)registro.get(nombre);
			if(cad!=null) {
			   return cargador.loadClass(cad);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
