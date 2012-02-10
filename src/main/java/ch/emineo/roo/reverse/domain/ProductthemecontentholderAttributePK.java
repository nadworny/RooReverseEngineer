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
public final class ProductthemecontentholderAttributePK implements Serializable implements Serializable implements Serializable implements Serializable {

	public String toJson() {
        return new JSONSerializer().exclude("*.class").serialize(this);
    }

	public static ProductthemecontentholderAttributePK fromJsonToProductthemecontentholderAttributePK(String json) {
        return new JSONDeserializer<ProductthemecontentholderAttributePK>().use(null, ProductthemecontentholderAttributePK.class).deserialize(json);
    }

	public static String toJsonArray(Collection<ProductthemecontentholderAttributePK> collection) {
        return new JSONSerializer().exclude("*.class").serialize(collection);
    }

	public static Collection<ProductthemecontentholderAttributePK> fromJsonArrayToProductthemecontentholderAttributePKs(String json) {
        return new JSONDeserializer<List<ProductthemecontentholderAttributePK>>().use(null, ArrayList.class).use("values", ProductthemecontentholderAttributePK.class).deserialize(json);
    }

	@Column(name = "PRODUCTTHEMECONTENTHOLDER_PRODUCTTHEMECONTENTHOLDERID", nullable = false)
    private Integer productthemecontentholderProductthemecontentholderid;

	@Column(name = "IDX", nullable = false)
    private Integer idx;

	public ProductthemecontentholderAttributePK(Integer productthemecontentholderProductthemecontentholderid, Integer idx) {
        super();
        this.productthemecontentholderProductthemecontentholderid = productthemecontentholderProductthemecontentholderid;
        this.idx = idx;
    }

	private ProductthemecontentholderAttributePK() {
        super();
    }

	public Integer getProductthemecontentholderProductthemecontentholderid() {
        return productthemecontentholderProductthemecontentholderid;
    }

	public Integer getIdx() {
        return idx;
    }

	private static final long serialVersionUID = 1L;
}
