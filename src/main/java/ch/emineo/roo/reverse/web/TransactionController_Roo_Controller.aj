// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.web;

import ch.emineo.roo.reverse.domain.Transaction;
import ch.emineo.roo.reverse.domain.UserTransaction;
import ch.emineo.roo.reverse.web.TransactionController;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.joda.time.format.DateTimeFormat;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect TransactionController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String TransactionController.create(@Valid Transaction transaction, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, transaction);
            return "transactions/create";
        }
        uiModel.asMap().clear();
        transaction.persist();
        return "redirect:/transactions/" + encodeUrlPathSegment(transaction.getTransactionid().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String TransactionController.createForm(Model uiModel) {
        populateEditForm(uiModel, new Transaction());
        return "transactions/create";
    }
    
    @RequestMapping(value = "/{id}", produces = "text/html")
    public String TransactionController.show(@PathVariable("id") Integer id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("transaction", Transaction.findTransaction(id));
        uiModel.addAttribute("itemId", id);
        return "transactions/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String TransactionController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("transactions", Transaction.findTransactionEntries(firstResult, sizeNo));
            float nrOfPages = (float) Transaction.countTransactions() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("transactions", Transaction.findAllTransactions());
        }
        addDateTimeFormatPatterns(uiModel);
        return "transactions/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String TransactionController.update(@Valid Transaction transaction, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, transaction);
            return "transactions/update";
        }
        uiModel.asMap().clear();
        transaction.merge();
        return "redirect:/transactions/" + encodeUrlPathSegment(transaction.getTransactionid().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String TransactionController.updateForm(@PathVariable("id") Integer id, Model uiModel) {
        populateEditForm(uiModel, Transaction.findTransaction(id));
        return "transactions/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String TransactionController.delete(@PathVariable("id") Integer id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Transaction transaction = Transaction.findTransaction(id);
        transaction.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/transactions";
    }
    
    void TransactionController.addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("transaction_date_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }
    
    void TransactionController.populateEditForm(Model uiModel, Transaction transaction) {
        uiModel.addAttribute("transaction", transaction);
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("usertransactions", UserTransaction.findAllUserTransactions());
    }
    
    String TransactionController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        } catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
    
}
