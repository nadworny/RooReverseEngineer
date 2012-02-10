package ch.emineo.roo.reverse.web;

import ch.emineo.roo.reverse.domain.Productthemesubcategory;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/productthemesubcategorys")
@Controller
@RooWebScaffold(path = "productthemesubcategorys", formBackingObject = Productthemesubcategory.class)
public class ProductthemesubcategoryController {
}
