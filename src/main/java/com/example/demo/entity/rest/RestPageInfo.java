package com.example.demo.entity.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 返回给前端的分页信息
 * @author jielum
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestPageInfo<T> {
    /**
     * 当前页
     */
    private int pageNum;
    /**
     * 每页的数量
     */
    private int pageSize;
    /**
     * 每页的数量
     */
    private int size;
    /**
     * 总页数
     */
    private int pages;
    /**
     * 前一页
     */
    private int prePage;
    /**
     * 下一页
     */
    private int nextPage;
    /**
     * 数据总数
     */
    private long total;

    /**
     * 是否有前一页
     */
    @Builder.Default
    private boolean hasPreviousPage = false;
    /**
     * 是否有下一页
     */
    @Builder.Default
    private boolean hasNextPage = false;
    /**
     * 业务数据列表
     */
    private List<T> list;

    public static <T> RestPageInfo<T> buildRestPageInfo(PageInfo<T> pageInfo) {
        return RestPageInfo.<T>builder()
                .pageNum(pageInfo.getPageNum())
                .pageSize(pageInfo.getPageSize())
                .size(pageInfo.getSize())
                .pages(pageInfo.getPages())
                .prePage(pageInfo.getPrePage())
                .nextPage(pageInfo.getNextPage())
                .hasPreviousPage(pageInfo.isHasPreviousPage())
                .hasNextPage(pageInfo.isHasNextPage())
                .total(pageInfo.getTotal())
                .list(pageInfo.getList())
                .build();
    }

    public static <T> RestPageInfo<T> buildRestPageInfo(PageInfo<?> pageInfo, List<T> list) {
        return RestPageInfo.<T>builder()
                .pageNum(pageInfo.getPageNum())
                .pageSize(pageInfo.getPageSize())
                .size(pageInfo.getSize())
                .pages(pageInfo.getPages())
                .prePage(pageInfo.getPrePage())
                .nextPage(pageInfo.getNextPage())
                .hasPreviousPage(pageInfo.isHasPreviousPage())
                .hasNextPage(pageInfo.isHasNextPage())
                .total(pageInfo.getTotal())
                .list(list)
                .build();
    }

    /**
     * 用于查询所有
     */
    public static <T> RestPageInfo<T> buildRestPageInfo(List<T> list) {
        return RestPageInfo.<T>builder()
                .pageNum(1)
                .pageSize(list.size())
                .size(list.size())
                .pages(1)
                .prePage(0)
                .nextPage(0)
                .hasPreviousPage(false)
                .hasNextPage(false)
                .list(list)
                .build();
    }
}
