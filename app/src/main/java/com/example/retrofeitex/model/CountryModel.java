package com.example.retrofeitex.model;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class CountryModel {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("result")
    @Expose
    private List<ResultModel> resultmodel;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<ResultModel> getResultmodel() {
        return resultmodel;
    }

    public void setResultmodel(List<ResultModel> resultmodel) {
        this.resultmodel = resultmodel;
    }

}