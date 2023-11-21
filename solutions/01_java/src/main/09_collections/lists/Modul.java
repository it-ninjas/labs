package lists;

import java.util.ArrayList;

public class Modul {
    private String moduleName;
    private ArrayList<LBV> lbvs = new ArrayList<>();

    public Modul(String moduleName) {
        this.moduleName = moduleName;
    }

    public void addLBV(LBV exam) {
        lbvs.add(exam);
    }

    public float getFinalModuleGrade() throws ModulNotGradeableException {
        float totalWeight = 0;
        float totalGrade = 0;

        for (LBV exam : lbvs) {
            totalWeight += exam.getWeight();
            totalGrade += exam.getGrade() * exam.getWeight();
        }

        if (totalWeight != 1.0f) {
            throw new ModulNotGradeableException("The total weight of LBVs in the module must be 1.0");
        }

        return totalGrade;
    }

    public void printReportEntry() {
        try {
            float finalGrade = getFinalModuleGrade();
            System.out.println(moduleName + " : " + finalGrade);
        } catch (ModulNotGradeableException e) {
            System.out.println(moduleName + " : " + e.getMessage());
        }
    }
}

