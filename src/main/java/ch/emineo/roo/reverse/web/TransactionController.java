package ch.emineo.roo.reverse.web;

import ch.emineo.roo.reverse.domain.Transaction;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/transactions")
@Controller
@RooWebScaffold(path = "transactions", formBackingObject = Transaction.class)
public class TransactionController {
}
