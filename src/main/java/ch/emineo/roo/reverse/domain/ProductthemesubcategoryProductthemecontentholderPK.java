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
public final class ProductthemesubcategoryProductthemecontentholderPK implements Serializable implements Serializable implements Serializable implements Serializable {

	public String toJson() {
        return new JSONSerializer().exclude("*.class").serialize(this);
    }

	public static ProductthemesubcategoryProductthemecontentholderPK fromJsonToProductthemesubcategoryProductthemecontentholderPK(String json) {
        return new JSONDeserializer<ProductthemesubcategoryProductthemecontentholderPK>().use(null, ProductthemesubcategoryProductthemecontentholderPK.class).deserialize(json);
    }

	public static String toJsonArray(Collection<ProductthemesubcategoryProductthemecontentholderPK> collection) {
        return new JSONSerializer().exclude("*.class").serialize(collection);
    }

	public static Collection<ProductthemesubcategoryProductthemecontentholderPK> fromJsonArrayToProductthemesubcategoryProductthemecontentholderPKs(String json) {
        return new JSONDeserializer<List<ProductthemesubcategoryProductthemecontentholderPK>>().use(null, ArrayList.class).use("values", ProductthemesubcategoryProductthemecontentholderPK.class).deserialize(json);
    }

	private static final long serialVersionUID = 1L;

	@Column(name = "PRODUCTTHEMESUBCATEGORY_PRODUCTTHEMESUBCATEGORYID", nullable = false)
    private Integer productthemesubcategoryProductthemesubcategoryid;

	@Column(name = "IDX", nullable = false)
    private Integer idx;

	public ProductthemesubcategoryProductthemecontentholderPK(Integer productthemesubcategoryProductthemesubcategoryid, Integer idx) {
        super();
        this.productthemesubcategoryProductthemesubcategoryid = productthemesubcategoryProductthemesubcategoryid;
        this.idx = idx;
    }

	private ProductthemesubcategoryProductthemecontentholderPK() {
        super();
    }

	public Integer getProductthemesubcategoryProductthemesubcategoryid() {
        return productthemesubcategoryProductthemesubcategoryid;
    }

	public Integer getIdx() {
        return idx;
    }
}
