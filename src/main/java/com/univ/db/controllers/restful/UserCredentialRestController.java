package com.univ.db.controllers.restful;

/*
 * Created by @GoodforGod on 05.05.2017.
 */

import com.univ.db.controllers.restful.exceptions.NotCreatedException;
import com.univ.db.controllers.restful.exceptions.NotFoundException;
import com.univ.db.model.dto.UserDTO;
import com.univ.db.service.modelbased.impl.UserService;
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
public class UserCredentialRestController {

    private final String PATH = RestResolver.USER;
    private final UserService userService;

    @Autowired
    public UserCredentialRestController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = PATH + "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> get(@PathVariable("id") Long id) {
        UserDTO recentDTO = Converter.toDTO(userService.getById(id).orElseThrow(NotFoundException::new));
        return new ResponseEntity<>(recentDTO, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = PATH, method = RequestMethod.PATCH)
    public void update(@PathVariable("id") Long id, @Valid @RequestBody UserDTO model) {
        userService.save(Converter.toDAO(model)).orElseThrow(NotCreatedException::new);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = PATH, method = RequestMethod.POST)
    public void create(@Valid @RequestBody UserDTO model) {
        userService.save(Converter.toDAO(model)).orElseThrow(NotCreatedException::new);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = PATH + "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        try {
            userService.deleteById(id);
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }
}
