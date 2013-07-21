package available;

import java.util.List;

public class SurveyListVO {  
    
    private String message;  
    private List<SurveyVO> result;  
    public String getMessage() {  
        return message;  
    }  
    public void setMessage(String message) {  
        this.message = message;  
    }  
    public List<SurveyVO> getResult() {  
        return result;  
    }  
    public void setResult(List<SurveyVO> result) {  
        this.result = result;  
    }  
}
