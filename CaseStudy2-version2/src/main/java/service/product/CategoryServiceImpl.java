package service.product;

import model.product.Category;
import repository.product.CategoryRepositoryImpl;
import repository.product.ICategoryRepository;

import java.util.List;

public class CategoryServiceImpl implements ICategoryService{

    ICategoryRepository categoryRepository = new CategoryRepositoryImpl();
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
