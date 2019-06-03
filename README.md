# BoulderDash Project
Bastien DUPONT | Clément ALBOS
22/05/2019
---
Jave/POO/UML Project

<p>&nbsp;</p>
<h2 style="text-align: center;">1. Project presentation</h2>
<p><img style="margin: 50px 300px 50px 300px;" src="http://image.noelshack.com/fichiers/2017/25/7/1498399249-capture.png" alt="" width="441" height="193" align="middle" /></p>
<p>The objective of this project was to remake an old video game called BoulderDash.</p>
<p>Its goal is to pick up a given number of diamonds on the map to open the exit door, allowing us to access the next level.</p>
<p>The character has to dig through the dirt to make his way, but he must be careful not to be touched by an enemy nor crushed by a rock or a diamond which can fall if they're not supported by some dirt beneath them.</p>
<p>Turns out some of the levels happen not to have any diamonds, so the players has to generate some by crushing an enemy with a rock.</p>
<p><span class="short_text" lang="en"><span class="">We had to create 5 differents levels which can be changed in the the code and are saved in a database.</span></span></p>
<p>&nbsp;</p>

---

<h2 style="text-align: center;">2. UML</h2>
<p>We also had to make the uml of the project.</p>
<p>UML is a modeling language which allows the program to be represented in a codified graphic way.</p>
<p>Here is the component diagram of the program :</p>
<p><img style="margin-right: 250px; margin-left: 250px;" src="http://image.noelshack.com/fichiers/2017/25/7/1498405233-component.png" alt="" width="566" height="302" /></p>
<p>The contracts' class diagram</p> <p><img src="http://image.noelshack.com/fichiers/2017/25/7/1498422956-uml-contract.png" alt="" width="1104" height="568" /></p>
<p>The view class diagram :</p>
<p><img style="margin-right: 100px; margin-left: 100px;" src="http://image.noelshack.com/fichiers/2017/25/7/1498405348-view.png" alt="" width="878" height="544" /></p>
<p>The model class diagrams :</p>
<p><img src="http://image.noelshack.com/fichiers/2017/25/7/1498405811-model1.png" alt="" width="1048" height="497" /></p>
<p><img src="http://image.noelshack.com/fichiers/2017/25/7/1498405811-model2.png" alt="" width="1051" height="643" /></p>
<p>The controller class diagram :</p>
<p><img style="margin-right: 100px; margin-left: 100px;" src="http://image.noelshack.com/fichiers/2017/25/7/1498407931-controller.png" alt="" width="849" height="384" /></p>
<p>&nbsp;</p>

---

<h2 style="text-align: center;">3.MVC architecture</h2>
<h3>3.1 Model</h3>
<p>The model is the central part of the system, it contains all the informations needed for the game: the timer, the score the objective and obviously all the elements which constitute the map. Its sole purpose is to store the data so they can be read and displayed by the view and modified by the controller</p>
<p>&nbsp;</p>
<h3>3.2 Controller</h3>
<p>The controller represents the game engine, it creates the model as well as the view, and provides a Human-Computer Interface.</p>
<p>It carries out the users movements, awaiting a key pressed and sent to him by the view, then interact with the model to "tell it" what it needs to move, or to do, and finaly, orders the enemies to move and the rocks and diamond to fall.</p>
<p>&nbsp;</p>
<h3>3.3 View</h3>
<p>&nbsp;The view is the display of the game. It have to reads the model. The package view contain only one class (ViewFacade) whcih create a window, display the sprites and update itself when the model change.</p>
<h3>3.4 Database</h3>
<p>The database stores all the information needed to load the level: it contains the height and width of the map as well as the number of diamonds needed to complete the level and of course the map itself as a string a character</p>
<p>&nbsp;</p>
<h3>3.5 Contract</h3>
<p>The contract makes it possible to link all the other packets between them and thus to make them work together, it is him who regroups all the interfaces of each of the parts, and each part calls upon him if necessary, we defined and finished it first Which allowed us to work on our own to finish this project</p>

---

<h2 style="text-align: center;">4. Bilan</h2>
<p>&nbsp;The project was a fun challenge to take up. Without too much difficulty we were able to practice java in a fun way.</p>