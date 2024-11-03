package project.unimed.dev.fipe_api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import project.unimed.dev.fipe_api.dto.FipeCarDTO;
import project.unimed.dev.fipe_api.service.FipeCarService;

import java.io.Serializable;
import java.net.URI;

@Controller
@RestController
@RequestMapping(value = "/carros")
public class FipeCarController implements Serializable {
    private static final long serialVersionUID = 1L;

    @Autowired
    private FipeCarService service;

    @GetMapping
    public ResponseEntity<Page<FipeCarDTO>> findAllPaged(Pageable pageable){
        Page<FipeCarDTO> list = service.findAllPaged(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<FipeCarDTO> findById(@PathVariable Long id) {
        FipeCarDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<FipeCarDTO> insert(@Valid @RequestBody FipeCarDTO dto){
        dto = service.insert(dto);

        //quando se trata de inserir, convém mostrar o caminho da localização do obj
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();

        //retorna a requisição com o cód 201(obj criado) e o obj no corpo da resposta
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<FipeCarDTO> update(@PathVariable Long id, @Valid @RequestBody FipeCarDTO dto){
        dto = service.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build(); //retorna cód 204 = não tem corpo na resposta, mas requisição está ok!
    }

}