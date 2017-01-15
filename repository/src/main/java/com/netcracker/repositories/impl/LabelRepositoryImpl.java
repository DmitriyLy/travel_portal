package com.netcracker.repositories.impl;

import com.netcracker.entities.Label;
import com.netcracker.queries.QueriesRepository;
import com.netcracker.repositories.IRepository;
import com.netcracker.specifications.Specification;
import com.netcracker.specifications.SqlSpecification;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Egor Oveian
 */
@Repository
public class LabelRepositoryImpl implements IRepository<Label> {

    private final static Logger LOGGER = LogManager.getLogger(LabelRepositoryImpl.class.getName());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Label> mapper = (rs, rowNum) -> {
        Label label = new Label();
        label.setId(rs.getLong("id"));
        label.setUserId(rs.getLong("user_id"));
        label.setLocationId(rs.getLong("location_id"));
        label.setOwnerComment(rs.getString("owner_comment"));
        label.setRating(rs.getInt("rating"));
        label.setCoordLat(rs.getDouble("coordinate_lat"));
        label.setCoordLong(rs.getDouble("coordinate_long"));
        label.setCreationDate(rs.getDate("creation_date"));
        label.setMapProviderId(rs.getLong("map_provider_id"));
        return label;
    };

    @Override
    public Label add(Label item) {
        String query = QueriesRepository.INSERT_LABEL;
        item.setId(getNewLabelId());

        int out = jdbcTemplate.update(query,
                item.getId(),
                item.getUserId(),
                item.getLocationId(),
                item.getOwnerComment(),
                item.getRating(),
                item.getCoordLat(),
                item.getCoordLong(),
                item.getCreationDate(),
                item.getMapProviderId()
        );

        if (out == 0) {
            LOGGER.warn("Cannot insert " + item.toString());
        }

        return item;
    }

    @Override
    public Label update(Label item) {
        String query = QueriesRepository.UPDATE_LABEL;
        int out = jdbcTemplate.update(query,
                item.getUserId(),
                item.getLocationId(),
                item.getOwnerComment(),
                item.getRating(),
                item.getCoordLat(),
                item.getCoordLong(),
                item.getCreationDate(),
                item.getMapProviderId(),
                item.getId()
        );

        if (out == 0) {
            LOGGER.warn("Cannot delete " + item.toString());
        }

        return item;
    }

    @Override
    public Label remove(Label item) {
        String query = QueriesRepository.DELETE_LABEL;
        int out = jdbcTemplate.update(query,
                item.getId()
        );

        if (out == 0) {
            LOGGER.warn("Cannot delete " + item.toString());
        }

        return item;
    }

    @Override
    public Label getById(long id) {
        String query = QueriesRepository.GET_LABEL_BY_ID;
        return jdbcTemplate.queryForObject(query, new Object[]{id}, mapper);
    }

    @Override
    public long getColumnCount() {
        String query = QueriesRepository.GET_COUNT_OF_LABELS;
        return jdbcTemplate.queryForObject(query, Long.class);
    }

    @Override
    public List<Label> query(Specification specification) {
        SqlSpecification sqlSpecification = (SqlSpecification) specification;
        return jdbcTemplate.query(sqlSpecification.toSqlQuery(), mapper);
    }

    /**
     * @return long value - id of last row in LABELS table.
     */
    private long getNewLabelId(){
        String query = QueriesRepository.GET_NEW_ID_LABELS;
        return jdbcTemplate.queryForObject(query, Long.class);
    }
}
