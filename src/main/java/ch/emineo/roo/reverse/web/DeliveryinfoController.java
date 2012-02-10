package ch.emineo.roo.reverse.web;

import ch.emineo.roo.reverse.domain.Deliveryinfo;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/deliveryinfoes")
@Controller
@RooWebScaffold(path = "deliveryinfoes", formBackingObject = Deliveryinfo.class)
public class DeliveryinfoController {
}
