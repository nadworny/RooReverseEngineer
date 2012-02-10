package ch.emineo.roo.reverse.web;

import ch.emineo.roo.reverse.domain.Productthemecontentholder;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/productthemecontentholders")
@Controller
@RooWebScaffold(path = "productthemecontentholders", formBackingObject = Productthemecontentholder.class)
public class ProductthemecontentholderController {
}
