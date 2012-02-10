package ch.emineo.roo.reverse.domain;

import org.springframework.roo.addon.dbre.RooDbManaged;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(identifierType = ProductthemeAttributePK.class, versionField = "", table = "producttheme_attribute")
@RooDbManaged(automaticallyDelete = true)
public class ProductthemeAttribute {
}