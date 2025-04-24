package com.lacheln.dcms.entity;

import java.sql.Timestamp;
import java.time.Instant;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import com.lacheln.dcms.utilities.StringPrefixedSequenceIdGenerator;

@Entity
@Table(name = "treatment_master")
public class TreatmentMaster {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "treatment_master_seq")
    @GenericGenerator(
        name = "treatment_master_seq", 
        strategy = "com.lacheln.dcms.utilities.StringPrefixedSequenceIdGenerator", 
        parameters = { 
            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "50"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "TRTM"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
        })
    @Column(name = "tm_id", updatable = false, nullable = false)
    private String tmId;
    
    @Column(name = "treatment_name", nullable = false)
    private String treatmentName;
    
    @Column(name = "treatment_added_date", nullable = false)
    private Timestamp treatmentAddedDate;
    
    @Column(name = "treatment_updated_date", nullable = true)
    private Timestamp treatmentUpdatedDate;

    @PrePersist
    protected void onCreate() {
        treatmentAddedDate = Timestamp.from(Instant.now());
        treatmentUpdatedDate = Timestamp.from(Instant.now());
    }

    @PreUpdate
    protected void onUpdate() {
        treatmentUpdatedDate = Timestamp.from(Instant.now());
    }
    
    
    // Getters and setters
    public String getTmId() {
        return tmId;
    }

    public void setTmId(String tmId) {
        this.tmId = tmId;
    }

    public String getTreatmentName() {
        return treatmentName;
    }

    public void setTreatmentName(String treatmentName) {
        this.treatmentName = treatmentName;
    }

    public Timestamp getTreatmentAddedDate() {
        return treatmentAddedDate;
    }

    public void setTreatmentAddedDate(Timestamp treatmentAddedDate) {
        this.treatmentAddedDate = treatmentAddedDate;
    }

    public Timestamp getTreatmentUpdatedDate() {
        return treatmentUpdatedDate;
    }

    public void setTreatmentUpdatedDate(Timestamp treatmentUpdatedDate) {
        this.treatmentUpdatedDate = treatmentUpdatedDate;
    }
}
