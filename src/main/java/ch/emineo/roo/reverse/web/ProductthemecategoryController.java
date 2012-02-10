package ch.emineo.roo.reverse.web;

import ch.emineo.roo.reverse.domain.Productthemecategory;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/productthemecategorys")
@Controller
@RooWebScaffold(path = "productthemecategorys", formBackingObject = Productthemecategory.class)
public class ProductthemecategoryController {
}
