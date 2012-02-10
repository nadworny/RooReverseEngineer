package ch.emineo.roo.reverse.web;

import ch.emineo.roo.reverse.domain.Purchaseditem;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/purchaseditems")
@Controller
@RooWebScaffold(path = "purchaseditems", formBackingObject = Purchaseditem.class)
public class PurchaseditemController {
}
