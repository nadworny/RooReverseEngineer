package ch.emineo.roo.reverse.web;

import ch.emineo.roo.reverse.domain.AdvancenoticeAttribute;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/advancenoticeattributes")
@Controller
@RooWebScaffold(path = "advancenoticeattributes", formBackingObject = AdvancenoticeAttribute.class)
public class AdvancenoticeAttributeController {
}
