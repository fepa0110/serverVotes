const assert = require('assert');
const { Given, When, Then } = require('cucumber');
const request = require('sync-request');
const jsondiff = require('json-diff');
const deleteKey = require('key-del');

const urlServer = 'http://server:8080/labprog-server/rest';

//*PASSED
Given('los pedidos generados', function(pedidosGenerados) {
   //return true;
   try {
      let res = request('GET', urlServer + '/pedidosFabricacion');

      let response = JSON.parse(res.getBody());    //Json leido del servlet
      let pedidos = JSON.parse(pedidosGenerados);  //Json leido del Feature

      //console.log(response.data);

      response.data.pedidosParaPlanificar.forEach((item) =>{
            delete item.cliente.cuit;
            delete item.producto.tareas;
            delete item.ordenTrabajos;
            if (item.estado === "GENERADO") {
               item.estado = {"id": 1, "nombre": "GENERADO"};
            }
         }
      );
      //console.log(response.data);

      if (response.StatusCode == 200) {
         return assert.equal(undefined, jsondiff.diff(response.data, pedidos));
      } else {
         return assert.fail(response.StatusText);
      }

   } catch (error) {
      return assert.fail(error.message);
   }
});

//*PASSED
Given('el siguiente conjunto de talleres con su layout', function (talleres) {
   try {
      let res = request('GET', urlServer + '/talleres/all');

      let response = JSON.parse(res.getBody());    //Json leido del servlet
      let talleresEsperados = JSON.parse(talleres);          //Json leido del Feature

      response.data.talleres.forEach((item) => {   //Por cada taller
            item.equipos.sort(function(a,b){       //Ordeno los equipos
               return a.id - b.id;                 //En forma ascendente
            });
            item.equipos.forEach((equipo) => {
               delete equipo.planificaciones;
            });
         }
      );

      if (response.StatusCode == 200) {
         return assert.equal(undefined, jsondiff.diff(response.data, talleresEsperados));
      } else {
         return assert.fail(response.StatusText);
      }

   } catch (error) {
      return assert.fail(error.message);
   }
});

//!PENDING
When('se solicita planificar todos los pedidos generados a partir de la fecha {string}', function (fechaPedido) {
   return true; // <-- UPS... Este se decidio no usarlo por el momento..
   // Write code here that turns the phrase above into concrete actions
   return 'pending';
});

//!PENDING
Then('se obtiene la siguiente respuesta', function (respuestaEsperada) {
   return true; // <-- UPS... Este se decidio no usarlo por el momento..
   // Write code here that turns the phrase above into concrete actions
   return 'pending';
});