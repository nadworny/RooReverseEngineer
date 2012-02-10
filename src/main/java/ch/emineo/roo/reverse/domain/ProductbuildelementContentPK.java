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
public final class ProductbuildelementContentPK implements Serializable implements Serializable implements Serializable implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "PRODUCTBUILDELEMENT_PRODUCTBUILDELEMENTID", nullable = false)
    private Integer productbuildelementProductbuildelementid;

	@Column(name = "IDX", nullable = false)
    private Integer idx;

	public ProductbuildelementContentPK(Integer productbuildelementProductbuildelementid, Integer idx) {
        super();
        this.productbuildelementProductbuildelementid = productbuildelementProductbuildelementid;
        this.idx = idx;
    }

	private ProductbuildelementContentPK() {
        super();
    }

	public Integer getProductbuildelementProductbuildelementid() {
        return productbuildelementProductbuildelementid;
    }

	public Integer getIdx() {
        return idx;
    }

	public String toJson() {
        return new JSONSerializer().exclude("*.class").serialize(this);
    }

	public static ProductbuildelementContentPK fromJsonToProductbuildelementContentPK(String json) {
        return new JSONDeserializer<ProductbuildelementContentPK>().use(null, ProductbuildelementContentPK.class).deserialize(json);
    }

	public static String toJsonArray(Collection<ProductbuildelementContentPK> collection) {
        return new JSONSerializer().exclude("*.class").serialize(collection);
    }

	public static Collection<ProductbuildelementContentPK> fromJsonArrayToProductbuildelementContentPKs(String json) {
        return new JSONDeserializer<List<ProductbuildelementContentPK>>().use(null, ArrayList.class).use("values", ProductbuildelementContentPK.class).deserialize(json);
    }
}
