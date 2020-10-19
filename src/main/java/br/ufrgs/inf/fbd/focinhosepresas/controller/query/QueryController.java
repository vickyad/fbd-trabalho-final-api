package br.ufrgs.inf.fbd.focinhosepresas.controller.query;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/query/")
public class QueryController {

    @GetMapping("/pet_info/")
    public ResponseEntity<String> getPetInfo() {
        return new ResponseEntity<>("pet_info", HttpStatus.OK);
    }

    @GetMapping("/client_by_pet/")
    public ResponseEntity<String> getClientByPet() {
        return new ResponseEntity<>("client_by_pet", HttpStatus.OK);
    }

    @GetMapping("/available_staff/")
    public ResponseEntity<String> getAvailableStaff() {
        return new ResponseEntity<>("available_staff", HttpStatus.OK);
    }

    @GetMapping("/clients_with_speding_above_average/")
    public ResponseEntity<String> getClienteWithSpendingAboveAverage() {
        return new ResponseEntity<>("clients_with_speding_above_average", HttpStatus.OK);
    }

    @GetMapping("/clients_with_no_delivers/")
    public ResponseEntity<String> getClientsWithNoDelivers() {
        return new ResponseEntity<>("clients_with_no_delivers", HttpStatus.OK);
    }

    @GetMapping("/pet_appointments_by_client_and_date/")
    public ResponseEntity<String> getPetAppointmentsByClientAndDate() {
        return new ResponseEntity<>("pet_appointments_by_client_and_date", HttpStatus.OK);
    }

    @GetMapping("/total_spent_by_client/")
    public ResponseEntity<String> getTotalSpentByClient() {
        return new ResponseEntity<>("total_spent_by_client", HttpStatus.OK);
    }

    @GetMapping("/order_info/")
    public ResponseEntity<String> getOrderInfo() {
        return new ResponseEntity<>("order_info", HttpStatus.OK);
    }

    @GetMapping("/deliverman_delivers/")
    public ResponseEntity<String> getDelivermanDelivers() {
        return new ResponseEntity<>("deliverman_delivers", HttpStatus.OK);
    }

    @GetMapping("/appointments_by_date/")
    public ResponseEntity<String> getAppointmentsByDate() {
        return new ResponseEntity<>("appointments_by_date", HttpStatus.OK);
    }

    @GetMapping("/treatments_by_date/")
    public ResponseEntity<String> getTreatmentsByDate() {
        return new ResponseEntity<>("treatments_by_date", HttpStatus.OK);
    }

    @GetMapping("/delivers_not_delivered/")
    public ResponseEntity<String> getDeliversNotDelivered() {
        return new ResponseEntity<>("delivers_not_delivered", HttpStatus.OK);
    }

    @GetMapping("/pet_records/")
    public ResponseEntity<String> getPetRecords() {
        return new ResponseEntity<>("pet_records", HttpStatus.OK);
    }
}
