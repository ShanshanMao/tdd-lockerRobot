package com.tw.tdd.lockerRobot;

import com.tw.tdd.lockerRobot.Bag.Bag;
import com.tw.tdd.lockerRobot.Bag.sSizeBag;
import com.tw.tdd.lockerRobot.Exception.NoRoomException;
import com.tw.tdd.lockerRobot.Locker.sSizeLocker;
import com.tw.tdd.lockerRobot.Ticket.sSizeTicket;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LockerRobotTest {

    @Test
    void should_store_ordinary_user_sSizeBag_in_sSizeLocker_and_return_sSizeTicket_when_xiaoying_store_bag_given_sSizeLocker_have_capacity() {
        Bag bag = new sSizeBag();
        sSizeLocker xiaoying = new sSizeLocker(1);
        sSizeTicket ticket = (sSizeTicket) xiaoying.store(bag);
        assertNotNull(ticket);
    }

    @Test
    void should_store_ordinary_user_sSizeBag_in_sSizeLocker_fail_when_xiaoying_store_bag_given_sSizeLocker_is_full() {
        Bag bag = new sSizeBag();
        sSizeLocker xiaoying = new sSizeLocker(1);
        xiaoying.store(bag);

        assertThrows(NoRoomException.class, () -> xiaoying.store(bag));
    }

    @Test
    void should_pick_up_ordinary_user_sSizeBag_in_sSizeLocker_success_when_xiaoying_pick_up_bag_given_valid_sSizeTicket() {
        Bag bag = new sSizeBag();
        sSizeLocker xiaoying = new sSizeLocker(1);
        sSizeTicket ticket = xiaoying.store(bag);

        Bag returnBag = xiaoying.pickUp(ticket);
        assertEquals(bag, returnBag);
    }
}
