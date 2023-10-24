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

import pe.com.fika.fikaproyect.dto.RolDTO;
import pe.com.fika.fikaproyect.service.RolService;

@RestController
@RequestMapping("/rol")
public class RolRestController {
    @Autowired
    private RolService servicio;

    @GetMapping
    public List<RolDTO> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<RolDTO> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public RolDTO findById(@PathVariable Long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public RolDTO add(@RequestBody RolDTO c) {
        return servicio.add(c);
    }

    @PutMapping("{id}")
    public RolDTO update(@PathVariable long id, @RequestBody RolDTO c) {
        return servicio.update(c, id);
    }

    @DeleteMapping("{id}")
    public RolDTO delete(@PathVariable Long id) {
        return servicio.delete(id);
    }

    @PutMapping("enable/{id}")
    public RolDTO enable(@PathVariable long id) {
        return servicio.enable(id);
    }
}
