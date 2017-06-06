package com.univ.db.controllers;

import com.univ.db.model.dao.cassandra.Declaration;
import com.univ.db.model.dao.mongo.Item;
import com.univ.db.model.dao.neo4j.Order;
import com.univ.db.model.dao.neo4j.Seller;
import com.univ.db.model.dao.redis.ItemRecent;
import com.univ.db.model.dao.sql.User;
import com.univ.db.model.dao.sql.UserAddress;
import com.univ.db.service.modelbased.impl.ItemRecentService;
import com.univ.db.util.PopulateResolver;
import io.dummymaker.export.IExporter;
import io.dummymaker.export.impl.CsvExporter;
import io.dummymaker.export.impl.SqlExporter;
import io.dummymaker.produce.GenProduceFactory;
import io.dummymaker.produce.IProduceFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Default Comment
 *
 * @author GoodforGod (Anton Kurako)
 * @since 05.06.2017
 */
@Controller
public class WebPopulateController {
    private final Logger logger = org.slf4j.LoggerFactory.getLogger(WebMainController.class);

    private static Long counter = 1L;

    private final ItemRecentService itemRecentService;

    @Autowired
    public WebPopulateController(ItemRecentService itemRecentService) {
        this.itemRecentService = itemRecentService;
    }

    @RequestMapping(path = PopulateResolver.SQL, method = RequestMethod.GET)
    public String populateSql(Model model) {
        IProduceFactory<User> factory = new GenProduceFactory<>(User.class);
        IProduceFactory<UserAddress> addressFactory = new GenProduceFactory<>(UserAddress.class);

        new SqlExporter<>(User.class).export(factory.produce(1000000));

        return "home";
    }

    @RequestMapping(path = PopulateResolver.REDIS, method = RequestMethod.GET)
    public String populateRedis(Model model) {
        IProduceFactory<ItemRecent> factory = new GenProduceFactory<>(ItemRecent.class);

        Long counter = 1L;
        for(ItemRecent itemRecent :factory.produce(1000000)) {
            itemRecent.setCatalogCode(counter);
            itemRecentService.save(itemRecent);
            counter++;
        }

        return "home";
    }

    @RequestMapping(path = PopulateResolver.MONGO, method = RequestMethod.GET)
    public String populateMongo(Model model) {
        IProduceFactory<Item> factory = new GenProduceFactory<>(Item.class);

        new CsvExporter<>(Item.class).export(factory.produce(1000000));

        return "home";
    }

    @RequestMapping(path = PopulateResolver.CASSANDRA, method = RequestMethod.GET)
    public String populateCassandra(Model model) {
        IProduceFactory<Declaration> factory = new GenProduceFactory<>(Declaration.class);

        new CsvExporter<>(Declaration.class, true, true).export(factory.produce(1000000));

        return "home";
    }

    @RequestMapping(path = PopulateResolver.NEO4J, method = RequestMethod.GET)
    public String populateNeo4j(Model model) {
        IProduceFactory<Seller> factory = new GenProduceFactory<>(Seller.class);
        IProduceFactory<Order> orderFactory = new GenProduceFactory<>(Order.class);
        IExporter<Order> orderExporter = new CsvExporter<Order>(Order.class, false, true);

        new CsvExporter<>(Seller.class, false, true).export(factory.produce(1000000));

        List<Order> orders = orderFactory.produce(1000000);
        long orderId = 1;
        for(Order order : orders) {

        }

        return "home";
    }
}
