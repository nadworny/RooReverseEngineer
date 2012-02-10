package ch.emineo.roo.reverse.web;

import ch.emineo.roo.reverse.domain.ProductbuildelementContent;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/productbuildelementcontents")
@Controller
@RooWebScaffold(path = "productbuildelementcontents", formBackingObject = ProductbuildelementContent.class)
public class ProductbuildelementContentController {
}
