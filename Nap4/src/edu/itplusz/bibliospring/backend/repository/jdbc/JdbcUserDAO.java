package edu.itplusz.bibliospring.backend.repository.jdbc;

import edu.itplusz.bibliospring.backend.model.User;
import edu.itplusz.bibliospring.backend.repository.RepositoryExeption;
import edu.itplusz.bibliospring.backend.repository.UserDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcUserDAO implements UserDAO {
    private static final Logger LOG = LoggerFactory.getLogger(JdbcUserDAO.class);

    @Override
    public User findById(Long id) {
        Connection conn = null;
        try {
            conn = ConnectionManager.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE id=?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setUuid(rs.getString("uuid"));
                return user;
            }
            return null;
        } catch (SQLException e) {
            LOG.error("error:findById",e);
            throw new RepositoryExeption("error:findById",e);
            //throw new RuntimeException(e);
        } finally {
            ConnectionManager.getInstance().returnConnection(conn);
        }
    }

    @Override
    public User create(User user) {
        Connection conn = null;
        try {
            conn = ConnectionManager.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO users(username,password,uuid) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getUuid());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()) {
                user.setId(rs.getLong(1));
                return user;
            }
            return null;
        } catch (SQLException e) {
            LOG.error("error:create",e);
            throw new RepositoryExeption("error:create",e);
            //throw new RuntimeException(e);
        } finally {
            ConnectionManager.getInstance().returnConnection(conn);
        }

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public List<User> findAll() {
        Connection conn = null;
        List<User> users = new ArrayList<>();
        try {
            conn = ConnectionManager.getInstance().getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setUuid(rs.getString("uuid"));
                users.add(user);
            }
            return users;

        } catch (SQLException e) {
            LOG.error("error:findAll",e);
            throw new RepositoryExeption("error:findAll",e);
            //throw new RuntimeException(e);
        } finally {
            ConnectionManager.getInstance().returnConnection(conn);
        }
    }

    @Override
    public User findByUsername(String username) {
        Connection conn = null;
        try {
            conn = ConnectionManager.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE username=?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setUuid(rs.getString("uuid"));
                return user;
            }
            return null;
        } catch (SQLException e) {
            LOG.error("error:findByUsername",e);
            throw new RepositoryExeption("error:findByUsername",e);
            //throw new RuntimeException(e);
        } finally {
            ConnectionManager.getInstance().returnConnection(conn);
        }
    }
}
