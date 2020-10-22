package br.ufrgs.inf.fbd.focinhosepresas.controller.query;

import br.ufrgs.inf.fbd.focinhosepresas.entity.Cliente;
import br.ufrgs.inf.fbd.focinhosepresas.model.AvailableStaff;
import br.ufrgs.inf.fbd.focinhosepresas.model.ClienteWIthNoDelivers;
import br.ufrgs.inf.fbd.focinhosepresas.service.QueryService;
import br.ufrgs.inf.fbd.focinhosepresas.view.TotalGasto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/pet_info/")
    public ResponseEntity<?> getPetInfo(@RequestParam("nomePet") String nomePet, @RequestParam("cpf") Long cpf) {
        return this.queryService.getPetInfo(nomePet, cpf);
    }

    @GetMapping("/client_by_pet/")
    public ResponseEntity<List<String>> getClientByPet(@RequestParam("nomeEspecie") String nomeEspecie) {
        return this.queryService.getClientByPet(nomeEspecie);
    }

    @GetMapping("/available_staff/")
    public ResponseEntity<List<AvailableStaff>> getAvailableStaff(@RequestParam("dateTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTime) {
        return this.queryService.getAvailableStaff(dateTime);
    }

    @GetMapping("/clients_with_speding_above_average/")
    public ResponseEntity<List<TotalGasto>> getClienteWithSpendingAboveAverage() {
        return this.queryService.getClienteWithSpendingAboveAverage();
    }

    @GetMapping("/clients_with_no_delivers/")
    public ResponseEntity<List<?>> getClientsWithNoDelivers() {
        return this.queryService.getClientsWithNoDelivers();
    }

    @GetMapping("/pet_appointments_by_client_and_date/")
    public ResponseEntity<?> getPetAppointmentsByClientAndDate() {
        return this.queryService.getPetAppointmentsByClientAndDate();
    }

    @GetMapping("/total_spent_by_client/")
    public ResponseEntity<?> getTotalSpentByClient() {
        return this.queryService.getTotalSpentByClient();
    }

    @GetMapping("/order_info/")
    public ResponseEntity<?> getOrderInfo() {
        return  this.queryService.getOrderInfo();
    }

    @GetMapping("/deliverman_delivers/")
    public ResponseEntity<?> getDelivermanDelivers() {
        return this.queryService.getDelivermanDelivers();
    }

    @GetMapping("/appointments_by_date/")
    public ResponseEntity<?> getAppointmentsByDate() {
        return this.queryService.getAppointmentsByDate();
    }

    @GetMapping("/treatments_by_date/")
    public ResponseEntity<?> getTreatmentsByDate() {
        return this.queryService.getTreatmentsByDate();
    }

    @GetMapping("/delivers_not_delivered/")
    public ResponseEntity<?> getDeliversNotDelivered() {
        return this.queryService.getDeliversNotDelivered();
    }

    @GetMapping("/pet_records/")
    public ResponseEntity<?> getPetRecords() {
        return this.queryService.getPetRecords();
    }
}
