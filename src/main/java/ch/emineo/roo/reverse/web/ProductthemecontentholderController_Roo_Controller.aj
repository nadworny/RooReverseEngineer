// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.web;

import ch.emineo.roo.reverse.domain.Productbuild;
import ch.emineo.roo.reverse.domain.Productthemecontentholder;
import ch.emineo.roo.reverse.domain.ProductthemecontentholderAttribute;
import ch.emineo.roo.reverse.domain.ProductthemesubcategoryProductthemecontentholder;
import ch.emineo.roo.reverse.web.ProductthemecontentholderController;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect ProductthemecontentholderController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String ProductthemecontentholderController.create(@Valid Productthemecontentholder productthemecontentholder, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, productthemecontentholder);
            return "productthemecontentholders/create";
        }
        uiModel.asMap().clear();
        productthemecontentholder.persist();
        return "redirect:/productthemecontentholders/" + encodeUrlPathSegment(productthemecontentholder.getProductthemecontentholderid().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String ProductthemecontentholderController.createForm(Model uiModel) {
        populateEditForm(uiModel, new Productthemecontentholder());
        return "productthemecontentholders/create";
    }
    
    @RequestMapping(value = "/{id}", produces = "text/html")
    public String ProductthemecontentholderController.show(@PathVariable("id") Integer id, Model uiModel) {
        uiModel.addAttribute("productthemecontentholder", Productthemecontentholder.findProductthemecontentholder(id));
        uiModel.addAttribute("itemId", id);
        return "productthemecontentholders/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String ProductthemecontentholderController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("productthemecontentholders", Productthemecontentholder.findProductthemecontentholderEntries(firstResult, sizeNo));
            float nrOfPages = (float) Productthemecontentholder.countProductthemecontentholders() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("productthemecontentholders", Productthemecontentholder.findAllProductthemecontentholders());
        }
        return "productthemecontentholders/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String ProductthemecontentholderController.update(@Valid Productthemecontentholder productthemecontentholder, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, productthemecontentholder);
            return "productthemecontentholders/update";
        }
        uiModel.asMap().clear();
        productthemecontentholder.merge();
        return "redirect:/productthemecontentholders/" + encodeUrlPathSegment(productthemecontentholder.getProductthemecontentholderid().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String ProductthemecontentholderController.updateForm(@PathVariable("id") Integer id, Model uiModel) {
        populateEditForm(uiModel, Productthemecontentholder.findProductthemecontentholder(id));
        return "productthemecontentholders/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String ProductthemecontentholderController.delete(@PathVariable("id") Integer id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Productthemecontentholder productthemecontentholder = Productthemecontentholder.findProductthemecontentholder(id);
        productthemecontentholder.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/productthemecontentholders";
    }
    
    void ProductthemecontentholderController.populateEditForm(Model uiModel, Productthemecontentholder productthemecontentholder) {
        uiModel.addAttribute("productthemecontentholder", productthemecontentholder);
        uiModel.addAttribute("productbuilds", Productbuild.findAllProductbuilds());
        uiModel.addAttribute("productthemecontentholderattributes", ProductthemecontentholderAttribute.findAllProductthemecontentholderAttributes());
        uiModel.addAttribute("productthemesubcategoryproductthemecontentholders", ProductthemesubcategoryProductthemecontentholder.findAllProductthemesubcategoryProductthemecontentholders());
    }
    
    String ProductthemecontentholderController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
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
