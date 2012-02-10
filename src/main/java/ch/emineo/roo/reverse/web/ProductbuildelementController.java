package ch.emineo.roo.reverse.web;

import ch.emineo.roo.reverse.domain.Productbuildelement;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/productbuildelements")
@Controller
@RooWebScaffold(path = "productbuildelements", formBackingObject = Productbuildelement.class)
public class ProductbuildelementController {
}
