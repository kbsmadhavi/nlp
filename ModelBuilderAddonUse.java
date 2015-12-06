import java.io.File;

import opennlp.addons.modelbuilder.DefaultModelBuilderUtil;

public class ModelBuilderAddonUse {

  public static void main(String[] args) {
    /*File fileOfSentences = new File("E:\\nlp\\mbuildSentence.txt");
    File fileOfNames = new File("E:\\nlp\\mbuildKnown.txt");
    File blackListFile = new File("E:\\nlp\\blacklist.txt");
    File modelOutFile = new File("E:\\nlp\\mbuildOutSent.bin");
    File annotatedSentencesOutFile = new File("E:\\nlp\\mbuildOutAnnotated.txt");*/
    
    File fileOfSentences = new File("E:\\nlp\\citiesSentence.txt");
    File fileOfNames = new File("E:\\nlp\\citiesKnown.txt");
    File blackListFile = new File("E:\\nlp\\blacklist.txt");
    File modelOutFile = new File("E:\\nlp\\citiesSentOut.bin");
    File annotatedSentencesOutFile = new File("E:\\nlp\\citiesOutAnnotated.txt");
    
    

    DefaultModelBuilderUtil.generateModel(fileOfSentences, fileOfNames, blackListFile, modelOutFile, annotatedSentencesOutFile, "location", 3);


  }
}