package com.course.courseDemo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UuidDto {
    @UUID(message = "INVALID_ID")
    private String id;

    public java.util.UUID toUuid() {
        return java.util.UUID.fromString(this.id);
    }
}