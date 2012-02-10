// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.web;

import ch.emineo.roo.reverse.domain.Attribute;
import ch.emineo.roo.reverse.domain.Productthemesubcategory;
import ch.emineo.roo.reverse.domain.ProductthemesubcategoryAttribute;
import ch.emineo.roo.reverse.domain.ProductthemesubcategoryAttributePK;
import ch.emineo.roo.reverse.web.ProductthemesubcategoryAttributeController;
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

privileged aspect ProductthemesubcategoryAttributeController_Roo_Controller {
    
    private ConversionService ProductthemesubcategoryAttributeController.conversionService;
    
    @Autowired
    public ProductthemesubcategoryAttributeController.new(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String ProductthemesubcategoryAttributeController.create(@Valid ProductthemesubcategoryAttribute productthemesubcategoryAttribute, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, productthemesubcategoryAttribute);
            return "productthemesubcategoryattributes/create";
        }
        uiModel.asMap().clear();
        productthemesubcategoryAttribute.persist();
        return "redirect:/productthemesubcategoryattributes/" + encodeUrlPathSegment(conversionService.convert(productthemesubcategoryAttribute.getId(), String.class), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String ProductthemesubcategoryAttributeController.createForm(Model uiModel) {
        populateEditForm(uiModel, new ProductthemesubcategoryAttribute());
        return "productthemesubcategoryattributes/create";
    }
    
    @RequestMapping(value = "/{id}", produces = "text/html")
    public String ProductthemesubcategoryAttributeController.show(@PathVariable("id") ProductthemesubcategoryAttributePK id, Model uiModel) {
        uiModel.addAttribute("productthemesubcategoryattribute", ProductthemesubcategoryAttribute.findProductthemesubcategoryAttribute(id));
        uiModel.addAttribute("itemId", conversionService.convert(id, String.class));
        return "productthemesubcategoryattributes/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String ProductthemesubcategoryAttributeController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("productthemesubcategoryattributes", ProductthemesubcategoryAttribute.findProductthemesubcategoryAttributeEntries(firstResult, sizeNo));
            float nrOfPages = (float) ProductthemesubcategoryAttribute.countProductthemesubcategoryAttributes() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("productthemesubcategoryattributes", ProductthemesubcategoryAttribute.findAllProductthemesubcategoryAttributes());
        }
        return "productthemesubcategoryattributes/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String ProductthemesubcategoryAttributeController.update(@Valid ProductthemesubcategoryAttribute productthemesubcategoryAttribute, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, productthemesubcategoryAttribute);
            return "productthemesubcategoryattributes/update";
        }
        uiModel.asMap().clear();
        productthemesubcategoryAttribute.merge();
        return "redirect:/productthemesubcategoryattributes/" + encodeUrlPathSegment(conversionService.convert(productthemesubcategoryAttribute.getId(), String.class), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String ProductthemesubcategoryAttributeController.updateForm(@PathVariable("id") ProductthemesubcategoryAttributePK id, Model uiModel) {
        populateEditForm(uiModel, ProductthemesubcategoryAttribute.findProductthemesubcategoryAttribute(id));
        return "productthemesubcategoryattributes/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String ProductthemesubcategoryAttributeController.delete(@PathVariable("id") ProductthemesubcategoryAttributePK id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        ProductthemesubcategoryAttribute productthemesubcategoryAttribute = ProductthemesubcategoryAttribute.findProductthemesubcategoryAttribute(id);
        productthemesubcategoryAttribute.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/productthemesubcategoryattributes";
    }
    
    void ProductthemesubcategoryAttributeController.populateEditForm(Model uiModel, ProductthemesubcategoryAttribute productthemesubcategoryAttribute) {
        uiModel.addAttribute("productthemesubcategoryAttribute", productthemesubcategoryAttribute);
        uiModel.addAttribute("attributes", Attribute.findAllAttributes());
        uiModel.addAttribute("productthemesubcategorys", Productthemesubcategory.findAllProductthemesubcategorys());
    }
    
    String ProductthemesubcategoryAttributeController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
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
