package com.univ.db.controllers.restful;

import com.univ.db.controllers.restful.exceptions.NotCreatedException;
import com.univ.db.controllers.restful.exceptions.NotFoundException;
import com.univ.db.model.dto.SellerDTO;
import com.univ.db.service.modelbased.impl.SellerService;
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
public class SellerRestController {

    private final String PATH = RestResolver.SELLER;
    private final SellerService sellerService;

    @Autowired
    public SellerRestController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @RequestMapping(value = PATH + "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SellerDTO> get(@PathVariable("id") Long id) {
        SellerDTO dto = Converter.toDTO(sellerService.getById(id).orElseThrow(NotFoundException::new));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = PATH, method = RequestMethod.PATCH)
    public void update(@Valid @RequestBody SellerDTO model) {
        sellerService.save(Converter.toDAO(model)).orElseThrow(NotCreatedException::new);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = PATH, method = RequestMethod.POST)
    public void create(@Valid @RequestBody SellerDTO model) {
        sellerService.save(Converter.toDAO(model)).orElseThrow(NotCreatedException::new);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = PATH + "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        try {
            sellerService.deleteById(id);
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }
}
