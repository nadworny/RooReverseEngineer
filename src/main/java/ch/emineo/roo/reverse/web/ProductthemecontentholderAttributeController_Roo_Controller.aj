// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.web;

import ch.emineo.roo.reverse.domain.Attribute;
import ch.emineo.roo.reverse.domain.Productthemecontentholder;
import ch.emineo.roo.reverse.domain.ProductthemecontentholderAttribute;
import ch.emineo.roo.reverse.domain.ProductthemecontentholderAttributePK;
import ch.emineo.roo.reverse.web.ProductthemecontentholderAttributeController;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect ProductthemecontentholderAttributeController_Roo_Controller {
    
    private ConversionService ProductthemecontentholderAttributeController.conversionService;
    
    @Autowired
    public ProductthemecontentholderAttributeController.new(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String ProductthemecontentholderAttributeController.create(@Valid ProductthemecontentholderAttribute productthemecontentholderAttribute, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, productthemecontentholderAttribute);
            return "productthemecontentholderattributes/create";
        }
        uiModel.asMap().clear();
        productthemecontentholderAttribute.persist();
        return "redirect:/productthemecontentholderattributes/" + encodeUrlPathSegment(conversionService.convert(productthemecontentholderAttribute.getId(), String.class), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String ProductthemecontentholderAttributeController.createForm(Model uiModel) {
        populateEditForm(uiModel, new ProductthemecontentholderAttribute());
        return "productthemecontentholderattributes/create";
    }
    
    @RequestMapping(value = "/{id}", produces = "text/html")
    public String ProductthemecontentholderAttributeController.show(@PathVariable("id") ProductthemecontentholderAttributePK id, Model uiModel) {
        uiModel.addAttribute("productthemecontentholderattribute", ProductthemecontentholderAttribute.findProductthemecontentholderAttribute(id));
        uiModel.addAttribute("itemId", conversionService.convert(id, String.class));
        return "productthemecontentholderattributes/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String ProductthemecontentholderAttributeController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("productthemecontentholderattributes", ProductthemecontentholderAttribute.findProductthemecontentholderAttributeEntries(firstResult, sizeNo));
            float nrOfPages = (float) ProductthemecontentholderAttribute.countProductthemecontentholderAttributes() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("productthemecontentholderattributes", ProductthemecontentholderAttribute.findAllProductthemecontentholderAttributes());
        }
        return "productthemecontentholderattributes/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String ProductthemecontentholderAttributeController.update(@Valid ProductthemecontentholderAttribute productthemecontentholderAttribute, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, productthemecontentholderAttribute);
            return "productthemecontentholderattributes/update";
        }
        uiModel.asMap().clear();
        productthemecontentholderAttribute.merge();
        return "redirect:/productthemecontentholderattributes/" + encodeUrlPathSegment(conversionService.convert(productthemecontentholderAttribute.getId(), String.class), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String ProductthemecontentholderAttributeController.updateForm(@PathVariable("id") ProductthemecontentholderAttributePK id, Model uiModel) {
        populateEditForm(uiModel, ProductthemecontentholderAttribute.findProductthemecontentholderAttribute(id));
        return "productthemecontentholderattributes/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String ProductthemecontentholderAttributeController.delete(@PathVariable("id") ProductthemecontentholderAttributePK id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        ProductthemecontentholderAttribute productthemecontentholderAttribute = ProductthemecontentholderAttribute.findProductthemecontentholderAttribute(id);
        productthemecontentholderAttribute.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/productthemecontentholderattributes";
    }
    
    void ProductthemecontentholderAttributeController.populateEditForm(Model uiModel, ProductthemecontentholderAttribute productthemecontentholderAttribute) {
        uiModel.addAttribute("productthemecontentholderAttribute", productthemecontentholderAttribute);
        uiModel.addAttribute("attributes", Attribute.findAllAttributes());
        uiModel.addAttribute("productthemecontentholders", Productthemecontentholder.findAllProductthemecontentholders());
    }
    
    String ProductthemecontentholderAttributeController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
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
