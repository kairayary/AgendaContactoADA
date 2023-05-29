package com.example.Agenda._Contactos.servicio;

import com.example.Agenda._Contactos.entidad.Contacto;

import java.util.List;

public interface contactoServicio {
    public List<Contacto>DirectorioContactos();

    public Contacto RegistrarContacto(Contacto contacto);
    public Contacto ObtenerContactoId(Integer Id);
    public Contacto ActualizarContacto(Contacto contacto);

    public void Eliminar(Contacto contacto);
}
