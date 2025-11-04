package com.gastos.controlgastosrest.controladores;

import com.gastos.controlgastosrest.hashconfig.ConfigHashBD;
import com.gastos.controlgastosrest.modelos.UsuariosModelo;
import com.gastos.controlgastosrest.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioControlador {
    private final UsuarioServicio usuarioServicio;

    @Autowired
    public UsuarioControlador(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crearUsuario(@RequestBody UsuariosModelo usuario) throws Exception {
        String nombre = usuario.getNombre();
        String correo = usuario.getCorreo();
        String contrasenia = usuario.getContraseniaHash();
        String estado = usuario.getEstado();

        if (nombre == null || correo == null || contrasenia == null || estado == null){
            HashMap<String, Object> response = new HashMap<>();
            response.put("mensaje", "Campos vacios");
            response.put("COMPLETAR", "COMPLETAR TODOS LOS CAMPOS");
            response.put("STATUS", 400);

            return ResponseEntity.badRequest().body(response);
        }
        byte[] salt = ConfigHashBD.generarSalt();
        byte[] contraseniaHasheada = ConfigHashBD.hashContrasenia(contrasenia.toCharArray(), salt);

        usuario.setSalt(ConfigHashBD.toBase64(salt));
        usuario.setContraseniaHash(ConfigHashBD.toBase64(contraseniaHasheada));

        usuarioServicio.guardarUsuario(usuario);

        HashMap<String, Object> response = new HashMap<>();
        response.put("mensaje", "Usuario creado");
        response.put("STATUS", 200);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarUsuarios(){
        List<UsuariosModelo> usuarios =  usuarioServicio.listarTodosUsuarios();

        HashMap<String, Object> response = new HashMap<>();
        response.put("usuarios", usuarios);
        response.put("STATUS", 200);
        return ResponseEntity.ok(response);
    }

}
