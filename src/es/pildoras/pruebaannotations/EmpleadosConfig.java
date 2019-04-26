package es.pildoras.pruebaannotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("es.pildoras.pruebaannotations")
public class EmpleadosConfig {

	// definir el bean para InformeFinancioeroDTOCompras
	
	@Bean
	public CreacionInformeFinanciero informeFinancieroDtoCompras() {// sera el id del bean inyectado
		return new InformeFinancieroDtoCompras();
	}
	
	// definir el bean para DirectorFinanciero e inyectar dependencias
	@Bean
	public Empleados directorFinanciero() {
		return new DirectorFinanciero(informeFinancieroDtoCompras());
	}
	
}
