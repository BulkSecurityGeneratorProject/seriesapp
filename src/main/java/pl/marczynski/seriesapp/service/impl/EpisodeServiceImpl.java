package pl.marczynski.seriesapp.service.impl;

import org.springframework.stereotype.Service;
import pl.marczynski.seriesapp.domain.*;
import pl.marczynski.seriesapp.domain.builder.WatchedEpisodeBuilder;
import pl.marczynski.seriesapp.repository.EpisodeRepository;
import pl.marczynski.seriesapp.repository.UserRepository;
import pl.marczynski.seriesapp.repository.WatchedEpisodeRepository;
import pl.marczynski.seriesapp.security.SecurityUtils;
import pl.marczynski.seriesapp.service.EpisodeService;
import pl.marczynski.seriesapp.service.SeriesService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EpisodeServiceImpl implements EpisodeService {
    private EpisodeRepository episodeRepository;

    public EpisodeServiceImpl(EpisodeRepository episodeRepository) {
        this.episodeRepository = episodeRepository;
    }

    @Override
    public Episode save(Episode episode) {
        return episodeRepository.save(episode);
    }

    @Override
    public List<Episode> findAll() {
        return episodeRepository.findAll();
    }

    @Override
    public Optional<Episode> findById(Long id) {
        return episodeRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        episodeRepository.deleteById(id);
    }

    @Override
    public Episode update(Episode episode) {
        return episodeRepository.save(episode);
    }

    @Override
    public Optional<Episode> findEpisodeFromSeries(Integer year, String name, Integer seasonNumber, Integer episodeNumber) {
        return episodeRepository.findBySeries(year, name, seasonNumber, episodeNumber);
    }

}
