package es.eoi.jdbc.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import es.eoi.jdbc.entity.Alumno;

public class AlumnoRepositoryImpl implements AlumnoRepository {

	private java.sql.Connection openConnection() {

		String url = "jdbc:mysql://localhost:3306/EJDBC?serverTimezone=UTC";
		String user = "root";
		String pass = "1234";

		try {
			Connection conexion = DriverManager.getConnection(url, user, pass);
			//System.out.println("Conectado a ".concat(url));
			return conexion;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public Alumno findByDni(String dni) {

		Alumno al = new Alumno();

		Connection conexion = openConnection();

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM ALUMNO ");
		sql.append("WHERE DNI = ? ");
		//System.out.println(sql.toString());

		if (conexion != null) {

			try {
				PreparedStatement pst = conexion.prepareStatement(sql.toString());
				pst.setString(1, dni);

				ResultSet rs = pst.executeQuery();

				if (rs.next()) {
					al.setDni(rs.getString("DNI"));
					al.setNombre(rs.getString("NOMBRE"));
					al.setApellidos(rs.getString("APELLIDOS"));
					al.setEdad(rs.getInt("EDAD"));
					
					conexion.close();
					return al;
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	public List<Alumno> findAll() {

		List<Alumno> alumnos = new ArrayList<Alumno>();
		Alumno al;

		Connection conexion = openConnection();
		String sql = "SELECT * FROM ALUMNO ";

		if (conexion != null) {

			try {
				Statement st = conexion.createStatement();

				ResultSet rs = st.executeQuery(sql);

				while (rs.next()) {

					al = new Alumno();

					al.setDni(rs.getString("DNI"));
					al.setNombre(rs.getString("NOMBRE"));
					al.setApellidos(rs.getString("APELLIDOS"));
					al.setEdad(rs.getInt("EDAD"));

					alumnos.add(al);

				}
				conexion.close();
				return alumnos;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	public boolean create(Alumno nuevoAlumno) {

		Connection conexion = openConnection();

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO ALUMNO ");
		sql.append("(`DNI`,`NOMBRE`,`APELLIDOS`,`EDAD`) ");
		sql.append("VALUES( ?, ?, ?, ?);");
		//System.out.println(sql.toString());

		if (conexion != null) {

			try {
				PreparedStatement pst = conexion.prepareStatement(sql.toString());
				pst.setString(1, nuevoAlumno.getDni());
				pst.setString(2, nuevoAlumno.getNombre());
				pst.setString(3, nuevoAlumno.getApellidos());
				pst.setInt(4, nuevoAlumno.getEdad());

				if (pst.executeUpdate() >= 1) {
					conexion.close();
					return true;
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}

	public boolean delete(String dni) {

		Connection conexion = openConnection();

		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM ALUMNO ");
		sql.append("WHERE DNI = ? ");
		//System.out.println(sql.toString());

		if (conexion != null) {

			try {
				PreparedStatement pst = conexion.prepareStatement(sql.toString());
				pst.setString(1, dni);

				if (pst.executeUpdate() >= 1) {
					conexion.close();
					return true;
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}

	public boolean update(String dni, String nombre, String apellidos) {

		Connection conexion = openConnection();

		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE ALUMNO ");
		sql.append("SET `NOMBRE` = ?, `APELLIDOS` = ? ");
		sql.append("WHERE DNI = ? ");
		//System.out.println(sql.toString());

		if (conexion != null) {

			try {
				PreparedStatement pst = conexion.prepareStatement(sql.toString());
				pst.setString(1, nombre);
				pst.setString(2, apellidos);
				pst.setString(3, dni);

				if (pst.executeUpdate() >= 1) {
					conexion.close();
					return true;
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}

}
