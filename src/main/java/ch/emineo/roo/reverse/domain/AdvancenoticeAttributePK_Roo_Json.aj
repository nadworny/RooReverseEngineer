// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.domain;

import ch.emineo.roo.reverse.domain.AdvancenoticeAttributePK;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

privileged aspect AdvancenoticeAttributePK_Roo_Json {
    
    public String AdvancenoticeAttributePK.toJson() {
        return new JSONSerializer().exclude("*.class").serialize(this);
    }
    
    public static AdvancenoticeAttributePK AdvancenoticeAttributePK.fromJsonToAdvancenoticeAttributePK(String json) {
        return new JSONDeserializer<AdvancenoticeAttributePK>().use(null, AdvancenoticeAttributePK.class).deserialize(json);
    }
    
    public static String AdvancenoticeAttributePK.toJsonArray(Collection<AdvancenoticeAttributePK> collection) {
        return new JSONSerializer().exclude("*.class").serialize(collection);
    }
    
    public static Collection<AdvancenoticeAttributePK> AdvancenoticeAttributePK.fromJsonArrayToAdvancenoticeAttributePKs(String json) {
        return new JSONDeserializer<List<AdvancenoticeAttributePK>>().use(null, ArrayList.class).use("values", AdvancenoticeAttributePK.class).deserialize(json);
    }
    
}