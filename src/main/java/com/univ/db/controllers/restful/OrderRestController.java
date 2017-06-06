package com.univ.db.controllers.restful;

import com.univ.db.controllers.restful.exceptions.NotCreatedException;
import com.univ.db.controllers.restful.exceptions.NotFoundException;
import com.univ.db.model.dao.neo4j.Order;
import com.univ.db.model.dao.neo4j.Seller;
import com.univ.db.model.dto.OrderDTO;
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
 * @author GoodforGod (Anton Kurako)
 * @since 06.06.2017
 */
@RestController
public class OrderRestController {
    private final String PATH = RestResolver.SELLER;
    private final SellerService sellerService;

    @Autowired
    public OrderRestController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @RequestMapping(value = PATH + "/{sellerId}" + "/orders" + "/{orderId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderDTO> get(@PathVariable("sellerId") Long sellerId, @PathVariable("orderId") Long orderId) {
        Seller seller = sellerService.getById(sellerId).orElseThrow(NotFoundException::new);
        Order order = seller.getOrders().stream().filter(o -> o.getId().equals(orderId)).findFirst().orElseThrow(NotFoundException::new);
        return new ResponseEntity<>(Converter.toDTO(order), HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = PATH + "/{sellerId}" + "/orders", method = RequestMethod.PATCH)
    public void update(@PathVariable("sellerId}") Long sellerId, @Valid @RequestBody OrderDTO model) {
        Seller seller = sellerService.getById(sellerId).orElseThrow(NotFoundException::new);
        seller.addOrder(Converter.toDAO(model));
        sellerService.save(seller).orElseThrow(NotCreatedException::new);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = PATH + "/{sellerId}" + "/orders", method = RequestMethod.POST)
    public void create(@PathVariable("sellerId}") Long sellerId, @Valid @RequestBody OrderDTO model) {
        Seller seller = sellerService.getById(sellerId).orElseThrow(NotFoundException::new);
        Order order = seller.getOrders().stream().filter(o -> o.getId().equals(model.getId())).findFirst().orElseThrow(NotFoundException::new);
        Order updated = Converter.update(order, model);
        seller.removeOrder(order);
        seller.addOrder(updated);
        sellerService.save(seller).orElseThrow(NotCreatedException::new);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = PATH + "/{sellerId}" + "/orders" + "/{orderId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("sellerId") Long sellerId, @PathVariable("orderId") Long orderId) {
        try {
            Seller seller = sellerService.getById(sellerId).orElseThrow(NotFoundException::new);
            Order order = seller.getOrders().stream().filter(o -> o.getId().equals(orderId)).findFirst().orElseThrow(NotFoundException::new);
            seller.removeOrder(order);
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }
}
