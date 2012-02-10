// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.domain;

import ch.emineo.roo.reverse.domain.UserAttributePK;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

privileged aspect UserAttributePK_Roo_Json {
    
    public String UserAttributePK.toJson() {
        return new JSONSerializer().exclude("*.class").serialize(this);
    }
    
    public static UserAttributePK UserAttributePK.fromJsonToUserAttributePK(String json) {
        return new JSONDeserializer<UserAttributePK>().use(null, UserAttributePK.class).deserialize(json);
    }
    
    public static String UserAttributePK.toJsonArray(Collection<UserAttributePK> collection) {
        return new JSONSerializer().exclude("*.class").serialize(collection);
    }
    
    public static Collection<UserAttributePK> UserAttributePK.fromJsonArrayToUserAttributePKs(String json) {
        return new JSONDeserializer<List<UserAttributePK>>().use(null, ArrayList.class).use("values", UserAttributePK.class).deserialize(json);
    }
    
}