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
public final class ProductthemeProductvariantPK implements Serializable implements Serializable implements Serializable implements Serializable {

	public String toJson() {
        return new JSONSerializer().exclude("*.class").serialize(this);
    }

	public static ProductthemeProductvariantPK fromJsonToProductthemeProductvariantPK(String json) {
        return new JSONDeserializer<ProductthemeProductvariantPK>().use(null, ProductthemeProductvariantPK.class).deserialize(json);
    }

	public static String toJsonArray(Collection<ProductthemeProductvariantPK> collection) {
        return new JSONSerializer().exclude("*.class").serialize(collection);
    }

	public static Collection<ProductthemeProductvariantPK> fromJsonArrayToProductthemeProductvariantPKs(String json) {
        return new JSONDeserializer<List<ProductthemeProductvariantPK>>().use(null, ArrayList.class).use("values", ProductthemeProductvariantPK.class).deserialize(json);
    }

	@Column(name = "PRODUCTTHEME_PRODUCTTHEMEID", nullable = false)
    private Integer productthemeProductthemeid;

	@Column(name = "IDX", nullable = false)
    private Integer idx;

	public ProductthemeProductvariantPK(Integer productthemeProductthemeid, Integer idx) {
        super();
        this.productthemeProductthemeid = productthemeProductthemeid;
        this.idx = idx;
    }

	private ProductthemeProductvariantPK() {
        super();
    }

	public Integer getProductthemeProductthemeid() {
        return productthemeProductthemeid;
    }

	public Integer getIdx() {
        return idx;
    }

	private static final long serialVersionUID = 1L;
}
