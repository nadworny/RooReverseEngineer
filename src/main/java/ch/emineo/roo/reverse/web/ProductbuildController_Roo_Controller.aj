// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.web;

import ch.emineo.roo.reverse.domain.Product;
import ch.emineo.roo.reverse.domain.Productbuild;
import ch.emineo.roo.reverse.domain.ProductbuildAttribute;
import ch.emineo.roo.reverse.domain.ProductbuildProductbuildelement;
import ch.emineo.roo.reverse.domain.Productthemecontentholder;
import ch.emineo.roo.reverse.web.ProductbuildController;
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

privileged aspect ProductbuildController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String ProductbuildController.create(@Valid Productbuild productbuild, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, productbuild);
            return "productbuilds/create";
        }
        uiModel.asMap().clear();
        productbuild.persist();
        return "redirect:/productbuilds/" + encodeUrlPathSegment(productbuild.getProductbuildid().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String ProductbuildController.createForm(Model uiModel) {
        populateEditForm(uiModel, new Productbuild());
        return "productbuilds/create";
    }
    
    @RequestMapping(value = "/{id}", produces = "text/html")
    public String ProductbuildController.show(@PathVariable("id") Integer id, Model uiModel) {
        uiModel.addAttribute("productbuild", Productbuild.findProductbuild(id));
        uiModel.addAttribute("itemId", id);
        return "productbuilds/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String ProductbuildController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("productbuilds", Productbuild.findProductbuildEntries(firstResult, sizeNo));
            float nrOfPages = (float) Productbuild.countProductbuilds() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("productbuilds", Productbuild.findAllProductbuilds());
        }
        return "productbuilds/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String ProductbuildController.update(@Valid Productbuild productbuild, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, productbuild);
            return "productbuilds/update";
        }
        uiModel.asMap().clear();
        productbuild.merge();
        return "redirect:/productbuilds/" + encodeUrlPathSegment(productbuild.getProductbuildid().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String ProductbuildController.updateForm(@PathVariable("id") Integer id, Model uiModel) {
        populateEditForm(uiModel, Productbuild.findProductbuild(id));
        return "productbuilds/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String ProductbuildController.delete(@PathVariable("id") Integer id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Productbuild productbuild = Productbuild.findProductbuild(id);
        productbuild.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/productbuilds";
    }
    
    void ProductbuildController.populateEditForm(Model uiModel, Productbuild productbuild) {
        uiModel.addAttribute("productbuild", productbuild);
        uiModel.addAttribute("products", Product.findAllProducts());
        uiModel.addAttribute("productbuildattributes", ProductbuildAttribute.findAllProductbuildAttributes());
        uiModel.addAttribute("productbuildproductbuildelements", ProductbuildProductbuildelement.findAllProductbuildProductbuildelements());
        uiModel.addAttribute("productthemecontentholders", Productthemecontentholder.findAllProductthemecontentholders());
    }
    
    String ProductbuildController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
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
