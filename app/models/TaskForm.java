package models;

import play.data.validation.Constraints.Required;
import play.data.validation.Constraints.MinLength;
import play.data.validation.Constraints.MaxLength;
import play.data.validation.Constraints.MinValidator;


public class TaskForm {

    @Required
    @MinLength(3)
    @MaxLength(10)
    private String contents;
    

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
