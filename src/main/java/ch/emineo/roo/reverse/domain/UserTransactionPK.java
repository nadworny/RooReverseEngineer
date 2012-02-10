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
public final class UserTransactionPK implements Serializable implements Serializable implements Serializable implements Serializable {

	public String toJson() {
        return new JSONSerializer().exclude("*.class").serialize(this);
    }

	public static UserTransactionPK fromJsonToUserTransactionPK(String json) {
        return new JSONDeserializer<UserTransactionPK>().use(null, UserTransactionPK.class).deserialize(json);
    }

	public static String toJsonArray(Collection<UserTransactionPK> collection) {
        return new JSONSerializer().exclude("*.class").serialize(collection);
    }

	public static Collection<UserTransactionPK> fromJsonArrayToUserTransactionPKs(String json) {
        return new JSONDeserializer<List<UserTransactionPK>>().use(null, ArrayList.class).use("values", UserTransactionPK.class).deserialize(json);
    }

	@Column(name = "USER_USERID", nullable = false)
    private Integer userUserid;

	@Column(name = "IDX", nullable = false)
    private Integer idx;

	public UserTransactionPK(Integer userUserid, Integer idx) {
        super();
        this.userUserid = userUserid;
        this.idx = idx;
    }

	private UserTransactionPK() {
        super();
    }

	public Integer getUserUserid() {
        return userUserid;
    }

	public Integer getIdx() {
        return idx;
    }

	private static final long serialVersionUID = 1L;
}
