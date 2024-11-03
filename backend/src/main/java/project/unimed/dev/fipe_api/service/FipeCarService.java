package project.unimed.dev.fipe_api.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.unimed.dev.fipe_api.dto.FipeCarDTO;
import project.unimed.dev.fipe_api.entity.FipeCar;
import project.unimed.dev.fipe_api.repository.FipeCarRepository;
import org.springframework.web.client.RestTemplate;
import project.unimed.dev.fipe_api.service.exception.DataBaseException;
import project.unimed.dev.fipe_api.service.exception.ResourceNotFoundException;

import java.io.Serializable;
import java.util.Optional;

@Service
public class FipeCarService implements Serializable {
    private static final long serialVersionUID = 1L;

    @Autowired
    private FipeCarRepository repository;

    @Transactional(readOnly = true)
    public Page<FipeCarDTO> findAllPaged(Pageable pageable){
        Page<FipeCar> list = repository.findAll(pageable);
        return list.map( x -> new FipeCarDTO(x));
    }

    @Transactional(readOnly = true)
    public FipeCarDTO findById(Long id) {
        Optional<FipeCar> obj = repository.findById(id);
        FipeCar entity = obj.orElseThrow( () -> new ResourceNotFoundException("Ops! Produto não cadastrado") );
        return new FipeCarDTO(entity);
    }

    public FipeCarDTO insert(@Valid FipeCarDTO dto) {
        FipeCar entity = new FipeCar();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new FipeCarDTO(entity);
    }

    public FipeCarDTO update(Long id, @Valid FipeCarDTO dto) {
        try {
            FipeCar entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new FipeCarDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("ID "+ id + " not found!");
        }
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("ID "+id+" Not Found!");
        }
        catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Integrity Violation"); //tenta deletar obj que outros dependem
        }
    }


    private void copyDtoToEntity(FipeCarDTO dto, FipeCar entity) {
        entity.setId(dto.getId());
        entity.setValor(dto.getValor());
        entity.setMarca(dto.getMarca());
        entity.setModelo(dto.getModelo());
        entity.setAnoModelo(dto.getAnoModelo());
        entity.setCodigoFipe(dto.getCodigoFipe());
    }

}
