import java.util.*;

public interface OnboardingOutput {
    void printInput(String raw);
    void printErrors(List<String> errors);
    void printSuccess(StudentRecord rec, int totalCount);
}
