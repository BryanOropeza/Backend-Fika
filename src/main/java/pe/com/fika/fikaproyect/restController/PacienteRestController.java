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

import pe.com.fika.fikaproyect.dto.PacienteDTO;
import pe.com.fika.fikaproyect.service.PacienteService;

@RestController
@RequestMapping("/paciente")
@CrossOrigin(origins = "http://localhost:4200")
public class PacienteRestController {
    @Autowired
    private PacienteService servicio;

    @GetMapping
    public List<PacienteDTO> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<PacienteDTO> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public PacienteDTO findById(@PathVariable Long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public PacienteDTO add(@RequestBody PacienteDTO c) {
        return servicio.add(c);
    }

    @PostMapping("/{usuarioId}")
    public ResponseEntity<PacienteDTO> crearPaciente(@PathVariable Long usuarioId,
            @RequestBody PacienteDTO pacienteDTO) {
        PacienteDTO nuevoPaciente = servicio.crearPaciente(usuarioId, pacienteDTO);
        return new ResponseEntity<>(nuevoPaciente, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public PacienteDTO update(@PathVariable long id, @RequestBody PacienteDTO c) {
        return servicio.update(c, id);
    }

    @DeleteMapping("{id}")
    public PacienteDTO delete(@PathVariable Long id) {
        return servicio.delete(id);
    }

    @PutMapping("enable/{id}")
    public PacienteDTO enable(@PathVariable long id) {
        return servicio.enable(id);
    }
}
