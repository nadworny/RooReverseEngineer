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
public final class ProductthemeAttributePK implements Serializable implements Serializable implements Serializable implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "PRODUCTTHEME_PRODUCTTHEMEID", nullable = false)
    private Integer productthemeProductthemeid;

	@Column(name = "IDX", nullable = false)
    private Integer idx;

	public ProductthemeAttributePK(Integer productthemeProductthemeid, Integer idx) {
        super();
        this.productthemeProductthemeid = productthemeProductthemeid;
        this.idx = idx;
    }

	private ProductthemeAttributePK() {
        super();
    }

	public Integer getProductthemeProductthemeid() {
        return productthemeProductthemeid;
    }

	public Integer getIdx() {
        return idx;
    }

	public String toJson() {
        return new JSONSerializer().exclude("*.class").serialize(this);
    }

	public static ProductthemeAttributePK fromJsonToProductthemeAttributePK(String json) {
        return new JSONDeserializer<ProductthemeAttributePK>().use(null, ProductthemeAttributePK.class).deserialize(json);
    }

	public static String toJsonArray(Collection<ProductthemeAttributePK> collection) {
        return new JSONSerializer().exclude("*.class").serialize(collection);
    }

	public static Collection<ProductthemeAttributePK> fromJsonArrayToProductthemeAttributePKs(String json) {
        return new JSONDeserializer<List<ProductthemeAttributePK>>().use(null, ArrayList.class).use("values", ProductthemeAttributePK.class).deserialize(json);
    }
}
