// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.web;

import ch.emineo.roo.reverse.domain.Attribute;
import ch.emineo.roo.reverse.domain.Producttheme;
import ch.emineo.roo.reverse.domain.ProductthemeAttribute;
import ch.emineo.roo.reverse.domain.ProductthemeAttributePK;
import ch.emineo.roo.reverse.web.ProductthemeAttributeController;
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

privileged aspect ProductthemeAttributeController_Roo_Controller {
    
    private ConversionService ProductthemeAttributeController.conversionService;
    
    @Autowired
    public ProductthemeAttributeController.new(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String ProductthemeAttributeController.create(@Valid ProductthemeAttribute productthemeAttribute, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, productthemeAttribute);
            return "productthemeattributes/create";
        }
        uiModel.asMap().clear();
        productthemeAttribute.persist();
        return "redirect:/productthemeattributes/" + encodeUrlPathSegment(conversionService.convert(productthemeAttribute.getId(), String.class), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String ProductthemeAttributeController.createForm(Model uiModel) {
        populateEditForm(uiModel, new ProductthemeAttribute());
        return "productthemeattributes/create";
    }
    
    @RequestMapping(value = "/{id}", produces = "text/html")
    public String ProductthemeAttributeController.show(@PathVariable("id") ProductthemeAttributePK id, Model uiModel) {
        uiModel.addAttribute("productthemeattribute", ProductthemeAttribute.findProductthemeAttribute(id));
        uiModel.addAttribute("itemId", conversionService.convert(id, String.class));
        return "productthemeattributes/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String ProductthemeAttributeController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("productthemeattributes", ProductthemeAttribute.findProductthemeAttributeEntries(firstResult, sizeNo));
            float nrOfPages = (float) ProductthemeAttribute.countProductthemeAttributes() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("productthemeattributes", ProductthemeAttribute.findAllProductthemeAttributes());
        }
        return "productthemeattributes/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String ProductthemeAttributeController.update(@Valid ProductthemeAttribute productthemeAttribute, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, productthemeAttribute);
            return "productthemeattributes/update";
        }
        uiModel.asMap().clear();
        productthemeAttribute.merge();
        return "redirect:/productthemeattributes/" + encodeUrlPathSegment(conversionService.convert(productthemeAttribute.getId(), String.class), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String ProductthemeAttributeController.updateForm(@PathVariable("id") ProductthemeAttributePK id, Model uiModel) {
        populateEditForm(uiModel, ProductthemeAttribute.findProductthemeAttribute(id));
        return "productthemeattributes/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String ProductthemeAttributeController.delete(@PathVariable("id") ProductthemeAttributePK id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        ProductthemeAttribute productthemeAttribute = ProductthemeAttribute.findProductthemeAttribute(id);
        productthemeAttribute.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/productthemeattributes";
    }
    
    void ProductthemeAttributeController.populateEditForm(Model uiModel, ProductthemeAttribute productthemeAttribute) {
        uiModel.addAttribute("productthemeAttribute", productthemeAttribute);
        uiModel.addAttribute("attributes", Attribute.findAllAttributes());
        uiModel.addAttribute("productthemes", Producttheme.findAllProductthemes());
    }
    
    String ProductthemeAttributeController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
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
