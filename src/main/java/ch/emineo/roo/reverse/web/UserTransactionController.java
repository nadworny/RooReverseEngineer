package ch.emineo.roo.reverse.web;

import ch.emineo.roo.reverse.domain.UserTransaction;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/usertransactions")
@Controller
@RooWebScaffold(path = "usertransactions", formBackingObject = UserTransaction.class)
public class UserTransactionController {
}
