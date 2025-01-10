# HIBERNATE Labs for PJSH

* Exercise 1 - Entity Definition

Defined:
- the main table, called "COMPANY" using @Table.
COMPANY has fields: COMPANY_ID (PK) -> @Id  and COMPANY_NAME -> @Column;
- and an additional table, called "COMPANY_DETAILS" using @SecondaryTable.
COMPANY_DETAILS has fields: COMPANY_ID (FK) -> @Id and COMPANY_ADDRESS -> @Column;

COMPANY & COMPANY_DETAILS will join based on COMPANY_ID column.

Runned Launcher & tested in the console how these tables look like.
