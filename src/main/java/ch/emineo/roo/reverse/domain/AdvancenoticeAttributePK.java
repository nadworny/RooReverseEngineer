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
public final class AdvancenoticeAttributePK implements Serializable implements Serializable implements Serializable implements Serializable {

	@Column(name = "ADVANCENOTICE_ADVANCENOTICEID", nullable = false)
    private Integer advancenoticeAdvancenoticeid;

	@Column(name = "IDX", nullable = false)
    private Integer idx;

	public AdvancenoticeAttributePK(Integer advancenoticeAdvancenoticeid, Integer idx) {
        super();
        this.advancenoticeAdvancenoticeid = advancenoticeAdvancenoticeid;
        this.idx = idx;
    }

	private AdvancenoticeAttributePK() {
        super();
    }

	public Integer getAdvancenoticeAdvancenoticeid() {
        return advancenoticeAdvancenoticeid;
    }

	public Integer getIdx() {
        return idx;
    }

	public String toJson() {
        return new JSONSerializer().exclude("*.class").serialize(this);
    }

	public static AdvancenoticeAttributePK fromJsonToAdvancenoticeAttributePK(String json) {
        return new JSONDeserializer<AdvancenoticeAttributePK>().use(null, AdvancenoticeAttributePK.class).deserialize(json);
    }

	public static String toJsonArray(Collection<AdvancenoticeAttributePK> collection) {
        return new JSONSerializer().exclude("*.class").serialize(collection);
    }

	public static Collection<AdvancenoticeAttributePK> fromJsonArrayToAdvancenoticeAttributePKs(String json) {
        return new JSONDeserializer<List<AdvancenoticeAttributePK>>().use(null, ArrayList.class).use("values", AdvancenoticeAttributePK.class).deserialize(json);
    }

	private static final long serialVersionUID = 1L;
}
