package ch.emineo.roo.reverse.web;

import ch.emineo.roo.reverse.domain.ProductProductvariant;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/productproductvariants")
@Controller
@RooWebScaffold(path = "productproductvariants", formBackingObject = ProductProductvariant.class)
public class ProductProductvariantController {
}
