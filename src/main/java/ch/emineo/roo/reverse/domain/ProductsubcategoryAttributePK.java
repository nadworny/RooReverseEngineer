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
public final class ProductsubcategoryAttributePK implements Serializable implements Serializable implements Serializable implements Serializable {

	public String toJson() {
        return new JSONSerializer().exclude("*.class").serialize(this);
    }

	public static ProductsubcategoryAttributePK fromJsonToProductsubcategoryAttributePK(String json) {
        return new JSONDeserializer<ProductsubcategoryAttributePK>().use(null, ProductsubcategoryAttributePK.class).deserialize(json);
    }

	public static String toJsonArray(Collection<ProductsubcategoryAttributePK> collection) {
        return new JSONSerializer().exclude("*.class").serialize(collection);
    }

	public static Collection<ProductsubcategoryAttributePK> fromJsonArrayToProductsubcategoryAttributePKs(String json) {
        return new JSONDeserializer<List<ProductsubcategoryAttributePK>>().use(null, ArrayList.class).use("values", ProductsubcategoryAttributePK.class).deserialize(json);
    }

	@Column(name = "PRODUCTSUBCATEGORY_PRODUCTSUBCATEGORYID", nullable = false)
    private Integer productsubcategoryProductsubcategoryid;

	@Column(name = "IDX", nullable = false)
    private Integer idx;

	public ProductsubcategoryAttributePK(Integer productsubcategoryProductsubcategoryid, Integer idx) {
        super();
        this.productsubcategoryProductsubcategoryid = productsubcategoryProductsubcategoryid;
        this.idx = idx;
    }

	private ProductsubcategoryAttributePK() {
        super();
    }

	public Integer getProductsubcategoryProductsubcategoryid() {
        return productsubcategoryProductsubcategoryid;
    }

	public Integer getIdx() {
        return idx;
    }

	private static final long serialVersionUID = 1L;
}
