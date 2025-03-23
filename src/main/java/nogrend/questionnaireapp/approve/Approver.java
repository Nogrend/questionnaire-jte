package nogrend.questionnaireapp.approve;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Approver {
    @NotBlank private String name;
    @NotNull private boolean hasApproved;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean hasApproved() {
        return hasApproved;
    }

    public void setHasApproved(boolean hasApproved) {
        this.hasApproved = hasApproved;
    }

    @Override
    public String toString() {
        return "Approver{" +
          "name='" + name + '\'' +
          ", hasApproved=" + hasApproved +
          '}';
    }
}
