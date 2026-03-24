package com.example.practicaexamenu3.services;

import com.example.practicaexamenu3.clases.Contacto;

import java.util.ArrayList;
import java.util.List;

public class ContactoService {
    private final String[] parentescos = {"Padre", "Madre", "Hermano", "Hermana", "Abuelo", "Abuela", "Tío", "Tía"};
    private final List<Contacto> contactos = new ArrayList<>();

    public String[] getParentescos() {
        return parentescos;
    }

    private Contacto buscarPorNombre(String nombre) {
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return c;
            }
        }
        return null;
    }

    private void validarCampos(String nombre, String telefono, String parentesco) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (telefono == null || telefono.isEmpty()) {
            throw new IllegalArgumentException("El teléfono no puede estar vacío");
        }
        if (!telefono.matches("\\d{10}")) {
            throw new IllegalArgumentException("El teléfono debe tener exactamente 10 dígitos");
        }
        if (parentesco == null || parentesco.isEmpty()) {
            throw new IllegalArgumentException("Debes seleccionar un parentesco");
        }
    }

    public void addContacto(String nombre, String telefono, String parentesco) {
        validarCampos(nombre, telefono, parentesco);
        if (buscarPorNombre(nombre) != null) {
            throw new IllegalArgumentException("Ya existe un contacto con ese nombre");
        }
        contactos.add(new Contacto(nombre, telefono, parentesco));
    }

    public Contacto buscarContacto(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("Ingresa un nombre para buscar");
        }
        Contacto encontrado = buscarPorNombre(nombre);
        if (encontrado == null) {
            throw new IllegalArgumentException("No se encontró un contacto con ese nombre");
        }
        return encontrado;
    }

    public void updateContacto(String nombreOriginal, String nuevoNombre, String nuevoTelefono, String nuevoParentesco) {
        validarCampos(nuevoNombre, nuevoTelefono, nuevoParentesco);
        Contacto c = buscarPorNombre(nombreOriginal);
        if (c == null) {
            throw new IllegalArgumentException("No se encontró el contacto a actualizar");
        }
        if (!nombreOriginal.equalsIgnoreCase(nuevoNombre) && buscarPorNombre(nuevoNombre) != null) {
            throw new IllegalArgumentException("Ya existe un contacto con ese nombre");
        }
        c.setNombre(nuevoNombre);
        c.setTelefono(nuevoTelefono);
        c.setParentesco(nuevoParentesco);
    }

    public void deleteContacto(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("Ingresa un nombre para eliminar");
        }
        Contacto c = buscarPorNombre(nombre);
        if (c == null) {
            throw new IllegalArgumentException("No se encontró un contacto con ese nombre");
        }
        contactos.remove(c);
    }

    public List<String> loadDataForList() {
        List<String> list = new ArrayList<>();
        for (Contacto c : contactos) {
            list.add(c.toString());
        }
        return list;
    }
}
