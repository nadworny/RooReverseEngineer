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
public final class ProductbuildAttributePK implements Serializable implements Serializable implements Serializable implements Serializable {

	private static final long serialVersionUID = 1L;

	public String toJson() {
        return new JSONSerializer().exclude("*.class").serialize(this);
    }

	public static ProductbuildAttributePK fromJsonToProductbuildAttributePK(String json) {
        return new JSONDeserializer<ProductbuildAttributePK>().use(null, ProductbuildAttributePK.class).deserialize(json);
    }

	public static String toJsonArray(Collection<ProductbuildAttributePK> collection) {
        return new JSONSerializer().exclude("*.class").serialize(collection);
    }

	public static Collection<ProductbuildAttributePK> fromJsonArrayToProductbuildAttributePKs(String json) {
        return new JSONDeserializer<List<ProductbuildAttributePK>>().use(null, ArrayList.class).use("values", ProductbuildAttributePK.class).deserialize(json);
    }

	@Column(name = "PRODUCTBUILD_PRODUCTBUILDID", nullable = false)
    private Integer productbuildProductbuildid;

	@Column(name = "IDX", nullable = false)
    private Integer idx;

	public ProductbuildAttributePK(Integer productbuildProductbuildid, Integer idx) {
        super();
        this.productbuildProductbuildid = productbuildProductbuildid;
        this.idx = idx;
    }

	private ProductbuildAttributePK() {
        super();
    }

	public Integer getProductbuildProductbuildid() {
        return productbuildProductbuildid;
    }

	public Integer getIdx() {
        return idx;
    }
}
