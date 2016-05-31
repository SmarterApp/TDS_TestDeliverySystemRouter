package tds.router.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import tds.router.config.TdsRouterProperties;

@Controller
public class IndexController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TdsRouterProperties tdsRouterProperties;

    @RequestMapping("/")
    String index() {

        logger.debug(" In controller {} ", this.getClass().getName());
        logger.debug("Properties: {} ", tdsRouterProperties);

        return "index";
    }

}