package com.example.Agenda._Contactos.repositorio;

import com.example.Agenda._Contactos.entidad.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface contactoRepositorio extends JpaRepository<Contacto,Integer> {

}
