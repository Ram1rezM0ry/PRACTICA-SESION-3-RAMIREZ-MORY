/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paquete;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import javax.servlet.annotation.WebServlet;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener los parámetros del formulario
        String nombre = request.getParameter("nombre");
        String apellidoPaterno = request.getParameter("apellidoPaterno");
        String apellidoMaterno = request.getParameter("apellidoMaterno");
        String fechaNacimiento = request.getParameter("fechaNacimiento");
        String lugarResidencia = request.getParameter("lugarResidencia");
        String telefono = request.getParameter("telefono");
        String email = request.getParameter("email");

        // Calcular la edad
        LocalDate birthDate = LocalDate.parse(fechaNacimiento);
        LocalDate today = LocalDate.now();
        int edad = Period.between(birthDate, today).getYears();

        // Guardar los datos en el request para pasarlos a la página de éxito
        request.setAttribute("nombre", nombre);
        request.setAttribute("apellidoPaterno", apellidoPaterno);
        request.setAttribute("apellidoMaterno", apellidoMaterno);
        request.setAttribute("fechaNacimiento", fechaNacimiento);
        request.setAttribute("lugarResidencia", lugarResidencia);
        request.setAttribute("telefono", telefono);
        request.setAttribute("email", email);
        request.setAttribute("edad", edad);

        // Redirigir a la página de éxito
        RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
        dispatcher.forward(request, response);
    }
}
