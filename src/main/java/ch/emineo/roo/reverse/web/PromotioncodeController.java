package ch.emineo.roo.reverse.web;

import ch.emineo.roo.reverse.domain.Promotioncode;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/promotioncodes")
@Controller
@RooWebScaffold(path = "promotioncodes", formBackingObject = Promotioncode.class)
public class PromotioncodeController {
}
