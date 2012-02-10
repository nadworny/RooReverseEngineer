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
public final class ProductbuildelementAttributePK implements Serializable implements Serializable implements Serializable implements Serializable {

	@Column(name = "PRODUCTBUILDELEMENT_PRODUCTBUILDELEMENTID", nullable = false)
    private Integer productbuildelementProductbuildelementid;

	@Column(name = "IDX", nullable = false)
    private Integer idx;

	public ProductbuildelementAttributePK(Integer productbuildelementProductbuildelementid, Integer idx) {
        super();
        this.productbuildelementProductbuildelementid = productbuildelementProductbuildelementid;
        this.idx = idx;
    }

	private ProductbuildelementAttributePK() {
        super();
    }

	public Integer getProductbuildelementProductbuildelementid() {
        return productbuildelementProductbuildelementid;
    }

	public Integer getIdx() {
        return idx;
    }

	private static final long serialVersionUID = 1L;

	public String toJson() {
        return new JSONSerializer().exclude("*.class").serialize(this);
    }

	public static ProductbuildelementAttributePK fromJsonToProductbuildelementAttributePK(String json) {
        return new JSONDeserializer<ProductbuildelementAttributePK>().use(null, ProductbuildelementAttributePK.class).deserialize(json);
    }

	public static String toJsonArray(Collection<ProductbuildelementAttributePK> collection) {
        return new JSONSerializer().exclude("*.class").serialize(collection);
    }

	public static Collection<ProductbuildelementAttributePK> fromJsonArrayToProductbuildelementAttributePKs(String json) {
        return new JSONDeserializer<List<ProductbuildelementAttributePK>>().use(null, ArrayList.class).use("values", ProductbuildelementAttributePK.class).deserialize(json);
    }
}
