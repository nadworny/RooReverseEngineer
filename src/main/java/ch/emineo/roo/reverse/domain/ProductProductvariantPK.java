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
public final class ProductProductvariantPK implements Serializable implements Serializable implements Serializable implements Serializable {

	@Column(name = "PRODUCT_PRODUCTID", nullable = false)
    private Integer productProductid;

	@Column(name = "IDX", nullable = false)
    private Integer idx;

	public ProductProductvariantPK(Integer productProductid, Integer idx) {
        super();
        this.productProductid = productProductid;
        this.idx = idx;
    }

	private ProductProductvariantPK() {
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

	public static ProductProductvariantPK fromJsonToProductProductvariantPK(String json) {
        return new JSONDeserializer<ProductProductvariantPK>().use(null, ProductProductvariantPK.class).deserialize(json);
    }

	public static String toJsonArray(Collection<ProductProductvariantPK> collection) {
        return new JSONSerializer().exclude("*.class").serialize(collection);
    }

	public static Collection<ProductProductvariantPK> fromJsonArrayToProductProductvariantPKs(String json) {
        return new JSONDeserializer<List<ProductProductvariantPK>>().use(null, ArrayList.class).use("values", ProductProductvariantPK.class).deserialize(json);
    }
}
