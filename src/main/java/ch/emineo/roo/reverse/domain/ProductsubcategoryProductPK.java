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

@Configurable
@Embeddable
@RooIdentifier(dbManaged = true)
public final class ProductsubcategoryProductPK implements Serializable implements Serializable implements Serializable implements Serializable {

	public String toJson() {
        return new JSONSerializer().exclude("*.class").serialize(this);
    }

	public static ProductsubcategoryProductPK fromJsonToProductsubcategoryProductPK(String json) {
        return new JSONDeserializer<ProductsubcategoryProductPK>().use(null, ProductsubcategoryProductPK.class).deserialize(json);
    }

	public static String toJsonArray(Collection<ProductsubcategoryProductPK> collection) {
        return new JSONSerializer().exclude("*.class").serialize(collection);
    }

	public static Collection<ProductsubcategoryProductPK> fromJsonArrayToProductsubcategoryProductPKs(String json) {
        return new JSONDeserializer<List<ProductsubcategoryProductPK>>().use(null, ArrayList.class).use("values", ProductsubcategoryProductPK.class).deserialize(json);
    }

	private static final long serialVersionUID = 1L;

	@Column(name = "PRODUCTSUBCATEGORY_PRODUCTSUBCATEGORYID", nullable = false)
    private Integer productsubcategoryProductsubcategoryid;

	@Column(name = "IDX", nullable = false)
    private Integer idx;

	public ProductsubcategoryProductPK(Integer productsubcategoryProductsubcategoryid, Integer idx) {
        super();
        this.productsubcategoryProductsubcategoryid = productsubcategoryProductsubcategoryid;
        this.idx = idx;
    }

	private ProductsubcategoryProductPK() {
        super();
    }

	public Integer getProductsubcategoryProductsubcategoryid() {
        return productsubcategoryProductsubcategoryid;
    }

	public Integer getIdx() {
        return idx;
    }
}
