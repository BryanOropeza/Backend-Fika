package pe.com.fika.fikaproyect.restController;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.fika.fikaproyect.dto.UsuarioDTO;
import pe.com.fika.fikaproyect.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
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
}
