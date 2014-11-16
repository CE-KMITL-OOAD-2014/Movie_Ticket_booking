/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import model.pojo.*;

import org.junit.Test;
import static org.junit.Assert.*;
import service.UsersService;

/**
 *
 * @author TRathC
 */
public class UserBookingUnitTest {

    @Test
    public void test() {
        //add user
        Users user1 = new Users("user1", null, null, null, false);
        Users user2 = new Users("user2", null, null, null, false);

        //add Cinema
        Cinema cinema1 = new Cinema(50);
        cinema1.setCinema(1);
        Cinema cinema2 = new Cinema(70);
        cinema2.setCinema(2);

        //add Movie
        Movie movie1 = new Movie("MovieA", null, null, 0, null, null);
        Movie movie2 = new Movie("MovieB", null, null, 0, null, null);

        //add Showtime
        ShowtimeId showtimeid1 = new ShowtimeId("10:00", cinema1.getCinema());
        ShowtimeId showtimeid2 = new ShowtimeId("12:00", cinema2.getCinema());
        Showtime showtime1 = new Showtime(showtimeid1, movie1.getMname());
        Showtime showtime2 = new Showtime(showtimeid2, movie2.getMname());

        //add Seat
        SeatId seatid1 = new SeatId(showtimeid1.getTime(), showtimeid1.getCinema(), "A01");
        SeatId seatid2 = new SeatId(showtimeid1.getTime(), showtimeid1.getCinema(), "A02");
        SeatId seatid3 = new SeatId(showtimeid1.getTime(), showtimeid1.getCinema(), "A03");
        SeatId seatid4 = new SeatId(showtimeid1.getTime(), showtimeid1.getCinema(), "A04");
        SeatId seatid5 = new SeatId(showtimeid2.getTime(), showtimeid2.getCinema(), "B01");
        SeatId seatid6 = new SeatId(showtimeid2.getTime(), showtimeid2.getCinema(), "B02");
        SeatId seatid7 = new SeatId(showtimeid2.getTime(), showtimeid2.getCinema(), "B03");
        SeatId seatid8 = new SeatId(showtimeid2.getTime(), showtimeid2.getCinema(), "B04");
        Seat seat1 = new Seat(seatid1, 1, true);
        Seat seat2 = new Seat(seatid2, 1, true);
        Seat seat3 = new Seat(seatid3, 1, true);
        Seat seat4 = new Seat(seatid4, 1, true);
        Seat seat5 = new Seat(seatid5, 1, true);
        Seat seat6 = new Seat(seatid6, 1, true);
        Seat seat7 = new Seat(seatid7, 1, true);
        Seat seat8 = new Seat(seatid8, 1, true);

        //User1 booking seat1 to seat4
        String seatnameforuser1 = seat1.getId().getSeat() + seat2.getId().getSeat() + seat3.getId().getSeat() + seat4.getId().getSeat();

        //User2 booking seat5 to seat8
        String seatnameforuser2 = seat5.getId().getSeat() + seat6.getId().getSeat() + seat7.getId().getSeat() + seat8.getId().getSeat();

        //generate Code
        Code codeforuser1 = UsersService.generateCode(showtime1, seatnameforuser1);
        Code codeforuser2 = UsersService.generateCode(showtime2, seatnameforuser2);

        //User get code
        user1.setCode(codeforuser1.getCode());
        user2.setCode(codeforuser2.getCode());
        
        //check code with Info
        assertEquals(showtime1.getId().getCinema(), codeforuser1.getCinema());
        assertEquals(showtime1.getMname(), codeforuser1.getMname());
        assertEquals(showtime1.getId().getTime(), codeforuser1.getTime());
        assertEquals(seatnameforuser1, codeforuser1.getSeatname());
        
        assertEquals(showtime2.getId().getCinema(), codeforuser2.getCinema());
        assertEquals(showtime2.getMname(), codeforuser2.getMname());
        assertEquals(showtime2.getId().getTime(), codeforuser2.getTime());
        assertEquals(seatnameforuser2, codeforuser2.getSeatname());
        
        //check usercode with generatecode
        assertEquals(user1.getCode(), codeforuser1.getCode());
        assertEquals(user2.getCode(), codeforuser2.getCode());

    }

}
