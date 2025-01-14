# HIBERNATE Labs for PJSH

                                 Exercise 1 - Entity Definition

Defined:
- the main table, called "COMPANY" using @Table.
COMPANY has fields: COMPANY_ID (PK) -> @Id  and COMPANY_NAME -> @Column;
- and an additional table, called "COMPANY_DETAILS" using @SecondaryTable.
COMPANY_DETAILS has fields: COMPANY_ID (FK) -> @Id and COMPANY_ADDRESS -> @Column;

COMPANY & COMPANY_DETAILS will join based on COMPANY_ID column.

Runned Launcher & tested in the console how these tables look like.


                              Exercise 2 - Identity of Entity Definition
                              (Simple and composite identity for entity)

There are 3 cases:

-> Case 1: Single identity
   - @Id for the id
   - @GeneratedValue: the id should be generated automatically! So in the Launcher,
there is no need to set the id manually (otherwise, the behaviour of the annotation
is overriden, making Hibernate believe the entity is already in the database.)

-> Case 2: Composite with identity as separate class (@EmbeddedId)
   - DepartmentKey = the entity identity: company name + department name <=> PK class
(Composite Primary Key!!!)
   - DepartmentKey implements Serializable
   - @EmbeddedId for the id field, of type DepartmentKey

-> Case 3: Composite with identity fields inside the entity class (@IdClass)
   - DepartmentKey marked with @Embeddable. companyName + departmentName will be
persisted as a part of entity
   - @IdClass(DepartmentKey.class) on Department_3 => DepartmentKey should be
used as identity for this entity & entity class should contain fields with the same names
as in the class DepartmentKey.
   - @Id


                                Exercise 3 - Entities relations definition

There are the following entities:
- Company;
- Department;
- Employee: contains collection of Project objects (Project is not an entity).

Bidirectional:
- Company - Department (1:M)
- Department - Company (M:1)
- Department - Employee (1:M)
- Employee - Department (M:1)

Example4 & Example7 (for ElementCollection) from labguide are useful.


                                    Exercise 4 - Entities class hierarchy
                                    (Map the OO model to relational model)

3 domain objects:
- Customer
- Employee
- Executive

Common parent class: Person (id, name -> to share)

1. Single Table Per Class Hierarchy -> InheritanceType.SINGLE_TABLE
- Example11 for inspo
- Result: Only 1 created table: Person, which has: id (PK), name, salary, bonus,
discount and type (Customer, Employee, Executive) columns; noticed the nullable
ones.

2. Table per Concrete Class Strategy -> InheritanceType.TABLE_PER_CLASS
- Example13 for inspo
- Used @MappedSuperclass - template

3. Joined Subclass Strategy -> InheritanceType.JOINED
- Example12 for inspo