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
public final class ProductcategoryAttributePK implements Serializable implements Serializable implements Serializable implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "PRODUCTCATEGORY_PRODUCTCATEGORYID", nullable = false)
    private Integer productcategoryProductcategoryid;

	@Column(name = "IDX", nullable = false)
    private Integer idx;

	public ProductcategoryAttributePK(Integer productcategoryProductcategoryid, Integer idx) {
        super();
        this.productcategoryProductcategoryid = productcategoryProductcategoryid;
        this.idx = idx;
    }

	private ProductcategoryAttributePK() {
        super();
    }

	public Integer getProductcategoryProductcategoryid() {
        return productcategoryProductcategoryid;
    }

	public Integer getIdx() {
        return idx;
    }

	public String toJson() {
        return new JSONSerializer().exclude("*.class").serialize(this);
    }

	public static ProductcategoryAttributePK fromJsonToProductcategoryAttributePK(String json) {
        return new JSONDeserializer<ProductcategoryAttributePK>().use(null, ProductcategoryAttributePK.class).deserialize(json);
    }

	public static String toJsonArray(Collection<ProductcategoryAttributePK> collection) {
        return new JSONSerializer().exclude("*.class").serialize(collection);
    }

	public static Collection<ProductcategoryAttributePK> fromJsonArrayToProductcategoryAttributePKs(String json) {
        return new JSONDeserializer<List<ProductcategoryAttributePK>>().use(null, ArrayList.class).use("values", ProductcategoryAttributePK.class).deserialize(json);
    }
}
