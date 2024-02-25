
  Feature: Bears order form

    Scenario: complete bears form
      Given user is on bear webpage
      When user enters username
      And user enters password
      And user click on login button
      And user click on Order
      And user select familyAlbum from product
      And user select quantity 2
      And user click calculate button
      And user fill address information
      And user click on "visa" radio button
      And user put cardnumber
      And user click on Progress
      Then user should see success message “New order has been successfully added.”