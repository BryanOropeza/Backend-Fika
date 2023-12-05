package pe.com.fika.fikaproyect.restController;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.fika.fikaproyect.dto.CitaDTO;
import pe.com.fika.fikaproyect.service.CitaService;

@RestController
@RequestMapping("/citas")
@CrossOrigin(origins = "http://localhost:4200")
public class CitaRestController {
    @Autowired
    private CitaService servicio;

    @GetMapping
    public List<CitaDTO> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<CitaDTO> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public CitaDTO findById(@PathVariable Long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public CitaDTO add(@RequestBody CitaDTO c) {
        return servicio.add(c);
    }

    @PutMapping("{id}")
    public CitaDTO update(@PathVariable long id, @RequestBody CitaDTO c) {
        return servicio.update(c, id);
    }

    @DeleteMapping("{id}")
    public CitaDTO delete(@PathVariable Long id) {
        return servicio.delete(id);
    }

    @PutMapping("enable/{id}")
    public CitaDTO enable(@PathVariable long id) {
        return servicio.enable(id);
    }

    @GetMapping("/checkDate/{date}")
    public boolean checkDateExists(@PathVariable Date date) {
        return servicio.existsByDate(date);
    }

    @GetMapping("/checkDateOutOfTime/{date}")
    public boolean isDateOutOfTime(@PathVariable Date date) {
        return servicio.isDateOutOfTime(date);
    }
}
