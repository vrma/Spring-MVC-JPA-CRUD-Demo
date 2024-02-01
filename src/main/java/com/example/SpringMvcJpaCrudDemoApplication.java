package com.example;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.entities.Correo;
import com.example.entities.Departamento;
import com.example.entities.Empleado;
import com.example.entities.Genero;
import com.example.entities.Telefono;
import com.example.services.CorreoService;
import com.example.services.DepartamentoService;
import com.example.services.EmpleadoService;
import com.example.services.TelefonoService;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringMvcJpaCrudDemoApplication implements CommandLineRunner{

	private final EmpleadoService empleadoService;
	private final DepartamentoService departamentoService;
	private final TelefonoService telefonoService;
	private final CorreoService correoService;

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcJpaCrudDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Primero : Creamos departamentos

		Departamento dpt1 = Departamento.builder()
				.nombre("RRHH")
				.build();
		
		Departamento dpt2 = Departamento.builder()
				.nombre("INFORMATICA")
				.build();

		Departamento dpt3 = Departamento.builder()
				.nombre("CONTABILIDAD")
				.build();

		departamentoService.persitirDpto(dpt1);		
		departamentoService.persitirDpto(dpt2);
		departamentoService.persitirDpto(dpt3);

		// Empleados

		Empleado emp1 = Empleado.builder()
			.nombre("Aurora")
			.primerApellido("Duque")
			.fechaAlta(LocalDate.of(2000, Month.JANUARY, 12))
			.salario(2500.50)
			.departamento(departamentoService.dameUnDepartamento(1))
			.genero(Genero.OTRO)
			.build();

		Empleado emp2 = Empleado.builder()
			.nombre("Rosa Aurora")
			.primerApellido("Duque")
			.fechaAlta(LocalDate.of(2000, Month.JANUARY, 12))
			.salario(2540.50)
			.departamento(departamentoService.dameUnDepartamento(2))
			.genero(Genero.MUJER)
			.build();

		empleadoService.persistirEmpleado(emp1);
		empleadoService.persistirEmpleado(emp2);


		// Telefonos 
		
		// List<Telefono> telefonosEmpleado1 = new ArrayList<>(); 

		Telefono telefono1Empleado1 = Telefono.builder()
			.numero("96123456")
			.empleado(empleadoService.dameUnEmpleado(1))
			.build();

		Telefono telefono2Empleado1 = Telefono.builder()
			.numero("97123456") 
			.empleado(empleadoService.dameUnEmpleado(1))
			.build();

		// telefonosEmpleado1.add(telefono1Empleado1);
		// telefonosEmpleado1.add(telefono2Empleado1);	

		telefonoService.persistirTelefono(1, telefono1Empleado1);
		telefonoService.persistirTelefono(1, telefono2Empleado1);

		// List<Telefono> telefonosEmpleado2 = new ArrayList<>(); 

		Telefono telefono1Empleado2 = Telefono.builder()
			.numero("98123456")
			.empleado(empleadoService.dameUnEmpleado(2))
			.build();

		Telefono telefono2Empleado2 = Telefono.builder()
			.numero("99123456") 
			.empleado(empleadoService.dameUnEmpleado(2))
			.build();

		// telefonosEmpleado2.add(telefono1Empleado2);
		// telefonosEmpleado2.add(telefono2Empleado2);
		telefonoService.persistirTelefono(2, telefono1Empleado2);
		telefonoService.persistirTelefono(2, telefono2Empleado2);

		// Correos 

		// List<Correo> correosEmpleado1 = new ArrayList<>();

		Correo correo1Empleado1 = Correo.builder()
			.correo("aaaa@gmail.com")
			.build();

		Correo correo2Empleado1 = Correo.builder()
			.correo("bbbb@gmail.com")
			.build();

		// correosEmpleado1.add(correo1Empleado1);
		// correosEmpleado1.add(correo2Empleado1);
		correoService.persistirCorreo(1, correo1Empleado1);
		correoService.persistirCorreo(1, correo2Empleado1);


		// List<Correo> correosEmpleado2 = new ArrayList<>();

		Correo correo1Empleado2 = Correo.builder()
			.correo("ccccc@gmail.com")
			.build();

		Correo correo2Empleado2 = Correo.builder()
			.correo("dddd@gmail.com")
			.build();

		// correosEmpleado2.add(correo1Empleado2);
		// correosEmpleado2.add(correo2Empleado2);
		correoService.persistirCorreo(2, correo1Empleado2);
		correoService.persistirCorreo(2, correo2Empleado2);

		




	


		

	}

}
