// Cargar de manera automatica los datos registrados en usuarios
function loadTableUser() {
  $.ajax({
    url: "http://localhost:9000/api/usuarios",
    method: "GET",
    headers: {
      "Content-Type": "application/json",
    },
  }).done(function (items) {
    var registros = `<option value="">--seleccionar--</option>`;
    items.forEach(function (item, index, array) {
      registros +=
        `<option value="` +
        item.id +
        `">` +
        item.nombre +
        " " +
        item.apellido +
        `</option>`;
    });
    $("#idUser").html(registros);
  });
}

function loadTableService() {
  $.ajax({
    url: "http://localhost:9000/api/servicios",
    method: "GET",
    headers: {
      "Content-Type": "application/json",
    },
  }).done(function (items) {
    var registros = `<option value="">--seleccionar--</option>`;
    items.forEach(function (item, index, array) {
      registros +=
        `<option value="` + item.id + `">` + item.descripcion + `</option>`;
    });
    $("#idServicio").html(registros);
  });
}

function loadTableTipoPago() {
  $.ajax({
    url: "http://localhost:9000/api/tiposPagos",
    method: "GET",
    headers: {
      "Content-Type": "application/json",
    },
  }).done(function (items) {
    var registros = `<option value="">--seleccionar--</option>`;
    items.forEach(function (item, index, array) {
      registros +=
        `<option value="` + item.id + `">` + item.descripcion + `</option>`;
    });
    $("#idPago").html(registros);
  });
}

// Cargar de manera automatica los datos registrados
function loadTable() {
  $.ajax({
    url: "http://localhost:9000/api/agendamientos",
    method: "GET",
    headers: {
      "Content-Type": "application/json",
    },
  }).done(function (items) {
    var registros = "";
    items.forEach(function (item, index, array) {
      registros +=
        `<tr>
          <td>` +
        item.fecha +
        `</td>
          <td>` +
        item.hora +
        `</td>
          <td>` +
        item.usuarioId.nombre +
        `</td>
          <td>` +
        item.serviciosId.descripcion +
        `</td>
            <td>` +
        item.tipoPago.descripcion +
        `</td>
          <td>
            <svg
              xmlns="http://www.w3.org/2000/svg"
              width="16"
              height="16"
              fill="currentColor"
              class="bi bi-pencil-fill"
              viewBox="0 0 16 16"
              onclick="findById(` +
        item.id +
        `)"
             >
          <path
            d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708l-3-3zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207l6.5-6.5zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.499.499 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11l.178-.178z"
          />
        </svg>
            <svg
              xmlns="http://www.w3.org/2000/svg"
              width="16"
              height="16"
              fill="currentColor"
              class="bi bi-trash-fill"
              viewBox="0 0 16 16"
              style="margin-right: 5%"  onclick="Eliminar(` +
        item.id +
        `)">
             
              <path
                d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 1 0z"
              />
            </svg>
          </td>
        </tr>`;
    });
    $("#dataResult").html(registros);
    Limpiar();
  });
}

// Busqueda por id
function findById(id) {
  $.ajax({
    url: "http://localhost:9000/api/agendamientos/" + id,
    method: "GET",
    headers: {
      "Content-Type": "application/json",
    },
  }).done(function (item) {
    $("#id").val(item.id);
    $("#dateAgendamiento").val(item.fecha);
    $("#timeAgendamiento").val(item.hora);
    $("#idUser").val(item.usuarioId.id);
    $("#idServicio").val(item.serviciosId.id);
    $("#idPago").val(item.tipoPago.id);
  });
}

//Accion de adicionar un registro
function Agregar() {
  $.ajax({
    url: "http://localhost:9000/api/agendamientos",
    data: JSON.stringify({
      fecha: $("#dateAgendamiento").val(),
      hora: $("#timeAgendamiento").val(),
      usuarioId: {
        id: $("#idUser").val(),
      },
      serviciosId: {
        id: $("#idServicio").val(),
      },
      tipoPago: {
        id: $("#idPago").val(),
      },
    }),
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
  }).done(function (result) {
    loadTable();
  });
}

//Modificar
function Modificar() {
  $.ajax({
    url:
      "http:////localhost:9000/api/agendamientos/" + parseInt($("#id").val()),
    data: JSON.stringify({
      fecha: $("#dateAgendamiento").val(),
      hora: $("#timeAgendamiento").val(),
      usuarioId: {
        id: $("#idUser").val(),
      },
      serviciosId: {
        id: $("#idServicio").val(),
      },
      tipoPago: {
        id: $("#idPago").val(),
      },
    }),
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
    },
  }).done(function (result) {
    loadTable();
  });
}

// eliminar
function Eliminar(id) {
  $.ajax({
    url: "http:////localhost:9000/api/agendamientos/" + id,
    method: "DELETE",
    headers: {
      "Content-Type": "application/json",
    },
  }).done(function (result) {
    loadTable();
  });
}

//limpiar
function Limpiar() {
  $("#dateAgendamiento").val("");
  $("#timeAgendamiento").val("");
  $("#idUser").val("");
  $("#idServicio").val("");
  $("#idPago").val("");
}
