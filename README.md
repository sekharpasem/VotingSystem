# Voting System

Problem Statement :-

Indian Government wants you to create a Java solution for managing the voting on motions once

debate has concluded in the parliament. The system you create must accept votes (For or Against)

on a specified motion and determine whether motion is pass or fail.

Conditions :-

1. No votes can be accepted upon a motion until it is opened for voting.

2. When a motion is closed for voting, a result is returned that describes whether the motion

passed or failed

The number of votes for and against

The time that voting opened and closed

3. A motion cannot be closed for voting less than 15 minutes after it was opened.

4. No voter can vote more than once on the same motion.

5. The maximum votes that can be received on a motion is 51.

6. If voting is a tie, then an attempt to close the motion for voting will cause it to enter a special

&quot;tied&quot; state.

7. In the &quot;tied&quot; state, the speaker of the parliament is the only person allowed to vote. Once the

speaker votes, the motion is automatically closed.

8. The speaker is not allowed to vote except when voting has entered the &quot;tied&quot; state.

9. If the speaker is not available to vote, then voting can be forced to the closed state which causes

the motion to fail.

Implementation Details :-

1. Expose a rest api to start a new motion. Only speaker should have access to start a new motion.

2. Expose a rest api to accept vote of a user (For or Against).

2. Expose a rest api to get the current state of a motion at any time (Not Started, In progress,

Completed, Tied, Void).

3. Expose a rest api to get the results of a motion (The number of votes for and against, and the

time that voting opened and closed).

4. Write unit test cases to validate the above conditions.

Note :-

The solution will be evaluated on following parameters.

Object Oriented Design aspects of the solution.

Overall coding practices.

Working code covering the above conditions.

You must include a brief explanation of your design, restrictions and assumptions in a README

file.
