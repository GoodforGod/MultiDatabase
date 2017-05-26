package com.univ.db.controllers.restful;

import com.univ.db.controllers.restful.exceptions.NotCreatedException;
import com.univ.db.controllers.restful.exceptions.NotFoundException;
import com.univ.db.model.dto.DeclarationDTO;
import com.univ.db.service.modelbased.impl.DeclarationService;
import com.univ.db.util.Converter;
import com.univ.db.util.RestResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Default Comment
 *
 * @author @GoodforGod
 * @since 26.05.2017
 */
@RestController
public class DeclarationRestController {

    private final String PATH = RestResolver.DECLARATION;
    private final DeclarationService declarationService;

    @Autowired
    public DeclarationRestController(DeclarationService declarationService) {
        this.declarationService = declarationService;
    }

    @RequestMapping(value = PATH + "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DeclarationDTO> get(@PathVariable("id") Long id) {
        DeclarationDTO dto = Converter.toDTO(declarationService.getByCatalogCode(id).orElseThrow(NotFoundException::new));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = PATH, method = RequestMethod.PATCH)
    public void update(@Valid @RequestBody DeclarationDTO model) {
        declarationService.save(Converter.toDAO(model)).orElseThrow(NotCreatedException::new);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = PATH, method = RequestMethod.POST)
    public void create(@Valid @RequestBody DeclarationDTO model) {
        declarationService.save(Converter.toDAO(model)).orElseThrow(NotCreatedException::new);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = PATH + "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        try {
            declarationService.getByCatalogCode(id);
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }
}
