package es.pildoras.pruebaannotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")// Para esta clase trabaje con prototype, patron de diseño.
public class ComercialExperimentado implements Empleados {

	/*
	 Autowired usando campos de clase.
	 Aqui se aplica el concepto Reflexion!
	 */
	@Autowired
	@Qualifier("informeFinancieroTrim4") // bean id que debe utilizar
	private CreacionInformeFinanciero nuevoInforme;
	
	/*
	 @Autowired
	 Busca en todo el proyecto, si hay una clase que implemente CreacionInformeFinanciero.
	 si la encuentra, es de esa clse que obtiene la inyeccion de dependencia... 
	 */
	/*@Autowired
	public ComercialExperimentado(CreacionInformeFinanciero nuevoInforme) {
		this.nuevoInforme = nuevoInforme;
	}*/
	
	
	/*
	@Autowired
	public void setNuevoInforme(CreacionInformeFinanciero nuevoInforme) {
		this.nuevoInforme = nuevoInforme;
	}
	*/

	@Override
	public String getTareas() {
		// TODO Auto-generated method stub
		return "Vender, vender y vender mas!";
	}

	@Override
	public String getInforme() {
		// TODO Auto-generated method stub
		return nuevoInforme.getInformeFinanciero();
	}
	
	
	/*
	 ejecucion de codigo despues de creacion del bean
	 cualquier modificador de acceso
	 retornar cualquier tipo. por lo general es void
	 en java 9 falta el javax.annotation-api/1.2
	*/
	@PostConstruct // para estos metodos no se puede trabajar con el scope prototype.
	public void ejecutaDespuesCreacion() {
		System.out.println("Ejecutado tras creacion de Bean");
	}
	
	/*
	 ejecucion de codigo despues de apagado de contenedor de spring
	 cualquier modificador de acceso
	 retornar cualquier tipo. por lo general es void
	 en java 9 falta el javax.annotation-api/1.2
	*/
	@PreDestroy // para estos metodos no se puede trabajar con el scope prototype.
	public void ejecutaAntesDestruccion() {
		System.out.println("Ejecutado antes de la destruccion");
	}

}

