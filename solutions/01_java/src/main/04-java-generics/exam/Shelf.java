package exam;

import java.util.List;

public class Shelf {
    private static int shelfId = 0;
    private List<Article> articles;

    public Shelf(List<Article> articles) {
        ++shelfId;
        this.articles = articles;
    }

    public static int getShelfId() {
        return shelfId;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public void addArticle(Article article) {
        articles.add(article);
    }

    public void removeArticle(Article article) {
        articles.remove(article);
    }
}
