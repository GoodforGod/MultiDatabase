package com.univ.db.controllers.restful;

/*
 * Created by @GoodforGod on 05.05.2017.
 */

import com.univ.db.controllers.restful.exceptions.NotCreatedException;
import com.univ.db.controllers.restful.exceptions.NotFoundException;
import com.univ.db.model.dto.ItemRecentDTO;
import com.univ.db.service.impl.ItemRecentService;
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
 */
@RestController
public class ItemRecentRestController {
    private final String PATH = RestResolver.ITEM_RECENT;
    private final ItemRecentService itemService;

    @Autowired
    public ItemRecentRestController(ItemRecentService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping(value = PATH + "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ItemRecentDTO> get(@PathVariable("id") Long id) {
        ItemRecentDTO recentDTO = Converter.toDTO(itemService.getById(id).orElseThrow(NotFoundException::new));
        return new ResponseEntity<>(recentDTO, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = PATH, method = RequestMethod.PATCH)
    public void update(@Valid @RequestBody ItemRecentDTO model) {
        itemService.save(Converter.toDAO(model)).orElseThrow(NotCreatedException::new);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = PATH, method = RequestMethod.POST)
    public void create(@Valid @RequestBody ItemRecentDTO model) {
        itemService.save(Converter.toDAO(model)).orElseThrow(NotCreatedException::new);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = PATH + "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        try {
            itemService.deleteById(id);
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }
}
