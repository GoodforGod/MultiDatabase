package com.univ.db.controllers;

/*
 * Created by @GoodforGod on 05.05.2017.
 */

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

        modelAndView.addObject("userCount", userService.count().orElse(-1L));
        modelAndView.addObject("itemCount", itemService.count().orElse(-1L));
        modelAndView.addObject("itemRecentCount", itemRecentService.count().orElse(-1L));

        return modelAndView;
    }
}
