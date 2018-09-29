package co.edu.intecap.apiclient.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UsersResponse {

    private int page;
    private int total;
    @SerializedName("total_pages")
    private int totalPages;
    @SerializedName("per_page")
    private int userPerPage;
    private List<User> data;


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getUserPerPage() {
        return userPerPage;
    }

    public void setUserPerPage(int userPerPage) {
        this.userPerPage = userPerPage;
    }

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }
}
