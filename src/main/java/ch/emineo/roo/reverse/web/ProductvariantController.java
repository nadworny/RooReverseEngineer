package ch.emineo.roo.reverse.web;

import ch.emineo.roo.reverse.domain.Productvariant;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/productvariants")
@Controller
@RooWebScaffold(path = "productvariants", formBackingObject = Productvariant.class)
public class ProductvariantController {
}
