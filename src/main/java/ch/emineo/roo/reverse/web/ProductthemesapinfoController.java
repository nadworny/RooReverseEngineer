package ch.emineo.roo.reverse.web;

import ch.emineo.roo.reverse.domain.Productthemesapinfo;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/productthemesapinfoes")
@Controller
@RooWebScaffold(path = "productthemesapinfoes", formBackingObject = Productthemesapinfo.class)
public class ProductthemesapinfoController {
}
