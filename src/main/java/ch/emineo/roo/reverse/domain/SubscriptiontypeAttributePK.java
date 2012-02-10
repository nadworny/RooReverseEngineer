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
public final class SubscriptiontypeAttributePK implements Serializable implements Serializable implements Serializable implements Serializable {

	@Column(name = "SUBSCRIPTIONTYPE_MONTHS", nullable = false)
    private Integer subscriptiontypeMonths;

	@Column(name = "IDX", nullable = false)
    private Integer idx;

	public SubscriptiontypeAttributePK(Integer subscriptiontypeMonths, Integer idx) {
        super();
        this.subscriptiontypeMonths = subscriptiontypeMonths;
        this.idx = idx;
    }

	private SubscriptiontypeAttributePK() {
        super();
    }

	public Integer getSubscriptiontypeMonths() {
        return subscriptiontypeMonths;
    }

	public Integer getIdx() {
        return idx;
    }

	private static final long serialVersionUID = 1L;

	public String toJson() {
        return new JSONSerializer().exclude("*.class").serialize(this);
    }

	public static SubscriptiontypeAttributePK fromJsonToSubscriptiontypeAttributePK(String json) {
        return new JSONDeserializer<SubscriptiontypeAttributePK>().use(null, SubscriptiontypeAttributePK.class).deserialize(json);
    }

	public static String toJsonArray(Collection<SubscriptiontypeAttributePK> collection) {
        return new JSONSerializer().exclude("*.class").serialize(collection);
    }

	public static Collection<SubscriptiontypeAttributePK> fromJsonArrayToSubscriptiontypeAttributePKs(String json) {
        return new JSONDeserializer<List<SubscriptiontypeAttributePK>>().use(null, ArrayList.class).use("values", SubscriptiontypeAttributePK.class).deserialize(json);
    }
}
