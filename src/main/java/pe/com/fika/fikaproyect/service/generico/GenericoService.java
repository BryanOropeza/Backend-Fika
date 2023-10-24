package pe.com.fika.fikaproyect.service.generico;

import java.util.List;

public interface GenericoService<T> {
    List<T> findAll();

    List<T> findAllCustom();

    T findById(Long id);

    T add(T t);

    T update(T t, Long id);

    T delete(Long id);

    T enable(Long id);
}
