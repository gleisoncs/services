package com.yourdesire.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Customer {

    @Id
    private String UUID;
    
    private String firstName;
    
    private String lastName;
    
    @NotNull
    private String username;
  
    @LastModifiedDate
    private Date lastModifiedDate;
    
    @Version
    private int version;

}
