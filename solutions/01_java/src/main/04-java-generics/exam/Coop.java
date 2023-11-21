package exam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Coop {

    List<Branch> branches;

    public Coop(List<Branch> branches) {
        this.branches = branches;
    }

    public void checkoutCart(List<Article> cart, Optional<Schuepercard> schuepercard) {
        double subtotal = 0;
        for (Article article : cart) {
            if (article.hasBarcode()) {
                subtotal += article.getPrice();
            }
        }
        if (schuepercard.isPresent()) {
            schuepercard.get().addSchueperpoints(subtotal);
        }
    }

    public void selfCheckoutCart(List<Article> cart, Optional<Schuepercard> schuepercard) {
        double subtotal = 0;
        for (Article article : cart) {
            if (article.hasBarcode()) {
                subtotal += article.getPrice();
            } else {
                enterArticleManual(article);
                subtotal += article.getPrice();
            }
        }
        if (schuepercard.isPresent()) {
            schuepercard.get().addSchueperpoints(subtotal);
        }
    }

    public int enterArticleManual(Article article) {
        return article.getArticleId();
    }

    public Branch findEmployeeBranch(Employee employee) {
        Optional<Branch> foundBranch = branches.stream()
                .filter(branch -> branch.getEmployees().contains(employee))
                .findFirst();
        return foundBranch.orElse(null);
    }

    public List<Employee> getAllEmployees() {
        return branches.stream()
                .flatMap(branch -> branch.getEmployees().stream())
                .collect(Collectors.toList());
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }
}
