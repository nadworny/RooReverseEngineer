package ch.emineo.roo.reverse.web;

import ch.emineo.roo.reverse.domain.Attribute;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/attributes")
@Controller
@RooWebScaffold(path = "attributes", formBackingObject = Attribute.class)
public class AttributeController {
}
