package ch.emineo.roo.reverse.web;

import ch.emineo.roo.reverse.domain.ProductthemecategoryProductthemesubcategory;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/productthemecategoryproductthemesubcategorys")
@Controller
@RooWebScaffold(path = "productthemecategoryproductthemesubcategorys", formBackingObject = ProductthemecategoryProductthemesubcategory.class)
public class ProductthemecategoryProductthemesubcategoryController {
}
