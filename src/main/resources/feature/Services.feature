@BookingSG

Feature: BookingSG website's services working flow

  Scenario Outline: Service 1
    Given User opens browser and navigate "<service>" with "<url>" and login
    When User should see Booking page of "<service>" and chooses the first time slot
    And User clicks confirm button in Booking page
    And User should see Personal details page and click on Next button
    And User should see Review page and click on Submit button
    And User should see Booking request page in "<service>" with "<booking_status>"
    Then User should see Your bookings page
    And User should see information of booking request in "<service>" with status as "<status>"

    Examples:
      | service   | url                                                                 | status             | booking_status                  |
      | Service_1 | https://www.tst.bookingsg.io/public/services/xYy8abAG/availability? | Pending approval   | Booking request in progress     |
      | Service_2 | https://www.tst.bookingsg.io/public/services/3LywG3yZ/availability? | Pending Acceptance | Booking request in progress     |
      | Service_3 | https://www.tst.bookingsg.io/public/services/wgyb9Qke/availability? | Accepted           | Your booking has been confirmed |
      | Service_4 | https://www.tst.bookingsg.io/public/services/8ayQDNko/availability? | Pending Approval   | Booking request in progress     |
      | Service_5 | https://www.tst.bookingsg.io/public/services/MgyXW0kr/availability? | Accepted           | Your booking has been confirmed |
      | Service_6 | https://www.tst.bookingsg.io/public/services/KmkZMapa/availability? | Pending Acceptance | Booking request in progress     |
