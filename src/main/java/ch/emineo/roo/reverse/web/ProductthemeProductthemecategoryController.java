package ch.emineo.roo.reverse.web;

import ch.emineo.roo.reverse.domain.ProductthemeProductthemecategory;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/productthemeproductthemecategorys")
@Controller
@RooWebScaffold(path = "productthemeproductthemecategorys", formBackingObject = ProductthemeProductthemecategory.class)
public class ProductthemeProductthemecategoryController {
}
