package ch.emineo.roo.reverse.web;

import ch.emineo.roo.reverse.domain.Productbuild;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/productbuilds")
@Controller
@RooWebScaffold(path = "productbuilds", formBackingObject = Productbuild.class)
public class ProductbuildController {
}
