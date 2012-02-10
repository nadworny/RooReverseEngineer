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
public final class UserRolePK implements Serializable implements Serializable implements Serializable implements Serializable {

	@Column(name = "USER_USERID", nullable = false)
    private Integer userUserid;

	@Column(name = "IDX", nullable = false)
    private Integer idx;

	public UserRolePK(Integer userUserid, Integer idx) {
        super();
        this.userUserid = userUserid;
        this.idx = idx;
    }

	private UserRolePK() {
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

	public static UserRolePK fromJsonToUserRolePK(String json) {
        return new JSONDeserializer<UserRolePK>().use(null, UserRolePK.class).deserialize(json);
    }

	public static String toJsonArray(Collection<UserRolePK> collection) {
        return new JSONSerializer().exclude("*.class").serialize(collection);
    }

	public static Collection<UserRolePK> fromJsonArrayToUserRolePKs(String json) {
        return new JSONDeserializer<List<UserRolePK>>().use(null, ArrayList.class).use("values", UserRolePK.class).deserialize(json);
    }
}
