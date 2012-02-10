// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.web;

import ch.emineo.roo.reverse.domain.Producttheme;
import ch.emineo.roo.reverse.domain.Productthemesapinfo;
import ch.emineo.roo.reverse.web.ProductthemesapinfoController;
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

privileged aspect ProductthemesapinfoController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String ProductthemesapinfoController.create(@Valid Productthemesapinfo productthemesapinfo, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, productthemesapinfo);
            return "productthemesapinfoes/create";
        }
        uiModel.asMap().clear();
        productthemesapinfo.persist();
        return "redirect:/productthemesapinfoes/" + encodeUrlPathSegment(productthemesapinfo.getProductthemesapinfoid().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String ProductthemesapinfoController.createForm(Model uiModel) {
        populateEditForm(uiModel, new Productthemesapinfo());
        return "productthemesapinfoes/create";
    }
    
    @RequestMapping(value = "/{id}", produces = "text/html")
    public String ProductthemesapinfoController.show(@PathVariable("id") Integer id, Model uiModel) {
        uiModel.addAttribute("productthemesapinfo", Productthemesapinfo.findProductthemesapinfo(id));
        uiModel.addAttribute("itemId", id);
        return "productthemesapinfoes/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String ProductthemesapinfoController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("productthemesapinfoes", Productthemesapinfo.findProductthemesapinfoEntries(firstResult, sizeNo));
            float nrOfPages = (float) Productthemesapinfo.countProductthemesapinfoes() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("productthemesapinfoes", Productthemesapinfo.findAllProductthemesapinfoes());
        }
        return "productthemesapinfoes/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String ProductthemesapinfoController.update(@Valid Productthemesapinfo productthemesapinfo, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, productthemesapinfo);
            return "productthemesapinfoes/update";
        }
        uiModel.asMap().clear();
        productthemesapinfo.merge();
        return "redirect:/productthemesapinfoes/" + encodeUrlPathSegment(productthemesapinfo.getProductthemesapinfoid().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String ProductthemesapinfoController.updateForm(@PathVariable("id") Integer id, Model uiModel) {
        populateEditForm(uiModel, Productthemesapinfo.findProductthemesapinfo(id));
        return "productthemesapinfoes/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String ProductthemesapinfoController.delete(@PathVariable("id") Integer id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Productthemesapinfo productthemesapinfo = Productthemesapinfo.findProductthemesapinfo(id);
        productthemesapinfo.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/productthemesapinfoes";
    }
    
    void ProductthemesapinfoController.populateEditForm(Model uiModel, Productthemesapinfo productthemesapinfo) {
        uiModel.addAttribute("productthemesapinfo", productthemesapinfo);
        uiModel.addAttribute("productthemes", Producttheme.findAllProductthemes());
    }
    
    String ProductthemesapinfoController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
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