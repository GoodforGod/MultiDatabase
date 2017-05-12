package com.univ.db.controllers;

/*
 * Created by @GoodforGod on 05.05.2017.
 */

import com.univ.db.service.impl.ItemRecentService;
import com.univ.db.service.impl.ItemService;
import com.univ.db.service.impl.UserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Default Comment
 */
@Controller
public class WebMainController {

    private final Logger logger = org.slf4j.LoggerFactory.getLogger(WebMainController.class);

    private final ItemRecentService itemRecentService;
    private final ItemService itemService;
    private final UserService userService;

    @Autowired
    public WebMainController(ItemRecentService itemRecentService, ItemService itemService, UserService userService) {
        this.itemRecentService = itemRecentService;
        this.itemService = itemService;
        this.userService = userService;
    }

    @RequestMapping(path = {"/" ,"/home"}, method = RequestMethod.GET)
    public ModelAndView getHome(Model model) {
        ModelAndView modelAndView = new ModelAndView("home");

//        userService.save(new User("bob", "bob@bob", "bob"));
//        itemService.save(new Item(1L, "test", "Descr", Collections.emptyList(), Collections.emptyList(), Manufacture.EMPTY));

//        Optional<List<User>> users = userService.getAll();
//        Optional<List<Item>> items = itemService.getAll();
//
//        users.ifPresent(users1 -> logger.warn(String.valueOf(users1.size())));
//        items.ifPresent(items1 -> logger.warn(String.valueOf(items1.size())));

        modelAndView.addObject("userCount", userService.count().get());
        modelAndView.addObject("itemCount", itemService.count().get());
        modelAndView.addObject("itemRecentCount", itemRecentService.count().get());

        return modelAndView;
    }
}
