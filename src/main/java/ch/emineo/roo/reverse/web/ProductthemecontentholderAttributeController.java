package ch.emineo.roo.reverse.web;

import ch.emineo.roo.reverse.domain.ProductthemecontentholderAttribute;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/productthemecontentholderattributes")
@Controller
@RooWebScaffold(path = "productthemecontentholderattributes", formBackingObject = ProductthemecontentholderAttribute.class)
public class ProductthemecontentholderAttributeController {
}
