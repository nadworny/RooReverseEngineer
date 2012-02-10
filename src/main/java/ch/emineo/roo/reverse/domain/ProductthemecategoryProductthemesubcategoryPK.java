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
public final class ProductthemecategoryProductthemesubcategoryPK implements Serializable implements Serializable implements Serializable implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "PRODUCTTHEMECATEGORY_PRODUCTTHEMECATEGORYID", nullable = false)
    private Integer productthemecategoryProductthemecategoryid;

	@Column(name = "IDX", nullable = false)
    private Integer idx;

	public ProductthemecategoryProductthemesubcategoryPK(Integer productthemecategoryProductthemecategoryid, Integer idx) {
        super();
        this.productthemecategoryProductthemecategoryid = productthemecategoryProductthemecategoryid;
        this.idx = idx;
    }

	private ProductthemecategoryProductthemesubcategoryPK() {
        super();
    }

	public Integer getProductthemecategoryProductthemecategoryid() {
        return productthemecategoryProductthemecategoryid;
    }

	public Integer getIdx() {
        return idx;
    }

	public String toJson() {
        return new JSONSerializer().exclude("*.class").serialize(this);
    }

	public static ProductthemecategoryProductthemesubcategoryPK fromJsonToProductthemecategoryProductthemesubcategoryPK(String json) {
        return new JSONDeserializer<ProductthemecategoryProductthemesubcategoryPK>().use(null, ProductthemecategoryProductthemesubcategoryPK.class).deserialize(json);
    }

	public static String toJsonArray(Collection<ProductthemecategoryProductthemesubcategoryPK> collection) {
        return new JSONSerializer().exclude("*.class").serialize(collection);
    }

	public static Collection<ProductthemecategoryProductthemesubcategoryPK> fromJsonArrayToProductthemecategoryProductthemesubcategoryPKs(String json) {
        return new JSONDeserializer<List<ProductthemecategoryProductthemesubcategoryPK>>().use(null, ArrayList.class).use("values", ProductthemecategoryProductthemesubcategoryPK.class).deserialize(json);
    }
}
