package ch.emineo.roo.reverse.web;

import ch.emineo.roo.reverse.domain.SubscriptiontypeAttribute;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/subscriptiontypeattributes")
@Controller
@RooWebScaffold(path = "subscriptiontypeattributes", formBackingObject = SubscriptiontypeAttribute.class)
public class SubscriptiontypeAttributeController {
}
