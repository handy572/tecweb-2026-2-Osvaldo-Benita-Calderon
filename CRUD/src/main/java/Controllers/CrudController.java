package Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

import  java.sql.*;
import java.util.*;

@Controller
@RequestMapping("/categorias")
public class CrudController {
    private Connection conectar() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/tablas";
        String usuario = "root";
        String password = "root";
        String pass = "";
        return DriverManager.getConnection(url,usuario,password);
    }

    @GetMapping
    public String listas(Model model){
        List<Map<String, Object>> lista = new ArrayList<>();

        try {
            Connection con = conectar();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM categorias");

            while(rs.next()){
                Map<String, Object> cat = new HashMap<>();
                cat.put("id", rs.getInt("id"));
                cat.put("nombre", rs.getString("nombre"));
                cat.put("descripcion", rs.getString("descripcion"));
                cat.put("fecha", rs.getDate("fecha_creacion"));
                lista.add(cat);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        model.addAttribute("categorias", lista);
        return "lista";
    }

    @GetMapping("/crear")
    public String crear(Model model){
        return "crear";
    }

    @PostMapping("/guardar")
    public String guardar(@RequestParam int id,
                          @RequestParam String nombre,
                          @RequestParam String descripcion,
                          @RequestParam String fecha_creacion){
        try{
            Connection con = conectar();
            String sql = "INSERT INTO categoria VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, nombre);
            ps.setString(3, descripcion);
            ps.setDate(4, Date.valueOf(fecha_creacion));

            ps.executeUpdate();
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/categorias";
    }

    @GetMapping("eliminar/{id}")
    public String eliminar(@PathVariable int id){
        try{
            Connection con = conectar();
            String sql = "DELETE FROM categorias WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/categorias";
    }
}
