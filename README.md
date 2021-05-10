# DBMS-schedule-serializability
Advanced DBMS course project

In this project I checked the given schedule is serializable or not.
Different types of serializability checked: result, conflict, view

# Subject Literal

## Serial Schedule

It's a schedule in which transactions are aligned in such a way that one transaction
is executed first. When the first transaction completes its cycle, then the next
transaction is executed. Transactions are ordered one after the other. This type
of schedule is called a serial schedule, as transactions are executed in a
serial manner

## Result Equivalent Schedules

If two schedules produce the same database state after execution, they are said to be
result equivalent.

## Result Serializability

If a schedule is result equivalent with its serial schedule,
The schedule is a result serializable.

## Conflicting Operations

Two operations are said to be conflicting if all below conditions satisfy:

- They belong to different transactions
- They operate on the same data item
- At least one of them is a write operation

## Conflict Serializability

A schedule is called conflict serializable if it can be transformed into
its serial schedule by swapping non-conflicting operations.

## View Serializability

TODO complete this section

# The Implemented Algorithms

## Result Serializability

I just execute the schedule and its serial schedule.
A schedule execution leaves the database in a resulting state.
If the result states are the same, the schedule is a result serializable.

## Conflict Serializability

In the schedule, we have some conflicting operations that their order can't
be changed. So we can get a graph that the operations are its nodes and the edges
represent that the source node of the graph can't be after the destination node
(they are conflicting operations and the source node are before the destination node
in the schedule).
This graph is called the conflict precedence graph. If the conflict precedence graph
of the schedule is the same as the conflict precedence graph of its serial schedule,
the schedule can be converted to its serial schedule by swapping the non-conflicting
operations. So The schedule is conflict serializable.

## View Serializability

TODO complete this section
