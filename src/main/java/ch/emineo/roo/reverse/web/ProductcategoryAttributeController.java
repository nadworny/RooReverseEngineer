package ch.emineo.roo.reverse.web;

import ch.emineo.roo.reverse.domain.ProductcategoryAttribute;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/productcategoryattributes")
@Controller
@RooWebScaffold(path = "productcategoryattributes", formBackingObject = ProductcategoryAttribute.class)
public class ProductcategoryAttributeController {
}
