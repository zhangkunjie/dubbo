package com.common.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <tt>PageModel</tt> 通用分页对象
 * <p>
 * 通用分页对象, 封装前台所需的页码{@link #pageNo}, 每页显示条数{@link #pageSize}, 总条数{@link #totalRecords}等参数
 * </p>
 *
 * @param <T> 分页类型
 * @author zheng.sun
 * @version 1.0
 */
public class PageModel<T> implements Serializable {

    private static final long serialVersionUID = -8962539825382687762L;

    /**
     * 数据库的类型，不同数据库类型的分页语句不一样
     */
    private String databaseType;

    /**
     * 页码，默认是第一页
     */
    private int pageNo;

    /**
     * 每页显示的记录数，默认是10
     */
    private int pageSize;

    /**
     * 总记录数
     */
    private int totalRecords;

    /**
     * 总页数
     */
    private int totalPage;

    /**
     * 对应的当前页记录
     */
    private List<T> results;

    /**
     * 其他的参数分装成一个Map对象
     */
    private Map<String, Object> params = new HashMap<String, Object>();

    /**
     * url参数
     */
    private String urlParam;

    private String url;

    public PageModel() {
    }

    /**
     * 设置页码和每页显示的记录数
     *
     * @param pageNo   页码
     * @param pageSize 每页显示的记录数
     */
    public PageModel(int pageNo, int pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
        // 在设置总页数的时候计算出对应的总页数，在下面的三目运算中加法拥有更高的优先级，所以最后可以不加括号。
        int totalPage = totalRecords % pageSize == 0 ? totalRecords / pageSize
                : totalRecords / pageSize + 1;
        this.setTotalPage(totalPage);
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public String getUrlParam() {
        return urlParam;
    }

    public void setUrlParam(String urlParam) {
        this.urlParam = urlParam;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDatabaseType() {
        return databaseType;
    }

    public void setDatabaseType(String databaseType) {
        this.databaseType = databaseType;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Page [pageNo=").append(pageNo).append(", pageSize=")
                .append(pageSize).append(", results=").append(results)
                .append(", totalPage=").append(totalPage)
                .append(", totalRecord=").append(totalRecords).append("]");
        return builder.toString();
    }

    public void pageMessage2Pairs(Map<String, Object> pairs) {
        pairs.put("totalRecords", totalRecords);
        pairs.put("totalPage", totalPage);
    }
}