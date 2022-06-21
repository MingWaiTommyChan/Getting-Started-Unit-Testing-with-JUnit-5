package patientintake;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;


class ClinicCalendarShould {
  @Test
  @Tag("DateTime")
   void allowEntryofAnAppointment(){
      ClinicCalendar c = new ClinicCalendar();
      c.addAppointment("Tom","Chan","avery","09/01/1999 3:00 pm");
      List<PatientAppointment> appointments = c.getAppointments();
      assertNotNull(appointments);
      assertEquals(1,appointments.size());
   }

   @Test

    void returnTrueForHasAppointment(){
       ClinicCalendar c = new ClinicCalendar();
       c.addAppointment("Tom","Chan","avery","09/01/1999 3:00 pm");
       List<PatientAppointment> appointments = c.getAppointments();
       assertTrue(c.getAppointments().contains(appointments.get(0)));
   }

}
