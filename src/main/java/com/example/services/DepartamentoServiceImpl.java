package com.example.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dao.DepartamentoDao;
import com.example.entities.Departamento;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartamentoServiceImpl implements DepartamentoService {

    // Inyeccion de Dependencia (DI) por constructor

    /*
     *   Antiguamente para inyectar una dependencia por constructor
     * 
     *   Primero : Declarabas la variable del tipo del objeto
     * 
     *   Segundo : Creabas el constructor y le pasabas el objeto. 
     * 
     *   Pero, actualmente con LOMBOK lo anterior no es necesario, se facilita,
     *   solamente declarando la variable de objeto y especificando el modificador
     *   final y utilizzando la anotacion de lombok @RequiredArgsConstructor  
     **/
    // private DepartamentoDao departamentoDao;

    // public DepartamentoServiceImpl(DepartamentoDao departamentoDao) {
    //     this.departamentoDao = departamentoDao;
    // }

    // Actualmente. La inyeccion de dependencia por constructor se realiza 
    // de la forma siguiente, y con la anotacion de lombok correspondiente
    private final DepartamentoDao departamentoDao;

    @Override
    public List<Departamento> dameDepartamentos() {
        return departamentoDao.findAll();
    }

    @Override
    public Departamento dameUnDepartamento(int idDepartamento) {
        return departamentoDao.findById(idDepartamento).get();
    }

    @Override
    public void persitirDpto(Departamento departamento) {
        departamentoDao.save(departamento);
    }

}
