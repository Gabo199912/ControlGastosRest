package com.gastos.controlgastosrest.servicios;

import com.gastos.controlgastosrest.modelos.UsuariosModelo;
import com.gastos.controlgastosrest.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UsuarioServicio {
    private final UsuarioRepositorio usuarioRepositorio;

    @Autowired
    public UsuarioServicio(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public UsuariosModelo guardarUsuario(UsuariosModelo usuario) {
        return usuarioRepositorio.save(usuario);
    }

    public boolean eliminarUsuario(Integer idUsuario){
        if (idUsuario == null){
            System.out.printf("idUsuario es requerido");
            return false;
        }

        usuarioRepositorio.deleteById(idUsuario);
        return true;
    }

    public UsuariosModelo buscarUsuarioPorNombre(String nombre){
        return usuarioRepositorio.findByNombre(nombre);
    }

    public UsuariosModelo buscarUsuarioPorId(Integer id){
        return usuarioRepositorio.findById(id).orElse(null);
    }

    public boolean existeUsuario(String nombre){
        boolean ok =  usuarioRepositorio.existsByNombre(nombre);
        return ok;
    }

    public List<UsuariosModelo> listarTodosUsuarios(){
        return usuarioRepositorio.findAll();
    }
}
