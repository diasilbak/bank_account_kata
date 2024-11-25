# Bank Account Kata

Une application de gestion de comptes bancaires permettant de réaliser des dépôts, des retraits et de générer un relevé de compte pour répondre aux problématiques de US1, US2.

## Classes
1 - La classe client, c'est le propriétaire du compte, l'idéal serait qu'elle soit abstraite afin de créer plusieurs implémentations (client particulier, entreprise ...)

2 - La classe CompteBancaire, c'est une classe abstraite. Il existe une seule implémentation `CompteCourant`, mais on peut avoir d'autres comme compte épargne....

3 - `Operation` c'est une classe générique pour les 2 implémentations `Retrait` et `Versement`. Ces 2 classes sont faites juste pour tracer les opérations effectuées sur un compte.

Il y a aussi les **Repositories**, les **Services** et un **Contrôleur** pour effectuer un **Versement** et un **Retrait**.

J'ai utilisé h2, mais pour l'instant il n'y a aucune donnée par défaut dans la base. Il faut créer d'autres services pour alimenter la base, comme créer un client, créer des comptes bancaires et les alimenter.... afin d'appeler les 2 microservices.

Sinon, il existe des tests unitaires pour les 2 opérations de retrait et de versement.
