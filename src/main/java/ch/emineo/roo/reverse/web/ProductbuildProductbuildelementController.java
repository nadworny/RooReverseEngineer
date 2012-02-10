package ch.emineo.roo.reverse.web;

import ch.emineo.roo.reverse.domain.ProductbuildProductbuildelement;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/productbuildproductbuildelements")
@Controller
@RooWebScaffold(path = "productbuildproductbuildelements", formBackingObject = ProductbuildProductbuildelement.class)
public class ProductbuildProductbuildelementController {
}
