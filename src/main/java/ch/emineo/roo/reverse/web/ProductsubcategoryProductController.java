package ch.emineo.roo.reverse.web;

import ch.emineo.roo.reverse.domain.ProductsubcategoryProduct;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/productsubcategoryproducts")
@Controller
@RooWebScaffold(path = "productsubcategoryproducts", formBackingObject = ProductsubcategoryProduct.class)
public class ProductsubcategoryProductController {
}
