package cn.edu.zjut.action;


import cn.edu.zjut.po.Result;
import cn.edu.zjut.po.ResultD;
import cn.edu.zjut.service.ResultDService;
import cn.edu.zjut.service.ResultService;
import cn.edu.zjut.service.SignService;

import java.util.List;

public class ResultDetailsAction {
    private Result result;
    private ResultD resultDetail;
    private List<ResultD> resultDetails;
    private List<Result> results;
    private SignService resultDetailsService = null;
    private SignService resultService = null;

    public SignService getResultDetailsService() {
        return resultDetailsService;
    }

    public void setResultDetailsService(ResultDService resultDetailsService) {
        this.resultDetailsService = resultDetailsService;
    }

    public SignService getResultService() {
        return resultService;
    }

    public void setResultService(ResultService resultService) {
        this.resultService = resultService;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public ResultD getResultDetail() {
        return resultDetail;
    }

    public void setResultDetail(ResultD resultDetail) {
        this.resultDetail = resultDetail;
    }

    public void setResultDetails(List<ResultD> resultDetails) {
        this.resultDetails = resultDetails;
    }

    public List<ResultD> getResultDetails() {
        return resultDetails;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public List<Result> getResults() {
        return results;
    }

    public ResultDetailsAction() {
        System.out.println("create---ResultDetailsAction");
    }

    public String SignDetails() {
        System.out.println("now the ResultDetailsAction-signDetails");
        System.out.println(result.getSign_id());
        results = resultService.getRById(result.getSign_id());
        resultDetails = resultDetailsService.getResultDetails(result.getSign_id());
        return "success-Details";
    }

    public String changeDetails() {
        System.out.println("now the ResultDetailsAction-changeDetails");
        System.out.println(result.getSign_id());
        resultDetailsService.changeResultDetails(resultDetail.getId(), resultDetail.getIsSigned());
        results = resultService.getRById(result.getSign_id());
        resultDetails = resultDetailsService.getResultDetails(result.getSign_id());
        return "success-Details";

    }

}
