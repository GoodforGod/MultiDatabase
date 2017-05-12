package com.univ.db.controllers;

/*
 * Created by @GoodforGod on 05.05.2017.
 */

import com.univ.db.model.dao.Item;
import com.univ.db.model.dao.ItemRecent;
import com.univ.db.model.dao.Manufacture;
import com.univ.db.model.dao.User;
import com.univ.db.service.modelbased.impl.ItemRecentService;
import com.univ.db.service.modelbased.impl.ItemService;
import com.univ.db.service.modelbased.impl.UserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.Optional;

/**
 * Default Comment
 */
@Controller
public class WebMainController {

    private final Logger logger = org.slf4j.LoggerFactory.getLogger(WebMainController.class);

    private final ItemRecentService itemRecentService;
    private final ItemService itemService;
    private final UserService userService;

    private static Long counter = 10L;

    @Autowired
    public WebMainController(ItemRecentService itemRecentService, ItemService itemService, UserService userService) {
        this.itemRecentService = itemRecentService;
        this.itemService = itemService;
        this.userService = userService;

        counter = itemService.count().orElse(100L);
    }

    @RequestMapping(path = {"/" ,"/home"}, method = RequestMethod.GET)
    public ModelAndView getHome(Model model) {
        ModelAndView modelAndView = new ModelAndView("home");

        userService.save(new User("bob", "bob@bob", "bob"));
        itemService.save(new Item(counter, "test", "Descr", Collections.emptyList(), Collections.emptyList(), Manufacture.EMPTY));
        itemRecentService.save(new ItemRecent(counter, "test", "test", "test"));

//        Optional<List<User>> users = userService.getAll();
//        Optional<List<Item>> items = itemService.getAll();
//        users.ifPresent(users1 -> logger.warn(String.valueOf(users1.size())));
//        items.ifPresent(items1 -> logger.warn(String.valueOf(items1.size())));

        Optional<ItemRecent> itemRecent = itemRecentService.getById(counter.toString());

        counter++;

        modelAndView.addObject("userCount", userService.count().orElse(-1L));
        modelAndView.addObject("itemCount", itemService.count().orElse(-1L));
        modelAndView.addObject("itemRecentCount", itemRecentService.count().orElse(-1L));

        return modelAndView;
    }
}
