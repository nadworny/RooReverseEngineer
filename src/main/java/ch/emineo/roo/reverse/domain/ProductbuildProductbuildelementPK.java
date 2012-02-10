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
public final class ProductbuildProductbuildelementPK implements Serializable implements Serializable implements Serializable implements Serializable {

	private static final long serialVersionUID = 1L;

	public String toJson() {
        return new JSONSerializer().exclude("*.class").serialize(this);
    }

	public static ProductbuildProductbuildelementPK fromJsonToProductbuildProductbuildelementPK(String json) {
        return new JSONDeserializer<ProductbuildProductbuildelementPK>().use(null, ProductbuildProductbuildelementPK.class).deserialize(json);
    }

	public static String toJsonArray(Collection<ProductbuildProductbuildelementPK> collection) {
        return new JSONSerializer().exclude("*.class").serialize(collection);
    }

	public static Collection<ProductbuildProductbuildelementPK> fromJsonArrayToProductbuildProductbuildelementPKs(String json) {
        return new JSONDeserializer<List<ProductbuildProductbuildelementPK>>().use(null, ArrayList.class).use("values", ProductbuildProductbuildelementPK.class).deserialize(json);
    }

	@Column(name = "PRODUCTBUILD_PRODUCTBUILDID", nullable = false)
    private Integer productbuildProductbuildid;

	@Column(name = "IDX", nullable = false)
    private Integer idx;

	public ProductbuildProductbuildelementPK(Integer productbuildProductbuildid, Integer idx) {
        super();
        this.productbuildProductbuildid = productbuildProductbuildid;
        this.idx = idx;
    }

	private ProductbuildProductbuildelementPK() {
        super();
    }

	public Integer getProductbuildProductbuildid() {
        return productbuildProductbuildid;
    }

	public Integer getIdx() {
        return idx;
    }
}
