package ru.uennar.birem.logger;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.uennar.birem.beans.Record;


public class DbLogger {

    private static final String SQL_ERROR_STATE_SCHEMA_EXISTS = "X0Y68";
    private static final String SQL_ERROR_STATE_TABLE_EXISTS = "X0Y32";

    private JdbcTemplate jdbcTemplate;
    private String schema;

    public DbLogger(JdbcTemplate jdbcTemplate, String schema) {
        this.jdbcTemplate = jdbcTemplate;
        this.schema = schema.toUpperCase();
    }

    public void init() {
        createDBSchema();
        createTableIfNotExists();
        updateRecordAutoId();
    }

    public void destroy() {
        int totalRecords = getTotalRecords();
        System.out.println("Total records in the DB: " + totalRecords);

        List<Record> allRecords = getAllRecords();
        String allRecordIds = allRecords.stream()
                .map(Record::getId)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println("All DB Record ids: " + allRecordIds);
    }

    private void createDBSchema() {
        try {
            jdbcTemplate.update("CREATE SCHEMA " + schema);
        } catch (DataAccessException e) {
            Throwable causeException = e.getCause();
            if (causeException instanceof SQLException) {
                SQLException sqlException = (SQLException) causeException;
                if (sqlException.getSQLState().equals(SQL_ERROR_STATE_SCHEMA_EXISTS)) {
                    System.out.println("Schema already exists");
                } else {
                    throw e;
                }
            } else {
                throw e;
            }
        }
    }

    private void createTableIfNotExists() {
        try {
            jdbcTemplate.update("CREATE TABLE t_record (" + "id INT NOT NULL PRIMARY KEY," + "date TIMESTAMP,"
                    + "msg VARCHAR(255)" + ")");

            System.out.println("Created table t_record");
        } catch (DataAccessException e) {
            Throwable causeException = e.getCause();
            if (causeException instanceof SQLException) {
                SQLException sqlException = (SQLException) causeException;
                if (sqlException.getSQLState().equals(SQL_ERROR_STATE_TABLE_EXISTS)) {
                    System.out.println("Table already exists");
                } else {
                    throw e;
                }
            } else {
                throw e;
            }
        }
    }

    private void updateRecordAutoId() {
        int maxId = getMaxId();
        Record.initAutoId(maxId + 1);
        System.out.println("Initialized Record.AUTO_ID to " + maxId);
    }

    private int getMaxId() {
        Integer count = jdbcTemplate.queryForObject("select max(id) from t_record", Integer.class);
        return count != null ? count.intValue() : 0;
    }


    public void logRecord(Record record) {
        jdbcTemplate.update("INSERT INTO t_record (id, date, msg) VALUES (?,?,?)", record.getId(), record.getDate(),
                record.toString());
        System.out.println("Saved to DB record with id " + record.getId());
    }

    public int getTotalRecords() {
        Integer count = jdbcTemplate.queryForObject("select count(*) from t_record", Integer.class);
        return count != null ? count.intValue() : 0;
    }

    public List<Record> getAllRecords() {
        List<Record> list = jdbcTemplate.query("select * from t_record", new RowMapper<Record>() {
            @Override
            public Record mapRow(ResultSet rs, int rowNum) throws SQLException {
                Integer id = rs.getInt("id");
                Date date = rs.getDate("date");
                String msg = rs.getString("msg");
                Record record = new Record(id, new Date(date.getTime()), msg);
                return record;
            }
        });
        return list;
    }

}
