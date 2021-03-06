package com.univ.db.controllers.restful;

/*
 * Created by @GoodforGod on 05.05.2017.
 */

import com.univ.db.controllers.restful.exceptions.NotCreatedException;
import com.univ.db.controllers.restful.exceptions.NotFoundException;
import com.univ.db.model.dao.sql.User;
import com.univ.db.model.dao.sql.UserAddress;
import com.univ.db.model.dto.UserAddressDTO;
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
public class UserAddressRestController {
    private final String PATH = RestResolver.ADDRESS;
    private final UserService userService;

    @Autowired
    public UserAddressRestController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = PATH + "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserAddressDTO> get(@PathVariable("id") Long id) {
        UserAddressDTO recentDTO = Converter.toDTO(userService.getById(id).orElseThrow(NotFoundException::new).getAddress());
        return new ResponseEntity<>(recentDTO, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = PATH + "/{id}", method = RequestMethod.PATCH)
    public void update(@PathVariable("id") Long id, @Valid @RequestBody UserAddressDTO model) {
        User user = userService.getById(id).orElseThrow(NotCreatedException::new);
        user.setAddress(Converter.toDAO(model));
        userService.save(user).orElseThrow(NotCreatedException::new);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = PATH + "/{id}", method = RequestMethod.POST)
    public void create(@PathVariable("id") Long id, @Valid @RequestBody UserAddressDTO model) {
        User user = userService.getById(id).orElseThrow(NotCreatedException::new);
        user.setAddress(Converter.toDAO(model));
        userService.save(user).orElseThrow(NotCreatedException::new);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = PATH + "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        try {
            User user = userService.getById(id).orElseThrow(NotFoundException::new);
            user.setAddress(UserAddress.EMPTY);
            userService.save(user).orElseThrow(NotCreatedException::new);
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }
}
