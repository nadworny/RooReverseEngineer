// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.domain;

import ch.emineo.roo.reverse.domain.AdvancenoticeAttribute;
import ch.emineo.roo.reverse.domain.AdvancenoticeAttributePK;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

privileged aspect AdvancenoticeAttribute_Roo_Jpa_Entity {
    
    declare @type: AdvancenoticeAttribute: @Entity;
    
    declare @type: AdvancenoticeAttribute: @Table(name = "advancenotice_attribute");
    
    @EmbeddedId
    private AdvancenoticeAttributePK AdvancenoticeAttribute.id;
    
    public AdvancenoticeAttributePK AdvancenoticeAttribute.getId() {
        return this.id;
    }
    
    public void AdvancenoticeAttribute.setId(AdvancenoticeAttributePK id) {
        this.id = id;
    }
    
}
