package ch.emineo.roo.reverse.web;

import ch.emineo.roo.reverse.domain.ProductthemeProductvariant;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/productthemeproductvariants")
@Controller
@RooWebScaffold(path = "productthemeproductvariants", formBackingObject = ProductthemeProductvariant.class)
public class ProductthemeProductvariantController {
}
