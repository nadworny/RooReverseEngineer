package ch.emineo.roo.reverse.web;

import ch.emineo.roo.reverse.domain.Subscriptiontype;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/subscriptiontypes")
@Controller
@RooWebScaffold(path = "subscriptiontypes", formBackingObject = Subscriptiontype.class)
public class SubscriptiontypeController {
}
