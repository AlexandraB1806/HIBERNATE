# HIBERNATE Labs for PJSH

1.Exercise 1 - Entity Definition

Defined:
- the main table, called "COMPANY" using @Table.
COMPANY has fields: COMPANY_ID (PK) -> @Id  and COMPANY_NAME -> @Column;
- and an additional table, called "COMPANY_DETAILS" using @SecondaryTable.
COMPANY_DETAILS has fields: COMPANY_ID (FK) -> @Id and COMPANY_ADDRESS -> @Column;

COMPANY & COMPANY_DETAILS will join based on COMPANY_ID column.

Runned Launcher & tested in the console how these tables look like.


2.Exercise 2 - Identity of Entity Definition (Simple and composite identity for entity)

There are 3 cases:

-> Case 1: Single identity
   --> @Id for the id
   --> @GeneratedValue: the id should be generated automatically! So in the Launcher,
there is no need to set the id manually (otherwise, the behaviour of the annotation
is overriden, making Hibernate believe the entity is already in the database.)

-> Case 2: Composite with identity as separate class (@EmbeddedId)
   --> DepartmentKey = the entity identity: company name + department name <=> PK class
(Composite Primary Key!!!)
   --> DepartmentKey implements Serializable
   --> @EmbeddedId for the id field, of type DepartmentKey

-> Case 3: Composite with identity fields inside the entity class (@IdClass)
   --> DepartmentKey marked with @Embeddable. companyName + departmentName will be
persisted as a part of entity
   --> @IdClass(DepartmentKey.class) on Department_3 => DepartmentKey should be
used as identity for this entity & entity class should contain fields with the same names
as in the class DepartmentKey.
   --> @Id
