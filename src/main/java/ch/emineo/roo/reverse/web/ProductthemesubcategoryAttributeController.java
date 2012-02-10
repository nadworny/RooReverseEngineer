package ch.emineo.roo.reverse.web;

import ch.emineo.roo.reverse.domain.ProductthemesubcategoryAttribute;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/productthemesubcategoryattributes")
@Controller
@RooWebScaffold(path = "productthemesubcategoryattributes", formBackingObject = ProductthemesubcategoryAttribute.class)
public class ProductthemesubcategoryAttributeController {
}
