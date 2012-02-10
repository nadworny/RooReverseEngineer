package ch.emineo.roo.reverse.web;

import ch.emineo.roo.reverse.domain.ProductAttribute;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/productattributes")
@Controller
@RooWebScaffold(path = "productattributes", formBackingObject = ProductAttribute.class)
public class ProductAttributeController {
}
