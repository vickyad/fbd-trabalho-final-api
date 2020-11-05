package br.ufrgs.inf.fbd.focinhosepresas.controller.query;

import br.ufrgs.inf.fbd.focinhosepresas.model.AvailableStaff;
import br.ufrgs.inf.fbd.focinhosepresas.query_model.*;
import br.ufrgs.inf.fbd.focinhosepresas.service.QueryService;
import br.ufrgs.inf.fbd.focinhosepresas.view.TotalGasto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/query/")
public class QueryController {

    private final QueryService queryService;

    @Autowired
    public QueryController(QueryService queryService) {
        this.queryService = queryService;
    }

    @CrossOrigin
    @GetMapping("/pet_info/")
    public ResponseEntity<?> getPetInfo(@RequestParam("nomePet") String nomePet, @RequestParam("cpf") Long cpf) {
        return this.queryService.getPetInfo(nomePet, cpf);
    }

    @CrossOrigin
    @GetMapping("/client_by_pet/")
    public ResponseEntity<List<String>> getClientByPet(@RequestParam("nomeEspecie") String nomeEspecie) {
        return this.queryService.getClientByPet(nomeEspecie);
    }

    @CrossOrigin
    @GetMapping("/available_staff/")
    public ResponseEntity<List<AvailableStaff>> getAvailableStaff(@RequestParam("dateTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTime) {
        return this.queryService.getAvailableStaff(dateTime);
    }

    @CrossOrigin
    @GetMapping("/clients_with_speding_above_average/")
    public ResponseEntity<List<TotalGasto>> getClienteWithSpendingAboveAverage() {
        return this.queryService.getClienteWithSpendingAboveAverage();
    }

    @CrossOrigin
    @GetMapping("/clients_with_no_delivers/")
    public ResponseEntity<List<?>> getClientsWithNoDelivers() {
        return this.queryService.getClientsWithNoDelivers();
    }

    @CrossOrigin
    @GetMapping("/pet_appointments_by_client_and_date/")
    public ResponseEntity<?> getPetAppointmentsByClientAndDate(
            @RequestParam("cpf") Long cpf,
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return this.queryService.getPetAppointmentsByClientAndDate(cpf, date);
    }

    @CrossOrigin
    @GetMapping("/total_spent_by_client/")
    public ResponseEntity<List<TotalSpentByClient>> getTotalSpentByClient() {
        return this.queryService.getTotalSpentByClient();
    }

    @CrossOrigin
    @GetMapping("/order_info/")
    public ResponseEntity<List<OrderInfo>> getOrderInfo(@RequestParam("nroPedido") Long nroPedido) {
        return  this.queryService.getOrderInfo(nroPedido);
    }

    @CrossOrigin
    @GetMapping("/deliverman_delivers/")
    public ResponseEntity<List<DelivermanDelivers>> getDelivermanDelivers(@RequestParam("cpfFuncionario") Long cpfFuncionario) {
        return this.queryService.getDelivermanDelivers(cpfFuncionario);
    }

    @CrossOrigin
    @GetMapping("/appointments_by_date/")
    public ResponseEntity<List<AppointmentsByDate>> getAppointmentsByDate(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return this.queryService.getAppointmentsByDate(date);
    }

    @CrossOrigin
    @GetMapping("/treatments_by_date/")
    public ResponseEntity<List<TreatmentsByDate>> getTreatmentsByDate(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return this.queryService.getTreatmentsByDate(date);
    }

    @CrossOrigin
    @GetMapping("/delivers_not_delivered/")
    public ResponseEntity<List<DeliverNotDelivered>> getDeliversNotDelivered() {
        return this.queryService.getDeliversNotDelivered();
    }

    @CrossOrigin
    @GetMapping("/pet_records/")
    public ResponseEntity<List<PetRecords>> getPetRecords(@RequestParam("nomePet") String nomePet, @RequestParam("cpf") Long cpf) {
        return this.queryService.getPetRecords(nomePet, cpf);
    }
}
