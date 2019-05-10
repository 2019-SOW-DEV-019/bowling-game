<H1>The Bowling Game</H1>

Upon receiving a valid sequence of rolls [American Ten-Pin Bowling], this class will calculate the total score for the game.

<H4>Rules Of The Game:</H4>

<OL>
<LI>Each game, or "line" of bowling, includes ten turns, or "frames" for the bowler.</LI>
<LI>In each frame, the bowler gets up to two tries to knock down all the pins.</LI>
<LI>If in two tries, he fails to knock them all down, his score for that frame is the total number of pins knocked down in his two tries.</LI>
<LI>If in two tries he knocks them all down, this is called a "spare" and his score for the frame is ten plus the number of pins knocked down on his next throw (in his next turn).</LI>
<LI>If on his first try in the frame he knocks down all the pins, this is called a "strike". His turn is over, and his score for the frame is ten plus the simple total of the pins knocked down in his next two rolls.</LI>
<LI>If he gets a spare or strike in the last (tenth) frame, the bowler gets to throw one or two more bonus balls, respectively. These bonus throws are taken as part of the same turn. If the bonus throws knock down all the pins, the process does not repeat: the bonus throws are only used to calculate the score of the final frame.</LI>
<LI>The game score is the total of all frame scores.</LI>
</OL>

<H5>Examples:</H5>
<UL>
<LI>X X X X X X X X X X X X (12 rolls: 12 strikes) = 10 frames * 30 points = 300</LI>
<LI>9- 9- 9- 9- 9- 9- 9- 9- 9- 9- (20 rolls: 10 pairs of 9 and miss) = 10 frames * 9 points = 90</LI>
<LI>5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/5 (21 rolls: 10 pairs of 5 and spare, with a final 5) = 10 frames * 15 points = 150</LI>
</UL>

<H6>Assumptions:</H6>

<UL>
<LI>We will not check for valid rolls.</LI>
<LI>We will not check for correct number of rolls and frames.</LI>
<LI>We will not provide scores for intermediate frames.</LI>
</UL>


<H3>Steps to compile the project</H3>

<UL>
<LI>Check out the project from GIT.</LI>
<LI>Do Maven Clean Install the project.</LI>
<LI>Run the main class GameRunner.java</LI>
<LI>Enter the rolls to calculate the BowlingGame Score.</LI>
<LI>Open the file <B>"index.html"</B> in the path "/target/site/jacoco/com.kata.bowling/" in browser, to view the test coverage</LI>
</UL>
