package com.example.Agenda._Contactos.controlador;

import com.example.Agenda._Contactos.entidad.Contacto;
import com.example.Agenda._Contactos.servicio.contactoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class ControladorContacto {
    @Autowired
    private contactoServicio contactoServicio;

    @GetMapping("/")
    public String verPagInicio(Model modelo) {
        List<Contacto> contactos = contactoServicio.DirectorioContactos();

        modelo.addAttribute("contactos", contactos);
        return "index";
    }

    @GetMapping("/nuevo")
    public String mostrarFormRegistro(Model modelo) {
        modelo.addAttribute("contacto", new Contacto());
        return "nuevo";
    }

    @PostMapping("/save")
    public String guardarContacto(@Validated Contacto contacto,BindingResult bindingResult,
                                  RedirectAttributes redirect,Model modelo) {

        if(bindingResult.hasErrors()) {
            modelo.addAttribute("contacto", contacto);
            return "nuevo";
        }

        contactoServicio.RegistrarContacto(contacto);
        redirect.addFlashAttribute("msgExito", "El contacto ha" +
                " sido agregado exitosamente");

        return "redirect:/";
    }


    @GetMapping("/editar/{id}")
    public String mostrarFormEditarContacto(@PathVariable Integer id,Model modelo) {
        Contacto contacto = contactoServicio.ObtenerContactoId(id);
        modelo.addAttribute("contacto", contacto);
        return "editar";
    }

    @PostMapping("/editar/{id}")
    public String ActualizarContacto(@PathVariable Integer id,@Validated Contacto contacto,
                                     BindingResult bindingResult,RedirectAttributes redirect,Model modelo) {

        Contacto contactoDB = contactoServicio.ObtenerContactoId(id);

        if(bindingResult.hasErrors()) {
            modelo.addAttribute("contacto", contacto);
            return "editar";
        }

        contactoDB.setNombre(contacto.getNombre());
        contactoDB.setCelular(contacto.getCelular());
        contactoDB.setEmail(contacto.getEmail());
        contactoDB.setFechaNacimiento(contacto.getFechaNacimiento());

        contactoServicio.RegistrarContacto(contactoDB);

        redirect.addFlashAttribute("msgExito", "El contacto " +
                "ha sido actualizado correctamente");

        return "redirect:/";
    }

    @PostMapping("/eliminar/{id}")
    public String EliminarContacto(@PathVariable Integer id,RedirectAttributes redirect) {
        Contacto contacto = contactoServicio.ObtenerContactoId(id);

        contactoServicio.Eliminar(contacto);

        redirect.addFlashAttribute("msgExito", "El contacto ha " +
                "sido eliminado correctamente");

        return "redirect:/";
    }

}
