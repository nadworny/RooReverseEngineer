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
public final class ProductthemecategoryAttributePK implements Serializable implements Serializable implements Serializable implements Serializable {

	@Column(name = "PRODUCTTHEMECATEGORY_PRODUCTTHEMECATEGORYID", nullable = false)
    private Integer productthemecategoryProductthemecategoryid;

	@Column(name = "IDX", nullable = false)
    private Integer idx;

	public ProductthemecategoryAttributePK(Integer productthemecategoryProductthemecategoryid, Integer idx) {
        super();
        this.productthemecategoryProductthemecategoryid = productthemecategoryProductthemecategoryid;
        this.idx = idx;
    }

	private ProductthemecategoryAttributePK() {
        super();
    }

	public Integer getProductthemecategoryProductthemecategoryid() {
        return productthemecategoryProductthemecategoryid;
    }

	public Integer getIdx() {
        return idx;
    }

	private static final long serialVersionUID = 1L;

	public String toJson() {
        return new JSONSerializer().exclude("*.class").serialize(this);
    }

	public static ProductthemecategoryAttributePK fromJsonToProductthemecategoryAttributePK(String json) {
        return new JSONDeserializer<ProductthemecategoryAttributePK>().use(null, ProductthemecategoryAttributePK.class).deserialize(json);
    }

	public static String toJsonArray(Collection<ProductthemecategoryAttributePK> collection) {
        return new JSONSerializer().exclude("*.class").serialize(collection);
    }

	public static Collection<ProductthemecategoryAttributePK> fromJsonArrayToProductthemecategoryAttributePKs(String json) {
        return new JSONDeserializer<List<ProductthemecategoryAttributePK>>().use(null, ArrayList.class).use("values", ProductthemecategoryAttributePK.class).deserialize(json);
    }
}
