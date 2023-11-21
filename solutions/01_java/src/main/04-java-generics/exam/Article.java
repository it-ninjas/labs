package exam;

public class Article {
    private boolean hasBarcode;
    private double price;
    private int articleId;
    private String type; // ?

    public Article(boolean hasBarcode, double price, int articleId, String type) {
        this.hasBarcode = hasBarcode;
        this.price = price;
        this.articleId = articleId;
        this.type = type;
    }

    public boolean hasBarcode() {
        return hasBarcode;
    }

    public boolean isHasBarcode() {
        return hasBarcode;
    }

    public void setHasBarcode(boolean hasBarcode) {
        this.hasBarcode = hasBarcode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
