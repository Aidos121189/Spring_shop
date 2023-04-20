package tongatar111.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tongatar111.shop.entity.Product;
import tongatar111.shop.service.CartService;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    //select* from Product p where p.price > int from;
    List<Product> findAllByPriceAfter(int from);

    //select* from Product p where p.category = long categoryId;
    List<Product>findAllByCategoryId(long categoryId);


   // select* from Product p join Category c on p.category.id = c.id where c.name = String categoryName;
   List<Product>findAllByCategoryName(String categoryName);


   // select* from Product p where p.name like '%?%' and p.price between ? and ?
    List<Product>findAllByNameContainingAndPriceBetween(String nameFragment, int minPrice, int maxPrice);


    @Query(value = "select p from Product p where p.name like ?1 and p.price between ?2 and ?3")
    List<Product> findAllByNameAndPrice(String nameFragment, int minPrice, int maxPrice);

    List<Product> findAllByCategoryIdAndPriceBetween(long categoryId, int minPrice, int maxPrice);


}
