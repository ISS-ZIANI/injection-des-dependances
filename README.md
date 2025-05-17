 TP – Injection des dépendances en Java (Spring, XML, Annotation)
Ce projet est un TP pratique visant à comprendre et implémenter l'injection des dépendances (IoC – Inversion of Control) en Java à l'aide de Spring Framework.
L'objectif est de découpler les composants d'une application afin de faciliter la maintenance, la flexibilité et les tests.

📁 Structure du projet
dao : contient les classes responsables de fournir les données (DaoImpl, IDao)

ext : contient une version alternative de la DAO (DaoImplV2)

metier : contient la logique métier (IMetier, MetierImpl)

pres : contient différentes présentations pour tester l'application (Pres1, Pres2, PresSpringXML, PresSpringAnnotation)

🛠️ Méthodes d’injection utilisées
✅ 1. Injection manuelle via le constructeur
Dans Pres1.java, j’ai instancié manuellement les classes DAO (DaoImplV2) et METIER (MetierImpl) en injectant la dépendance via le constructeur :

DaoImplV2 d = new DaoImplV2();
MetierImpl metier = new MetierImpl(d);
System.out.println("RES= "+metier.calcul());
🌀 2. Injection dynamique avec Reflection + fichier config
Dans Pres2.java, j’ai utilisé la réflexion Java pour instancier dynamiquement les classes, en lisant leurs noms depuis un fichier config.txt. Cela permet de modifier le comportement sans toucher au code source.


Scanner scanner = new Scanner(new File("config.txt"));
String daoClassName = scanner.nextLine();
String metierClassName = scanner.nextLine();
// Instanciation dynamique
📦 3. Injection via Spring XML
Dans PresSpringXML.java, j’ai configuré les beans dans un fichier config.xml et j’ai utilisé Spring pour gérer l’instanciation et l’injection :


ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
IMetier metier = context.getBean(IMetier.class);
🧩 4. Injection via Spring Annotations
Dans PresSpringAnnotation.java, j’ai utilisé les annotations @Component, @Repository, @Service et @Autowired de Spring pour déclarer et injecter automatiquement les dépendances.


@Service("merier")
public class MetierImpl implements IMetier {
    public MetierImpl(@Qualifier("d2") IDao dao) { ... }
}
Et j’ai lancé l’application via :


ApplicationContext context = new AnnotationConfigApplicationContext("net.youssfi");
IMetier metier = context.getBean(IMetier.class);

📷 Capture de résultat
Exemple de sortie affichée par PresSpringAnnotation.java :



📚 Concepts mis en pratique
Couplage faible via interfaces

Injection de dépendances par constructeur et setter

Instanciation dynamique avec réflexion

Utilisation de Spring (avec XML et annotations)

Organisation modulaire d’un projet Java
