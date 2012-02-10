package ch.emineo.roo.reverse.web;

import ch.emineo.roo.reverse.domain.UserAttribute;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/userattributes")
@Controller
@RooWebScaffold(path = "userattributes", formBackingObject = UserAttribute.class)
public class UserAttributeController {
}
