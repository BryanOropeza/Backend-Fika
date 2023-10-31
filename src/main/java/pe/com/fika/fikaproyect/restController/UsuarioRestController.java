package pe.com.fika.fikaproyect.restController;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.fika.fikaproyect.dto.UsuarioDTO;
import pe.com.fika.fikaproyect.model.LoginRequest;
import pe.com.fika.fikaproyect.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioRestController {
    @Autowired
    private UsuarioService servicio;

    @GetMapping
    public List<UsuarioDTO> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<UsuarioDTO> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public UsuarioDTO findById(@PathVariable Long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public UsuarioDTO add(@RequestBody UsuarioDTO c) {
        return servicio.add(c);

    }

    @PutMapping("{id}")
    public UsuarioDTO update(@PathVariable long id, @RequestBody UsuarioDTO c) {
        return servicio.update(c, id);
    }

    @DeleteMapping("{id}")
    public UsuarioDTO delete(@PathVariable Long id) {
        return servicio.delete(id);
    }

    @PutMapping("enable/{id}")
    public UsuarioDTO enable(@PathVariable long id) {
        return servicio.enable(id);
    }

    @PostMapping("login")
    public ResponseEntity<UsuarioDTO> login(@RequestBody LoginRequest request) {
        // request debería contener el nombre de usuario y la contraseña proporcionados
        // en el frontend.
        // Realiza la lógica de validación de credenciales aquí.
        // Busca el usuario en tu base de datos y verifica si las credenciales son
        // correctas.

        UsuarioDTO userId = servicio.login(request);

        if (userId != null) {
            return new ResponseEntity<>(userId, HttpStatus.OK); // Devuelve el ID del usuario y el código 200 si las
                                                                // credenciales son válidas.
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED); // Devuelve el código 401 si las credenciales son
                                                                  // incorrectas.
        }
    }
}
