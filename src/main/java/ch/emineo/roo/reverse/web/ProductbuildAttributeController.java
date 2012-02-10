package ch.emineo.roo.reverse.web;

import ch.emineo.roo.reverse.domain.ProductbuildAttribute;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/productbuildattributes")
@Controller
@RooWebScaffold(path = "productbuildattributes", formBackingObject = ProductbuildAttribute.class)
public class ProductbuildAttributeController {
}
