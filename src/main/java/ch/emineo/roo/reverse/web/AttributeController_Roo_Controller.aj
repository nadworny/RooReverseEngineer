// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.web;

import ch.emineo.roo.reverse.domain.AdvancenoticeAttribute;
import ch.emineo.roo.reverse.domain.Attribute;
import ch.emineo.roo.reverse.domain.Content;
import ch.emineo.roo.reverse.domain.ProductAttribute;
import ch.emineo.roo.reverse.domain.ProductbuildAttribute;
import ch.emineo.roo.reverse.domain.ProductbuildelementAttribute;
import ch.emineo.roo.reverse.domain.ProductcategoryAttribute;
import ch.emineo.roo.reverse.domain.ProductsubcategoryAttribute;
import ch.emineo.roo.reverse.domain.ProductthemeAttribute;
import ch.emineo.roo.reverse.domain.ProductthemecategoryAttribute;
import ch.emineo.roo.reverse.domain.ProductthemecontentholderAttribute;
import ch.emineo.roo.reverse.domain.ProductthemesubcategoryAttribute;
import ch.emineo.roo.reverse.domain.SubscriptiontypeAttribute;
import ch.emineo.roo.reverse.domain.UserAttribute;
import ch.emineo.roo.reverse.web.AttributeController;
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

privileged aspect AttributeController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String AttributeController.create(@Valid Attribute attribute, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, attribute);
            return "attributes/create";
        }
        uiModel.asMap().clear();
        attribute.persist();
        return "redirect:/attributes/" + encodeUrlPathSegment(attribute.getAttributeid().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String AttributeController.createForm(Model uiModel) {
        populateEditForm(uiModel, new Attribute());
        return "attributes/create";
    }
    
    @RequestMapping(value = "/{id}", produces = "text/html")
    public String AttributeController.show(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("attribute", Attribute.findAttribute(id));
        uiModel.addAttribute("itemId", id);
        return "attributes/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String AttributeController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("attributes", Attribute.findAttributeEntries(firstResult, sizeNo));
            float nrOfPages = (float) Attribute.countAttributes() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("attributes", Attribute.findAllAttributes());
        }
        return "attributes/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String AttributeController.update(@Valid Attribute attribute, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, attribute);
            return "attributes/update";
        }
        uiModel.asMap().clear();
        attribute.merge();
        return "redirect:/attributes/" + encodeUrlPathSegment(attribute.getAttributeid().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String AttributeController.updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, Attribute.findAttribute(id));
        return "attributes/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String AttributeController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Attribute attribute = Attribute.findAttribute(id);
        attribute.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/attributes";
    }
    
    void AttributeController.populateEditForm(Model uiModel, Attribute attribute) {
        uiModel.addAttribute("attribute", attribute);
        uiModel.addAttribute("advancenoticeattributes", AdvancenoticeAttribute.findAllAdvancenoticeAttributes());
        uiModel.addAttribute("contents", Content.findAllContents());
        uiModel.addAttribute("productattributes", ProductAttribute.findAllProductAttributes());
        uiModel.addAttribute("productbuildattributes", ProductbuildAttribute.findAllProductbuildAttributes());
        uiModel.addAttribute("productbuildelementattributes", ProductbuildelementAttribute.findAllProductbuildelementAttributes());
        uiModel.addAttribute("productcategoryattributes", ProductcategoryAttribute.findAllProductcategoryAttributes());
        uiModel.addAttribute("productsubcategoryattributes", ProductsubcategoryAttribute.findAllProductsubcategoryAttributes());
        uiModel.addAttribute("productthemeattributes", ProductthemeAttribute.findAllProductthemeAttributes());
        uiModel.addAttribute("productthemecategoryattributes", ProductthemecategoryAttribute.findAllProductthemecategoryAttributes());
        uiModel.addAttribute("productthemecontentholderattributes", ProductthemecontentholderAttribute.findAllProductthemecontentholderAttributes());
        uiModel.addAttribute("productthemesubcategoryattributes", ProductthemesubcategoryAttribute.findAllProductthemesubcategoryAttributes());
        uiModel.addAttribute("subscriptiontypeattributes", SubscriptiontypeAttribute.findAllSubscriptiontypeAttributes());
        uiModel.addAttribute("userattributes", UserAttribute.findAllUserAttributes());
    }
    
    String AttributeController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
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