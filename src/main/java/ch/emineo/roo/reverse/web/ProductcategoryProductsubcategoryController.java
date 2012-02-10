package ch.emineo.roo.reverse.web;

import ch.emineo.roo.reverse.domain.ProductcategoryProductsubcategory;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/productcategoryproductsubcategorys")
@Controller
@RooWebScaffold(path = "productcategoryproductsubcategorys", formBackingObject = ProductcategoryProductsubcategory.class)
public class ProductcategoryProductsubcategoryController {
}
