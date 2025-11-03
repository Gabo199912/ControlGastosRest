package com.gastos.controlgastosrest.controladores;

import com.gastos.controlgastosrest.DTO.LoginDTO;
import com.gastos.controlgastosrest.hashconfig.ConfigHashBD;
import com.gastos.controlgastosrest.modelos.UsuariosModelo;
import com.gastos.controlgastosrest.servicios.UsuarioServicio;
import com.gastos.controlgastosrest.singleton.SesionActivaSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/login")
public class LoginControlador {
    private final UsuarioServicio usuarioServicio;

    @Autowired
    public LoginControlador(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginDTO login) throws Exception {
        System.out.printf(login.getNombre() + " " + login.getContrasenia());

        boolean ok = usuarioServicio.existeUsuario(login.getNombre());


      if (ok){
          UsuariosModelo usuario = usuarioServicio.buscarUsuarioPorNombre(login.getNombre());

          byte[] contraseniaHash = ConfigHashBD.fromBase64(usuario.getContraseniaHash());
          byte[] salt = ConfigHashBD.fromBase64(usuario.getSalt());
          char[] contrasenia = login.getContrasenia().toCharArray();

          if (ConfigHashBD.verificarContrasenia(contrasenia, salt, contraseniaHash)){
              HashMap<String, Object> response = new HashMap<>();
              response.put("mensaje", "Login exitoso");
              response.put("STATUS", 200);
              response.put("usuario", usuario);

              SesionActivaSingleton.setNombreUsuario(usuario.getNombre());
              SesionActivaSingleton.setCorreoUsuario(usuario.getCorreo());
              SesionActivaSingleton.setEstadoUsuario(usuario.getEstado());
              SesionActivaSingleton.setIdUsuario(usuario.getIdUsuario());

              return ResponseEntity.ok(response);
          }else {
              HashMap<String, Object> response = new HashMap<>();
              response.put("mensaje", "usuario o contrasenia incorrectos");
              response.put("STATUS", 400);
              return ResponseEntity.badRequest().body(response);
          }
      }else {
          HashMap<String, Object> response = new HashMap<>();
          response.put("mensaje", "Usuario no encontrado");
          response.put("STATUS", 400);
          return ResponseEntity.badRequest().body(response);
      }
    }
}
