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
public final class ProductAttributePK implements Serializable implements Serializable implements Serializable implements Serializable {

	@Column(name = "PRODUCT_PRODUCTID", nullable = false)
    private Integer productProductid;

	@Column(name = "IDX", nullable = false)
    private Integer idx;

	public ProductAttributePK(Integer productProductid, Integer idx) {
        super();
        this.productProductid = productProductid;
        this.idx = idx;
    }

	private ProductAttributePK() {
        super();
    }

	public Integer getProductProductid() {
        return productProductid;
    }

	public Integer getIdx() {
        return idx;
    }

	private static final long serialVersionUID = 1L;

	public String toJson() {
        return new JSONSerializer().exclude("*.class").serialize(this);
    }

	public static ProductAttributePK fromJsonToProductAttributePK(String json) {
        return new JSONDeserializer<ProductAttributePK>().use(null, ProductAttributePK.class).deserialize(json);
    }

	public static String toJsonArray(Collection<ProductAttributePK> collection) {
        return new JSONSerializer().exclude("*.class").serialize(collection);
    }

	public static Collection<ProductAttributePK> fromJsonArrayToProductAttributePKs(String json) {
        return new JSONDeserializer<List<ProductAttributePK>>().use(null, ArrayList.class).use("values", ProductAttributePK.class).deserialize(json);
    }
}
