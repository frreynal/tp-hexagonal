# tp-hexagonal
TP sur architecture hexagonal - Pôle Emploi


Vous allez construire une ville médiévale de commerçants marins

Votre ville aura plusieurs ports qui lui permettront de commercer avec d'autres villes :
- vous achetez des fraises et de la pâte sablée à Metro, qui livre par UberBoat, mais il faut commander par pigeon 
voyageur, et seulement quand vous avez assez de trésorerie, les délais de livraison sont fluctuants, aléatoirement
- Vous recevez en flux continue du lait des Alpes, par pipeline océanique, du Moyen-Age, il est gratuit, vous avez 
fait un raccord pirate sur celui de Milka, mais parfois ça coupe, aléatoirement
- des voyageurs Vikings viennent visiter votre ville régulièrement, quand ils passent, vous leur vendez du lait ou
de préférence des tartes aux fraises mais seulement s'il y en a en stock, leur nombre et la fréquence de leurs
visites, sont aléatoires
- à chaque achat ou vente, vous notifiez la banque qui tient vos comptes
- la banque vous préviendra quand vous aurez assez pour ériger une statue à l'effigie de Dora

Vous n'êtes ni marin, ni maçon, ni pâtissier, mais data scientist... votre travail consiste à faire une 
simulation pour savoir quand vous pourrez avoir votre statue dans ces conditions

Vous referez ensuite une simulation, qui permet de comparer avec la simulation initiale,
en changeant de metier.fournisseur pour les tartes aux fraises, avec Amazon, plus cher mais beaucoup plus rapide

Enfin une dernière simulation, dans laquelle, vous adaptez dynamiquement le metier.fournisseur, vous utilisez le plus rapide
seulement quand il n'y a plus de tartes aux fraises en stock
