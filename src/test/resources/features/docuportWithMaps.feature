Feature: Homework day 16
@t1
  Scenario: create login for docuport and locate elements
    Given user is on login page
    When user enter credentials
  |client|
  |advisor|
  |supervisor|
  |employee  |

@t2
  Scenario: validate left navigate options of docuport for all types of users

 #   Then user validates all accessible fields on the left panel for his usertype
 # |client     | Home| Received docs| My uploads| Invitations |             |           |           |               |               |               |
 # |employee   | Home| Received docs| My uploads| Clients     | Users      | Bookkeeping|1099 Form  |Reconciliations|               |               |
 # |supervisor | Home| Received docs| My uploads| Clients     | Users      | Leads      |Bookkeeping|1099 Form      |Reconciliations|               |
 # |advisor    | Home| Received docs| My uploads| Clients     | Invitations| Users      |Leads      |Bookkeeping    |1099 Form      |Reconciliations|
  Then user validates all accessible fields on the left panel for his usertype
    |client     | Home, Received docs, My uploads, Invitations, 1099 Form                                                     |
    |employee   | Home, Received docs, My uploads, Clients, Users, Bookkeeping, 1099 Form, Reconciliations                    |
    |supervisor | Home, Received docs, My uploads, Clients, Users, Leads, Bookkeeping, 1099 Form, Reconciliations             |
    |advisor    | Home, Received docs, My uploads, Clients, Invitations, Users, Leads, Bookkeeping, 1099 Form, Reconciliations|
