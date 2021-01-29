package com.stephen.demo.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by stephen on 2021-01-29 11:58 .
 * Description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ListResult<T> {

    private int currentPage;

    private int pageSize;

    private long totalPage;

    private long total;

    private List<T> list;



}
