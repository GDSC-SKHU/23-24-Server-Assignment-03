package com.gdsc.review.repository;
import com.gdsc.review.domain.Review;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class MemoryReviewRepository implements ReviewRepository{

    private static Map<Long, Review> store = new HashMap<>();
    private static Long sequence = 0L;
    @Override
    public void save(Review review) {
        review.initId(++sequence);
        store.put(review.getId(), review);
    }

    @Override
    public Review findById(Long id) {
        return store.get(id);
    }
    @Override
    public List<Review> findByRestaurantName(String restaurantName){
        return store.values()
                .stream()
                .filter(review -> review.getRestaurantName().equals(restaurantName))
                .collect(Collectors.toList());      }
    @Override
    public List<Review> findByReviewerName(String reviewerName){
        return store.values()
                .stream()
                .filter(review -> review.getReviewerName().equals(reviewerName))
                .collect(Collectors.toList());      }

    @Override
    public List<Review> findAll() {
        return store.values().stream().toList();
    }

    @Override
    public void updateById(Long id, Review review) {
        store.put(id, review);
    }

    @Override
    public void deleteById(Long id) {
        store.remove(id);
    }
}
