package tongatar111.shop.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> product;

    @OneToMany(mappedBy = "category")
    private List<Option> options;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Product> getProduct() {
        return product;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }
}
