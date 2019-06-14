package com.auditing.audit.audit;


import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

@MappedSuperclass
@EntityListeners( AuditingEntityListener.class )
public abstract class Auditable<U> {
// ---   @CreatedBy- Declares a field as the one representing the principal
// ----   that created the entity containing the field.
    @CreatedBy
    protected U createdBy;

//  ---  @CreatedDate - Declares a field as the one representing the date
//   --- the entity containing the field was created.
    //--- @Temporal shows the date is temporary
    @CreatedDate
    @Temporal(TIMESTAMP)
    protected Date createdDate;

//  ---  @LastModifiedBy - Declares a field as the one representing the principal that recently
//   --- modified the entity containing the field.

    @LastModifiedBy
    protected U lastModifiedBy;

//  ---  @LastModifiedDate - Declares a field as the one representing the date
//   --- the entity containing the field was recently modified.
// ---@Temporal shows the date is temporary
    @LastModifiedDate
    @Temporal(TIMESTAMP)
    protected Date lastModifiedDate;

    public U getCreatedBy() {
        return createdBy;
    }

    public Auditable<U> setCreatedBy(U createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Auditable<U> setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public U getLastModifiedBy() {
        return lastModifiedBy;
    }

    public Auditable<U> setLastModifiedBy(U lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
        return this;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public Auditable<U> setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
        return this;
    }
}
