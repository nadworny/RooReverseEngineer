package ch.emineo.roo.reverse.web;

import ch.emineo.roo.reverse.domain.ProductthemeAttribute;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/productthemeattributes")
@Controller
@RooWebScaffold(path = "productthemeattributes", formBackingObject = ProductthemeAttribute.class)
public class ProductthemeAttributeController {
}
