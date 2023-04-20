package tongatar111.shop.entity;

import javax.persistence.*;

@Entity
@Table(name = "values")
public class Value {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "option_id")
    private Option option;

    private String value;


    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public Option getOption() {
        return option;
    }

    public String getValue() {
        return value;
    }

    public void setId(Long id) {        this.id = id;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
