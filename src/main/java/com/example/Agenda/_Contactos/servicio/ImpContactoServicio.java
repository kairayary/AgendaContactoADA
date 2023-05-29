package com.example.Agenda._Contactos.servicio;

import com.example.Agenda._Contactos.entidad.Contacto;
import com.example.Agenda._Contactos.repositorio.contactoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpContactoServicio implements contactoServicio{

    @Autowired
    private contactoRepositorio contactoRepositorio;


    @Override
    public List<Contacto> DirectorioContactos() {
      return contactoRepositorio.findAll();
    }

    @Override
    public Contacto RegistrarContacto(Contacto contacto) {
        return contactoRepositorio.save(contacto);
    }

    @Override
    public Contacto ObtenerContactoId(Integer Id) {
        return contactoRepositorio.findById(Id).get();
    }

    @Override
    public Contacto ActualizarContacto(Contacto contacto) {
        return contactoRepositorio.save(contacto);
    }

    @Override
    public void Eliminar(Contacto contacto) {
        contactoRepositorio.delete(contacto);
    }
}
