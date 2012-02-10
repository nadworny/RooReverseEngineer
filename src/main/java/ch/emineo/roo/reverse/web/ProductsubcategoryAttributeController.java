package ch.emineo.roo.reverse.web;

import ch.emineo.roo.reverse.domain.ProductsubcategoryAttribute;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/productsubcategoryattributes")
@Controller
@RooWebScaffold(path = "productsubcategoryattributes", formBackingObject = ProductsubcategoryAttribute.class)
public class ProductsubcategoryAttributeController {
}
