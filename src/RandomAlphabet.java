/**
 * This is a class
 * Created 2021-09-16
 *
 * @author Magnus Silverdal
 */
public class RandomAlphabet {
    public static void main(String[] args) {
        String crypt ="SVZPCZ DZ VOV QN HDLO ÖOVÅ ON? GÄ, KÄL KGDMAEF XVXXVÅF VEE XJÅÅV OFL VLVMJEÖQHV RVQHÖLFL. OFE " +
                "KÄL ÄUHQN ÅGÄZOF SVZ VEE PVHEÖQHE AZÄÅZVRRFZV RVQHÖLFL EÖMM VEE ÅCZV MCQV AZÄXMFR. KÄL SVZ VMMEQN " +
                "OFL PCZQEV AZÄÅZVRRFZVZFL DSFL ÄR RVQHÖLFL ÖLEF FBÖQEFZVOF ZFLE PJQÖQHE.\n" +
                "KÄL EÖMMQHZÖSQ ÄUHQN OFL PCZQEV XTÅÅ-ZDEELÖLÅFL ON KÄL HÄZZÖÅFZVOF PFM QÄR XVXXVÅF KVOF ÅGÄZE. KÄL " +
                "ÖLQNÅ ÄUHQN VEE AÄEFLEÖVMFL KÄQ FL VLVMJEÖQH RVQHÖL MNÅ MNLÅE XÄZEÄR ZFLE QÖPPFZETÅÅVLOF.\n"+
                "VLEV, PCZ FEE CÅÄLXMÖUH, VEE OF PTLOVRFLEVMV ZFMVEÖÄLFZLV RFMMVL QAFUÖPÖHV MGTO Ö OFL SFEFLQHVAMÖÅV " +
                "KVZRÄLÖL ÄUK RTQÖHQHVAVLOFE SVZ RÄEEVÅMÖÅV PCZ FEE QNOVLE TEEZJUH ÄUK QNOVLV PCZDLOZÖLÅVZ. Ö QN PVMM" +
                " QHTMMF RVQHÖLFL HTLLV HÄRAÄLFZV ÖLSFUHMVOF ÄUK SFEFLQHVAMÖÅV RTQÖHQEJUHFL VS SÖMHFL HÄRAMFBÖEFE " +
                "FMMFZ MDLÅO QÄR KFMQE. -VOV MÄSFMVUF, 1842";
        char[] correctAlphabet = {'P','X','Ö','Ä','T','E','J','K','-','Y','H','N','L','Å','D','F','S','M','V','U','C'
                ,'A','-','B','-','R','G','O','I'};
        char[] randomAlphabett = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U'
                ,'V','W','X','Y','Z','Å','Ä','Ö'};
        char[] cryptchar = crypt.toCharArray();
        for (int i = 0 ; i < crypt.length() ; i++) {
            int c;
            if (crypt.charAt(i) == 'Å') {
                c = 26;
            } else if (crypt.charAt(i) == 'Ä'){
                c = 27;
            } else if (crypt.charAt(i) == 'Ö') {
                c = 28;
            } else if (crypt.charAt(i)< 65 || crypt.charAt(i)>91) {
                continue;
            } else {
                c = cryptchar[i] - 65;
            }
            if (randomAlphabett[c] != '-') {
                cryptchar[i] = correctAlphabet[c];
            }
        }
        System.out.println(new String(cryptchar));
        String message = "PROGRAMMERINGÄRSKOJ";
        String cryptMessage = "";
        for (int i = 0 ; i < message.length() ; i++) {
            int c;
            if (message.charAt(i) == 'Å') {
                c = 197;
            } else if (message.charAt(i) == 'Ä'){
                c = 196;
            } else if (message.charAt(i) == 'Ö') {
                c = 214;
            } else if (message.charAt(i)< 65 || crypt.charAt(i)>91) {
                cryptMessage += " ";
                continue;
            } else {
                c = message.charAt(i);
            }
            for (int j = 0 ; j < randomAlphabett.length ; j++) {
                if (c == (int)correctAlphabet[j])
                    cryptMessage += randomAlphabett[j];
            }
        }
        System.out.println(cryptMessage);


    }


}
