# TP Techniques avancée de test: Behavior Driven Development
Ce TP a pour objectif de mettre en place des tests à partir d'éxigences fonctionelles autour d'un système automatisé d'allumage de phares
## Outils utilisés
* Git & Gitlab : Outil de gestion de code
* Maven : Pour récupérer les dépendances du projet
* jBehave : Permet de générer des classes pour le test à partir de scénarios d'utilisation rédigées en français.
* jUnit : Utilisé pour les tests, jBehave utilise jUnit pour lancer les tests

## Requirements
Les requirements sont rédigés à partir des éxigences fonctionelles de l'énoncé, en utilisant des termes précis permettant ensuite à jBehave de parser ces derniers.

## Steps
jBehave va ensuite être utilisé pour générer des "Steps"

__ Trois types de "Steps" sont générés : __
* Given
* When
* Then

Les steps sont générés dans le fichier CarLightSteps

## Configuration de jBehave

Une fois les steps générés, il faut configurer jBehave à l'aide de la classe _CarMainStory_ (Fournie)

``` java
configuration = new Configuration() {};
configuration.useFailureStrategy(new RethrowingFailure());
configuration.useKeywords(new LocalizedKeywords(Locale.ENGLISH));
configuration.usePathCalculator(new AbsolutePathCalculator());
configuration.useParameterControls(new ParameterControls());
configuration.useParameterConverters(new ParameterConverters());
configuration.useParanamer(new NullParanamer());
configuration.usePendingStepStrategy(new PassingUponPendingStep());
configuration.useStepCollector(new MarkUnmatchedStepsAsPending());
configuration.useStepdocReporter(new PrintStreamStepdocReporter());
configuration.useStepFinder(new StepFinder());
configuration.useStepMonitor(new SilentStepMonitor());
configuration.useStepPatternParser(new RegexPrefixCapturingPatternParser());
configuration.useStoryControls(new StoryControls());
configuration.useStoryLoader(new LoadFromClasspath());
configuration.useStoryParser(new RegexStoryParser(configuration.keywords()));
configuration.useStoryPathResolver(new UnderscoredCamelCaseResolver());
configuration.useStoryReporterBuilder(new StoryReporterBuilder());
configuration.useViewGenerator(new FreemarkerViewGenerator());
 
embedderControls embedderControls = configuredEmbedder().embedderControls();
embedderControls.doBatch(false);
embedderControls.doGenerateViewAfterStories(true);
embedderControls.doIgnoreFailureInStories(false);
embedderControls.doIgnoreFailureInView(false);
embedderControls.doSkip(false);
embedderControls.doVerboseFailures(false);
embedderControls.doVerboseFiltering(false);
embedderControls.useThreads(1);
```

## Lancement des tests
On peut desormais lancer les tests avec __jUnit__, certains passent, mais il faut rédiger l'implémentation pour que tous les tests passent.

## Implémentation
On peut désormais effectuer l'implémentation

``` java
package phare;import java.security.GeneralSecurityException;
import java.util.Date;

public class CarLight {
	private double intensity;      //input
	private SwitchMode switch_pos; //input
	private boolean is_on;         //output
	private Date last_intensity_change;

	public CarLight(double li, SwitchMode sm) {
		setIntensity(li);
		last_intensity_change = new Date();
		switch_pos = sm;
	}
	public void setIntensity(double li) {
		intensity=li;
		last_intensity_change = new Date();
	} 
	public void setSwitch(SwitchMode sm) {
		switch_pos = sm;
	} 
	public SwitchMode getSwitch() {
		return switch_pos;
	} 
	public boolean isOn() {
		return is_on;
	}
	public void dump() {
		System.out.printf("[car light] i=%f ; sw=%s ; On=%s \n",
				intensity, switch_pos, is_on);
	}


	// calcule is_on en fonction de intensity et switch_pos
	public void step() {
		// is_on = false;
		// finish me
		switch (switch_pos) {
		case ON: 
			is_on = true;
			break;

		case OFF: 
			is_on = false;
			break;

		case AUTO:
			if((is_on == true && intensity < 70) || intensity <= 70){
				is_on = true;					
			}else if((is_on == false && intensity >= 60) || intensity > 70){
				is_on = false;
			}
			break;
		}
	}

}
```

__Remarque:__ 
Cette implémentation de permet pas de faire passer le test REQ003.2
Cela est probablement dù à une mauvaise compréhension de l'exigence de notre part.