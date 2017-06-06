package com.univ.db.controllers.restful;

import com.univ.db.controllers.restful.exceptions.NotCreatedException;
import com.univ.db.controllers.restful.exceptions.NotFoundException;
import com.univ.db.model.dao.redis.DiscountOfferHot;
import com.univ.db.service.modelbased.multilevel.DiscountHotService;
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
 * @author GoodforGod (Anton Kurako)
 * @since 06.06.2017
 */
@RestController
public class DiscountRestController {

    private final String PATH = RestResolver.DISCOUNT;
    private final DiscountHotService discountHotService;

    @Autowired
    public DiscountRestController(DiscountHotService discountHotService) {
        this.discountHotService = discountHotService;
    }

    @RequestMapping(value = PATH + "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DiscountOfferHot> get(@PathVariable("id") Long id) {
        DiscountOfferHot discountOfferHot = discountHotService.getById(id.toString()).orElseThrow(NotFoundException::new);
        return new ResponseEntity<>(discountOfferHot, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = PATH, method = RequestMethod.PATCH)
    public void update(@Valid @RequestBody DiscountOfferHot model) {
        discountHotService.save(model).orElseThrow(NotCreatedException::new);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = PATH, method = RequestMethod.POST)
    public void create(@Valid @RequestBody DiscountOfferHot model) {
        discountHotService.save(model).orElseThrow(NotCreatedException::new);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = PATH + "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        try {
            discountHotService.deleteById(id.toString());
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }
}
