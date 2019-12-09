package siteParis;


import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.Collection;
import java.util.Arrays;


/**
 * 
 * @author Bernard Prou et Julien Mallet
 * <br><br>
 * La classe qui contient toutes les méthodes "Métier" de la gestion du site de paris. 
 * <br><br>
 * Dans toutes les méthodes :
 * <ul>
 * <li>un paramètre de type <code>String</code> est invalide si il n'est pas instancié.</li>
 *  <li>pour la validité d'un password de gestionnaire et d'un password de joueur :
 * <ul>
 * <li>       lettres et chiffres sont les seuls caractères autorisés </li>
 * <li>       il doit avoir une longueur d'au moins 8 caractères </li>
 * </ul></li>       
 * <li>pour la validité d'un pseudo de joueur  :
 * <ul>
 * <li>        lettres et chiffres sont les seuls caractères autorisés  </li>
 * <li>       il doit avoir une longueur d'au moins 4 caractères</li>
 * </ul></li>       
 * <li>pour la validité d'un prénom de joueur et d'un nom de joueur :
 *  <ul>
 *  <li>       lettres et tiret sont les seuls caractères autorisés  </li>
 *  <li>      il  doit avoir une longueur d'au moins 1 caractère </li>
 * </ul></li>
 * <li>pour la validité d'une compétition  :       
 *  <ul>
 *  <li>       lettres, chiffres, point, trait d'union et souligné sont les seuls caractères autorisés </li>
 *  <li>      elle  doit avoir une longueur d'au moins 4 caractères</li>
 * </ul></li>       
 * <li>pour la validité d'un compétiteur  :       
 *  <ul>
 *  <li>       lettres, chiffres, trait d'union et souligné sont les seuls caractères autorisés </li>
 *  <li>      il doit avoir une longueur d'au moins 4 caractères.</li>
 * </ul></li></ul>
 */

public class SiteDeParisMetier {

   String passwordGestionnaire;
   
   private LinkedList<Competition> list_competitions;
   //private LinkedList<LinkedList<String>>list_consulter_competitions;
   private LinkedList<Joueur> list_joueurs;
   private LinkedList<Joueur> list_joueurs_desincris;
   private LinkedList<String> list_competitions_soldes;
   private LinkedList<Pari> list_pari;



	/**
	 * constructeur de <code>SiteDeParisMetier</code>. 
	 * 
	 * @param passwordGestionnaire   le password du gestionnaire.   
	 * 
	 * @throws MetierException  levée 
	 * si le <code>passwordGestionnaire</code>  est invalide 
	 */
    
    public SiteDeParisMetier() {
    	
    }
    
	 public SiteDeParisMetier(String passwordGestionnaire) throws MetierException {
      
      list_competitions = new LinkedList<Competition>();
      //list_consulter_competitions = new  LinkedList<LinkedList<String>>();

      list_joueurs = new LinkedList<Joueur>();
      list_joueurs_desincris = new LinkedList<Joueur>();
      list_competitions_soldes = new LinkedList<String>();
      list_pari = new LinkedList<Pari>();

		/*if(passwordGestionnaire == null)
         throw new MetierException("password NULL");
         
      if(passwordGestionnaire.length() < 8)
         throw new MetierException("password has to be greater or equal to 8 characters");  
      if(passwordGestionnaire.matches("(.*) (.*)"))
         throw new MetierException("password not contains  space ");
      if(passwordGestionnaire.matches("(.*)-(.*)"))
         throw new MetierException("password not contains \"-\" ");   */ 
      
      checkPasswordGestionaire(passwordGestionnaire);
       this.passwordGestionnaire=passwordGestionnaire;
	}
   




	// Les méthodes du gestionnaire (avec mot de passe gestionnaire)



	/**
	 * inscrire un joueur. 
	 * 
	 * @param nom   le nom du joueur 
	 * @param prenom   le prénom du joueur   
	 * @param pseudo   le pseudo du joueur  
	 * @param passwordGestionnaire  le password du gestionnaire du site  
	 * 
	 * @throws MetierException   levée  
	 * si le <code>passwordGestionnaire</code> proposé est invalide,
	 * si le <code>passwordGestionnaire</code> est incorrect.
	 * @throws JoueurExistantException   levée si un joueur existe avec les mêmes noms et prénoms ou le même pseudo.
	 * @throws JoueurException levée si <code>nom</code>, <code>prenom</code>, <code>pseudo</code> sont invalides.
	 * 
	 * @return le mot de passe (déterminé par le site) du nouveau joueur inscrit.
	 */
	public String inscrireJoueur(String nom, String prenom, String pseudo, String passwordGestionnaire) throws MetierException, JoueurExistantException, JoueurException {
		/*if (prenom == null) throw new JoueurException("inscrire un joueur avec un prenom invalide (non instancié)");
		if (nom == null) throw new JoueurException("inscrire un joueur avec un nom invalide (non instancié)");
		if (pseudo == null) throw new JoueurException("inscrire un joueur avec un pseudo invalide (non instancié)");
		if (passwordGestionnaire == null) throw new MetierException("inscrire un joueur avec un password gestionnaire  invalide (non instancié)");
		if (prenom.matches(" ")) throw new JoueurException("inscrire un joueur avec un prénom invalide (un seul caractère : espace)");
		if (nom.matches("(.*) (.*)")) throw new JoueurException("inscrire un joueur avec un nom invalide (Dur an)");
		if (nom.matches("(.*)\'(.*)")) throw new JoueurException("inscrire un joueur avec un nom invalide (un caractère ')");
		if (pseudo.length()<4) throw new JoueurException("inscrire un joueur avec un pseudo invalide (moins de 4 caractères)");
		if (pseudo.matches("(.*)\\.(.*)")) throw new JoueurException("inscrire un joueur avec un pseudo invalide (un caractère .)");
		if (passwordGestionnaire.length()<8) throw new MetierException("inscrire un joueur avec un password gestionnaire  invalide (moins de 8 caractères)");
		if (!passwordGestionnaire.matches(this.passwordGestionnaire)) throw new MetierException("inscrire un joueur avec un password gestionnaire  incorrect");
*/

      checkPasswordGestionaire(passwordGestionnaire);
      checkNomJoueur(nom);
      checkPrenomJoueur(prenom);
      checkPseudoJoueur(pseudo);
      
		for(Joueur j:list_joueurs){
			if (j.getPseudo().equals(pseudo)) throw new JoueurExistantException("inscrire un joueur existant");
			if (j.getPrenom().equals(prenom) && j.getNom().equals(nom)) throw new JoueurExistantException("nscrire un joueur avec même nom et prénom");
		}

		Joueur j = new Joueur(nom, prenom, pseudo);
		String passwordJoueur="unPasswordUnique";
		j.setPassword(passwordJoueur);
		list_joueurs.add(j);

      //return "unPasswordUnique";
		return passwordJoueur;
	}
   
   
   
   
 //simplify the code
   protected void checkPasswordGestionaire(String passwordGestionnaire) throw MetierException{
      checkPasswordGestionaire(passwordGestionnaire);
      if(passwordGestionnaire == null)
         throw new MetierException("password NULL");   
      if(passwordGestionnaire.length() < 8)
         throw new MetierException("password has to be greater or equal to 8 characters");  
      if(passwordGestionnaire.matches("(.*) (.*)"))
         throw new MetierException("password not contains  space ");
      if(passwordGestionnaire.matches("(.*)-(.*)"))
         throw new MetierException("password not contains \"-\" ");    
      if (!passwordGestionnaire.matches(this.passwordGestionnaire)) 
         throw new MetierException("inscrire un joueur avec un password gestionnaire  incorrect");

   }

   
   
 protected void checkNomJoueur(String nom) throw JoueurException{
      checkNomJoueur(nom);
 		if (nom == null) throw new JoueurException("inscrire un joueur avec un nom invalide (non instancié)");
      if (nom.matches("(.*) (.*)")) throw new JoueurException("inscrire un joueur avec un nom invalide (Dur an)");
		if (nom.matches("(.*)\'(.*)")) throw new JoueurException("inscrire un joueur avec un nom invalide (un caractère ')");
 
 }
 
 protected void checkPrenomJoueur(String pseudo) throw JoueurException{
      checkPrenomJoueur(prenom);
      if (prenom == null) throw new JoueurException("inscrire un joueur avec un prenom invalide (non instancié)");      if (nom.matches("(.*) (.*)")) throw new JoueurException("inscrire un joueur avec un nom invalide (Dur an)");
		if (prenom.matches(" ")) throw new JoueurException("inscrire un joueur avec un prénom invalide (un seul caractère : espace)");
 
 }
 protected void checkPseudoJoueur(String prenom) throw JoueurException{
      checkPseudoJoueur(String pseudo);
		if (pseudo == null) throw new JoueurException("inscrire un joueur avec un pseudo invalide (non instancié)");
		if (pseudo.length()<4) throw new JoueurException("inscrire un joueur avec un pseudo invalide (moins de 4 caractères)");
		if (pseudo.matches("(.*)\\.(.*)")) throw new JoueurException("inscrire un joueur avec un pseudo invalide (un caractère .)");
 }

	/**
	 * supprimer un joueur. 
	 * 
	 * @param nom   le nom du joueur 
	 * @param prenom   le prénom du joueur   
	 * @param pseudo   le pseudo du joueur  
	 * @param passwordGestionnaire  le password du gestionnaire du site  
	 * 
	 * @throws MetierException
	 * si le <code>passwordGestionnaire</code>  est invalide,
	 * si le <code>passwordGestionnaire</code> est incorrect.
	 * @throws JoueurInexistantException   levée si il n'y a pas de joueur  avec le même <code>nom</code>, <code>prenom</code>  et <code>pseudo</code>.
	 * @throws JoueurException levée 
	 * si le joueur a des paris en cours,
	 * si <code>nom</code>, <code>prenom</code>, <code>pseudo</code> sont invalides.
	 * 
	 * @return le nombre de jetons à rembourser  au joueur qui vient d'être désinscrit.
	 * 
	 */
	public long desinscrireJoueur(String nom, String prenom, String pseudo, String passwordGestionnaire) throws MetierException, JoueurInexistantException, JoueurException {
		 checkPasswordGestionaire(passwordGestionnaire);

      
      
      boolean jouerInexistant = true;
		long nbJetons=0; //erase 0 and define the correct number of jetons
		int index_toremove_list_joueur=0;

		for(Joueur j:list_joueurs){
			if (j.getNom().equals(nom) && j.getPrenom().equals(prenom) && j.getPseudo().equals(pseudo)){
				jouerInexistant=false;
				break;
			}
			index_toremove_list_joueur++;
		}

		if (jouerInexistant) throw new JoueurInexistantException("désinscrire un joueur inexistant");
		if (!passwordGestionnaire.matches(this.passwordGestionnaire)) throw new MetierException("désinscrire un joueur avec un  password gestionnaire incorrect");

		for (Joueur j:list_joueurs_desincris){
			if (j.getNom().equals(nom) && j.getPrenom().equals(prenom) && j.getPseudo().equals(pseudo)) {
				throw new JoueurInexistantException("désinscrire un joueur déjà retiré");
			}
		}

		//removing a joueur to list joueur
		//list_joueurs.remove(index_toremove_list_joueur);
		list_joueurs.remove(index_toremove_list_joueur);

		Joueur j = new Joueur(nom,prenom,pseudo);
		list_joueurs_desincris.add(j);

		/*System.out.println("jugadores inscritos:");
		for(Joueur i:list_joueurs) {
			System.out.println(i.getPseudo());
		}
		System.out.println("jugadores desinscritos:");
		for(Joueur i:list_joueurs_desincris) {
			System.out.println(i.getPseudo());
		}*/

		return nbJetons;

	}



	/**
	 * ajouter une compétition.  
	 * 
	 * @param competition le nom de la compétition
	 * @param dateCloture   la date à partir de laquelle il ne sera plus possible de miser  
	 * @param competiteurs   les noms des différents compétiteurs de la compétition 
	 * @param passwordGestionnaire  le password du gestionnaire du site 
	 * 
	 * @throws MetierException levée si le tableau des
	 * compétiteurs n'est pas instancié, si le
	 * <code>passwordGestionnaire</code> est invalide, si le
	 * <code>passwordGestionnaire</code> est incorrect.
	 * @throws CompetitionExistanteException levée si une compétition existe avec le même nom. 
	 * @throws CompetitionException levée si le nom de la
	 * compétition ou des compétiteurs sont invalides, si il y a
	 * moins de 2 compétiteurs, si un des competiteurs n'est pas instancié,
	 * si deux compétiteurs ont le même nom, si la date de clôture 
	 * n'est pas instanciée ou est dépassée.
	 */
	public void ajouterCompetition(String competition, DateFrancaise dateCloture, String [] competiteurs, String passwordGestionnaire) throws MetierException, CompetitionExistanteException, CompetitionException  {
       
       //EXCEPTIONS -------------------------------------------------------------------------------------------
       if (passwordGestionnaire==null)
         throw new MetierException("validitePasswordGestionnaire avec un password gestionnaire invalide (non instancié) n'a pas levé l'exception MetierException");
       if (passwordGestionnaire.length()<8) 
         throw new MetierException("validitePasswordGestionnaire avec un password gestionnaire invalide (moins de 8 caracteres) n'a pas levé l'exception MetierException ");
       //if (!passwordGestionnaire.matches("{8,}")) 
         //throw new MetierException("validitePasswordGestionnaire avec un password gestionnaire invalide (moins de 8 caracteres) n'a pas levé l'exception MetierException ");
	    if (!passwordGestionnaire.matches(this.passwordGestionnaire)) 
         throw new MetierException("validitePasswordGestionnaire avec un password gestionnaire incorrect  ");

       if (competition==null) 
         throw new CompetitionException("l'ajout d'une compétition avec un nom invalide (non instancié) n'a pas levé l'exception CompetitionException");
       //if (competition) throw new MetierException("l'ajout d'une compétition avec un nom invalide (avec espace) n'a pas levé l'exception CompetitionException ")
	    if(competition.matches("(.*) (.*)"))
         throw new CompetitionException("l'ajout d'une compétition avec un nom invalide (avec espace) n'a pas levé l'exception CompetitionException mais siteParis.MetierException");
       if(competition.matches("(.*)\\|(.*)"))
         throw new CompetitionException("l'ajout d'une compétition avec un nom invalide (caractere |) n'a pas levé l'exception CompetitionException mais siteParis.MetierException");
       if(competition.length()<4)
         throw new CompetitionException("  l'ajout d'une compétition avec un nom invalide (moins de 4 caractères) n'a pas levé l'exception CompetitionException mais siteParis.MetierException");
       
       if (dateCloture==null) 
         throw new CompetitionException("l'ajout d'une compétition avec une date invalide (non instanciée) n'a pas levé l'exception CompetitionException");
        
       if (competiteurs==null) 
         throw new MetierException("l'ajout d'une compétition avec un tableau de compétiteurs invalide (non instancié) n'a pas levé l'exception MetierException");
   
       if (competiteurs.length<2) 
         throw new CompetitionException("l'ajout d'une compétition avec un seul compétiteur n'a pas levé l'exception CompetitionException");   
       
       
        for (int i = 0; i < competiteurs.length; i++) {
            String value = competiteurs[i];
            if (value==null) 
               throw new CompetitionException("l'ajout d'une compétition avec un nom de compétiteur invalide (avec espace) n'a pas levé l'exception CompetitionException ");
            else ;
            if (value.matches("(.*) (.*)") )
               throw new CompetitionException("l'ajout d'une compétition avec un nom de compétiteur invalide (avec espace) n'a pas levé l'exception CompetitionException");
            else ;
            if (value.length()<4)
               throw new CompetitionException("l'ajout d'une compétition avec un nom de compétiteur invalide (moins de 4 caracteres) n'a pas levé l'exception CompetitionException");
            else ;
            if (value.matches("(.*)\\*(.*)") )
               throw new CompetitionException("l'ajout d'une compétition avec un nom de compétiteur invalide (caractere *) n'a pas levé l'exception CompetitionException");
            else ;
                        
            }
         Arrays.sort(competiteurs);
         
        // System.out.println(Arrays.toString(competiteurs));
         
       for (int i = 0; i < competiteurs.length-1; i++) {
         {
            if(competiteurs[i]==competiteurs[i+1])
               throw new CompetitionException("l'ajout d'une compétition avec deux compétiteurs de même nom  n'a pas levé l'exception CompetitionException");
            else;
            }
        
       }
        
        
       if (dateCloture.before(DateFrancaise.getDate())==true)
           throw new CompetitionException("l'ajout d'une compétition avec date passée n'a pas levé l'exception CompetitionException");



		for(Competition c:list_competitions){
			if (c.getCompetitionName().equals(competition) && c.getDebutDate().equals(dateCloture))
				throw new CompetitionExistanteException("l'ajout d'une compétition existante");
		}

		//IMPLEMENTATION -------------------------------------------------------------------------------------------

		LinkedList<Competiteur> list_competiteurs_temp = new LinkedList<Competiteur>();
		//LinkedList<String> cct = new LinkedList<String>();
        //Create list of competiteurs
		for (int i=0;i<competiteurs.length;i++)
		{
			list_competiteurs_temp.add(new Competiteur(competiteurs[i]));
		}

		list_competitions.add(new Competition(competition, dateCloture, list_competiteurs_temp));

		//cct.add(competition);
		//cct.add(dateCloture.toString());
		//list_consulter_competitions.add(cct);
   }


	/**
	 * solder une compétition vainqueur (compétition avec vainqueur).  
	 * 
	 * Chaque joueur ayant misé sur cette compétition
	 * en choisissant ce compétiteur est crédité d'un nombre de
	 * jetons égal à :
	 * 
	 * (le montant de sa mise * la somme des
	 * jetons misés pour cette compétition) / la somme des jetons
	 * misés sur ce compétiteur.
	 *
	 * Si aucun joueur n'a trouvé le
	 * bon compétiteur, des jetons sont crédités aux joueurs ayant
	 * misé sur cette compétition (conformément au montant de
	 * leurs mises). La compétition est "supprimée" si il ne reste
	 * plus de mises suite à ce solde.
	 * 
	 * @param competition   le nom de la compétition  
	 * @param vainqueur   le nom du vainqueur de la compétition 
	 * @param passwordGestionnaire  le password du gestionnaire du site 
	 * 
	 * @throws MetierException   levée 
	 * si le <code>passwordGestionnaire</code>  est invalide,
	 * si le <code>passwordGestionnaire</code> est incorrect.
	 * @throws CompetitionInexistanteException   levée si il n'existe pas de compétition de même nom.
	 * @throws CompetitionException levée 
	 * si le nom de la compétition ou du vainqueur est invalide, 
	 * si il n'existe pas de compétiteur du nom du vainqueur dans la compétition,
	 * si la date de clôture de la compétition est dans le futur.
	 * 
	 */	
	public void solderVainqueur(String competition, String vainqueur, String passwordGestionnaire) throws MetierException,  CompetitionInexistanteException, CompetitionException  {

		//test

		//EXCEPTIONS -------------------------------------------------------------------------------------------
		//Select competition from list
		boolean InexistantComp = true;
		Competition competition_solder = new Competition();
		for (Competition c : list_competitions) {
			if (c.getCompetitionName().equals(competition)) {
				competition_solder = c;
				InexistantComp = false;
				break;
			}
		}
		if (InexistantComp)
			throw new CompetitionInexistanteException("une compétition inexistante est  soldée");

		if (DateFrancaise.getDate().before(competition_solder.getDebutDate()))
			throw new CompetitionException("une compétition non terminée a été soldée");

		LinkedList<String> temp_list_competiteurs= consulterCompetiteurs(competition);


		if (!temp_list_competiteurs.contains(vainqueur))
			throw new CompetitionException("une compétition avec un vainqueur inexistant a été soldée");

		if (!passwordGestionnaire.equals(this.passwordGestionnaire))
			throw new MetierException("une compétition a été soldée avec un password gestionnaire incorrect");

		if (list_competitions_soldes.contains(competition))
			throw new CompetitionInexistanteException("une compétition déja soldée est  soldée");



		//IMPLEMENTATION -------------------------------------------------------------------------------------------

		//selectionner les paris
		LinkedList<Pari> parisSelectiones = new LinkedList<Pari>();
		long somme_jetons_competition=0;

		for (Pari p : list_pari) {
			if (p.getCompetition().getCompetitionName().equals(competition))
			{
				parisSelectiones.add(p);
				somme_jetons_competition+=p.getMisseEnJetons();
			}
		}

		//Compute the total amount mised for tentative vainqueur
		long somme_jetons_competiteur=0;

		for (Pari p : parisSelectiones) {
			if (p.getWinner().getPrenom().equals(vainqueur)){
					somme_jetons_competiteur+=p.getMisseEnJetons();
 				}
		}


		//Solder les vainqueurs
		long somme_jetons_debiter=0;
		for (Pari p : parisSelectiones) {
			if (p.getWinner().getPrenom().equals(vainqueur)){
				somme_jetons_debiter=(p.getMisseEnJetons()*somme_jetons_competition)/somme_jetons_competiteur;
				System.out.println(p.getJoueur().getNom());
				System.out.println(p.getJoueur().getPrenom());
				System.out.println(p.getJoueur().getPseudo());
				//crediterJoueur(p.getJoueur().getNom(),p.getJoueur().getPrenom(),p.getJoueur().getPseudo(),somme_jetons_debiter,passwordGestionnaire);
				System.out.println(somme_jetons_debiter);
			}
		}


		list_competitions_soldes.add(competition);


	}



	/**
	 * créditer le compte en jetons d'un joueur du site de paris.
	 * 
	 * @param nom   le nom du joueur 
	 * @param prenom   le prenom du joueur   
	 * @param pseudo   le pseudo du joueur  
	 * @param sommeEnJetons la somme en jetons a crediter  
	 * @param passwordGestionnaire  le password du gestionnaire du site  
	 * 
	 * @throws MetierException   levée 
	 * si le <code>passwordGestionnaire</code>  est invalide,
	 * si le <code>passwordGestionnaire</code> est incorrect,
	 * si la somme en jetons est négative.
	 * @throws JoueurException levée  
	 * si <code>nom</code>, <code>prenom</code>,  <code>pseudo</code> sont invalides.
	 * @throws JoueurInexistantException   levée si il n'y a pas de joueur  avec les mêmes nom,  prénom et pseudo.
	 */
	//public void crediterJoueur(String nom, String prenom, String pseudo, long sommeEnJetons, String passwordGestionnaire) throws MetierException, JoueurException, JoueurInexistantException {
	public void crediterJoueur(String nom, String prenom, String pseudo, long sommeEnJetons, String passwordGestionnaire) throws MetierException, JoueurException, JoueurInexistantException {

		boolean jouerInexistant = true;

		//EXCEPTIONS -------------------------------------------------------------------------------------------
		//@throws MetierException levee si le <code>passwordGestionnaire</code> est invalide,
		if(!passwordGestionnaire.equals(this.passwordGestionnaire)) {
			throw new MetierException("passwordGestionnaire est invalide.");
		}
		
		//@throws MetierException si la somme en jetons est negative.
      if (sommeEnJetons < 0){
         throw new MetierException("somme en jetons est negative.");
      }
		
		//@throws JoueurException levee si <code>nom</code>, <code>prenom</code>, <code>pseudo</code> sont invalides.
		//(COPY) same as exception put in inscrireJoueur()
		
		//@throws JoueurInexistantException si il n'y a pas de joueur avec les memes nom, prenom et pseudo.

		for(Joueur j:list_joueurs){
			if (j.getNom().equals(nom) && j.getPrenom().equals(prenom) && j.getPseudo().equals(pseudo)){
				jouerInexistant=false;
				break;
			}
		}
		if (jouerInexistant) throw new JoueurInexistantException("il n'y a pas de joueur avec les memes nom, prenom et pseudo.");


      //IMPLEMENTATION -----------------------------------------------------------------------------------------
      
      //1) searching for user objet with given nom, prenom and pseudo
      Joueur j_temp = new Joueur();
      for (Joueur j : list_joueurs){
			if (j.getNom().equals(nom) && j.getPrenom().equals(prenom) && j.getPseudo().equals(pseudo)) {
            j_temp = j;
			//2) crediting user
			j.setJeton(sommeEnJetons);
            break;
			}
		}
      

      //TEST ---------------------------------------------------------------------------------------------------
      //System.out.println("User "+ j_temp.getNom() +" has " + j_temp.getJeton() + " jetons");
	}


	/**
	 * débiter le compte en jetons d'un joueur du site de paris.
	 * 
	 * @param nom   le nom du joueur 
	 * @param prenom   le prénom du joueur   
	 * @param pseudo   le pseudo du joueur  
	 * @param sommeEnJetons   la somme en jetons à débiter  
	 * @param passwordGestionnaire  le password du gestionnaire du site  
	 * 
	 * @throws MetierException   levée 
	 * si le <code>passwordGestionnaire</code>  est invalide,
	 * si le <code>passwordGestionnaire</code> est incorrect,
	 * si la somme en jetons est négative.
	 * @throws JoueurException levée  
	 * si <code>nom</code>, <code>prenom</code>,  <code>pseudo</code> sont invalides 
	 * si le compte en jetons du joueur est insuffisant (il deviendrait négatif).
	 * @throws JoueurInexistantException   levée si il n'y a pas de joueur  avec les mêmes nom,  prénom et pseudo.
	 * 
	 */

	public void debiterJoueur(String nom, String prenom, String pseudo, long sommeEnJetons, String passwordGestionnaire) throws  MetierException, JoueurInexistantException, JoueurException {
		boolean jouerInexistant = true;

		//EXCEPTIONS -------------------------------------------------------------------------------------------
		//@throws MetierException levee si le <code>passwordGestionnaire</code> est invalide,
		if (!passwordGestionnaire.equals(this.passwordGestionnaire)) {
			throw new MetierException("passwordGestionnaire est invalide.");
		}
		
		//@throws MetierException si la somme en jetons est negative.
      if (sommeEnJetons < 0){
         throw new MetierException("somme en jetons est negative.");
      }
		
		//@throws JoueurException levee si <code>nom</code>, <code>prenom</code>, <code>pseudo</code> sont invalides.
		//(COPY) same as exception put in inscrireJoueur()
      
      //@throws JoueurException levee si le compte en jetons du joueur est insuffisant (il deviendrait négatif).
		Joueur j_temp = new Joueur();
      for (Joueur j : list_joueurs){
			if (j.getNom().equals(nom) && j.getPrenom().equals(prenom) && j.getPseudo().equals(pseudo)) {
            j_temp = j;    
            break;
			}
		}
      if (sommeEnJetons > j_temp.getJeton()){
         throw new JoueurException("Compte en jetons du joueur est insuffisant.");
      }
      
		//@throws JoueurInexistantException si il n'y a pas de joueur avec les memes nom, prenom et pseudo.
		for(Joueur j:list_joueurs){
			if (j.getNom().equals(nom) && j.getPrenom().equals(prenom) && j.getPseudo().equals(pseudo)){
				jouerInexistant=false;
				break;
			}
		}
		if (jouerInexistant) throw new JoueurInexistantException("il n'y a pas de joueur avec les memes nom, prenom et pseudo.");

      //IMPLEMENTATION -----------------------------------------------------------------------------------------
      
      //1) searching for user objet with given nom, prenom and pseudo
      // already done above (j_temp)
      
      //2) debiting user
      j_temp.setJeton(-sommeEnJetons);
      
      //TEST ---------------------------------------------------------------------------------------------------
      System.out.println("User "+ j_temp.getNom() +" has " + j_temp.getJeton() + " jetons"); 

	}



	/** 
	 * consulter les  joueurs.
	 * 
	 * @param passwordGestionnaire  le password du gestionnaire du site de paris 

	 * @throws MetierException   levee  
	 * si le <code>passwordGestionnaire</code> est invalide,
	 * si le <code>passwordGestionnaire</code> est incorrect.
	 * 
	 * @return une liste de liste dont les elements (de type <code>String</code>) representent un joueur avec dans l'ordre : 
	 *  <ul>
	 *  <li>       le nom du joueur  </li>
	 *  <li>       le prenom du joueur </li>
	 *  <li>       le pseudo du joueur  </li>
	 *  <li>       son compte en jetons restant disponibles </li>
	 *  <li>       le total de jetons engages dans ses mises en cours. </li>
	 *  </ul>
	 */
	public LinkedList <LinkedList <String>> consulterJoueurs(String passwordGestionnaire) throws MetierException {
		
      //EXCEPTIONS ---------------------------------------------------------------------------------------------
      
      
      
      //IMPLEMENTATION -----------------------------------------------------------------------------------------

      LinkedList <LinkedList<String>> list_joueurs_serveur = new LinkedList <LinkedList<String>>();
      LinkedList<String> list_joueur_parameters;
          
      for (Joueur j : list_joueurs){
 
         list_joueur_parameters = new LinkedList<String>();
    
         list_joueur_parameters.add(j.getNom());
         list_joueur_parameters.add(j.getPrenom());
         list_joueur_parameters.add(j.getPseudo());
 
         list_joueurs_serveur.add(list_joueur_parameters);
        
		}
      
      //return new LinkedList <LinkedList <String>>();
      return list_joueurs_serveur;
	}


	// Les méthodes avec mot de passe utilisateur



	/**
	 * miserVainqueur  (parier sur une compétition, en désignant un vainqueur).
	 * Le compte du joueur est débité du nombre de jetons misés.
	 * 
	 * @param pseudo   le pseudo du joueur  
	 * @param passwordJoueur  le password du joueur  
	 * @param miseEnJetons   la somme en jetons à miser  
	 * @param competition   le nom de la compétition  relative au pari effectué
	 * @param vainqueurEnvisage   le nom du compétiteur  sur lequel le joueur mise comme étant le  vainqueur de la compétition  
	 * 
	 * @throws MetierException levée si la somme en jetons est négative.
	 * @throws JoueurInexistantException levée si il n'y a pas de
	 * joueur avec les mêmes pseudos et password.
	 * @throws CompetitionInexistanteException   levée si il n'existe pas de compétition de même nom. 
	 * @throws CompetitionException levée 
	 * si <code>competition</code> ou <code>vainqueurEnvisage</code> sont invalides,
	 * si il n'existe pas un compétiteur de  nom <code>vainqueurEnvisage</code> dans la compétition,
	 * si la compétition n'est plus ouverte (la date de clôture est dans le passé).
	 * @throws JoueurException   levée 
	 * si <code>pseudo</code> ou <code>password</code> sont invalides, 
	 * si le <code>compteEnJetons</code> du joueur est insuffisant (il deviendrait négatif).
	 */
    public void miserVainqueur(String pseudo, String passwordJoueur, long miseEnJetons, String competition, String vainqueurEnvisage) throws MetierException, JoueurInexistantException, CompetitionInexistanteException, CompetitionException, JoueurException  {


	Joueur pariJoueur = new Joueur();
	Competition pariCompetition = new Competition();
	Competiteur pariVainqueurEnvisage = new Competiteur();

	//Validate Joueur
		for (Joueur j : list_joueurs){
			if (j.getPseudo().equals(pseudo) && j.getPassword().equals(passwordJoueur)) {
				pariJoueur = j;
				break;
			}
		}

	//Validate Competition
		for (Competition c : list_competitions){
			if (c.getCompetitionName().equals(competition)) {
				pariCompetition = c;
				break;
			}
		}

	//Validate Competiteur
		for (Competiteur cc : pariCompetition.getList_competiteurs()){
			if (cc.getPrenom().equals(vainqueurEnvisage)) {
				pariVainqueurEnvisage = cc;
				break;
			}
		}

	Pari pari_temp = new Pari(pariJoueur,pariCompetition,pariVainqueurEnvisage,miseEnJetons);
	list_pari.add(pari_temp);
 
	 }


    

	// Les méthodes sans mot de passe


	/**
	 * connaître les compétitions en cours.
	 * 
	 * @return une liste de liste dont les elements (de type <code>String</code>) représentent une compétition avec dans l'ordre : 
	 *  <ul>
	 *  <li>       le nom de la competition,  </li>
	 *  <li>       la date de cloture de la competition. </li>
	 *  </ul>
	 */
	public LinkedList <LinkedList <String>> consulterCompetitions(){
   
      //EXCEPTIONS ---------------------------------------------------------------------------------------------
      if (passwordGestionnaire==null || !passwordGestionnaire.matches("[0-9a-zA-Z]")) 
         throw new MetierException("validitePasswordGestionnaire avec un password gestionnaire invalide (non instancié) n'a pas levé l'exception MetierException");
      if (consulterCompetitions().size() != 2)
         throw new CompetitionException("consulterCompetitions ne rend pas la liste des deux comp�titions restantes");

      
      
      
      //IMPLEMENTATION -----------------------------------------------------------------------------------------

      LinkedList <LinkedList<String>> list_competition_serveur = new LinkedList <LinkedList<String>>();
      LinkedList<String> list_competition_parameters;
          
      for (Competition c : list_competitions){
 
         list_competition_parameters = new LinkedList<String>();
    
         list_competition_parameters.add(c.getCompetitionName());
         list_competition_parameters.add(c.getDebutDate().toString()); //Corregir
         
         list_competition_serveur.add(list_competition_parameters);
        
		} 
      
      return list_competition_serveur;
	} 

	/**
	 * connaitre  la liste des noms des competiteurs d'une competition.  
	 * 
	 * @param competition   le nom de la competition  
	 * 
	 * @throws CompetitionException   levée  
	 * si le nom de la compétition est invalide.
	 * @throws CompetitionInexistanteException   levée si il n'existe pas de compétition de même nom. 
	 * 
	 * @return la liste des compétiteurs de la  compétition.
	 */
	public LinkedList <String> consulterCompetiteurs(String competition) throws CompetitionException, CompetitionInexistanteException{

      //EXCEPTIONS ---------------------------------------------------------------------------------------------
            
      //IMPLEMENTATION -----------------------------------------------------------------------------------------

      LinkedList<String> list_competiteurs_competition = new LinkedList<String>();
      
      //searching for "competition" given  
      for (Competition c : list_competitions){
         if (c.getCompetitionName().equals(competition)){
            //filling up the list_competiteurs_competition
            for (int i=0; i<c.getList_competiteurs().size(); i++){
               list_competiteurs_competition.add(c.getList_competiteurs().get(i).getPrenom());
            }
            break;
         }
        
		} 
      
      //return new LinkedList <String> ();
      return list_competiteurs_competition;
	}


	/**
	 * vérifier la validité du password du gestionnaire.
	 * 
	 * @param passwordGestionnaire   le password du gestionnaire à vérifier
	 * 
	 * @throws MetierException   levée 
	 * si le <code>passwordGestionnaire</code> est invalide.  
	 */
	protected void validitePasswordGestionnaire(String passwordGestionnaire) throws MetierException {
	    if (passwordGestionnaire==null) throw new MetierException("validitePasswordGestionnaire avec un password gestionnaire invalide (non instancié) n'a pas levé l'exception MetierException");
	    if (!passwordGestionnaire.matches("{8,}")) throw new MetierException("validitePasswordGestionnaire avec un password gestionnaire invalide (moins de 8 caracteres) n'a pas levé l'exception MetierException ");
	    if (!passwordGestionnaire.matches("[0-9a-zA-Z]")) throw new MetierException("validitePasswordGestionnaire avec un password gestionnaire invalide (un espace)  n'a pas levé l'exception MetierException");
}
	/**
	 * @uml.property name="joueur"
	 * @uml.associationEnd multiplicity="(0 -1)" inverse="siteDeParisMetier:Joueur"
	 */
   	private Collection joueur;

	/** 
	 * Getter of the property <tt>joueur</tt>
	 * @return  Returns the joueur.
	 * @uml.property  name="joueur"
	 */
	   public Collection getJoueur() {
		return joueur;
	}





	/** 
	 * Setter of the property <tt>joueur</tt>
	 * @param joueur  The joueur to set.
	 * @uml.property  name="joueur"
    
	 */
	public void setJoueur(Collection joueur) {
		this.joueur = joueur;
	}

	/** 
	 * @uml.property name="competition"
	 * @uml.associationEnd multiplicity="(0 -1)" inverse="siteDeParisMetier:Competition"
	 */
	private Collection competition;

	/** 
	 * Getter of the property <tt>competition</tt>
	 * @return  Returns the competition.
	 * @uml.property  name="competition"
	 */
    
	public Collection getCompetition() {
		return competition;
	}





	/** 
	 * Setter of the property <tt>competition</tt>
	 * @param competition  The competition to set.
	 * @uml.property  name="competition"
	 */
	public void setCompetition(Collection competition) {
		this.competition = competition;
	}

	/**
	 * @uml.property  name="gestionnaire"
	 * @uml.associationEnd  multiplicity="(1 1)" inverse="siteDeParisMetier:Gestionnaire"
	 */
	private Gestionnaire gestionnaire = new Gestionnaire();

	/**
	 * Getter of the property <tt>gestionnaire</tt>
	 * @return  Returns the gestionnaire.
	 * @uml.property  name="gestionnaire"
	 */
	public Gestionnaire getGestionnaire() {
		return gestionnaire;
	}





	/**
	 * Setter of the property <tt>gestionnaire</tt>
	 * @param gestionnaire  The gestionnaire to set.
	 * @uml.property  name="gestionnaire"
	 */
	public void setGestionnaire(Gestionnaire gestionnaire) {
		this.gestionnaire = gestionnaire;
	}



   //TEST =====================================================================================================
	public static void main (String [] args) {
   
     try{ 
      //CREATION DU SITE
      SiteDeParisMetier siteDeParisMetier = new SiteDeParisMetier(new String("ilesCaimans"));
		
   
      //INSCRITE JOUEUR

      String passwdThanos = siteDeParisMetier.inscrireJoueur("Thanos", "Perro", "Zorro", "ilesCaimans");
      String passwdBernard = siteDeParisMetier.inscrireJoueur("Prou", "Bernard", "nanard", "ilesCaimans");
      String passwdTony = siteDeParisMetier.inscrireJoueur("Tony", "Stark", "IronMan", "ilesCaimans");

      //CREDITER JOUEUR
      siteDeParisMetier.crediterJoueur("Prou", "Bernard", "nanard", 1789, "ilesCaimans");
      siteDeParisMetier.crediterJoueur("Prou", "Bernard", "nanard", 1, "ilesCaimans");
      siteDeParisMetier.debiterJoueur("Prou", "Bernard", "nanard", 790, "ilesCaimans");
      siteDeParisMetier.crediterJoueur("Tony", "Stark", "IronMan", 1789, "ilesCaimans");

      //CONSULTER JOUEUR
      LinkedList <LinkedList<String>> list_joueurs_serveur = new LinkedList <LinkedList<String>>();
      list_joueurs_serveur = siteDeParisMetier.consulterJoueurs("ilesCaimans");
      for (int i = 0; i<list_joueurs_serveur.size(); i++){
         System.out.println(list_joueurs_serveur.get(i));
      }

      //AJOUTER COMPETITION
		 siteDeParisMetier.ajouterCompetition(new String("ChampionnatDeFrance2012"), new DateFrancaise(4, 6, 2020, 15, 00), new String [] {new String("Lyon"), new String("Marseille"), "Paris", new String("Rennes"), new String("Brest"), "StEtienne", new String("Lille"), "Nancy", "Toulouse", "Auxerre"}, new String("ilesCaimans"));
		 siteDeParisMetier.ajouterCompetition(new String("ChampionnatDeFrance2013"), new DateFrancaise(27, 6, 2020, 20, 00), new String [] {new String("Lyon"), new String("Nantes"), new String("Lens"), new String("Marseille"), "Paris", new String("Rennes"), "StEtienne", new String("Lille"), "Nancy", "Toulouse", }, new String("ilesCaimans"));
		 siteDeParisMetier.ajouterCompetition(new String("finaleRG2012"), new DateFrancaise(7, 6, 2021, 15, 00), new String [] {new String("Tsonga"), new String("Nadal")}, new String("ilesCaimans"));

		 //CONSULTER COMPETITION
		 LinkedList <LinkedList <String>> listCompetitionServeur = siteDeParisMetier.consulterCompetitions();
		 for (int i = 0; i<listCompetitionServeur.size(); i++){
			 System.out.println(listCompetitionServeur.get(i));
		 }

		 //CONSULTER COMPETITEUR
		 LinkedList <String> listCompetiteurServeur = siteDeParisMetier.consulterCompetiteurs("ChampionnatDeFrance2012");
		 System.out.println(listCompetiteurServeur);
		 listCompetiteurServeur = siteDeParisMetier.consulterCompetiteurs("ChampionnatDeFrance2013");
		 System.out.println(listCompetiteurServeur);
		 listCompetiteurServeur = siteDeParisMetier.consulterCompetiteurs("finaleRG2012");
		 System.out.println(listCompetiteurServeur);


	 }
      
		catch (Exception e) {
			System.out.println("\n Exception impr�vue : " + e);
			e.printStackTrace();
		}
      
	}
   //==========================================================================================================

}


