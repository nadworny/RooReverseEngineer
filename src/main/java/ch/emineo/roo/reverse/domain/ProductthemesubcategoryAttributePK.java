package ch.emineo.roo.reverse.domain;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.roo.addon.jpa.identifier.RooIdentifier;

@Embeddable
@Configurable
@RooIdentifier(dbManaged = true)
public final class ProductthemesubcategoryAttributePK implements Serializable implements Serializable implements Serializable implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "PRODUCTTHEMESUBCATEGORY_PRODUCTTHEMESUBCATEGORYID", nullable = false)
    private Integer productthemesubcategoryProductthemesubcategoryid;

	@Column(name = "IDX", nullable = false)
    private Integer idx;

	public ProductthemesubcategoryAttributePK(Integer productthemesubcategoryProductthemesubcategoryid, Integer idx) {
        super();
        this.productthemesubcategoryProductthemesubcategoryid = productthemesubcategoryProductthemesubcategoryid;
        this.idx = idx;
    }

	private ProductthemesubcategoryAttributePK() {
        super();
    }

	public Integer getProductthemesubcategoryProductthemesubcategoryid() {
        return productthemesubcategoryProductthemesubcategoryid;
    }

	public Integer getIdx() {
        return idx;
    }

	public String toJson() {
        return new JSONSerializer().exclude("*.class").serialize(this);
    }

	public static ProductthemesubcategoryAttributePK fromJsonToProductthemesubcategoryAttributePK(String json) {
        return new JSONDeserializer<ProductthemesubcategoryAttributePK>().use(null, ProductthemesubcategoryAttributePK.class).deserialize(json);
    }

	public static String toJsonArray(Collection<ProductthemesubcategoryAttributePK> collection) {
        return new JSONSerializer().exclude("*.class").serialize(collection);
    }

	public static Collection<ProductthemesubcategoryAttributePK> fromJsonArrayToProductthemesubcategoryAttributePKs(String json) {
        return new JSONDeserializer<List<ProductthemesubcategoryAttributePK>>().use(null, ArrayList.class).use("values", ProductthemesubcategoryAttributePK.class).deserialize(json);
    }
}
