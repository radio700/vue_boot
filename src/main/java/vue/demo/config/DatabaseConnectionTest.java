package vue.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;



@Component
public class DatabaseConnectionTest implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        try {
            jdbcTemplate.execute("SELECT 1");
            System.out.println("✅ Database connection to PostgreSQL is successful!");
        } catch (Exception e) {
            System.err.println("❌ Failed to connect to the database: " + e.getMessage());
        }
    }
}