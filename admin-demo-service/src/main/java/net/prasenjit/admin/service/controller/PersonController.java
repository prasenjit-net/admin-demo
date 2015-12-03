package net.prasenjit.admin.service.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.prasenjit.admin.service.domain.Person;

@RestController
@RequestMapping("person")
public class PersonController {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@RequestMapping(method = RequestMethod.GET)
	public List<Person> list() {
		return jdbcTemplate.query("select * from person", new RowMapper<Person>() {

			@Override
			public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
				Person p = new Person();
				p.setId(rs.getInt("id"));
				p.setFirstname(rs.getString("firstname"));
				p.setLastname(rs.getString("lastname"));
				return p;
			}

		});
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@Transactional
	public Person create(@Valid @RequestBody Person person) {
		jdbcTemplate.update("delete from person where id = ?", new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, person.getId());
			}
		});
		jdbcTemplate.update("insert into person(id, firstname, lastname) values (?,?,?)",
				new PreparedStatementSetter() {

					@Override
					public void setValues(PreparedStatement ps) throws SQLException {
						ps.setInt(1, person.getId());
						ps.setString(2, person.getFirstname());
						ps.setString(3, person.getLastname());
					}
				});

		return jdbcTemplate.query("select * from person where id = ?", new Object[] { person.getId() },
				new ResultSetExtractor<Person>() {

					@Override
					public Person extractData(ResultSet rs) throws SQLException, DataAccessException {
						if (rs.next()) {
							Person p = new Person();
							p.setId(rs.getInt("id"));
							p.setFirstname(rs.getString("firstname"));
							p.setLastname(rs.getString("lastname"));
							return p;
						} else {
							return null;
						}
					}
				});

	}

	@Transactional
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Integer id) {
		jdbcTemplate.update("delete from person where id = ?", new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, id);
			}
		});
	}

}
