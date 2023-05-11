package com.my.company.recursion;

/**
 * See TowersOfHanoi.png
 *
 * <p>Many, many years ago, in a distant part of the Orient—in the Vietnamese city of Hanoi—the
 * emper- or’s wiseperson passed on to join his ancestors. The emperor needed a replacement
 * wiseperson. Being a rather wise person himself, the emperor devised a puzzle, declaring that its
 * solver could have the job of wiseperson.
 *
 * <p>The puzzle consists of n disks (we don’t know exactly how many) and three poles: A (the
 * source), B (the destination), and C (the spare). The disks were of different sizes and had holes
 * in the middle so that they could fit on the poles. Because of their great weight, the disks could
 * be placed only on top of disks larger than themselves. Initially, all the disks were on pole A,
 * as shown in TowersOfHanoi.png scenario-a. The puzzle was to move the disks, one by one, from pole
 * A to pole B. A person could also use pole C in the course of the transfer, but again a disk could
 * be placed only on top of a disk larger than itself.
 *
 * <p>As the position of wiseperson was generally known to be a soft job, there were many
 * applicants. Scholars and peasants alike brought the emperor their solutions. Many solutions were
 * thousands of steps long, and many contained deeply nested loops and control structures. “I can’t
 * understand these solutions,” bellowed the emperor. “There must be an easy way to solve this
 * puzzle.”
 *
 * <p>And indeed there was. A great Buddhist monk came out of the mountains to see the emperor. “My
 * son,” he said, “the puzzle is so easy, it almost solves itself.” The emperor’s security chief
 * wanted to throw this strange person out, but the emperor let him continue.
 *
 * <p>“If you have only one disk (that is, n = 1), move it from pole A to pole B.” So far, so good,
 * but even the village idiot could get that part right. “If you have more than one disk (that is, n
 * > 1), simply 1. Ignore the bottom disk and solve the problem for n – 1 disks, with the small
 * modification that pole C is the destination and pole B is the spare. (See TowersOfHanoi.png
 * scenario b) 2. After you have done this, n – 1 disks will be on pole C, and the largest disk will
 * remain on pole A. So solve the problem for n = 1 (recall that even the village idiot could do
 * this) by moving the large disk from A to B. (See TowersOfHanoi.png scenario-c.) 3. Now all you
 * have to do is move the n – 1 disks from pole C to pole B ; that is, solve the problem with pole C
 * as the source, pole B as the destination, and pole A as the spare.” (See TowersOfHanoi.png
 * scenario-d.)
 *
 * <p>There was silence for a few moments, and finally the emperor said impatiently, “Well, are you
 * going to tell us your solution or not?” The monk simply gave an all-knowing smile and vanished.
 * The emperor obviously was not a recursive thinker, but you should realize that the monk’s
 * solution is perfectly correct. The key to the solution is the observation that you can solve the
 * Towers problem of n disks by solving three smaller—in the sense of number of disks —Towers
 * problems.
 *
 * <p>Let towers(count, source, destination, spare) denote the problem of moving count disks from
 * pole source to pole destination , using pole spare as a spare. Notice that this definition makes
 * sense even if there are more than count disks on pole source ; in this case, you concern yourself
 * with only the top count disks and ignore the others. Similarly, the poles destination and spare
 * might have disks on them before you begin; you ignore these, too, except that you may place only
 * smaller disks on top of them. You can restate the emperor’s problem as follows: Beginning with n
 * disks on pole A and zero disks on poles B and C, solve towers(n, A, B, C) . You can state the
 * monk’s solution as follows:
 *
 * <p>Step 1. Starting in the initial state—with all the disks on pole A—solve the problem towers(n
 * - 1, A, C, B) That is, ignore the bottom (largest) disk and move the top n – 1 disks from pole A
 * to pole C, using pole B as a spare. When you are finished, the largest disk will remain on pole
 * A, and all the other disks will be on pole C.
 *
 * <p>Step 2. Now, with the largest disk on pole A and all others on pole C, solve the problem
 * towers(1, A, B, C) That is, move the largest disk from pole A to pole B. Because this disk is
 * larger than the disks already on the spare pole C, you really could not use the spare. However,
 * fortunately—and obviously—you do not need to use the spare in this base case. When you are done,
 * the largest disk will be on pole B, and all other disks will remain on pole C.
 *
 * <p>Step 3. Finally, with the largest disk on pole B and all the other disks on pole C, solve the
 * problem towers(n - 1, C, B, A) That is, move the n – 1 disks from pole C to pole B, using A as a
 * spare. Notice that the destina- tion pole B already has the largest disk, which you ignore. When
 * you are done, you will have solved the original problem: All the disks will be on pole B.
 */
public class TowersOfHanoi {
    public static void main(String[] args) {
        solveTowers(3, "A", "B", "C");
    }

    /*
     * A - source
     * B - destination
     * C - spare
     */
    public static void solveTowers(int count, String source, String destination, String spare) {
        if (count == 1) {
            System.out.println("The top disc is moved from pole " + source + " to pole " + destination);
        } else {
            solveTowers(count - 1, source, spare, destination);
            solveTowers(1, source, destination, spare);
            solveTowers(count - 1, spare, destination, source);
        }
    }
}
