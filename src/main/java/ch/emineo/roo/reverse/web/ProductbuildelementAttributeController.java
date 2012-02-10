package ch.emineo.roo.reverse.web;

import ch.emineo.roo.reverse.domain.ProductbuildelementAttribute;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/productbuildelementattributes")
@Controller
@RooWebScaffold(path = "productbuildelementattributes", formBackingObject = ProductbuildelementAttribute.class)
public class ProductbuildelementAttributeController {
}
