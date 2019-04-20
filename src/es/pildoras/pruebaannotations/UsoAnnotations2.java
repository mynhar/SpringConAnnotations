package es.pildoras.pruebaannotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsoAnnotations2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// leer el xml de configuracion
		//ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// leer el class de configuracion
		AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(EmpleadosConfig.class);
				
		// pedir un bean al contenedor
		Empleados antonio = contexto.getBean("comercialExperimentado",Empleados.class);
		
		Empleados lucia = contexto.getBean("comercialExperimentado",Empleados.class);
		
		// Apunta al mismo objeto en memoria.
		if(lucia == antonio) {
			System.out.println("Apunta al mismo lugar en memoria.");
			System.out.println(antonio+"\n"+lucia);
			
		}else {
			System.out.println("No apunta al mismo lugar en memoria.");
			System.out.println(antonio+"\n"+lucia);
		}
		
		// cerrar ccontexto
		contexto.close();


	}

}
