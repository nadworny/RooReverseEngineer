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
public final class ProductcategoryProductsubcategoryPK implements Serializable implements Serializable implements Serializable implements Serializable {

	public String toJson() {
        return new JSONSerializer().exclude("*.class").serialize(this);
    }

	public static ProductcategoryProductsubcategoryPK fromJsonToProductcategoryProductsubcategoryPK(String json) {
        return new JSONDeserializer<ProductcategoryProductsubcategoryPK>().use(null, ProductcategoryProductsubcategoryPK.class).deserialize(json);
    }

	public static String toJsonArray(Collection<ProductcategoryProductsubcategoryPK> collection) {
        return new JSONSerializer().exclude("*.class").serialize(collection);
    }

	public static Collection<ProductcategoryProductsubcategoryPK> fromJsonArrayToProductcategoryProductsubcategoryPKs(String json) {
        return new JSONDeserializer<List<ProductcategoryProductsubcategoryPK>>().use(null, ArrayList.class).use("values", ProductcategoryProductsubcategoryPK.class).deserialize(json);
    }

	@Column(name = "PRODUCTCATEGORY_PRODUCTCATEGORYID", nullable = false)
    private Integer productcategoryProductcategoryid;

	@Column(name = "IDX", nullable = false)
    private Integer idx;

	public ProductcategoryProductsubcategoryPK(Integer productcategoryProductcategoryid, Integer idx) {
        super();
        this.productcategoryProductcategoryid = productcategoryProductcategoryid;
        this.idx = idx;
    }

	private ProductcategoryProductsubcategoryPK() {
        super();
    }

	public Integer getProductcategoryProductcategoryid() {
        return productcategoryProductcategoryid;
    }

	public Integer getIdx() {
        return idx;
    }

	private static final long serialVersionUID = 1L;
}
