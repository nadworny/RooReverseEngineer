package ch.emineo.roo.reverse.web;

import ch.emineo.roo.reverse.domain.ProductthemecategoryAttribute;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/productthemecategoryattributes")
@Controller
@RooWebScaffold(path = "productthemecategoryattributes", formBackingObject = ProductthemecategoryAttribute.class)
public class ProductthemecategoryAttributeController {
}
