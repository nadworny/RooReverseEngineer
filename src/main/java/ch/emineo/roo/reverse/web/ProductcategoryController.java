package ch.emineo.roo.reverse.web;

import ch.emineo.roo.reverse.domain.Productcategory;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/productcategorys")
@Controller
@RooWebScaffold(path = "productcategorys", formBackingObject = Productcategory.class)
public class ProductcategoryController {
}
