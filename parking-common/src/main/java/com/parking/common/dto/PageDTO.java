package com.parking.common.dto;

import lombok.Data;
import java.io.Serializable;

@Data
public class PageDTO implements Serializable {

    private Integer pageNum = 1;
    private Integer pageSize = 10;
    private String orderBy;
    private String sortDirection = "desc";
}