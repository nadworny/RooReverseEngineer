package ch.emineo.roo.reverse.web;

import ch.emineo.roo.reverse.domain.ProductthemesubcategoryProductthemecontentholder;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/productthemesubcategoryproductthemecontentholders")
@Controller
@RooWebScaffold(path = "productthemesubcategoryproductthemecontentholders", formBackingObject = ProductthemesubcategoryProductthemecontentholder.class)
public class ProductthemesubcategoryProductthemecontentholderController {
}
