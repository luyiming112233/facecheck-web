package cn.edu.zjut.action;


import cn.edu.zjut.po.Publisher;
import cn.edu.zjut.po.Result;
import cn.edu.zjut.service.ResultService;
import cn.edu.zjut.service.SignService;
import com.opensymphony.xwork2.ActionSupport;


import java.util.List;

public class ResultAction extends ActionSupport {
    private Result result;
    private List<Result> results;
    private Publisher publisher;
    private SignService resultService = null;

    public void setResult(Result result) {
        this.result = result;
    }

    public Result getResult() {
        return result;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public SignService getResultService() {
        return resultService;
    }

    public void setResultService(ResultService resultService) {
        this.resultService = resultService;
    }

    public String lookAll() {
        System.out.println(publisher.getId() + "***********");
        results = (List<Result>) resultService.getRByPId(publisher.getId());
        return "success-lookAll";
    }

    public String Byname() {
        System.out.println("now the ResultAction-ByName" + result.getName());
        results = (List<Result>) resultService.getRByName(result.getName(), publisher.getId());
        return "success-Byname";
    }

    public String Bytime() {
        System.out.println("now the ResultAction-ByTime" + result.getTime());
        results = (List<Result>) resultService.getRByTime(result.getTime(), publisher.getId());
        return "success-Bytime";
    }
}
