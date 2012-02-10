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
public final class UserAttributePK implements Serializable implements Serializable implements Serializable implements Serializable {

	@Column(name = "USER_USERID", nullable = false)
    private Integer userUserid;

	@Column(name = "IDX", nullable = false)
    private Integer idx;

	public UserAttributePK(Integer userUserid, Integer idx) {
        super();
        this.userUserid = userUserid;
        this.idx = idx;
    }

	private UserAttributePK() {
        super();
    }

	public Integer getUserUserid() {
        return userUserid;
    }

	public Integer getIdx() {
        return idx;
    }

	private static final long serialVersionUID = 1L;

	public String toJson() {
        return new JSONSerializer().exclude("*.class").serialize(this);
    }

	public static UserAttributePK fromJsonToUserAttributePK(String json) {
        return new JSONDeserializer<UserAttributePK>().use(null, UserAttributePK.class).deserialize(json);
    }

	public static String toJsonArray(Collection<UserAttributePK> collection) {
        return new JSONSerializer().exclude("*.class").serialize(collection);
    }

	public static Collection<UserAttributePK> fromJsonArrayToUserAttributePKs(String json) {
        return new JSONDeserializer<List<UserAttributePK>>().use(null, ArrayList.class).use("values", UserAttributePK.class).deserialize(json);
    }
}
