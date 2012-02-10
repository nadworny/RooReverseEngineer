package ch.emineo.roo.reverse.web;

import ch.emineo.roo.reverse.domain.Productsubcategory;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/productsubcategorys")
@Controller
@RooWebScaffold(path = "productsubcategorys", formBackingObject = Productsubcategory.class)
public class ProductsubcategoryController {
}
