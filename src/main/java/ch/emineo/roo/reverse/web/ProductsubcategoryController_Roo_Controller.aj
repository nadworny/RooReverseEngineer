// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.web;

import ch.emineo.roo.reverse.domain.ProductcategoryProductsubcategory;
import ch.emineo.roo.reverse.domain.Productsubcategory;
import ch.emineo.roo.reverse.domain.ProductsubcategoryAttribute;
import ch.emineo.roo.reverse.domain.ProductsubcategoryProduct;
import ch.emineo.roo.reverse.web.ProductsubcategoryController;
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

privileged aspect ProductsubcategoryController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String ProductsubcategoryController.create(@Valid Productsubcategory productsubcategory, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, productsubcategory);
            return "productsubcategorys/create";
        }
        uiModel.asMap().clear();
        productsubcategory.persist();
        return "redirect:/productsubcategorys/" + encodeUrlPathSegment(productsubcategory.getProductsubcategoryid().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String ProductsubcategoryController.createForm(Model uiModel) {
        populateEditForm(uiModel, new Productsubcategory());
        return "productsubcategorys/create";
    }
    
    @RequestMapping(value = "/{id}", produces = "text/html")
    public String ProductsubcategoryController.show(@PathVariable("id") Integer id, Model uiModel) {
        uiModel.addAttribute("productsubcategory", Productsubcategory.findProductsubcategory(id));
        uiModel.addAttribute("itemId", id);
        return "productsubcategorys/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String ProductsubcategoryController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("productsubcategorys", Productsubcategory.findProductsubcategoryEntries(firstResult, sizeNo));
            float nrOfPages = (float) Productsubcategory.countProductsubcategorys() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("productsubcategorys", Productsubcategory.findAllProductsubcategorys());
        }
        return "productsubcategorys/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String ProductsubcategoryController.update(@Valid Productsubcategory productsubcategory, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, productsubcategory);
            return "productsubcategorys/update";
        }
        uiModel.asMap().clear();
        productsubcategory.merge();
        return "redirect:/productsubcategorys/" + encodeUrlPathSegment(productsubcategory.getProductsubcategoryid().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String ProductsubcategoryController.updateForm(@PathVariable("id") Integer id, Model uiModel) {
        populateEditForm(uiModel, Productsubcategory.findProductsubcategory(id));
        return "productsubcategorys/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String ProductsubcategoryController.delete(@PathVariable("id") Integer id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Productsubcategory productsubcategory = Productsubcategory.findProductsubcategory(id);
        productsubcategory.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/productsubcategorys";
    }
    
    void ProductsubcategoryController.populateEditForm(Model uiModel, Productsubcategory productsubcategory) {
        uiModel.addAttribute("productsubcategory", productsubcategory);
        uiModel.addAttribute("productcategoryproductsubcategorys", ProductcategoryProductsubcategory.findAllProductcategoryProductsubcategorys());
        uiModel.addAttribute("productsubcategoryattributes", ProductsubcategoryAttribute.findAllProductsubcategoryAttributes());
        uiModel.addAttribute("productsubcategoryproducts", ProductsubcategoryProduct.findAllProductsubcategoryProducts());
    }
    
    String ProductsubcategoryController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
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
