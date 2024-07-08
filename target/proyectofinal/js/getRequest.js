console.log("Entró a GetRequest");

document.addEventListener("DOMContentLoaded", function() {
    const movieSection = document.getElementById("clientes");

    function loadClienteList() {
        console.log("Entró a loadClienteList");
        fetch("/proyectofinal/clientes?action=getAll")
            .then(response => response.json())
            .then(data => {
                console.log("data: ", data);
                
                movieSection.querySelector("tbody").innerHTML = "";
                
                
                data.forEach(cliente => {
                    movieSection.querySelector("tbody").innerHTML += `
                        <tr>
                            <td>${cliente.id_usuario}</td>
                            <td>${cliente.activo}</td>
                            <td>${cliente.nombre}</td>
                            <td>${cliente.apellido}</td>
                            <td>${cliente.dni}</td>
                            <td>${cliente.fecha_de_nacimiento}</td>
                            <td>${cliente.telefono}</td>
                            <td>${cliente.domicilio}</td>
                            <td>${cliente.localidad}</td>
                            <td>${cliente.cp}</td>
                            <td>${cliente.email}</td>
                            <td>${cliente.password}</td>
                            <td>${cliente.password2}</td>
                            <td>${cliente.rol}</td>
                        </tr>
                    `;
                });
            })
            .catch(error => {
                console.error("Error fetching client data:", error);
            });
    }

    loadClienteList();
});
