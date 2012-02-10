package ch.emineo.roo.reverse.web;

import ch.emineo.roo.reverse.domain.Producttheme;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/productthemes")
@Controller
@RooWebScaffold(path = "productthemes", formBackingObject = Producttheme.class)
public class ProductthemeController {
}
