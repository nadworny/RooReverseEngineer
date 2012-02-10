package ch.emineo.roo.reverse.web;

import ch.emineo.roo.reverse.domain.Advancenotice;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/advancenotices")
@Controller
@RooWebScaffold(path = "advancenotices", formBackingObject = Advancenotice.class)
public class AdvancenoticeController {
}
