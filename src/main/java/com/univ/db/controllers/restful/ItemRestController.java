package com.univ.db.controllers.restful;

/*
 * Created by @GoodforGod on 05.05.2017.
 */

import com.univ.db.controllers.restful.exceptions.NotCreatedException;
import com.univ.db.controllers.restful.exceptions.NotFoundException;
import com.univ.db.model.dao.redis.ItemRecent;
import com.univ.db.model.dto.ItemDTO;
import com.univ.db.service.modelbased.impl.ItemRecentService;
import com.univ.db.service.modelbased.impl.ItemService;
import com.univ.db.util.Converter;
import com.univ.db.util.RestResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.logging.Logger;

/**
 * Default Comment
 */
@RestController
public class ItemRestController {

    private final String PATH = RestResolver.ITEM;
    private final ItemService itemService;
    private final ItemRecentService itemRecentService;

    private final Logger logger = Logger.getLogger(ItemRestController.class.getName());

    @Autowired
    public ItemRestController(ItemService itemService, ItemRecentService itemRecentService) {
        this.itemService = itemService;
        this.itemRecentService = itemRecentService;
    }

    @RequestMapping(value = PATH + "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ItemDTO> get(@PathVariable("id") String id) {
        ItemDTO itemDTO = Converter.toDTO(itemService.getById(id).orElseThrow(NotFoundException::new));
        itemRecentService.save(new ItemRecent(itemDTO));
        return new ResponseEntity<>(itemDTO, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = PATH, method = RequestMethod.PATCH)
    public void update(@Valid @RequestBody ItemDTO model) {
        itemService.save(Converter.toDAO(model)).orElseThrow(NotCreatedException::new);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = PATH, method = RequestMethod.POST)
    public void create(@Valid @RequestBody ItemDTO model) {
        itemService.save(Converter.toDAO(model)).orElseThrow(NotCreatedException::new);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = PATH + "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") String id) {
        try {
            itemService.deleteById(id);

            try {
                itemRecentService.deleteById(id);
            } catch (Exception e) {
                logger.warning(e.getMessage());
            }
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }
}
