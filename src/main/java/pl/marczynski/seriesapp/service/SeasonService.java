package pl.marczynski.seriesapp.service;

import org.springframework.stereotype.Service;
import pl.marczynski.seriesapp.domain.Season;
import pl.marczynski.seriesapp.repository.SeasonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SeasonService {
    private SeasonRepository seasonRepository;

    public SeasonService(SeasonRepository SeasonRepository) {
        this.seasonRepository = SeasonRepository;
    }

    public Season save(Season Season) {
        return seasonRepository.save(Season);
    }

    public List<Season> findAll() {
        return seasonRepository.findAll();
    }

    public Optional<Season> findById(Long id) {
        return seasonRepository.findById(id);
    }

    public void deleteById(Long id) {
        seasonRepository.deleteById(id);
    }

    public Season update(Season season) {
        return seasonRepository.save(season);
    }
}