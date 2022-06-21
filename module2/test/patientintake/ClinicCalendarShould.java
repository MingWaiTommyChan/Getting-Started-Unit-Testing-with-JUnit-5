package patientintake;

import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class ClinicCalendarShould {
   private ClinicCalendar calendar;
   private static int counter;

   @BeforeAll
   static void initAll(){
      System.out.println("Before All");
      counter = 0;
   }

   @BeforeEach
   void init(){
      System.out.println("Before Each");
      calendar = new ClinicCalendar(LocalDate.now());
   }

   @Test
   void allowEntryOfAnAppointment() {
      calendar.addAppointment("Jim", "Weaver", "avery",
         "09/01/2018 2:00 pm");
      List<PatientAppointment> appointments = calendar.getAppointments();
      assertNotNull(appointments);
      assertEquals(1, appointments.size());
      PatientAppointment enteredAppt = appointments.get(0);
      assertEquals("Jim", enteredAppt.getPatientFirstName());
      assertEquals("Weaver", enteredAppt.getPatientLastName());
      assertEquals(Doctor.avery, enteredAppt.getDoctor());
      assertEquals("9/1/2018 02:00 PM",
         enteredAppt.getAppointmentDateTime().format(DateTimeFormatter.ofPattern("M/d/yyyy hh:mm a", Locale.US)));
   }

   @Test
   void returnTrueForHasAppointments(){
      calendar.addAppointment("Jim", "Weaver", "avery",
              "09/01/2018 2:00 pm");
      calendar.addAppointment("Jimmy", "Weaver", "avery",
              "06/15/2022 2:00 pm");
      assertTrue(calendar.hasAppointment(LocalDate.of(2018,9,1)));

   }

   @Test
   void returnTrueForTodayAppointments(){
      calendar.addAppointment("Jim", "Weaver", "avery",
              "06/15/2022 2:00 pm");
      calendar.addAppointment("Jimmy", "Weaver", "avery",
              "06/15/2022 2:00 pm");
      assertIterableEquals(calendar.getAppointments(), calendar.getTodayAppointments());
   }

   @AfterEach
   void cleanEach(){
      counter++;
      System.out.println("After Each "+counter+" Test done");
   }

   @AfterAll
   static void cleanAll(){
      System.out.println("After All "+counter );
   }

}
