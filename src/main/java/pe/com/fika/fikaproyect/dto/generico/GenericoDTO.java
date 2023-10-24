package pe.com.fika.fikaproyect.dto.generico;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenericoDTO {

    @Builder.Default
    private Long codigo = 0L;

}
