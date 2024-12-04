/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.cibertec.dswii.u02.t07.dswii_u02_t07_servicioswebrest.ws;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.dswii.u02.t07.dswii_u02_t07_servicioswebrest.model.Persona;

/**
 *
 * @author SUITE
 */
@RestController
@RequestMapping("/api/personas")
public class PersonaRestController {

    @GetMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public Persona getPersona() {
        return new Persona("Juan", "Pérez", 28);
    }

    @GetMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public Persona getPersonaXml() {
        return new Persona("Juan", "Pérez", 28);
    }

    @GetMapping(value = "/html", produces = MediaType.TEXT_HTML_VALUE)
    public String getPersonaHtml() {
        Persona persona = new Persona("Juan", "Pérez", 28);
        String html = """
                    <html>
                        <body>
                            <h1> Personas </h1>
                            <p> <strong> Nombre: </strong>  #Nombre </p>
                            <p> <strong> Apellido: </strong>  #Apellido  </p>
                            <p> <strong> Edad: </strong>  #Edad  </p>
                        </body>
                    </html>
                    """;
        return html
                .replace("#Nombre", persona.getNombre())
                .replace("#Apellido", persona.getApellido())
                .replace("#Edad", persona.getEdad().toString());

    }

}
