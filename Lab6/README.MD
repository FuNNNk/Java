In main am apelat clasa MainFrame si am facut-o vizibila folosind setVisible
In clasa MainFrame construiesc cele 3 JPanel-uri denumite corespunzator, in constructor punem numele aplicatiei si apoi apelam functia init. In aceasta cream componentele MainFrameului si apoi le adaugam pe fiecare intr-un loc anume (BorderLayout.Center/South/North). Folosim apoi functia pack pentru a le aseza pe fiecare la locul respectiv.
In ConfigPanel este meniul in care scriem numarul de laturi a polygonului(default 6)./*colorcombo*/
In ControlPanel am construit toate butoanele care vor face anumite actiuni cu canvasul respectiv.
Deoarece era scris in indicatii frame.setLayout(new GridLayout(1,4)), la afisare frameul respectiv nu afisa ceea ce imi doream, asa ca am scos frame, pentru a se apela setLayout doar pentru clasa ControlPanel. Cand apasam pe butonul save, acesta apeleaza functia save(this::save) care apoi salveaza imaginea desenata./*celelalte butoane*/
In DrawingPanel am facut un rand pentru a fi afisat o singura culoare si un singur radius de fiecare data cand e apelata functia drawshape din init.
Clasa RegularPolygon este cea aflare a poligonului, apelata in drawShape.

Cum am spus, am avut batai de cap cu frame.setLayout(new GridLayout(1,4)), dar mi-am dat seama cum afecta aceasta codul si am rezolvat-o repede. De asemenea, am avut probleme cu folosirea JComboBox.