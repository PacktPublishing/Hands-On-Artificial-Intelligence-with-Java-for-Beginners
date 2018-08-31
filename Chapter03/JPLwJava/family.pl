child(michael, vito).
child(sonny, vito).
child(fredo, vito).
child(anthony, michael).
child(mary, michael).

father(X, Y) :- child(Y, X).
grandfather(X, Y) :- child(Y, Z), father(X, Z).


